

package org.apache.commons.lang3.concurrent;


public class EventCountCircuitBreaker extends org.apache.commons.lang3.concurrent.AbstractCircuitBreaker<java.lang.Integer> {
    private static final java.util.Map<org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State, org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy> STRATEGY_MAP = org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.createStrategyMap();

    private final java.util.concurrent.atomic.AtomicReference<org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData> checkIntervalData;

    private final int openingThreshold;

    private final long openingInterval;

    private final int closingThreshold;

    private final long closingInterval;

    public EventCountCircuitBreaker(final int openingThreshold, final long openingInterval, final java.util.concurrent.TimeUnit openingUnit, final int closingThreshold, final long closingInterval, final java.util.concurrent.TimeUnit closingUnit) {
        super();
        checkIntervalData = new java.util.concurrent.atomic.AtomicReference<>(new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData(0, 0));
        this.openingThreshold = openingThreshold;
        this.openingInterval = openingUnit.toNanos(openingInterval);
        this.closingThreshold = closingThreshold;
        this.closingInterval = closingUnit.toNanos(closingInterval);
    }

    public EventCountCircuitBreaker(final int openingThreshold, final long checkInterval, final java.util.concurrent.TimeUnit checkUnit, final int closingThreshold) {
        this(openingThreshold, checkInterval, checkUnit, closingThreshold, checkInterval, checkUnit);
    }

    public EventCountCircuitBreaker(final int threshold, final long checkInterval, final java.util.concurrent.TimeUnit checkUnit) {
        this(threshold, checkInterval, checkUnit, threshold);
    }

    public int getOpeningThreshold() {
        return openingThreshold;
    }

    public long getOpeningInterval() {
        return openingInterval;
    }

    public int getClosingThreshold() {
        return closingThreshold;
    }

    public long getClosingInterval() {
        return closingInterval;
    }

    @java.lang.Override
    public boolean checkState() {
        return performStateCheck(0);
    }

    @java.lang.Override
    public boolean incrementAndCheckState(final java.lang.Integer increment) throws org.apache.commons.lang3.concurrent.CircuitBreakingException {
        return performStateCheck(1);
    }

    public boolean incrementAndCheckState() {
        return incrementAndCheckState(1);
    }

    @java.lang.Override
    public void open() {
        super.open();
        checkIntervalData.set(new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData(0, now()));
    }

    @java.lang.Override
    public void close() {
        super.close();
        checkIntervalData.set(new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData(0, now()));
    }

    private boolean performStateCheck(final int increment) {
        org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData currentData;
        org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData nextData;
        org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State currentState;
        do {
            final long time = now();
            currentState = state.get();
            currentData = checkIntervalData.get();
            nextData = nextCheckIntervalData(increment, currentData, currentState, time);
        } while (!(updateCheckIntervalData(currentData, nextData)) );
        if (org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.stateStrategy(currentState).isStateTransition(org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.this, currentData, nextData)) {
            currentState = currentState.oppositeState();
            changeStateAndStartNewCheckInterval(currentState);
        }
        return !(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.isOpen(currentState));
    }

    private boolean updateCheckIntervalData(final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData currentData, final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData nextData) {
        return (currentData == nextData) || (checkIntervalData.compareAndSet(currentData, nextData));
    }

    private void changeStateAndStartNewCheckInterval(final org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State newState) {
        changeState(newState);
        checkIntervalData.set(new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData(0, now()));
    }

    private org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData nextCheckIntervalData(final int increment, final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData currentData, final org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State currentState, final long time) {
        org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData nextData;
        if (org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.stateStrategy(currentState).isCheckIntervalFinished(org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.this, currentData, time)) {
            nextData = new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData(increment, time);
        }else {
            nextData = currentData.increment(increment);
        }
        return nextData;
    }

    long now() {
        return java.lang.System.nanoTime();
    }

    private static org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy stateStrategy(final org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State state) {
        final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy strategy = org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.STRATEGY_MAP.get(state);
        return strategy;
    }

    private static java.util.Map<org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State, org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy> createStrategyMap() {
        final java.util.Map<org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State, org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy> map = new java.util.EnumMap<>(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.class);
        map.put(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.CLOSED, new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategyClosed());
        map.put(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.OPEN, new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategyOpen());
        return map;
    }

    private static class CheckIntervalData {
        private final int eventCount;

        private final long checkIntervalStart;

        public CheckIntervalData(final int count, final long intervalStart) {
            eventCount = count;
            checkIntervalStart = intervalStart;
        }

        public int getEventCount() {
            return eventCount;
        }

        public long getCheckIntervalStart() {
            return checkIntervalStart;
        }

        public org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData increment(final int delta) {
            return delta != 0 ? new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData(((getEventCount()) + delta), getCheckIntervalStart()) : org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData.this;
        }
    }

    private abstract static class StateStrategy {
        public boolean isCheckIntervalFinished(final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker breaker, final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData currentData, final long now) {
            return (now - (currentData.getCheckIntervalStart())) > (fetchCheckInterval(breaker));
        }

        public abstract boolean isStateTransition(org.apache.commons.lang3.concurrent.EventCountCircuitBreaker breaker, org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData currentData, org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData nextData);

        protected abstract long fetchCheckInterval(org.apache.commons.lang3.concurrent.EventCountCircuitBreaker breaker);
    }

    private static class StateStrategyClosed extends org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy {
        @java.lang.Override
        public boolean isStateTransition(final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker breaker, final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData currentData, final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData nextData) {
            return (nextData.getEventCount()) > (breaker.getOpeningThreshold());
        }

        @java.lang.Override
        protected long fetchCheckInterval(final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker breaker) {
            return breaker.getOpeningInterval();
        }
    }

    private static class StateStrategyOpen extends org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.StateStrategy {
        @java.lang.Override
        public boolean isStateTransition(final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker breaker, final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData currentData, final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker.CheckIntervalData nextData) {
            return ((nextData.getCheckIntervalStart()) != (currentData.getCheckIntervalStart())) && ((currentData.getEventCount()) < (breaker.getClosingThreshold()));
        }

        @java.lang.Override
        protected long fetchCheckInterval(final org.apache.commons.lang3.concurrent.EventCountCircuitBreaker breaker) {
            return breaker.getClosingInterval();
        }
    }
}

