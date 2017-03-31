

package org.apache.commons.lang3.reflect;


public class MethodUtils {
    public MethodUtils() {
        super();
    }

    public static java.lang.Object invokeMethod(final java.lang.Object object, final java.lang.String methodName) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        return org.apache.commons.lang3.reflect.MethodUtils.invokeMethod(object, methodName, org.apache.commons.lang3.ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static java.lang.Object invokeMethod(final java.lang.Object object, final boolean forceAccess, final java.lang.String methodName) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        return org.apache.commons.lang3.reflect.MethodUtils.invokeMethod(object, forceAccess, methodName, org.apache.commons.lang3.ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static java.lang.Object invokeMethod(final java.lang.Object object, final java.lang.String methodName, java.lang.Object... args) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        args = org.apache.commons.lang3.ArrayUtils.nullToEmpty(args);
        final java.lang.Class<?>[] parameterTypes = org.apache.commons.lang3.ClassUtils.toClass(args);
        return org.apache.commons.lang3.reflect.MethodUtils.invokeMethod(object, methodName, args, parameterTypes);
    }

    public static java.lang.Object invokeMethod(final java.lang.Object object, final boolean forceAccess, final java.lang.String methodName, java.lang.Object... args) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        args = org.apache.commons.lang3.ArrayUtils.nullToEmpty(args);
        final java.lang.Class<?>[] parameterTypes = org.apache.commons.lang3.ClassUtils.toClass(args);
        return org.apache.commons.lang3.reflect.MethodUtils.invokeMethod(object, forceAccess, methodName, args, parameterTypes);
    }

