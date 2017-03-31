

package org.apache.commons.lang3.concurrent;


public abstract class LazyInitializer<T> implements org.apache.commons.lang3.concurrent.ConcurrentInitializer<T> {
    private static final java.lang.Object NO_INIT = new java.lang.Object();

    @java.lang.SuppressWarnings(value = "unchecked")
    private volatile T object = ((T) (org.apache.commons.lang3.concurrent.LazyInitializer.NO_INIT));

    @java.lang.Override
    public T get() throws org.apache.commons.lang3.concurrent.ConcurrentException {
        T result = object;
        if (result == (org.apache.commons.lang3.concurrent.LazyInitializer.NO_INIT)) {
            synchronized(org.apache.commons.lang3.concurrent.LazyInitializer.this) {
                result = object;
                if (result == (org.apache.commons.lang3.concurrent.LazyInitializer.NO_INIT)) {
                    object = result = initialize();
                }
            }
        }
        return result;
    }

    protected abstract T initialize() throws org.apache.commons.lang3.concurrent.ConcurrentException;
}

