

package org.apache.commons.lang3.concurrent;


public abstract class AbstractCircuitBreaker<T> implements org.apache.commons.lang3.concurrent.CircuitBreaker<T> {
    public static final java.lang.String PROPERTY_NAME = "open";

    protected final java.util.concurrent.atomic.AtomicReference<org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State> state = new java.util.concurrent.atomic.AtomicReference<>(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.CLOSED);

    private final java.beans.PropertyChangeSupport changeSupport;

    public AbstractCircuitBreaker() {
        changeSupport = new java.beans.PropertyChangeSupport(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.this);
    }

    @java.lang.Override
    public boolean isOpen() {
        return org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.isOpen(state.get());
    }

    @java.lang.Override
    public boolean isClosed() {
        return !(isOpen());
    }

    @java.lang.Override
    public abstract boolean checkState();

    @java.lang.Override
    public abstract boolean incrementAndCheckState(T increment);

    @java.lang.Override
    public void close() {
        changeState(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.CLOSED);
    }

    @java.lang.Override
    public void open() {
        changeState(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.OPEN);
    }

    protected static boolean isOpen(final org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State state) {
        return state == (org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.OPEN);
    }

    protected void changeState(final org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State newState) {
        if (state.compareAndSet(newState.oppositeState(), newState)) {
            changeSupport.firePropertyChange(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.PROPERTY_NAME, (!(org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.isOpen(newState))), org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.isOpen(newState));
        }
    }

    public void addChangeListener(final java.beans.PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removeChangeListener(final java.beans.PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    protected static enum State {
CLOSED {
            @java.lang.Override
            public org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State oppositeState() {
                return org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.OPEN;
            }
        }, OPEN {
            @java.lang.Override
            public org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State oppositeState() {
                return org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.CLOSED;
            }
        };
        public abstract org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State oppositeState();
    }
}

