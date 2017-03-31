

package org.apache.commons.lang3.builder;


public class ReflectionDiffBuilder implements org.apache.commons.lang3.builder.Builder<org.apache.commons.lang3.builder.DiffResult> {
    private final java.lang.Object left;

    private final java.lang.Object right;

    private final org.apache.commons.lang3.builder.DiffBuilder diffBuilder;

    public <T> ReflectionDiffBuilder(final T lhs, final T rhs, final org.apache.commons.lang3.builder.ToStringStyle style) {
        this.left = lhs;
        this.right = rhs;
        diffBuilder = new org.apache.commons.lang3.builder.DiffBuilder(lhs, rhs, style);
    }

    @java.lang.Override
    public org.apache.commons.lang3.builder.DiffResult build() {
        if (left.equals(right)) {
            return diffBuilder.build();
        }
        appendFields(left.getClass());
        return diffBuilder.build();
    }

    private void appendFields(final java.lang.Class<?> clazz) {
        for (final java.lang.reflect.Field field : org.apache.commons.lang3.reflect.FieldUtils.getAllFields(clazz)) {
            if (accept(field)) {
                try {
                    diffBuilder.append(field.getName(), org.apache.commons.lang3.reflect.FieldUtils.readField(field, left, true), org.apache.commons.lang3.reflect.FieldUtils.readField(field, right, true));
                } catch (final java.lang.IllegalAccessException ex) {
                    throw new java.lang.InternalError(("Unexpected IllegalAccessException: " + (ex.getMessage())));
                }
            }
        }
    }

    private boolean accept(final java.lang.reflect.Field field) {
        if ((field.getName().indexOf(org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR)) != (-1)) {
            return false;
        }
        if (java.lang.reflect.Modifier.isTransient(field.getModifiers())) {
            return false;
        }
        if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
            return false;
        }
        return true;
    }
}

