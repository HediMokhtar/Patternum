

package org.apache.commons.lang3.concurrent;


public class CircuitBreakingException extends java.lang.RuntimeException {
    private static final long serialVersionUID = 1408176654686913340L;

    public CircuitBreakingException() {
        super();
    }

    public CircuitBreakingException(final java.lang.String message, final java.lang.Throwable cause) {
        super(message, cause);
    }

    public CircuitBreakingException(final java.lang.String message) {
        super(message);
    }

    public CircuitBreakingException(final java.lang.Throwable cause) {
        super(cause);
    }
}

