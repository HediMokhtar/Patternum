

package org.apache.commons.lang3.builder;


public class HashCodeBuilder implements org.apache.commons.lang3.builder.Builder<java.lang.Integer> {
    private static final int DEFAULT_INITIAL_VALUE = 17;

    private static final int DEFAULT_MULTIPLIER_VALUE = 37;

    private static final java.lang.ThreadLocal<java.util.Set<org.apache.commons.lang3.builder.IDKey>> REGISTRY = new java.lang.ThreadLocal<>();

    static java.util.Set<org.apache.commons.lang3.builder.IDKey> getRegistry() {
        return org.apache.commons.lang3.builder.HashCodeBuilder.REGISTRY.get();
    }

    static boolean isRegistered(final java.lang.Object value) {
        final java.util.Set<org.apache.commons.lang3.builder.IDKey> registry = org.apache.commons.lang3.builder.HashCodeBuilder.getRegistry();
        return (registry != null) && (registry.contains(new org.apache.commons.lang3.builder.IDKey(value)));
    }

    private static void reflectionAppend(final java.lang.Object object, final java.lang.Class<?> clazz, final org.apache.commons.lang3.builder.HashCodeBuilder builder, final boolean useTransients, final java.lang.String[] excludeFields) {
        if (org.apache.commons.lang3.builder.HashCodeBuilder.isRegistered(object)) {
            return ;
        }
        try {
            org.apache.commons.lang3.builder.HashCodeBuilder.register(object);
            final java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            java.lang.reflect.AccessibleObject.setAccessible(fields, true);
            for (final java.lang.reflect.Field field : fields) {
                if (((((!(org.apache.commons.lang3.ArrayUtils.contains(excludeFields, field.getName()))) && (!(field.getName().contains("$")))) && (useTransients || (!(java.lang.reflect.Modifier.isTransient(field.getModifiers()))))) && (!(java.lang.reflect.Modifier.isStatic(field.getModifiers())))) && (!(field.isAnnotationPresent(org.apache.commons.lang3.builder.HashCodeExclude.class)))) {
                    try {
                        final java.lang.Object fieldValue = field.get(object);
                        builder.append(fieldValue);
                    } catch (final java.lang.IllegalAccessException e) {
                        throw new java.lang.InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            org.apache.commons.lang3.builder.HashCodeBuilder.unregister(object);
        }
    }

    public static int reflectionHashCode(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber, final java.lang.Object object) {
        return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(initialNonZeroOddNumber, multiplierNonZeroOddNumber, object, false, null);
    }

    public static int reflectionHashCode(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber, final java.lang.Object object, final boolean testTransients) {
        return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(initialNonZeroOddNumber, multiplierNonZeroOddNumber, object, testTransients, null);
    }

    public static <T> int reflectionHashCode(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber, final T object, final boolean testTransients, final java.lang.Class<? super T> reflectUpToClass, final java.lang.String... excludeFields) {
        if (object == null) {
            throw new java.lang.IllegalArgumentException("The object to build a hash code for must not be null");
        }
        final org.apache.commons.lang3.builder.HashCodeBuilder builder = new org.apache.commons.lang3.builder.HashCodeBuilder(initialNonZeroOddNumber, multiplierNonZeroOddNumber);
        java.lang.Class<?> clazz = object.getClass();
        org.apache.commons.lang3.builder.HashCodeBuilder.reflectionAppend(object, clazz, builder, testTransients, excludeFields);
        while (((clazz.getSuperclass()) != null) && (clazz != reflectUpToClass)) {
            clazz = clazz.getSuperclass();
            org.apache.commons.lang3.builder.HashCodeBuilder.reflectionAppend(object, clazz, builder, testTransients, excludeFields);
        } 
        return builder.toHashCode();
    }

    public static int reflectionHashCode(final java.lang.Object object, final boolean testTransients) {
        return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(org.apache.commons.lang3.builder.HashCodeBuilder.DEFAULT_INITIAL_VALUE, org.apache.commons.lang3.builder.HashCodeBuilder.DEFAULT_MULTIPLIER_VALUE, object, testTransients, null);
    }

    public static int reflectionHashCode(final java.lang.Object object, final java.util.Collection<java.lang.String> excludeFields) {
        return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(object, org.apache.commons.lang3.builder.ReflectionToStringBuilder.toNoNullStringArray(excludeFields));
    }

    public static int reflectionHashCode(final java.lang.Object object, final java.lang.String... excludeFields) {
        return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(org.apache.commons.lang3.builder.HashCodeBuilder.DEFAULT_INITIAL_VALUE, org.apache.commons.lang3.builder.HashCodeBuilder.DEFAULT_MULTIPLIER_VALUE, object, false, null, excludeFields);
    }

    private static void register(final java.lang.Object value) {
        java.util.Set<org.apache.commons.lang3.builder.IDKey> registry = org.apache.commons.lang3.builder.HashCodeBuilder.getRegistry();
        if (registry == null) {
            registry = new java.util.HashSet<>();
            org.apache.commons.lang3.builder.HashCodeBuilder.REGISTRY.set(registry);
        }
        registry.add(new org.apache.commons.lang3.builder.IDKey(value));
    }

    private static void unregister(final java.lang.Object value) {
        final java.util.Set<org.apache.commons.lang3.builder.IDKey> registry = org.apache.commons.lang3.builder.HashCodeBuilder.getRegistry();
        if (registry != null) {
            registry.remove(new org.apache.commons.lang3.builder.IDKey(value));
            if (registry.isEmpty()) {
                org.apache.commons.lang3.builder.HashCodeBuilder.REGISTRY.remove();
            }
        }
    }

    private final int iConstant;

    private int iTotal = 0;

    public HashCodeBuilder() {
        iConstant = 37;
        iTotal = 17;
    }

    public HashCodeBuilder(final int initialOddNumber, final int multiplierOddNumber) {
        org.apache.commons.lang3.Validate.isTrue(((initialOddNumber % 2) != 0), "HashCodeBuilder requires an odd initial value");
        org.apache.commons.lang3.Validate.isTrue(((multiplierOddNumber % 2) != 0), "HashCodeBuilder requires an odd multiplier");
        iConstant = multiplierOddNumber;
        iTotal = initialOddNumber;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final boolean value) {
        iTotal = ((iTotal) * (iConstant)) + (value ? 0 : 1);
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final boolean[] array) {
        if (array == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            for (final boolean element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final byte value) {
        iTotal = ((iTotal) * (iConstant)) + value;
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final byte[] array) {
        if (array == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            for (final byte element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final char value) {
        iTotal = ((iTotal) * (iConstant)) + value;
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final char[] array) {
        if (array == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            for (final char element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final double value) {
        return append(java.lang.Double.doubleToLongBits(value));
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final double[] array) {
        if (array == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            for (final double element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final float value) {
        iTotal = ((iTotal) * (iConstant)) + (java.lang.Float.floatToIntBits(value));
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final float[] array) {
        if (array == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            for (final float element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final int value) {
        iTotal = ((iTotal) * (iConstant)) + value;
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final int[] array) {
        if (array == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            for (final int element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final long value) {
        iTotal = ((iTotal) * (iConstant)) + ((int) (value ^ (value >> 32)));
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final long[] array) {
        if (array == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            for (final long element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final java.lang.Object object) {
        if (object == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            if (object.getClass().isArray()) {
                appendArray(object);
            }else {
                iTotal = ((iTotal) * (iConstant)) + (object.hashCode());
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    private void appendArray(final java.lang.Object object) {
        if (object instanceof long[]) {
            append(((long[]) (object)));
        }else
            if (object instanceof int[]) {
                append(((int[]) (object)));
            }else
                if (object instanceof short[]) {
                    append(((short[]) (object)));
                }else
                    if (object instanceof char[]) {
                        append(((char[]) (object)));
                    }else
                        if (object instanceof byte[]) {
                            append(((byte[]) (object)));
                        }else
                            if (object instanceof double[]) {
                                append(((double[]) (object)));
                            }else
                                if (object instanceof float[]) {
                                    append(((float[]) (object)));
                                }else
                                    if (object instanceof boolean[]) {
                                        append(((boolean[]) (object)));
                                    }else {
                                        append(((java.lang.Object[]) (object)));
                                    }
                                
                            
                        
                    
                
            
        
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final java.lang.Object[] array) {
        if (array == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            for (final java.lang.Object element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final short value) {
        iTotal = ((iTotal) * (iConstant)) + value;
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder append(final short[] array) {
        if (array == null) {
            iTotal = (iTotal) * (iConstant);
        }else {
            for (final short element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public org.apache.commons.lang3.builder.HashCodeBuilder appendSuper(final int superHashCode) {
        iTotal = ((iTotal) * (iConstant)) + superHashCode;
        return org.apache.commons.lang3.builder.HashCodeBuilder.this;
    }

    public int toHashCode() {
        return iTotal;
    }

    @java.lang.Override
    public java.lang.Integer build() {
        return java.lang.Integer.valueOf(toHashCode());
    }

    @java.lang.Override
    public int hashCode() {
        return toHashCode();
    }
}

