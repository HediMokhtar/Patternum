

package org.apache.commons.lang3.reflect;


abstract class MemberUtils {
    private static final int ACCESS_TEST = ((java.lang.reflect.Modifier.PUBLIC) | (java.lang.reflect.Modifier.PROTECTED)) | (java.lang.reflect.Modifier.PRIVATE);

    private static final java.lang.Class<?>[] ORDERED_PRIMITIVE_TYPES = new java.lang.Class<?>[]{ java.lang.Byte.TYPE , java.lang.Short.TYPE , java.lang.Character.TYPE , java.lang.Integer.TYPE , java.lang.Long.TYPE , java.lang.Float.TYPE , java.lang.Double.TYPE };

    static boolean setAccessibleWorkaround(final java.lang.reflect.AccessibleObject o) {
        if ((o == null) || (o.isAccessible())) {
            return false;
        }
        final java.lang.reflect.Member m = ((java.lang.reflect.Member) (o));
        if (((!(o.isAccessible())) && (java.lang.reflect.Modifier.isPublic(m.getModifiers()))) && (org.apache.commons.lang3.reflect.MemberUtils.isPackageAccess(m.getDeclaringClass().getModifiers()))) {
            try {
                o.setAccessible(true);
                return true;
            } catch (final java.lang.SecurityException e) {
            }
        }
        return false;
    }

    static boolean isPackageAccess(final int modifiers) {
        return (modifiers & (org.apache.commons.lang3.reflect.MemberUtils.ACCESS_TEST)) == 0;
    }

    static boolean isAccessible(final java.lang.reflect.Member m) {
        return ((m != null) && (java.lang.reflect.Modifier.isPublic(m.getModifiers()))) && (!(m.isSynthetic()));
    }

    static int compareConstructorFit(final java.lang.reflect.Constructor<?> left, final java.lang.reflect.Constructor<?> right, final java.lang.Class<?>[] actual) {
        return org.apache.commons.lang3.reflect.MemberUtils.compareParameterTypes(org.apache.commons.lang3.reflect.MemberUtils.Executable.of(left), org.apache.commons.lang3.reflect.MemberUtils.Executable.of(right), actual);
    }

    static int compareMethodFit(final java.lang.reflect.Method left, final java.lang.reflect.Method right, final java.lang.Class<?>[] actual) {
        return org.apache.commons.lang3.reflect.MemberUtils.compareParameterTypes(org.apache.commons.lang3.reflect.MemberUtils.Executable.of(left), org.apache.commons.lang3.reflect.MemberUtils.Executable.of(right), actual);
    }

    private static int compareParameterTypes(final org.apache.commons.lang3.reflect.MemberUtils.Executable left, final org.apache.commons.lang3.reflect.MemberUtils.Executable right, final java.lang.Class<?>[] actual) {
        final float leftCost = org.apache.commons.lang3.reflect.MemberUtils.getTotalTransformationCost(actual, left);
        final float rightCost = org.apache.commons.lang3.reflect.MemberUtils.getTotalTransformationCost(actual, right);
        return leftCost < rightCost ? -1 : rightCost < leftCost ? 1 : 0;
    }

    private static float getTotalTransformationCost(final java.lang.Class<?>[] srcArgs, final org.apache.commons.lang3.reflect.MemberUtils.Executable executable) {
        final java.lang.Class<?>[] destArgs = executable.getParameterTypes();
        final boolean isVarArgs = executable.isVarArgs();
        float totalCost = 0.0F;
        final long normalArgsLen = isVarArgs ? (destArgs.length) - 1 : destArgs.length;
        if ((srcArgs.length) < normalArgsLen) {
            return java.lang.Float.MAX_VALUE;
        }
        for (int i = 0; i < normalArgsLen; i++) {
            totalCost += org.apache.commons.lang3.reflect.MemberUtils.getObjectTransformationCost(srcArgs[i], destArgs[i]);
        }
        if (isVarArgs) {
            final boolean noVarArgsPassed = (srcArgs.length) < (destArgs.length);
            final boolean explicitArrayForVarags = ((srcArgs.length) == (destArgs.length)) && (srcArgs[((srcArgs.length) - 1)].isArray());
            final float varArgsCost = 0.001F;
            final java.lang.Class<?> destClass = destArgs[((destArgs.length) - 1)].getComponentType();
            if (noVarArgsPassed) {
                totalCost += (org.apache.commons.lang3.reflect.MemberUtils.getObjectTransformationCost(destClass, java.lang.Object.class)) + varArgsCost;
            }else
                if (explicitArrayForVarags) {
                    final java.lang.Class<?> sourceClass = srcArgs[((srcArgs.length) - 1)].getComponentType();
                    totalCost += (org.apache.commons.lang3.reflect.MemberUtils.getObjectTransformationCost(sourceClass, destClass)) + varArgsCost;
                }else {
                    for (int i = (destArgs.length) - 1; i < (srcArgs.length); i++) {
                        final java.lang.Class<?> srcClass = srcArgs[i];
                        totalCost += (org.apache.commons.lang3.reflect.MemberUtils.getObjectTransformationCost(srcClass, destClass)) + varArgsCost;
                    }
                }
            
        }
        return totalCost;
    }

