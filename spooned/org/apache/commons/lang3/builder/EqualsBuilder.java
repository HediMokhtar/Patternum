

package org.apache.commons.lang3.builder;


public class EqualsBuilder implements org.apache.commons.lang3.builder.Builder<java.lang.Boolean> {
    private static final java.lang.ThreadLocal<java.util.Set<org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey>>> REGISTRY = new java.lang.ThreadLocal<>();

    static java.util.Set<org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey>> getRegistry() {
        return org.apache.commons.lang3.builder.EqualsBuilder.REGISTRY.get();
    }

    static org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey> getRegisterPair(final java.lang.Object lhs, final java.lang.Object rhs) {
        final org.apache.commons.lang3.builder.IDKey left = new org.apache.commons.lang3.builder.IDKey(lhs);
        final org.apache.commons.lang3.builder.IDKey right = new org.apache.commons.lang3.builder.IDKey(rhs);
        return org.apache.commons.lang3.tuple.Pair.of(left, right);
    }

    static boolean isRegistered(final java.lang.Object lhs, final java.lang.Object rhs) {
        final java.util.Set<org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey>> registry = org.apache.commons.lang3.builder.EqualsBuilder.getRegistry();
        final org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey> pair = org.apache.commons.lang3.builder.EqualsBuilder.getRegisterPair(lhs, rhs);
        final org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey> swappedPair = org.apache.commons.lang3.tuple.Pair.of(pair.getLeft(), pair.getRight());
        return (registry != null) && ((registry.contains(pair)) || (registry.contains(swappedPair)));
    }

    private static void register(final java.lang.Object lhs, final java.lang.Object rhs) {
        java.util.Set<org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey>> registry = org.apache.commons.lang3.builder.EqualsBuilder.getRegistry();
        if (registry == null) {
            registry = new java.util.HashSet<>();
            org.apache.commons.lang3.builder.EqualsBuilder.REGISTRY.set(registry);
        }
        final org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey> pair = org.apache.commons.lang3.builder.EqualsBuilder.getRegisterPair(lhs, rhs);
        registry.add(pair);
    }

    private static void unregister(final java.lang.Object lhs, final java.lang.Object rhs) {
        final java.util.Set<org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey>> registry = org.apache.commons.lang3.builder.EqualsBuilder.getRegistry();
        if (registry != null) {
            final org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.IDKey, org.apache.commons.lang3.builder.IDKey> pair = org.apache.commons.lang3.builder.EqualsBuilder.getRegisterPair(lhs, rhs);
            registry.remove(pair);
            if (registry.isEmpty()) {
                org.apache.commons.lang3.builder.EqualsBuilder.REGISTRY.remove();
            }
        }
    }

    private boolean isEquals = true;

    private boolean testTransients = false;

    private boolean testRecursive = false;

    private java.lang.Class<?> reflectUpToClass = null;

    private java.lang.String[] excludeFields = null;

    public EqualsBuilder() {
    }

