

package org.apache.commons.lang3.time;


public class StopWatch {
    private static final long NANO_2_MILLIS = 1000000L;

    public static org.apache.commons.lang3.time.StopWatch createStarted() {
        final org.apache.commons.lang3.time.StopWatch sw = new org.apache.commons.lang3.time.StopWatch();
        sw.start();
        return sw;
    }

    private enum State {
UNSTARTED {
            @java.lang.Override
            boolean isStarted() {
                return false;
            }

            @java.lang.Override
            boolean isStopped() {
                return true;
            }

            @java.lang.Override
            boolean isSuspended() {
                return false;
            }
        }, RUNNING {
            @java.lang.Override
            boolean isStarted() {
                return true;
            }

            @java.lang.Override
            boolean isStopped() {
                return false;
            }

            @java.lang.Override
            boolean isSuspended() {
                return false;
            }
        }, STOPPED {
            @java.lang.Override
            boolean isStarted() {
                return false;
            }

            @java.lang.Override
            boolean isStopped() {
                return true;
            }

            @java.lang.Override
            boolean isSuspended() {
                return false;
            }
        }, SUSPENDED {
            @java.lang.Override
            boolean isStarted() {
                return true;
            }

            @java.lang.Override
            boolean isStopped() {
                return false;
            }

            @java.lang.Override
            boolean isSuspended() {
                return true;
            }
        };
        abstract boolean isStarted();

        abstract boolean isStopped();

        abstract boolean isSuspended();
    }

    private enum SplitState {
SPLIT, UNSPLIT;    }

    private org.apache.commons.lang3.time.StopWatch.State runningState = org.apache.commons.lang3.time.StopWatch.State.UNSTARTED;

    private org.apache.commons.lang3.time.StopWatch.SplitState splitState = org.apache.commons.lang3.time.StopWatch.SplitState.UNSPLIT;

    private long startTime;

    private long startTimeMillis;

    private long stopTime;

    public StopWatch() {
        super();
    }

    public void start() {
        if ((org.apache.commons.lang3.time.StopWatch.this.runningState) == (org.apache.commons.lang3.time.StopWatch.State.STOPPED)) {
            throw new java.lang.IllegalStateException("Stopwatch must be reset before being restarted. ");
        }
        if ((org.apache.commons.lang3.time.StopWatch.this.runningState) != (org.apache.commons.lang3.time.StopWatch.State.UNSTARTED)) {
            throw new java.lang.IllegalStateException("Stopwatch already started. ");
        }
        org.apache.commons.lang3.time.StopWatch.this.startTime = java.lang.System.nanoTime();
        org.apache.commons.lang3.time.StopWatch.this.startTimeMillis = java.lang.System.currentTimeMillis();
        org.apache.commons.lang3.time.StopWatch.this.runningState = org.apache.commons.lang3.time.StopWatch.State.RUNNING;
    }

    public void stop() {
        if (((org.apache.commons.lang3.time.StopWatch.this.runningState) != (org.apache.commons.lang3.time.StopWatch.State.RUNNING)) && ((org.apache.commons.lang3.time.StopWatch.this.runningState) != (org.apache.commons.lang3.time.StopWatch.State.SUSPENDED))) {
            throw new java.lang.IllegalStateException("Stopwatch is not running. ");
        }
        if ((org.apache.commons.lang3.time.StopWatch.this.runningState) == (org.apache.commons.lang3.time.StopWatch.State.RUNNING)) {
            org.apache.commons.lang3.time.StopWatch.this.stopTime = java.lang.System.nanoTime();
        }
        org.apache.commons.lang3.time.StopWatch.this.runningState = org.apache.commons.lang3.time.StopWatch.State.STOPPED;
    }

    public void reset() {
        org.apache.commons.lang3.time.StopWatch.this.runningState = org.apache.commons.lang3.time.StopWatch.State.UNSTARTED;
        org.apache.commons.lang3.time.StopWatch.this.splitState = org.apache.commons.lang3.time.StopWatch.SplitState.UNSPLIT;
    }

    public void split() {
        if ((org.apache.commons.lang3.time.StopWatch.this.runningState) != (org.apache.commons.lang3.time.StopWatch.State.RUNNING)) {
            throw new java.lang.IllegalStateException("Stopwatch is not running. ");
        }
        org.apache.commons.lang3.time.StopWatch.this.stopTime = java.lang.System.nanoTime();
        org.apache.commons.lang3.time.StopWatch.this.splitState = org.apache.commons.lang3.time.StopWatch.SplitState.SPLIT;
    }