    private static float getObjectTransformationCost(java.lang.Class<?> srcClass, final java.lang.Class<?> destClass) {
        if (destClass.isPrimitive()) {
            return org.apache.commons.lang3.reflect.MemberUtils.getPrimitivePromotionCost(srcClass, destClass);
        }
        float cost = 0.0F;
        while ((srcClass != null) && (!(destClass.equals(srcClass)))) {
            if ((destClass.isInterface()) && (org.apache.commons.lang3.ClassUtils.isAssignable(srcClass, destClass))) {
                cost += 0.25F;
                break;
            }
            cost++;
            srcClass = srcClass.getSuperclass();
        } 
        if (srcClass == null) {
            cost += 1.5F;
        }
        return cost;
    }

    private static float getPrimitivePromotionCost(final java.lang.Class<?> srcClass, final java.lang.Class<?> destClass) {
        float cost = 0.0F;
        java.lang.Class<?> cls = srcClass;
        if (!(cls.isPrimitive())) {
            cost += 0.1F;
            cls = org.apache.commons.lang3.ClassUtils.wrapperToPrimitive(cls);
        }
        for (int i = 0; (cls != destClass) && (i < (org.apache.commons.lang3.reflect.MemberUtils.ORDERED_PRIMITIVE_TYPES.length)); i++) {
            if (cls == (org.apache.commons.lang3.reflect.MemberUtils.ORDERED_PRIMITIVE_TYPES[i])) {
                cost += 0.1F;
                if (i < ((org.apache.commons.lang3.reflect.MemberUtils.ORDERED_PRIMITIVE_TYPES.length) - 1)) {
                    cls = org.apache.commons.lang3.reflect.MemberUtils.ORDERED_PRIMITIVE_TYPES[(i + 1)];
                }
            }
        }
        return cost;
    }

    static boolean isMatchingMethod(final java.lang.reflect.Method method, final java.lang.Class<?>[] parameterTypes) {
        return org.apache.commons.lang3.reflect.MemberUtils.isMatchingExecutable(org.apache.commons.lang3.reflect.MemberUtils.Executable.of(method), parameterTypes);
    }

    static boolean isMatchingConstructor(final java.lang.reflect.Constructor<?> method, final java.lang.Class<?>[] parameterTypes) {
        return org.apache.commons.lang3.reflect.MemberUtils.isMatchingExecutable(org.apache.commons.lang3.reflect.MemberUtils.Executable.of(method), parameterTypes);
    }

    private static boolean isMatchingExecutable(final org.apache.commons.lang3.reflect.MemberUtils.Executable method, final java.lang.Class<?>[] parameterTypes) {
        final java.lang.Class<?>[] methodParameterTypes = method.getParameterTypes();
        if (method.isVarArgs()) {
            int i;
            for (i = 0; (i < ((methodParameterTypes.length) - 1)) && (i < (parameterTypes.length)); i++) {
                if (!(org.apache.commons.lang3.ClassUtils.isAssignable(parameterTypes[i], methodParameterTypes[i], true))) {
                    return false;
                }
            }
            final java.lang.Class<?> varArgParameterType = methodParameterTypes[((methodParameterTypes.length) - 1)].getComponentType();
            for (; i < (parameterTypes.length); i++) {
                if (!(org.apache.commons.lang3.ClassUtils.isAssignable(parameterTypes[i], varArgParameterType, true))) {
                    return false;
                }
            }
            return true;
        }
        return org.apache.commons.lang3.ClassUtils.isAssignable(parameterTypes, methodParameterTypes, true);
    }

    private static final class Executable {
        private final java.lang.Class<?>[] parameterTypes;

        private final boolean isVarArgs;

        private static org.apache.commons.lang3.reflect.MemberUtils.Executable of(final java.lang.reflect.Method method) {
            return new org.apache.commons.lang3.reflect.MemberUtils.Executable(method);
        }

        private static org.apache.commons.lang3.reflect.MemberUtils.Executable of(final java.lang.reflect.Constructor<?> constructor) {
            return new org.apache.commons.lang3.reflect.MemberUtils.Executable(constructor);
        }

        private Executable(final java.lang.reflect.Method method) {
            parameterTypes = method.getParameterTypes();
            isVarArgs = method.isVarArgs();
        }

        private Executable(final java.lang.reflect.Constructor<?> constructor) {
            parameterTypes = constructor.getParameterTypes();
            isVarArgs = constructor.isVarArgs();
        }

        public java.lang.Class<?>[] getParameterTypes() {
            return parameterTypes;
        }

        public boolean isVarArgs() {
            return isVarArgs;
        }
    }
}

