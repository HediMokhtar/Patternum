

package org.apache.commons.lang3;


public class ClassUtils {
    public enum Interfaces {
INCLUDE, EXCLUDE;    }

    public static final char PACKAGE_SEPARATOR_CHAR = '.';

    public static final java.lang.String PACKAGE_SEPARATOR = java.lang.String.valueOf(org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';

    public static final java.lang.String INNER_CLASS_SEPARATOR = java.lang.String.valueOf(org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR);

    private static final java.util.Map<java.lang.String, java.lang.Class<?>> namePrimitiveMap = new java.util.HashMap<>();

    static {
        org.apache.commons.lang3.ClassUtils.namePrimitiveMap.put("boolean", java.lang.Boolean.TYPE);
        org.apache.commons.lang3.ClassUtils.namePrimitiveMap.put("byte", java.lang.Byte.TYPE);
        org.apache.commons.lang3.ClassUtils.namePrimitiveMap.put("char", java.lang.Character.TYPE);
        org.apache.commons.lang3.ClassUtils.namePrimitiveMap.put("short", java.lang.Short.TYPE);
        org.apache.commons.lang3.ClassUtils.namePrimitiveMap.put("int", java.lang.Integer.TYPE);
        org.apache.commons.lang3.ClassUtils.namePrimitiveMap.put("long", java.lang.Long.TYPE);
        org.apache.commons.lang3.ClassUtils.namePrimitiveMap.put("double", java.lang.Double.TYPE);
        org.apache.commons.lang3.ClassUtils.namePrimitiveMap.put("float", java.lang.Float.TYPE);
        org.apache.commons.lang3.ClassUtils.namePrimitiveMap.put("void", java.lang.Void.TYPE);
    }

    private static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> primitiveWrapperMap = new java.util.HashMap<>();

    static {
        org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.put(java.lang.Boolean.TYPE, java.lang.Boolean.class);
        org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.put(java.lang.Byte.TYPE, java.lang.Byte.class);
        org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.put(java.lang.Character.TYPE, java.lang.Character.class);
        org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.put(java.lang.Short.TYPE, java.lang.Short.class);
        org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.put(java.lang.Integer.TYPE, java.lang.Integer.class);
        org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.put(java.lang.Long.TYPE, java.lang.Long.class);
        org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.put(java.lang.Double.TYPE, java.lang.Double.class);
        org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.put(java.lang.Float.TYPE, java.lang.Float.class);
        org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.put(java.lang.Void.TYPE, java.lang.Void.TYPE);
    }

    private static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> wrapperPrimitiveMap = new java.util.HashMap<>();

    static {
        for (final java.util.Map.Entry<java.lang.Class<?>, java.lang.Class<?>> entry : org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.entrySet()) {
            final java.lang.Class<?> primitiveClass = entry.getKey();
            final java.lang.Class<?> wrapperClass = entry.getValue();
            if (!(primitiveClass.equals(wrapperClass))) {
                org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap.put(wrapperClass, primitiveClass);
            }
        }
    }

    private static final java.util.Map<java.lang.String, java.lang.String> abbreviationMap;

    private static final java.util.Map<java.lang.String, java.lang.String> reverseAbbreviationMap;

    static {
        final java.util.Map<java.lang.String, java.lang.String> m = new java.util.HashMap<>();
        m.put("int", "I");
        m.put("boolean", "Z");
        m.put("float", "F");
        m.put("long", "J");
        m.put("short", "S");
        m.put("byte", "B");
        m.put("double", "D");
        m.put("char", "C");
        final java.util.Map<java.lang.String, java.lang.String> r = new java.util.HashMap<>();
        for (final java.util.Map.Entry<java.lang.String, java.lang.String> e : m.entrySet()) {
            r.put(e.getValue(), e.getKey());
        }
        abbreviationMap = java.util.Collections.unmodifiableMap(m);
        reverseAbbreviationMap = java.util.Collections.unmodifiableMap(r);
    }

    public ClassUtils() {
        super();
    }

    public static java.lang.String getShortClassName(final java.lang.Object object, final java.lang.String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        return org.apache.commons.lang3.ClassUtils.getShortClassName(object.getClass());
    }

    public static java.lang.String getShortClassName(final java.lang.Class<?> cls) {
        if (cls == null) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        return org.apache.commons.lang3.ClassUtils.getShortClassName(cls.getName());
    }

    public static java.lang.String getShortClassName(java.lang.String className) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(className)) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        final java.lang.StringBuilder arrayPrefix = new java.lang.StringBuilder();
        if (className.startsWith("[")) {
            while ((className.charAt(0)) == '[') {
                className = className.substring(1);
                arrayPrefix.append("[]");
            } 
            if (((className.charAt(0)) == 'L') && ((className.charAt(((className.length()) - 1))) == ';')) {
                className = className.substring(1, ((className.length()) - 1));
            }
            if (org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap.containsKey(className)) {
                className = org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap.get(className);
            }
        }
        final int lastDotIdx = className.lastIndexOf(org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR);
        final int innerIdx = className.indexOf(org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR, (lastDotIdx == (-1) ? 0 : lastDotIdx + 1));
        java.lang.String out = className.substring((lastDotIdx + 1));
        if (innerIdx != (-1)) {
            out = out.replace(org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR, org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        return out + arrayPrefix;
    }

    public static java.lang.String getSimpleName(final java.lang.Class<?> cls) {
        if (cls == null) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        return cls.getSimpleName();
    }

    public static java.lang.String getSimpleName(final java.lang.Object object, final java.lang.String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        return org.apache.commons.lang3.ClassUtils.getSimpleName(object.getClass());
    }

    public static java.lang.String getPackageName(final java.lang.Object object, final java.lang.String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        return org.apache.commons.lang3.ClassUtils.getPackageName(object.getClass());
    }

    public static java.lang.String getPackageName(final java.lang.Class<?> cls) {
        if (cls == null) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        return org.apache.commons.lang3.ClassUtils.getPackageName(cls.getName());
    }

    public static java.lang.String getPackageName(java.lang.String className) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(className)) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        while ((className.charAt(0)) == '[') {
            className = className.substring(1);
        } 
        if (((className.charAt(0)) == 'L') && ((className.charAt(((className.length()) - 1))) == ';')) {
            className = className.substring(1);
        }
        final int i = className.lastIndexOf(org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR);
        if (i == (-1)) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        return className.substring(0, i);
    }

    public static java.lang.String getAbbreviatedName(final java.lang.Class<?> cls, final int len) {
        if (cls == null) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        return org.apache.commons.lang3.ClassUtils.getAbbreviatedName(cls.getName(), len);
    }

    public static java.lang.String getAbbreviatedName(final java.lang.String className, final int len) {
        if (len <= 0) {
            throw new java.lang.IllegalArgumentException("len must be > 0");
        }
        if (className == null) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        int availableSpace = len;
        final int packageLevels = org.apache.commons.lang3.StringUtils.countMatches(className, '.');
        final java.lang.String[] output = new java.lang.String[packageLevels + 1];
        int endIndex = (className.length()) - 1;
        for (int level = packageLevels; level >= 0; level--) {
            final int startIndex = className.lastIndexOf('.', endIndex);
            final java.lang.String part = className.substring((startIndex + 1), (endIndex + 1));
            availableSpace -= part.length();
            if (level > 0) {
                availableSpace--;
            }
            if (level == packageLevels) {
                output[level] = part;
            }else {
                if (availableSpace > 0) {
                    output[level] = part;
                }else {
                    output[level] = part.substring(0, 1);
                }
            }
            endIndex = startIndex - 1;
        }
        return org.apache.commons.lang3.StringUtils.join(output, '.');
    }

    public static java.util.List<java.lang.Class<?>> getAllSuperclasses(final java.lang.Class<?> cls) {
        if (cls == null) {
            return null;
        }
        final java.util.List<java.lang.Class<?>> classes = new java.util.ArrayList<>();
        java.lang.Class<?> superclass = cls.getSuperclass();
        while (superclass != null) {
            classes.add(superclass);
            superclass = superclass.getSuperclass();
        } 
        return classes;
    }

    public static java.util.List<java.lang.Class<?>> getAllInterfaces(final java.lang.Class<?> cls) {
        if (cls == null) {
            return null;
        }
        final java.util.LinkedHashSet<java.lang.Class<?>> interfacesFound = new java.util.LinkedHashSet<>();
        org.apache.commons.lang3.ClassUtils.getAllInterfaces(cls, interfacesFound);
        return new java.util.ArrayList<>(interfacesFound);
    }

    private static void getAllInterfaces(java.lang.Class<?> cls, final java.util.HashSet<java.lang.Class<?>> interfacesFound) {
        while (cls != null) {
            final java.lang.Class<?>[] interfaces = cls.getInterfaces();
            for (final java.lang.Class<?> i : interfaces) {
                if (interfacesFound.add(i)) {
                    org.apache.commons.lang3.ClassUtils.getAllInterfaces(i, interfacesFound);
                }
            }
            cls = cls.getSuperclass();
        } 
    }

    public static java.util.List<java.lang.Class<?>> convertClassNamesToClasses(final java.util.List<java.lang.String> classNames) {
        if (classNames == null) {
            return null;
        }
        final java.util.List<java.lang.Class<?>> classes = new java.util.ArrayList<>(classNames.size());
        for (final java.lang.String className : classNames) {
            try {
                classes.add(java.lang.Class.forName(className));
            } catch (final java.lang.Exception ex) {
                classes.add(null);
            }
        }
        return classes;
    }

    public static java.util.List<java.lang.String> convertClassesToClassNames(final java.util.List<java.lang.Class<?>> classes) {
        if (classes == null) {
            return null;
        }
        final java.util.List<java.lang.String> classNames = new java.util.ArrayList<>(classes.size());
        for (final java.lang.Class<?> cls : classes) {
            if (cls == null) {
                classNames.add(null);
            }else {
                classNames.add(cls.getName());
            }
        }
        return classNames;
    }

    public static boolean isAssignable(final java.lang.Class<?>[] classArray, final java.lang.Class<?>... toClassArray) {
        return org.apache.commons.lang3.ClassUtils.isAssignable(classArray, toClassArray, org.apache.commons.lang3.SystemUtils.isJavaVersionAtLeast(org.apache.commons.lang3.JavaVersion.JAVA_1_5));
    }

    public static boolean isAssignable(java.lang.Class<?>[] classArray, java.lang.Class<?>[] toClassArray, final boolean autoboxing) {
        if ((org.apache.commons.lang3.ArrayUtils.isSameLength(classArray, toClassArray)) == false) {
            return false;
        }
        if (classArray == null) {
            classArray = org.apache.commons.lang3.ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (toClassArray == null) {
            toClassArray = org.apache.commons.lang3.ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < (classArray.length); i++) {
            if ((org.apache.commons.lang3.ClassUtils.isAssignable(classArray[i], toClassArray[i], autoboxing)) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimitiveOrWrapper(final java.lang.Class<?> type) {
        if (type == null) {
            return false;
        }
        return (type.isPrimitive()) || (org.apache.commons.lang3.ClassUtils.isPrimitiveWrapper(type));
    }

    public static boolean isPrimitiveWrapper(final java.lang.Class<?> type) {
        return org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap.containsKey(type);
    }

    public static boolean isAssignable(final java.lang.Class<?> cls, final java.lang.Class<?> toClass) {
        return org.apache.commons.lang3.ClassUtils.isAssignable(cls, toClass, org.apache.commons.lang3.SystemUtils.isJavaVersionAtLeast(org.apache.commons.lang3.JavaVersion.JAVA_1_5));
    }

    public static boolean isAssignable(java.lang.Class<?> cls, final java.lang.Class<?> toClass, final boolean autoboxing) {
        if (toClass == null) {
            return false;
        }
        if (cls == null) {
            return !(toClass.isPrimitive());
        }
        if (autoboxing) {
            if ((cls.isPrimitive()) && (!(toClass.isPrimitive()))) {
                cls = org.apache.commons.lang3.ClassUtils.primitiveToWrapper(cls);
                if (cls == null) {
                    return false;
                }
            }
            if ((toClass.isPrimitive()) && (!(cls.isPrimitive()))) {
                cls = org.apache.commons.lang3.ClassUtils.wrapperToPrimitive(cls);
                if (cls == null) {
                    return false;
                }
            }
        }
        if (cls.equals(toClass)) {
            return true;
        }
        if (cls.isPrimitive()) {
            if ((toClass.isPrimitive()) == false) {
                return false;
            }
            if (java.lang.Integer.TYPE.equals(cls)) {
                return ((java.lang.Long.TYPE.equals(toClass)) || (java.lang.Float.TYPE.equals(toClass))) || (java.lang.Double.TYPE.equals(toClass));
            }
            if (java.lang.Long.TYPE.equals(cls)) {
                return (java.lang.Float.TYPE.equals(toClass)) || (java.lang.Double.TYPE.equals(toClass));
            }
            if (java.lang.Boolean.TYPE.equals(cls)) {
                return false;
            }
            if (java.lang.Double.TYPE.equals(cls)) {
                return false;
            }
            if (java.lang.Float.TYPE.equals(cls)) {
                return java.lang.Double.TYPE.equals(toClass);
            }
            if (java.lang.Character.TYPE.equals(cls)) {
                return (((java.lang.Integer.TYPE.equals(toClass)) || (java.lang.Long.TYPE.equals(toClass))) || (java.lang.Float.TYPE.equals(toClass))) || (java.lang.Double.TYPE.equals(toClass));
            }
            if (java.lang.Short.TYPE.equals(cls)) {
                return (((java.lang.Integer.TYPE.equals(toClass)) || (java.lang.Long.TYPE.equals(toClass))) || (java.lang.Float.TYPE.equals(toClass))) || (java.lang.Double.TYPE.equals(toClass));
            }
            if (java.lang.Byte.TYPE.equals(cls)) {
                return ((((java.lang.Short.TYPE.equals(toClass)) || (java.lang.Integer.TYPE.equals(toClass))) || (java.lang.Long.TYPE.equals(toClass))) || (java.lang.Float.TYPE.equals(toClass))) || (java.lang.Double.TYPE.equals(toClass));
            }
            return false;
        }
        return toClass.isAssignableFrom(cls);
    }

    public static java.lang.Class<?> primitiveToWrapper(final java.lang.Class<?> cls) {
        java.lang.Class<?> convertedClass = cls;
        if ((cls != null) && (cls.isPrimitive())) {
            convertedClass = org.apache.commons.lang3.ClassUtils.primitiveWrapperMap.get(cls);
        }
        return convertedClass;
    }

    public static java.lang.Class<?>[] primitivesToWrappers(final java.lang.Class<?>... classes) {
        if (classes == null) {
            return null;
        }
        if ((classes.length) == 0) {
            return classes;
        }
        final java.lang.Class<?>[] convertedClasses = new java.lang.Class[classes.length];
        for (int i = 0; i < (classes.length); i++) {
            convertedClasses[i] = org.apache.commons.lang3.ClassUtils.primitiveToWrapper(classes[i]);
        }
        return convertedClasses;
    }

    public static java.lang.Class<?> wrapperToPrimitive(final java.lang.Class<?> cls) {
        return org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap.get(cls);
    }

    public static java.lang.Class<?>[] wrappersToPrimitives(final java.lang.Class<?>... classes) {
        if (classes == null) {
            return null;
        }
        if ((classes.length) == 0) {
            return classes;
        }
        final java.lang.Class<?>[] convertedClasses = new java.lang.Class[classes.length];
        for (int i = 0; i < (classes.length); i++) {
            convertedClasses[i] = org.apache.commons.lang3.ClassUtils.wrapperToPrimitive(classes[i]);
        }
        return convertedClasses;
    }

    public static boolean isInnerClass(final java.lang.Class<?> cls) {
        return (cls != null) && ((cls.getEnclosingClass()) != null);
    }

    public static java.lang.Class<?> getClass(final java.lang.ClassLoader classLoader, final java.lang.String className, final boolean initialize) throws java.lang.ClassNotFoundException {
        try {
            java.lang.Class<?> clazz;
            if (org.apache.commons.lang3.ClassUtils.namePrimitiveMap.containsKey(className)) {
                clazz = org.apache.commons.lang3.ClassUtils.namePrimitiveMap.get(className);
            }else {
                clazz = java.lang.Class.forName(org.apache.commons.lang3.ClassUtils.toCanonicalName(className), initialize, classLoader);
            }
            return clazz;
        } catch (final java.lang.ClassNotFoundException ex) {
            final int lastDotIndex = className.lastIndexOf(org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR);
            if (lastDotIndex != (-1)) {
                try {
                    return org.apache.commons.lang3.ClassUtils.getClass(classLoader, (((className.substring(0, lastDotIndex)) + (org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR)) + (className.substring((lastDotIndex + 1)))), initialize);
                } catch (final java.lang.ClassNotFoundException ex2) {
                }
            }
            throw ex;
        }
    }

    public static java.lang.Class<?> getClass(final java.lang.ClassLoader classLoader, final java.lang.String className) throws java.lang.ClassNotFoundException {
        return org.apache.commons.lang3.ClassUtils.getClass(classLoader, className, true);
    }

    public static java.lang.Class<?> getClass(final java.lang.String className) throws java.lang.ClassNotFoundException {
        return org.apache.commons.lang3.ClassUtils.getClass(className, true);
    }

    public static java.lang.Class<?> getClass(final java.lang.String className, final boolean initialize) throws java.lang.ClassNotFoundException {
        final java.lang.ClassLoader contextCL = java.lang.Thread.currentThread().getContextClassLoader();
        final java.lang.ClassLoader loader = contextCL == null ? org.apache.commons.lang3.ClassUtils.class.getClassLoader() : contextCL;
        return org.apache.commons.lang3.ClassUtils.getClass(loader, className, initialize);
    }

    public static java.lang.reflect.Method getPublicMethod(final java.lang.Class<?> cls, final java.lang.String methodName, final java.lang.Class<?>... parameterTypes) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        final java.lang.reflect.Method declaredMethod = cls.getMethod(methodName, parameterTypes);
        if (java.lang.reflect.Modifier.isPublic(declaredMethod.getDeclaringClass().getModifiers())) {
            return declaredMethod;
        }
        final java.util.List<java.lang.Class<?>> candidateClasses = new java.util.ArrayList<>();
        candidateClasses.addAll(org.apache.commons.lang3.ClassUtils.getAllInterfaces(cls));
        candidateClasses.addAll(org.apache.commons.lang3.ClassUtils.getAllSuperclasses(cls));
        for (final java.lang.Class<?> candidateClass : candidateClasses) {
            if (!(java.lang.reflect.Modifier.isPublic(candidateClass.getModifiers()))) {
                continue;
            }
            java.lang.reflect.Method candidateMethod;
            try {
                candidateMethod = candidateClass.getMethod(methodName, parameterTypes);
            } catch (final java.lang.NoSuchMethodException ex) {
                continue;
            }
            if (java.lang.reflect.Modifier.isPublic(candidateMethod.getDeclaringClass().getModifiers())) {
                return candidateMethod;
            }
        }
        throw new java.lang.NoSuchMethodException(((("Can't find a public method for " + methodName) + " ") + (org.apache.commons.lang3.ArrayUtils.toString(parameterTypes))));
    }

    private static java.lang.String toCanonicalName(java.lang.String className) {
        className = org.apache.commons.lang3.StringUtils.deleteWhitespace(className);
        if (className == null) {
            throw new java.lang.NullPointerException("className must not be null.");
        }else
            if (className.endsWith("[]")) {
                final java.lang.StringBuilder classNameBuffer = new java.lang.StringBuilder();
                while (className.endsWith("[]")) {
                    className = className.substring(0, ((className.length()) - 2));
                    classNameBuffer.append("[");
                } 
                final java.lang.String abbreviation = org.apache.commons.lang3.ClassUtils.abbreviationMap.get(className);
                if (abbreviation != null) {
                    classNameBuffer.append(abbreviation);
                }else {
                    classNameBuffer.append("L").append(className).append(";");
                }
                className = classNameBuffer.toString();
            }
        
        return className;
    }

    public static java.lang.Class<?>[] toClass(final java.lang.Object... array) {
        if (array == null) {
            return null;
        }else
            if ((array.length) == 0) {
                return org.apache.commons.lang3.ArrayUtils.EMPTY_CLASS_ARRAY;
            }
        
        final java.lang.Class<?>[] classes = new java.lang.Class[array.length];
        for (int i = 0; i < (array.length); i++) {
            classes[i] = ((array[i]) == null) ? null : array[i].getClass();
        }
        return classes;
    }

    public static java.lang.String getShortCanonicalName(final java.lang.Object object, final java.lang.String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        return org.apache.commons.lang3.ClassUtils.getShortCanonicalName(object.getClass().getName());
    }

    public static java.lang.String getShortCanonicalName(final java.lang.Class<?> cls) {
        if (cls == null) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        return org.apache.commons.lang3.ClassUtils.getShortCanonicalName(cls.getName());
    }

    public static java.lang.String getShortCanonicalName(final java.lang.String canonicalName) {
        return org.apache.commons.lang3.ClassUtils.getShortClassName(org.apache.commons.lang3.ClassUtils.getCanonicalName(canonicalName));
    }

    public static java.lang.String getPackageCanonicalName(final java.lang.Object object, final java.lang.String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        return org.apache.commons.lang3.ClassUtils.getPackageCanonicalName(object.getClass().getName());
    }

    public static java.lang.String getPackageCanonicalName(final java.lang.Class<?> cls) {
        if (cls == null) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        return org.apache.commons.lang3.ClassUtils.getPackageCanonicalName(cls.getName());
    }

    public static java.lang.String getPackageCanonicalName(final java.lang.String canonicalName) {
        return org.apache.commons.lang3.ClassUtils.getPackageName(org.apache.commons.lang3.ClassUtils.getCanonicalName(canonicalName));
    }

    private static java.lang.String getCanonicalName(java.lang.String className) {
        className = org.apache.commons.lang3.StringUtils.deleteWhitespace(className);
        if (className == null) {
            return null;
        }
        int dim = 0;
        while (className.startsWith("[")) {
            dim++;
            className = className.substring(1);
        } 
        if (dim < 1) {
            return className;
        }
        if (className.startsWith("L")) {
            className = className.substring(1, (className.endsWith(";") ? (className.length()) - 1 : className.length()));
        }else {
            if ((className.length()) > 0) {
                className = org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap.get(className.substring(0, 1));
            }
        }
        final java.lang.StringBuilder canonicalClassNameBuffer = new java.lang.StringBuilder(className);
        for (int i = 0; i < dim; i++) {
            canonicalClassNameBuffer.append("[]");
        }
        return canonicalClassNameBuffer.toString();
    }

    public static java.lang.Iterable<java.lang.Class<?>> hierarchy(final java.lang.Class<?> type) {
        return org.apache.commons.lang3.ClassUtils.hierarchy(type, org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE);
    }

    public static java.lang.Iterable<java.lang.Class<?>> hierarchy(final java.lang.Class<?> type, final org.apache.commons.lang3.ClassUtils.Interfaces interfacesBehavior) {
        final java.lang.Iterable<java.lang.Class<?>> classes = new java.lang.Iterable<java.lang.Class<?>>() {
            @java.lang.Override
            public java.util.Iterator<java.lang.Class<?>> iterator() {
                final org.apache.commons.lang3.mutable.MutableObject<java.lang.Class<?>> next = new org.apache.commons.lang3.mutable.MutableObject<java.lang.Class<?>>(type);
                return new java.util.Iterator<java.lang.Class<?>>() {
                    @java.lang.Override
                    public boolean hasNext() {
                        return (next.getValue()) != null;
                    }

                    @java.lang.Override
                    public java.lang.Class<?> next() {
                        final java.lang.Class<?> result = next.getValue();
                        next.setValue(result.getSuperclass());
                        return result;
                    }

                    @java.lang.Override
                    public void remove() {
                        throw new java.lang.UnsupportedOperationException();
                    }
                };
            }
        };
        if (interfacesBehavior != (org.apache.commons.lang3.ClassUtils.Interfaces.INCLUDE)) {
            return classes;
        }
        return new java.lang.Iterable<java.lang.Class<?>>() {
            @java.lang.Override
            public java.util.Iterator<java.lang.Class<?>> iterator() {
                final java.util.Set<java.lang.Class<?>> seenInterfaces = new java.util.HashSet<>();
                final java.util.Iterator<java.lang.Class<?>> wrapped = classes.iterator();
                return new java.util.Iterator<java.lang.Class<?>>() {
                    java.util.Iterator<java.lang.Class<?>> interfaces = java.util.Collections.<java.lang.Class<?>>emptySet().iterator();

                    @java.lang.Override
                    public boolean hasNext() {
                        return (interfaces.hasNext()) || (wrapped.hasNext());
                    }

                    @java.lang.Override
                    public java.lang.Class<?> next() {
                        if (interfaces.hasNext()) {
                            final java.lang.Class<?> nextInterface = interfaces.next();
                            seenInterfaces.add(nextInterface);
                            return nextInterface;
                        }
                        final java.lang.Class<?> nextSuperclass = wrapped.next();
                        final java.util.Set<java.lang.Class<?>> currentInterfaces = new java.util.LinkedHashSet<>();
                        walkInterfaces(currentInterfaces, nextSuperclass);
                        interfaces = currentInterfaces.iterator();
                        return nextSuperclass;
                    }

                    private void walkInterfaces(final java.util.Set<java.lang.Class<?>> addTo, final java.lang.Class<?> c) {
                        for (final java.lang.Class<?> iface : c.getInterfaces()) {
                            if (!(seenInterfaces.contains(iface))) {
                                addTo.add(iface);
                            }
                            walkInterfaces(addTo, iface);
                        }
                    }

                    @java.lang.Override
                    public void remove() {
                        throw new java.lang.UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
