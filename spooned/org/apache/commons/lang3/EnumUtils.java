

package org.apache.commons.lang3;


public class EnumUtils {
    private static final java.lang.String NULL_ELEMENTS_NOT_PERMITTED = "null elements not permitted";

    private static final java.lang.String CANNOT_STORE_S_S_VALUES_IN_S_BITS = "Cannot store %s %s values in %s bits";

    private static final java.lang.String S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE = "%s does not seem to be an Enum type";

    private static final java.lang.String ENUM_CLASS_MUST_BE_DEFINED = "EnumClass must be defined.";

    public EnumUtils() {
    }

    public static <E extends java.lang.Enum<E>> java.util.Map<java.lang.String, E> getEnumMap(final java.lang.Class<E> enumClass) {
        final java.util.Map<java.lang.String, E> map = new java.util.LinkedHashMap<>();
        for (final E e : enumClass.getEnumConstants()) {
            map.put(e.name(), e);
        }
        return map;
    }

    public static <E extends java.lang.Enum<E>> java.util.List<E> getEnumList(final java.lang.Class<E> enumClass) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(enumClass.getEnumConstants()));
    }

    public static <E extends java.lang.Enum<E>> boolean isValidEnum(final java.lang.Class<E> enumClass, final java.lang.String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            java.lang.Enum.valueOf(enumClass, enumName);
            return true;
        } catch (final java.lang.IllegalArgumentException ex) {
            return false;
        }
    }

    public static <E extends java.lang.Enum<E>> E getEnum(final java.lang.Class<E> enumClass, final java.lang.String enumName) {
        if (enumName == null) {
            return null;
        }
        try {
            return java.lang.Enum.valueOf(enumClass, enumName);
        } catch (final java.lang.IllegalArgumentException ex) {
            return null;
        }
    }

    public static <E extends java.lang.Enum<E>> long generateBitVector(final java.lang.Class<E> enumClass, final java.lang.Iterable<? extends E> values) {
        org.apache.commons.lang3.EnumUtils.checkBitVectorable(enumClass);
        org.apache.commons.lang3.Validate.notNull(values);
        long total = 0;
        for (final E constant : values) {
            org.apache.commons.lang3.Validate.isTrue((constant != null), org.apache.commons.lang3.EnumUtils.NULL_ELEMENTS_NOT_PERMITTED);
            total |= 1L << (constant.ordinal());
        }
        return total;
    }

    public static <E extends java.lang.Enum<E>> long[] generateBitVectors(final java.lang.Class<E> enumClass, final java.lang.Iterable<? extends E> values) {
        org.apache.commons.lang3.EnumUtils.asEnum(enumClass);
        org.apache.commons.lang3.Validate.notNull(values);
        final java.util.EnumSet<E> condensed = java.util.EnumSet.noneOf(enumClass);
        for (final E constant : values) {
            org.apache.commons.lang3.Validate.isTrue((constant != null), org.apache.commons.lang3.EnumUtils.NULL_ELEMENTS_NOT_PERMITTED);
            condensed.add(constant);
        }
        final long[] result = new long[(((enumClass.getEnumConstants().length) - 1) / (java.lang.Long.SIZE)) + 1];
        for (final E value : condensed) {
            result[((value.ordinal()) / (java.lang.Long.SIZE))] |= 1L << ((value.ordinal()) % (java.lang.Long.SIZE));
        }
        org.apache.commons.lang3.ArrayUtils.reverse(result);
        return result;
    }

    @java.lang.SafeVarargs
    public static <E extends java.lang.Enum<E>> long generateBitVector(final java.lang.Class<E> enumClass, final E... values) {
        org.apache.commons.lang3.Validate.noNullElements(values);
        return org.apache.commons.lang3.EnumUtils.generateBitVector(enumClass, java.util.Arrays.<E>asList(values));
    }

    @java.lang.SafeVarargs
    public static <E extends java.lang.Enum<E>> long[] generateBitVectors(final java.lang.Class<E> enumClass, final E... values) {
        org.apache.commons.lang3.EnumUtils.asEnum(enumClass);
        org.apache.commons.lang3.Validate.noNullElements(values);
        final java.util.EnumSet<E> condensed = java.util.EnumSet.noneOf(enumClass);
        java.util.Collections.addAll(condensed, values);
        final long[] result = new long[(((enumClass.getEnumConstants().length) - 1) / (java.lang.Long.SIZE)) + 1];
        for (final E value : condensed) {
            result[((value.ordinal()) / (java.lang.Long.SIZE))] |= 1L << ((value.ordinal()) % (java.lang.Long.SIZE));
        }
        org.apache.commons.lang3.ArrayUtils.reverse(result);
        return result;
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> processBitVector(final java.lang.Class<E> enumClass, final long value) {
        org.apache.commons.lang3.EnumUtils.checkBitVectorable(enumClass).getEnumConstants();
        return org.apache.commons.lang3.EnumUtils.processBitVectors(enumClass, value);
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> processBitVectors(final java.lang.Class<E> enumClass, final long... values) {
        final java.util.EnumSet<E> results = java.util.EnumSet.noneOf(org.apache.commons.lang3.EnumUtils.asEnum(enumClass));
        final long[] lvalues = org.apache.commons.lang3.ArrayUtils.clone(org.apache.commons.lang3.Validate.notNull(values));
        org.apache.commons.lang3.ArrayUtils.reverse(lvalues);
        for (final E constant : enumClass.getEnumConstants()) {
            final int block = (constant.ordinal()) / (java.lang.Long.SIZE);
            if ((block < (lvalues.length)) && (((lvalues[block]) & (1L << ((constant.ordinal()) % (java.lang.Long.SIZE)))) != 0)) {
                results.add(constant);
            }
        }
        return results;
    }

    private static <E extends java.lang.Enum<E>> java.lang.Class<E> checkBitVectorable(final java.lang.Class<E> enumClass) {
        final E[] constants = org.apache.commons.lang3.EnumUtils.asEnum(enumClass).getEnumConstants();
        org.apache.commons.lang3.Validate.isTrue(((constants.length) <= (java.lang.Long.SIZE)), org.apache.commons.lang3.EnumUtils.CANNOT_STORE_S_S_VALUES_IN_S_BITS, java.lang.Integer.valueOf(constants.length), enumClass.getSimpleName(), java.lang.Integer.valueOf(java.lang.Long.SIZE));
        return enumClass;
    }

    private static <E extends java.lang.Enum<E>> java.lang.Class<E> asEnum(final java.lang.Class<E> enumClass) {
        org.apache.commons.lang3.Validate.notNull(enumClass, org.apache.commons.lang3.EnumUtils.ENUM_CLASS_MUST_BE_DEFINED);
        org.apache.commons.lang3.Validate.isTrue(enumClass.isEnum(), org.apache.commons.lang3.EnumUtils.S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE, enumClass);
        return enumClass;
    }
}

