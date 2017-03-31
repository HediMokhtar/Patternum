

package org.apache.commons.lang3.concurrent;


public class ThresholdCircuitBreaker extends org.apache.commons.lang3.concurrent.AbstractCircuitBreaker<java.lang.Long> {
    private static final long INITIAL_COUNT = 0L;

    private final long threshold;

    private final java.util.concurrent.atomic.AtomicLong used;

    public ThresholdCircuitBreaker(final long threshold) {
        super();
        this.used = new java.util.concurrent.atomic.AtomicLong(org.apache.commons.lang3.concurrent.ThresholdCircuitBreaker.INITIAL_COUNT);
        this.threshold = threshold;
    }

    public long getThreshold() {
        return threshold;
    }

    @java.lang.Override
    public boolean checkState() throws org.apache.commons.lang3.concurrent.CircuitBreakingException {
        return isOpen();
    }

    @java.lang.Override
    public void close() {
        super.close();
        org.apache.commons.lang3.concurrent.ThresholdCircuitBreaker.this.used.set(org.apache.commons.lang3.concurrent.ThresholdCircuitBreaker.INITIAL_COUNT);
    }

    @java.lang.Override
    public boolean incrementAndCheckState(final java.lang.Long increment) throws org.apache.commons.lang3.concurrent.CircuitBreakingException {
        if ((threshold) == 0) {
            open();
        }
        final long used = org.apache.commons.lang3.concurrent.ThresholdCircuitBreaker.this.used.addAndGet(increment);
        if (used > (threshold)) {
            open();
        }
        return checkState();
    }
}