    public void unsplit() {
        if ((org.apache.commons.lang3.time.StopWatch.this.splitState) != (org.apache.commons.lang3.time.StopWatch.SplitState.SPLIT)) {
            throw new java.lang.IllegalStateException("Stopwatch has not been split. ");
        }
        org.apache.commons.lang3.time.StopWatch.this.splitState = org.apache.commons.lang3.time.StopWatch.SplitState.UNSPLIT;
    }

    public void suspend() {
        if ((org.apache.commons.lang3.time.StopWatch.this.runningState) != (org.apache.commons.lang3.time.StopWatch.State.RUNNING)) {
            throw new java.lang.IllegalStateException("Stopwatch must be running to suspend. ");
        }
        org.apache.commons.lang3.time.StopWatch.this.stopTime = java.lang.System.nanoTime();
        org.apache.commons.lang3.time.StopWatch.this.runningState = org.apache.commons.lang3.time.StopWatch.State.SUSPENDED;
    }

    public void resume() {
        if ((org.apache.commons.lang3.time.StopWatch.this.runningState) != (org.apache.commons.lang3.time.StopWatch.State.SUSPENDED)) {
            throw new java.lang.IllegalStateException("Stopwatch must be suspended to resume. ");
        }
        org.apache.commons.lang3.time.StopWatch.this.startTime += (java.lang.System.nanoTime()) - (org.apache.commons.lang3.time.StopWatch.this.stopTime);
        org.apache.commons.lang3.time.StopWatch.this.runningState = org.apache.commons.lang3.time.StopWatch.State.RUNNING;
    }

    public long getTime() {
        return (getNanoTime()) / (org.apache.commons.lang3.time.StopWatch.NANO_2_MILLIS);
    }

    public long getTime(final java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getNanoTime(), java.util.concurrent.TimeUnit.NANOSECONDS);
    }

    public long getNanoTime() {
        if (((org.apache.commons.lang3.time.StopWatch.this.runningState) == (org.apache.commons.lang3.time.StopWatch.State.STOPPED)) || ((org.apache.commons.lang3.time.StopWatch.this.runningState) == (org.apache.commons.lang3.time.StopWatch.State.SUSPENDED))) {
            return (org.apache.commons.lang3.time.StopWatch.this.stopTime) - (org.apache.commons.lang3.time.StopWatch.this.startTime);
        }else
            if ((org.apache.commons.lang3.time.StopWatch.this.runningState) == (org.apache.commons.lang3.time.StopWatch.State.UNSTARTED)) {
                return 0;
            }else
                if ((org.apache.commons.lang3.time.StopWatch.this.runningState) == (org.apache.commons.lang3.time.StopWatch.State.RUNNING)) {
                    return (java.lang.System.nanoTime()) - (org.apache.commons.lang3.time.StopWatch.this.startTime);
                }
            
        
        throw new java.lang.RuntimeException("Illegal running state has occurred.");
    }

    public long getSplitTime() {
        return (getSplitNanoTime()) / (org.apache.commons.lang3.time.StopWatch.NANO_2_MILLIS);
    }

    public long getSplitNanoTime() {
        if ((org.apache.commons.lang3.time.StopWatch.this.splitState) != (org.apache.commons.lang3.time.StopWatch.SplitState.SPLIT)) {
            throw new java.lang.IllegalStateException("Stopwatch must be split to get the split time. ");
        }
        return (org.apache.commons.lang3.time.StopWatch.this.stopTime) - (org.apache.commons.lang3.time.StopWatch.this.startTime);
    }

    public long getStartTime() {
        if ((org.apache.commons.lang3.time.StopWatch.this.runningState) == (org.apache.commons.lang3.time.StopWatch.State.UNSTARTED)) {
            throw new java.lang.IllegalStateException("Stopwatch has not been started");
        }
        return org.apache.commons.lang3.time.StopWatch.this.startTimeMillis;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return org.apache.commons.lang3.time.DurationFormatUtils.formatDurationHMS(getTime());
    }

    public java.lang.String toSplitString() {
        return org.apache.commons.lang3.time.DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    public boolean isStarted() {
        return runningState.isStarted();
    }

    public boolean isSuspended() {
        return runningState.isSuspended();
    }

    public boolean isStopped() {
        return runningState.isStopped();
    }
}

