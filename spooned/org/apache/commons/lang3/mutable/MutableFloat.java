

package org.apache.commons.lang3.mutable;


public class MutableFloat extends java.lang.Number implements java.lang.Comparable<org.apache.commons.lang3.mutable.MutableFloat> , org.apache.commons.lang3.mutable.Mutable<java.lang.Number> {
    private static final long serialVersionUID = 5787169186L;

    private float value;

    public MutableFloat() {
        super();
    }

    public MutableFloat(final float value) {
        super();
        org.apache.commons.lang3.mutable.MutableFloat.this.value = value;
    }

    public MutableFloat(final java.lang.Number value) {
        super();
        org.apache.commons.lang3.mutable.MutableFloat.this.value = value.floatValue();
    }

    public MutableFloat(final java.lang.String value) throws java.lang.NumberFormatException {
        super();
        org.apache.commons.lang3.mutable.MutableFloat.this.value = java.lang.Float.parseFloat(value);
    }

    @java.lang.Override
    public java.lang.Float getValue() {
        return java.lang.Float.valueOf(org.apache.commons.lang3.mutable.MutableFloat.this.value);
    }

    public void setValue(final float value) {
        org.apache.commons.lang3.mutable.MutableFloat.this.value = value;
    }

    @java.lang.Override
    public void setValue(final java.lang.Number value) {
        org.apache.commons.lang3.mutable.MutableFloat.this.value = value.floatValue();
    }

    public boolean isNaN() {
        return java.lang.Float.isNaN(value);
    }

    public boolean isInfinite() {
        return java.lang.Float.isInfinite(value);
    }

    public void increment() {
        (value)++;
    }

    public float getAndIncrement() {
        final float last = value;
        (value)++;
        return last;
    }

    public float incrementAndGet() {
        (value)++;
        return value;
    }

    public void decrement() {
        (value)--;
    }

    public float getAndDecrement() {
        final float last = value;
        (value)--;
        return last;
    }

    public float decrementAndGet() {
        (value)--;
        return value;
    }

    public void add(final float operand) {
        org.apache.commons.lang3.mutable.MutableFloat.this.value += operand;
    }

    public void add(final java.lang.Number operand) {
        org.apache.commons.lang3.mutable.MutableFloat.this.value += operand.floatValue();
    }

    public void subtract(final float operand) {
        org.apache.commons.lang3.mutable.MutableFloat.this.value -= operand;
    }

    public void subtract(final java.lang.Number operand) {
        org.apache.commons.lang3.mutable.MutableFloat.this.value -= operand.floatValue();
    }

    public float addAndGet(final float operand) {
        org.apache.commons.lang3.mutable.MutableFloat.this.value += operand;
        return value;
    }

    public float addAndGet(final java.lang.Number operand) {
        org.apache.commons.lang3.mutable.MutableFloat.this.value += operand.floatValue();
        return value;
    }

    public float getAndAdd(final float operand) {
        final float last = value;
        org.apache.commons.lang3.mutable.MutableFloat.this.value += operand;
        return last;
    }

    public float getAndAdd(final java.lang.Number operand) {
        final float last = value;
        org.apache.commons.lang3.mutable.MutableFloat.this.value += operand.floatValue();
        return last;
    }

    @java.lang.Override
    public int intValue() {
        return ((int) (value));
    }

    @java.lang.Override
    public long longValue() {
        return ((long) (value));
    }

    @java.lang.Override
    public float floatValue() {
        return value;
    }

    @java.lang.Override
    public double doubleValue() {
        return value;
    }

    public java.lang.Float toFloat() {
        return java.lang.Float.valueOf(floatValue());
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        return (obj instanceof org.apache.commons.lang3.mutable.MutableFloat) && ((java.lang.Float.floatToIntBits(((org.apache.commons.lang3.mutable.MutableFloat) (obj)).value)) == (java.lang.Float.floatToIntBits(value)));
    }

    @java.lang.Override
    public int hashCode() {
        return java.lang.Float.floatToIntBits(value);
    }

    @java.lang.Override
    public int compareTo(final org.apache.commons.lang3.mutable.MutableFloat other) {
        return java.lang.Float.compare(org.apache.commons.lang3.mutable.MutableFloat.this.value, other.value);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return java.lang.String.valueOf(value);
    }
}