    public static java.lang.Object invokeMethod(final java.lang.Object object, final boolean forceAccess, final java.lang.String methodName, java.lang.Object[] args, java.lang.Class<?>[] parameterTypes) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        parameterTypes = org.apache.commons.lang3.ArrayUtils.nullToEmpty(parameterTypes);
        args = org.apache.commons.lang3.ArrayUtils.nullToEmpty(args);
        final java.lang.String messagePrefix;
        java.lang.reflect.Method method = null;
        if (forceAccess) {
            messagePrefix = "No such method: ";
            method = org.apache.commons.lang3.reflect.MethodUtils.getMatchingMethod(object.getClass(), methodName, parameterTypes);
            if (method != null) {
                if (!(method.isAccessible())) {
                    method.setAccessible(true);
                }
            }
        }else {
            messagePrefix = "No such accessible method: ";
            method = org.apache.commons.lang3.reflect.MethodUtils.getMatchingAccessibleMethod(object.getClass(), methodName, parameterTypes);
        }
        if (method == null) {
            throw new java.lang.NoSuchMethodException((((messagePrefix + methodName) + "() on object: ") + (object.getClass().getName())));
        }
        args = org.apache.commons.lang3.reflect.MethodUtils.toVarArgs(method, args);
        return method.invoke(object, args);
    }

    public static java.lang.Object invokeMethod(final java.lang.Object object, final java.lang.String methodName, final java.lang.Object[] args, final java.lang.Class<?>[] parameterTypes) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        return org.apache.commons.lang3.reflect.MethodUtils.invokeMethod(object, false, methodName, args, parameterTypes);
    }

    public static java.lang.Object invokeExactMethod(final java.lang.Object object, final java.lang.String methodName) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        return org.apache.commons.lang3.reflect.MethodUtils.invokeExactMethod(object, methodName, org.apache.commons.lang3.ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static java.lang.Object invokeExactMethod(final java.lang.Object object, final java.lang.String methodName, java.lang.Object... args) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        args = org.apache.commons.lang3.ArrayUtils.nullToEmpty(args);
        final java.lang.Class<?>[] parameterTypes = org.apache.commons.lang3.ClassUtils.toClass(args);
        return org.apache.commons.lang3.reflect.MethodUtils.invokeExactMethod(object, methodName, args, parameterTypes);
    }

    public static java.lang.Object invokeExactMethod(final java.lang.Object object, final java.lang.String methodName, java.lang.Object[] args, java.lang.Class<?>[] parameterTypes) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        args = org.apache.commons.lang3.ArrayUtils.nullToEmpty(args);
        parameterTypes = org.apache.commons.lang3.ArrayUtils.nullToEmpty(parameterTypes);
        final java.lang.reflect.Method method = org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethod(object.getClass(), methodName, parameterTypes);
        if (method == null) {
            throw new java.lang.NoSuchMethodException(((("No such accessible method: " + methodName) + "() on object: ") + (object.getClass().getName())));
        }
        return method.invoke(object, args);
    }

    public static java.lang.Object invokeExactStaticMethod(final java.lang.Class<?> cls, final java.lang.String methodName, java.lang.Object[] args, java.lang.Class<?>[] parameterTypes) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        args = org.apache.commons.lang3.ArrayUtils.nullToEmpty(args);
        parameterTypes = org.apache.commons.lang3.ArrayUtils.nullToEmpty(parameterTypes);
        final java.lang.reflect.Method method = org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethod(cls, methodName, parameterTypes);
        if (method == null) {
            throw new java.lang.NoSuchMethodException(((("No such accessible method: " + methodName) + "() on class: ") + (cls.getName())));
        }
        return method.invoke(null, args);
    }

    public static java.lang.Object invokeStaticMethod(final java.lang.Class<?> cls, final java.lang.String methodName, java.lang.Object... args) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        args = org.apache.commons.lang3.ArrayUtils.nullToEmpty(args);
        final java.lang.Class<?>[] parameterTypes = org.apache.commons.lang3.ClassUtils.toClass(args);
        return org.apache.commons.lang3.reflect.MethodUtils.invokeStaticMethod(cls, methodName, args, parameterTypes);
    }

    public static java.lang.Object invokeStaticMethod(final java.lang.Class<?> cls, final java.lang.String methodName, java.lang.Object[] args, java.lang.Class<?>[] parameterTypes) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        args = org.apache.commons.lang3.ArrayUtils.nullToEmpty(args);
        parameterTypes = org.apache.commons.lang3.ArrayUtils.nullToEmpty(parameterTypes);
        final java.lang.reflect.Method method = org.apache.commons.lang3.reflect.MethodUtils.getMatchingAccessibleMethod(cls, methodName, parameterTypes);
        if (method == null) {
            throw new java.lang.NoSuchMethodException(((("No such accessible method: " + methodName) + "() on class: ") + (cls.getName())));
        }
        args = org.apache.commons.lang3.reflect.MethodUtils.toVarArgs(method, args);
        return method.invoke(null, args);
    }

    private static java.lang.Object[] toVarArgs(final java.lang.reflect.Method method, java.lang.Object[] args) {
        if (method.isVarArgs()) {
            final java.lang.Class<?>[] methodParameterTypes = method.getParameterTypes();
            args = org.apache.commons.lang3.reflect.MethodUtils.getVarArgs(args, methodParameterTypes);
        }
        return args;
    }

    static java.lang.Object[] getVarArgs(final java.lang.Object[] args, final java.lang.Class<?>[] methodParameterTypes) {
        if (((args.length) == (methodParameterTypes.length)) && (args[((args.length) - 1)].getClass().equals(methodParameterTypes[((methodParameterTypes.length) - 1)]))) {
            return args;
        }
        final java.lang.Object[] newArgs = new java.lang.Object[methodParameterTypes.length];
        java.lang.System.arraycopy(args, 0, newArgs, 0, ((methodParameterTypes.length) - 1));
        final java.lang.Class<?> varArgComponentType = methodParameterTypes[((methodParameterTypes.length) - 1)].getComponentType();
        final int varArgLength = ((args.length) - (methodParameterTypes.length)) + 1;
        java.lang.Object varArgsArray = java.lang.reflect.Array.newInstance(org.apache.commons.lang3.ClassUtils.primitiveToWrapper(varArgComponentType), varArgLength);
        java.lang.System.arraycopy(args, ((methodParameterTypes.length) - 1), varArgsArray, 0, varArgLength);
        if (varArgComponentType.isPrimitive()) {
            varArgsArray = org.apache.commons.lang3.ArrayUtils.toPrimitive(varArgsArray);
        }
        newArgs[((methodParameterTypes.length) - 1)] = varArgsArray;
        return newArgs;
    }

    public static java.lang.Object invokeExactStaticMethod(final java.lang.Class<?> cls, final java.lang.String methodName, java.lang.Object... args) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        args = org.apache.commons.lang3.ArrayUtils.nullToEmpty(args);
        final java.lang.Class<?>[] parameterTypes = org.apache.commons.lang3.ClassUtils.toClass(args);
        return org.apache.commons.lang3.reflect.MethodUtils.invokeExactStaticMethod(cls, methodName, args, parameterTypes);
    }

    public static java.lang.reflect.Method getAccessibleMethod(final java.lang.Class<?> cls, final java.lang.String methodName, final java.lang.Class<?>... parameterTypes) {
        try {
            return org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethod(cls.getMethod(methodName, parameterTypes));
        } catch (final java.lang.NoSuchMethodException e) {
            return null;
        }
    }

    public static java.lang.reflect.Method getAccessibleMethod(java.lang.reflect.Method method) {
        if (!(org.apache.commons.lang3.reflect.MemberUtils.isAccessible(method))) {
            return null;
        }
        final java.lang.Class<?> cls = method.getDeclaringClass();
        if (java.lang.reflect.Modifier.isPublic(cls.getModifiers())) {
            return method;
        }
        final java.lang.String methodName = method.getName();
        final java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
        method = org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethodFromInterfaceNest(cls, methodName, parameterTypes);
        if (method == null) {
            method = org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethodFromSuperclass(cls, methodName, parameterTypes);
        }
        return method;
    }

    private static java.lang.reflect.Method getAccessibleMethodFromSuperclass(final java.lang.Class<?> cls, final java.lang.String methodName, final java.lang.Class<?>... parameterTypes) {
        java.lang.Class<?> parentClass = cls.getSuperclass();
        while (parentClass != null) {
            if (java.lang.reflect.Modifier.isPublic(parentClass.getModifiers())) {
                try {
                    return parentClass.getMethod(methodName, parameterTypes);
                } catch (final java.lang.NoSuchMethodException e) {
                    return null;
                }
            }
            parentClass = parentClass.getSuperclass();
        } 
        return null;
    }

    private static java.lang.reflect.Method getAccessibleMethodFromInterfaceNest(java.lang.Class<?> cls, final java.lang.String methodName, final java.lang.Class<?>... parameterTypes) {
        for (; cls != null; cls = cls.getSuperclass()) {
            final java.lang.Class<?>[] interfaces = cls.getInterfaces();
            for (java.lang.Class<?> anInterface : interfaces) {
                if (!(java.lang.reflect.Modifier.isPublic(anInterface.getModifiers()))) {
                    continue;
                }
                try {
                    return anInterface.getDeclaredMethod(methodName, parameterTypes);
                } catch (final java.lang.NoSuchMethodException e) {
                }
                final java.lang.reflect.Method method = org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethodFromInterfaceNest(anInterface, methodName, parameterTypes);
                if (method != null) {
                    return method;
                }
            }
        }
        return null;
    }

    public static java.lang.reflect.Method getMatchingAccessibleMethod(final java.lang.Class<?> cls, final java.lang.String methodName, final java.lang.Class<?>... parameterTypes) {
        try {
            final java.lang.reflect.Method method = cls.getMethod(methodName, parameterTypes);
            org.apache.commons.lang3.reflect.MemberUtils.setAccessibleWorkaround(method);
            return method;
        } catch (final java.lang.NoSuchMethodException e) {
        }
        java.lang.reflect.Method bestMatch = null;
        final java.lang.reflect.Method[] methods = cls.getMethods();
        for (final java.lang.reflect.Method method : methods) {
            if ((method.getName().equals(methodName)) && (org.apache.commons.lang3.reflect.MemberUtils.isMatchingMethod(method, parameterTypes))) {
                final java.lang.reflect.Method accessibleMethod = org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethod(method);
                if ((accessibleMethod != null) && ((bestMatch == null) || ((org.apache.commons.lang3.reflect.MemberUtils.compareMethodFit(accessibleMethod, bestMatch, parameterTypes)) < 0))) {
                    bestMatch = accessibleMethod;
                }
            }
        }
        if (bestMatch != null) {
            org.apache.commons.lang3.reflect.MemberUtils.setAccessibleWorkaround(bestMatch);
        }
        if ((((bestMatch != null) && (bestMatch.isVarArgs())) && ((bestMatch.getParameterTypes().length) > 0)) && ((parameterTypes.length) > 0)) {
            final java.lang.Class<?>[] methodParameterTypes = bestMatch.getParameterTypes();
            final java.lang.Class<?> methodParameterComponentType = methodParameterTypes[((methodParameterTypes.length) - 1)].getComponentType();
            final java.lang.String methodParameterComponentTypeName = org.apache.commons.lang3.ClassUtils.primitiveToWrapper(methodParameterComponentType).getName();
            final java.lang.String parameterTypeName = parameterTypes[((parameterTypes.length) - 1)].getName();
            final java.lang.String parameterTypeSuperClassName = parameterTypes[((parameterTypes.length) - 1)].getSuperclass().getName();
            if ((!(methodParameterComponentTypeName.equals(parameterTypeName))) && (!(methodParameterComponentTypeName.equals(parameterTypeSuperClassName)))) {
                return null;
            }
        }
        return bestMatch;
    }

    public static java.lang.reflect.Method getMatchingMethod(final java.lang.Class<?> cls, final java.lang.String methodName, final java.lang.Class<?>... parameterTypes) {
        org.apache.commons.lang3.Validate.notNull(cls, "Null class not allowed.");
        org.apache.commons.lang3.Validate.notEmpty(methodName, "Null or blank methodName not allowed.");
        java.lang.reflect.Method[] methodArray = cls.getDeclaredMethods();
        final java.util.List<java.lang.Class<?>> superclassList = org.apache.commons.lang3.ClassUtils.getAllSuperclasses(cls);
        for (final java.lang.Class<?> klass : superclassList) {
            methodArray = org.apache.commons.lang3.ArrayUtils.addAll(methodArray, klass.getDeclaredMethods());
        }
        java.lang.reflect.Method inexactMatch = null;
        for (final java.lang.reflect.Method method : methodArray) {
            if ((methodName.equals(method.getName())) && (java.util.Objects.deepEquals(parameterTypes, method.getParameterTypes()))) {
                return method;
            }else
                if ((methodName.equals(method.getName())) && (org.apache.commons.lang3.ClassUtils.isAssignable(parameterTypes, method.getParameterTypes(), true))) {
                    if (inexactMatch == null) {
                        inexactMatch = method;
                    }else
                        if ((org.apache.commons.lang3.reflect.MethodUtils.distance(parameterTypes, method.getParameterTypes())) < (org.apache.commons.lang3.reflect.MethodUtils.distance(parameterTypes, inexactMatch.getParameterTypes()))) {
                            inexactMatch = method;
                        }
                    
                }
            
        }
        return inexactMatch;
    }

    private static int distance(final java.lang.Class<?>[] classArray, final java.lang.Class<?>[] toClassArray) {
        int answer = 0;
        if (!(org.apache.commons.lang3.ClassUtils.isAssignable(classArray, toClassArray, true))) {
            return -1;
        }
        for (int offset = 0; offset < (classArray.length); offset++) {
            if (classArray[offset].equals(toClassArray[offset])) {
                continue;
            }else
                if ((org.apache.commons.lang3.ClassUtils.isAssignable(classArray[offset], toClassArray[offset], true)) && (!(org.apache.commons.lang3.ClassUtils.isAssignable(classArray[offset], toClassArray[offset], false)))) {
                    answer++;
                }else {
                    answer = answer + 2;
                }
            
        }
        return answer;
    }

    public static java.util.Set<java.lang.reflect.Method> getOverrideHierarchy(final java.lang.reflect.Method method, final org.apache.commons.lang3.ClassUtils.Interfaces interfacesBehavior) {
        org.apache.commons.lang3.Validate.notNull(method);
        final java.util.Set<java.lang.reflect.Method> result = new java.util.LinkedHashSet<>();
        result.add(method);
        final java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
        final java.lang.Class<?> declaringClass = method.getDeclaringClass();
        final java.util.Iterator<java.lang.Class<?>> hierarchy = org.apache.commons.lang3.ClassUtils.hierarchy(declaringClass, interfacesBehavior).iterator();
        hierarchy.next();
        hierarchyTraversal : while (hierarchy.hasNext()) {
            final java.lang.Class<?> c = hierarchy.next();
            final java.lang.reflect.Method m = org.apache.commons.lang3.reflect.MethodUtils.getMatchingAccessibleMethod(c, method.getName(), parameterTypes);
            if (m == null) {
                continue;
            }
            if (java.util.Arrays.equals(m.getParameterTypes(), parameterTypes)) {
                result.add(m);
                continue;
            }
            final java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> typeArguments = org.apache.commons.lang3.reflect.TypeUtils.getTypeArguments(declaringClass, m.getDeclaringClass());
            for (int i = 0; i < (parameterTypes.length); i++) {
                final java.lang.reflect.Type childType = org.apache.commons.lang3.reflect.TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i]);
                final java.lang.reflect.Type parentType = org.apache.commons.lang3.reflect.TypeUtils.unrollVariables(typeArguments, m.getGenericParameterTypes()[i]);
                if (!(org.apache.commons.lang3.reflect.TypeUtils.equals(childType, parentType))) {
                    continue hierarchyTraversal;
                }
            }
            result.add(m);
        } 
        return result;
    }

    public static java.lang.reflect.Method[] getMethodsWithAnnotation(final java.lang.Class<?> cls, final java.lang.Class<? extends java.lang.annotation.Annotation> annotationCls) {
        final java.util.List<java.lang.reflect.Method> annotatedMethodsList = org.apache.commons.lang3.reflect.MethodUtils.getMethodsListWithAnnotation(cls, annotationCls);
        return annotatedMethodsList.toArray(new java.lang.reflect.Method[annotatedMethodsList.size()]);
    }

    public static java.util.List<java.lang.reflect.Method> getMethodsListWithAnnotation(final java.lang.Class<?> cls, final java.lang.Class<? extends java.lang.annotation.Annotation> annotationCls) {
        org.apache.commons.lang3.Validate.isTrue((cls != null), "The class must not be null");
        org.apache.commons.lang3.Validate.isTrue((annotationCls != null), "The annotation class must not be null");
        final java.lang.reflect.Method[] allMethods = cls.getMethods();
        final java.util.List<java.lang.reflect.Method> annotatedMethods = new java.util.ArrayList<>();
        for (final java.lang.reflect.Method method : allMethods) {
            if ((method.getAnnotation(annotationCls)) != null) {
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}

