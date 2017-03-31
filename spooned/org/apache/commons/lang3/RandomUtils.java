

package org.apache.commons.lang3;


public class RandomUtils {
    private static final java.util.Random RANDOM = new java.util.Random();

    public RandomUtils() {
        super();
    }

    public static boolean nextBoolean() {
        return org.apache.commons.lang3.RandomUtils.RANDOM.nextBoolean();
    }

    public static byte[] nextBytes(final int count) {
        org.apache.commons.lang3.Validate.isTrue((count >= 0), "Count cannot be negative.");
        final byte[] result = new byte[count];
        org.apache.commons.lang3.RandomUtils.RANDOM.nextBytes(result);
        return result;
    }

    public static int nextInt(final int startInclusive, final int endExclusive) {
        org.apache.commons.lang3.Validate.isTrue((endExclusive >= startInclusive), "Start value must be smaller or equal to end value.");
        org.apache.commons.lang3.Validate.isTrue((startInclusive >= 0), "Both range values must be non-negative.");
        if (startInclusive == endExclusive) {
            return startInclusive;
        }
        return startInclusive + (org.apache.commons.lang3.RandomUtils.RANDOM.nextInt((endExclusive - startInclusive)));
    }

    public static int nextInt() {
        return org.apache.commons.lang3.RandomUtils.nextInt(0, java.lang.Integer.MAX_VALUE);
    }

    public static long nextLong(final long startInclusive, final long endExclusive) {
        org.apache.commons.lang3.Validate.isTrue((endExclusive >= startInclusive), "Start value must be smaller or equal to end value.");
        org.apache.commons.lang3.Validate.isTrue((startInclusive >= 0), "Both range values must be non-negative.");
        if (startInclusive == endExclusive) {
            return startInclusive;
        }
        return ((long) (org.apache.commons.lang3.RandomUtils.nextDouble(startInclusive, endExclusive)));
    }

    public static long nextLong() {
        return org.apache.commons.lang3.RandomUtils.nextLong(0, java.lang.Long.MAX_VALUE);
    }

    public static double nextDouble(final double startInclusive, final double endInclusive) {
        org.apache.commons.lang3.Validate.isTrue((endInclusive >= startInclusive), "Start value must be smaller or equal to end value.");
        org.apache.commons.lang3.Validate.isTrue((startInclusive >= 0), "Both range values must be non-negative.");
        if (startInclusive == endInclusive) {
            return startInclusive;
        }
        return startInclusive + ((endInclusive - startInclusive) * (org.apache.commons.lang3.RandomUtils.RANDOM.nextDouble()));
    }

    public static double nextDouble() {
        return org.apache.commons.lang3.RandomUtils.nextDouble(0, java.lang.Double.MAX_VALUE);
    }

    public static float nextFloat(final float startInclusive, final float endInclusive) {
        org.apache.commons.lang3.Validate.isTrue((endInclusive >= startInclusive), "Start value must be smaller or equal to end value.");
        org.apache.commons.lang3.Validate.isTrue((startInclusive >= 0), "Both range values must be non-negative.");
        if (startInclusive == endInclusive) {
            return startInclusive;
        }
        return startInclusive + ((endInclusive - startInclusive) * (org.apache.commons.lang3.RandomUtils.RANDOM.nextFloat()));
    }

    public static float nextFloat() {
        return org.apache.commons.lang3.RandomUtils.nextFloat(0, java.lang.Float.MAX_VALUE);
    }
}

