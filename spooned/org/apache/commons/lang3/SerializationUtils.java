

package org.apache.commons.lang3;


public class SerializationUtils {
    public SerializationUtils() {
        super();
    }

    public static <T extends java.io.Serializable> T clone(final T object) {
        if (object == null) {
            return null;
        }
        final byte[] objectData = org.apache.commons.lang3.SerializationUtils.serialize(object);
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(objectData);
        try (final org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream in = new org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream(bais, object.getClass().getClassLoader())) {
            @java.lang.SuppressWarnings(value = "unchecked")
            final T readObject = ((T) (in.readObject()));
            return readObject;
        } catch (final java.lang.ClassNotFoundException ex) {
            throw new org.apache.commons.lang3.SerializationException("ClassNotFoundException while reading cloned object data", ex);
        } catch (final java.io.IOException ex) {
            throw new org.apache.commons.lang3.SerializationException("IOException while reading or closing cloned object data", ex);
        }
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    public static <T extends java.io.Serializable> T roundtrip(final T msg) {
        return ((T) (org.apache.commons.lang3.SerializationUtils.deserialize(org.apache.commons.lang3.SerializationUtils.serialize(msg))));
    }

    public static void serialize(final java.io.Serializable obj, final java.io.OutputStream outputStream) {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("The OutputStream must not be null");
        }
        try (java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(outputStream)) {
            out.writeObject(obj);
        } catch (final java.io.IOException ex) {
            throw new org.apache.commons.lang3.SerializationException(ex);
        }
    }

    public static byte[] serialize(final java.io.Serializable obj) {
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(512);
        org.apache.commons.lang3.SerializationUtils.serialize(obj, baos);
        return baos.toByteArray();
    }

    public static <T> T deserialize(final java.io.InputStream inputStream) {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("The InputStream must not be null");
        }
        try (java.io.ObjectInputStream in = new java.io.ObjectInputStream(inputStream)) {
            @java.lang.SuppressWarnings(value = "unchecked")
            final T obj = ((T) (in.readObject()));
            return obj;
        } catch (java.lang.ClassNotFoundException | java.io.IOException ex) {
            throw new org.apache.commons.lang3.SerializationException(ex);
        }
    }

    public static <T> T deserialize(final byte[] objectData) {
        if (objectData == null) {
            throw new java.lang.IllegalArgumentException("The byte[] must not be null");
        }
        return org.apache.commons.lang3.SerializationUtils.<T>deserialize(new java.io.ByteArrayInputStream(objectData));
    }

    static class ClassLoaderAwareObjectInputStream extends java.io.ObjectInputStream {
        private static final java.util.Map<java.lang.String, java.lang.Class<?>> primitiveTypes = new java.util.HashMap<>();

        static {
            org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.put("byte", byte.class);
            org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.put("short", short.class);
            org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.put("int", int.class);
            org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.put("long", long.class);
            org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.put("float", float.class);
            org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.put("double", double.class);
            org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.put("boolean", boolean.class);
            org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.put("char", char.class);
            org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.put("void", void.class);
        }

        private final java.lang.ClassLoader classLoader;

        public ClassLoaderAwareObjectInputStream(final java.io.InputStream in, final java.lang.ClassLoader classLoader) throws java.io.IOException {
            super(in);
            this.classLoader = classLoader;
        }

        @java.lang.Override
        protected java.lang.Class<?> resolveClass(final java.io.ObjectStreamClass desc) throws java.io.IOException, java.lang.ClassNotFoundException {
            final java.lang.String name = desc.getName();
            try {
                return java.lang.Class.forName(name, false, classLoader);
            } catch (final java.lang.ClassNotFoundException ex) {
                try {
                    return java.lang.Class.forName(name, false, java.lang.Thread.currentThread().getContextClassLoader());
                } catch (final java.lang.ClassNotFoundException cnfe) {
                    final java.lang.Class<?> cls = org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.primitiveTypes.get(name);
                    if (cls != null) {
                        return cls;
                    }
                    throw cnfe;
                }
            }
        }
    }
}

