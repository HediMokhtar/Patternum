

package org.apache.commons.lang3.mutable;


public class MutableByte extends java.lang.Number implements java.lang.Comparable<org.apache.commons.lang3.mutable.MutableByte> , org.apache.commons.lang3.mutable.Mutable<java.lang.Number> {
    private static final long serialVersionUID = -1585823265L;

    private byte value;

    public MutableByte() {
        super();
    }

    public MutableByte(final byte value) {
        super();
        org.apache.commons.lang3.mutable.MutableByte.this.value = value;
    }

    public MutableByte(final java.lang.Number value) {
        super();
        org.apache.commons.lang3.mutable.MutableByte.this.value = value.byteValue();
    }

    public MutableByte(final java.lang.String value) throws java.lang.NumberFormatException {
        super();
        org.apache.commons.lang3.mutable.MutableByte.this.value = java.lang.Byte.parseByte(value);
    }

    @java.lang.Override
    public java.lang.Byte getValue() {
        return java.lang.Byte.valueOf(org.apache.commons.lang3.mutable.MutableByte.this.value);
    }

    public void setValue(final byte value) {
        org.apache.commons.lang3.mutable.MutableByte.this.value = value;
    }

    @java.lang.Override
    public void setValue(final java.lang.Number value) {
        org.apache.commons.lang3.mutable.MutableByte.this.value = value.byteValue();
    }

    public void increment() {
        (value)++;
    }

    public byte getAndIncrement() {
        final byte last = value;
        (value)++;
        return last;
    }

    public byte incrementAndGet() {
        (value)++;
        return value;
    }

    public void decrement() {
        (value)--;
    }

    public byte getAndDecrement() {
        final byte last = value;
        (value)--;
        return last;
    }

    public byte decrementAndGet() {
        (value)--;
        return value;
    }

    public void add(final byte operand) {
        org.apache.commons.lang3.mutable.MutableByte.this.value += operand;
    }

    public void add(final java.lang.Number operand) {
        org.apache.commons.lang3.mutable.MutableByte.this.value += operand.byteValue();
    }

    public void subtract(final byte operand) {
        org.apache.commons.lang3.mutable.MutableByte.this.value -= operand;
    }

    public void subtract(final java.lang.Number operand) {
        org.apache.commons.lang3.mutable.MutableByte.this.value -= operand.byteValue();
    }

    public byte addAndGet(final byte operand) {
        org.apache.commons.lang3.mutable.MutableByte.this.value += operand;
        return value;
    }

    public byte addAndGet(final java.lang.Number operand) {
        org.apache.commons.lang3.mutable.MutableByte.this.value += operand.byteValue();
        return value;
    }

    public byte getAndAdd(final byte operand) {
        final byte last = value;
        org.apache.commons.lang3.mutable.MutableByte.this.value += operand;
        return last;
    }

    public byte getAndAdd(final java.lang.Number operand) {
        final byte last = value;
        org.apache.commons.lang3.mutable.MutableByte.this.value += operand.byteValue();
        return last;
    }

    @java.lang.Override
    public byte byteValue() {
        return value;
    }

    @java.lang.Override
    public int intValue() {
        return value;
    }

    @java.lang.Override
    public long longValue() {
        return value;
    }

    @java.lang.Override
    public float floatValue() {
        return value;
    }

    @java.lang.Override
    public double doubleValue() {
        return value;
    }

    public java.lang.Byte toByte() {
        return java.lang.Byte.valueOf(byteValue());
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj instanceof org.apache.commons.lang3.mutable.MutableByte) {
            return (value) == (((org.apache.commons.lang3.mutable.MutableByte) (obj)).byteValue());
        }
        return false;
    }

    @java.lang.Override
    public int hashCode() {
        return value;
    }

    @java.lang.Override
    public int compareTo(final org.apache.commons.lang3.mutable.MutableByte other) {
        return org.apache.commons.lang3.math.NumberUtils.compare(org.apache.commons.lang3.mutable.MutableByte.this.value, other.value);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return java.lang.String.valueOf(value);
    }
}

