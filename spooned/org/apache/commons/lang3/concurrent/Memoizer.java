

package org.apache.commons.lang3.concurrent;


public class Memoizer<I, O> implements org.apache.commons.lang3.concurrent.Computable<I, O> {
    private final java.util.concurrent.ConcurrentMap<I, java.util.concurrent.Future<O>> cache = new java.util.concurrent.ConcurrentHashMap<>();

    private final org.apache.commons.lang3.concurrent.Computable<I, O> computable;

    private final boolean recalculate;

    public Memoizer(final org.apache.commons.lang3.concurrent.Computable<I, O> computable) {
        this(computable, false);
    }

    public Memoizer(final org.apache.commons.lang3.concurrent.Computable<I, O> computable, final boolean recalculate) {
        this.computable = computable;
        this.recalculate = recalculate;
    }

    @java.lang.Override
    public O compute(final I arg) throws java.lang.InterruptedException {
        while (true) {
            java.util.concurrent.Future<O> future = cache.get(arg);
            if (future == null) {
                final java.util.concurrent.Callable<O> eval = new java.util.concurrent.Callable<O>() {
                    @java.lang.Override
                    public O call() throws java.lang.InterruptedException {
                        return computable.compute(arg);
                    }
                };
                final java.util.concurrent.FutureTask<O> futureTask = new java.util.concurrent.FutureTask<>(eval);
                future = cache.putIfAbsent(arg, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (final java.util.concurrent.CancellationException e) {
                cache.remove(arg, future);
            } catch (final java.util.concurrent.ExecutionException e) {
                if (recalculate) {
                    cache.remove(arg, future);
                }
                throw launderException(e.getCause());
            }
        } 
    }

    private java.lang.RuntimeException launderException(final java.lang.Throwable throwable) {
        if (throwable instanceof java.lang.RuntimeException) {
            return ((java.lang.RuntimeException) (throwable));
        }else
            if (throwable instanceof java.lang.Error) {
                throw ((java.lang.Error) (throwable));
            }else {
                throw new java.lang.IllegalStateException("Unchecked exception", throwable);
            }
        
    }
}