    public org.apache.commons.lang3.builder.EqualsBuilder setTestTransients(final boolean testTransients) {
        org.apache.commons.lang3.builder.EqualsBuilder.this.testTransients = testTransients;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder setTestRecursive(final boolean testRecursive) {
        org.apache.commons.lang3.builder.EqualsBuilder.this.testRecursive = testRecursive;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder setReflectUpToClass(final java.lang.Class<?> reflectUpToClass) {
        org.apache.commons.lang3.builder.EqualsBuilder.this.reflectUpToClass = reflectUpToClass;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder setExcludeFields(final java.lang.String... excludeFields) {
        org.apache.commons.lang3.builder.EqualsBuilder.this.excludeFields = excludeFields;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public static boolean reflectionEquals(final java.lang.Object lhs, final java.lang.Object rhs, final java.util.Collection<java.lang.String> excludeFields) {
        return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(lhs, rhs, org.apache.commons.lang3.builder.ReflectionToStringBuilder.toNoNullStringArray(excludeFields));
    }

    public static boolean reflectionEquals(final java.lang.Object lhs, final java.lang.Object rhs, final java.lang.String... excludeFields) {
        return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(lhs, rhs, false, null, excludeFields);
    }

    public static boolean reflectionEquals(final java.lang.Object lhs, final java.lang.Object rhs, final boolean testTransients) {
        return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(lhs, rhs, testTransients, null);
    }

    public static boolean reflectionEquals(final java.lang.Object lhs, final java.lang.Object rhs, final boolean testTransients, final java.lang.Class<?> reflectUpToClass, final java.lang.String... excludeFields) {
        return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(lhs, rhs, testTransients, reflectUpToClass, false, excludeFields);
    }

    public static boolean reflectionEquals(final java.lang.Object lhs, final java.lang.Object rhs, final boolean testTransients, final java.lang.Class<?> reflectUpToClass, final boolean testRecursive, final java.lang.String... excludeFields) {
        if (lhs == rhs) {
            return true;
        }
        if ((lhs == null) || (rhs == null)) {
            return false;
        }
        return new org.apache.commons.lang3.builder.EqualsBuilder().setExcludeFields(excludeFields).setReflectUpToClass(reflectUpToClass).setTestTransients(testTransients).setTestRecursive(testRecursive).reflectionAppend(lhs, rhs).isEquals();
    }

    public org.apache.commons.lang3.builder.EqualsBuilder reflectionAppend(final java.lang.Object lhs, final java.lang.Object rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            isEquals = false;
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        final java.lang.Class<?> lhsClass = lhs.getClass();
        final java.lang.Class<?> rhsClass = rhs.getClass();
        java.lang.Class<?> testClass;
        if (lhsClass.isInstance(rhs)) {
            testClass = lhsClass;
            if (!(rhsClass.isInstance(lhs))) {
                testClass = rhsClass;
            }
        }else
            if (rhsClass.isInstance(lhs)) {
                testClass = rhsClass;
                if (!(lhsClass.isInstance(rhs))) {
                    testClass = lhsClass;
                }
            }else {
                isEquals = false;
                return org.apache.commons.lang3.builder.EqualsBuilder.this;
            }
        
        try {
            if (testClass.isArray()) {
                append(lhs, rhs);
            }else {
                reflectionAppend(lhs, rhs, testClass);
                while (((testClass.getSuperclass()) != null) && (testClass != (reflectUpToClass))) {
                    testClass = testClass.getSuperclass();
                    reflectionAppend(lhs, rhs, testClass);
                } 
            }
        } catch (final java.lang.IllegalArgumentException e) {
            isEquals = false;
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    private void reflectionAppend(final java.lang.Object lhs, final java.lang.Object rhs, final java.lang.Class<?> clazz) {
        if (org.apache.commons.lang3.builder.EqualsBuilder.isRegistered(lhs, rhs)) {
            return ;
        }
        try {
            org.apache.commons.lang3.builder.EqualsBuilder.register(lhs, rhs);
            final java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            java.lang.reflect.AccessibleObject.setAccessible(fields, true);
            for (int i = 0; (i < (fields.length)) && (isEquals); i++) {
                final java.lang.reflect.Field f = fields[i];
                if (((((!(org.apache.commons.lang3.ArrayUtils.contains(excludeFields, f.getName()))) && (!(f.getName().contains("$")))) && ((testTransients) || (!(java.lang.reflect.Modifier.isTransient(f.getModifiers()))))) && (!(java.lang.reflect.Modifier.isStatic(f.getModifiers())))) && (!(f.isAnnotationPresent(org.apache.commons.lang3.builder.EqualsExclude.class)))) {
                    try {
                        append(f.get(lhs), f.get(rhs));
                    } catch (final java.lang.IllegalAccessException e) {
                        throw new java.lang.InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            org.apache.commons.lang3.builder.EqualsBuilder.unregister(lhs, rhs);
        }
    }

    public org.apache.commons.lang3.builder.EqualsBuilder appendSuper(final boolean superEquals) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        isEquals = superEquals;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final java.lang.Object lhs, final java.lang.Object rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        final java.lang.Class<?> lhsClass = lhs.getClass();
        if (!(lhsClass.isArray())) {
            if ((testRecursive) && (!(org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper(lhsClass)))) {
                reflectionAppend(lhs, rhs);
            }else {
                isEquals = lhs.equals(rhs);
            }
        }else {
            appendArray(lhs, rhs);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    private void appendArray(final java.lang.Object lhs, final java.lang.Object rhs) {
        if ((lhs.getClass()) != (rhs.getClass())) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
        }else
            if (lhs instanceof long[]) {
                append(((long[]) (lhs)), ((long[]) (rhs)));
            }else
                if (lhs instanceof int[]) {
                    append(((int[]) (lhs)), ((int[]) (rhs)));
                }else
                    if (lhs instanceof short[]) {
                        append(((short[]) (lhs)), ((short[]) (rhs)));
                    }else
                        if (lhs instanceof char[]) {
                            append(((char[]) (lhs)), ((char[]) (rhs)));
                        }else
                            if (lhs instanceof byte[]) {
                                append(((byte[]) (lhs)), ((byte[]) (rhs)));
                            }else
                                if (lhs instanceof double[]) {
                                    append(((double[]) (lhs)), ((double[]) (rhs)));
                                }else
                                    if (lhs instanceof float[]) {
                                        append(((float[]) (lhs)), ((float[]) (rhs)));
                                    }else
                                        if (lhs instanceof boolean[]) {
                                            append(((boolean[]) (lhs)), ((boolean[]) (rhs)));
                                        }else {
                                            append(((java.lang.Object[]) (lhs)), ((java.lang.Object[]) (rhs)));
                                        }
                                    
                                
                            
                        
                    
                
            
        
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final long lhs, final long rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        isEquals = lhs == rhs;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final int lhs, final int rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        isEquals = lhs == rhs;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final short lhs, final short rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        isEquals = lhs == rhs;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final char lhs, final char rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        isEquals = lhs == rhs;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final byte lhs, final byte rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        isEquals = lhs == rhs;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final double lhs, final double rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        return append(java.lang.Double.doubleToLongBits(lhs), java.lang.Double.doubleToLongBits(rhs));
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final float lhs, final float rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        return append(java.lang.Float.floatToIntBits(lhs), java.lang.Float.floatToIntBits(rhs));
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final boolean lhs, final boolean rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        isEquals = lhs == rhs;
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final java.lang.Object[] lhs, final java.lang.Object[] rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs.length) != (rhs.length)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        for (int i = 0; (i < (lhs.length)) && (isEquals); ++i) {
            append(lhs[i], rhs[i]);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final long[] lhs, final long[] rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs.length) != (rhs.length)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        for (int i = 0; (i < (lhs.length)) && (isEquals); ++i) {
            append(lhs[i], rhs[i]);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final int[] lhs, final int[] rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs.length) != (rhs.length)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        for (int i = 0; (i < (lhs.length)) && (isEquals); ++i) {
            append(lhs[i], rhs[i]);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final short[] lhs, final short[] rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs.length) != (rhs.length)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        for (int i = 0; (i < (lhs.length)) && (isEquals); ++i) {
            append(lhs[i], rhs[i]);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final char[] lhs, final char[] rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs.length) != (rhs.length)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        for (int i = 0; (i < (lhs.length)) && (isEquals); ++i) {
            append(lhs[i], rhs[i]);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final byte[] lhs, final byte[] rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs.length) != (rhs.length)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        for (int i = 0; (i < (lhs.length)) && (isEquals); ++i) {
            append(lhs[i], rhs[i]);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final double[] lhs, final double[] rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs.length) != (rhs.length)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        for (int i = 0; (i < (lhs.length)) && (isEquals); ++i) {
            append(lhs[i], rhs[i]);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final float[] lhs, final float[] rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs.length) != (rhs.length)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        for (int i = 0; (i < (lhs.length)) && (isEquals); ++i) {
            append(lhs[i], rhs[i]);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public org.apache.commons.lang3.builder.EqualsBuilder append(final boolean[] lhs, final boolean[] rhs) {
        if (!(isEquals)) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if (lhs == rhs) {
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs == null) || (rhs == null)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        if ((lhs.length) != (rhs.length)) {
            org.apache.commons.lang3.builder.EqualsBuilder.this.setEquals(false);
            return org.apache.commons.lang3.builder.EqualsBuilder.this;
        }
        for (int i = 0; (i < (lhs.length)) && (isEquals); ++i) {
            append(lhs[i], rhs[i]);
        }
        return org.apache.commons.lang3.builder.EqualsBuilder.this;
    }

    public boolean isEquals() {
        return org.apache.commons.lang3.builder.EqualsBuilder.this.isEquals;
    }

    @java.lang.Override
    public java.lang.Boolean build() {
        return java.lang.Boolean.valueOf(isEquals());
    }

    protected void setEquals(final boolean isEquals) {
        org.apache.commons.lang3.builder.EqualsBuilder.this.isEquals = isEquals;
    }

    public void reset() {
        org.apache.commons.lang3.builder.EqualsBuilder.this.isEquals = true;
    }
}

