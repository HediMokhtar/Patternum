

package org.apache.commons.lang3.builder;


final class IDKey {
    private final java.lang.Object value;

    private final int id;

    public IDKey(final java.lang.Object _value) {
        id = java.lang.System.identityHashCode(_value);
        value = _value;
    }

    @java.lang.Override
    public int hashCode() {
        return id;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object other) {
        if (!(other instanceof org.apache.commons.lang3.builder.IDKey)) {
            return false;
        }
        final org.apache.commons.lang3.builder.IDKey idKey = ((org.apache.commons.lang3.builder.IDKey) (other));
        if ((id) != (idKey.id)) {
            return false;
        }
        return (value) == (idKey.value);
    }
}

