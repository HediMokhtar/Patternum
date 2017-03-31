

package org.apache.commons.lang3.mutable;


public class MutableDouble extends java.lang.Number implements java.lang.Comparable<org.apache.commons.lang3.mutable.MutableDouble> , org.apache.commons.lang3.mutable.Mutable<java.lang.Number> {
    private static final long serialVersionUID = 1587163916L;

    private double value;

    public MutableDouble() {
        super();
    }

    public MutableDouble(final double value) {
        super();
        org.apache.commons.lang3.mutable.MutableDouble.this.value = value;
    }

    public MutableDouble(final java.lang.Number value) {
        super();
        org.apache.commons.lang3.mutable.MutableDouble.this.value = value.doubleValue();
    }

    public MutableDouble(final java.lang.String value) throws java.lang.NumberFormatException {
        super();
        org.apache.commons.lang3.mutable.MutableDouble.this.value = java.lang.Double.parseDouble(value);
    }

    @java.lang.Override
    public java.lang.Double getValue() {
        return java.lang.Double.valueOf(org.apache.commons.lang3.mutable.MutableDouble.this.value);
    }

    public void setValue(final double value) {
        org.apache.commons.lang3.mutable.MutableDouble.this.value = value;
    }

    @java.lang.Override
    public void setValue(final java.lang.Number value) {
        org.apache.commons.lang3.mutable.MutableDouble.this.value = value.doubleValue();
    }

    public boolean isNaN() {
        return java.lang.Double.isNaN(value);
    }

    public boolean isInfinite() {
        return java.lang.Double.isInfinite(value);
    }

    public void increment() {
        (value)++;
    }

    public double getAndIncrement() {
        final double last = value;
        (value)++;
        return last;
    }

    public double incrementAndGet() {
        (value)++;
        return value;
    }

    public void decrement() {
        (value)--;
    }

    public double getAndDecrement() {
        final double last = value;
        (value)--;
        return last;
    }

    public double decrementAndGet() {
        (value)--;
        return value;
    }

    public void add(final double operand) {
        org.apache.commons.lang3.mutable.MutableDouble.this.value += operand;
    }

    public void add(final java.lang.Number operand) {
        org.apache.commons.lang3.mutable.MutableDouble.this.value += operand.doubleValue();
    }

    public void subtract(final double operand) {
        org.apache.commons.lang3.mutable.MutableDouble.this.value -= operand;
    }

    public void subtract(final java.lang.Number operand) {
        org.apache.commons.lang3.mutable.MutableDouble.this.value -= operand.doubleValue();
    }

    public double addAndGet(final double operand) {
        org.apache.commons.lang3.mutable.MutableDouble.this.value += operand;
        return value;
    }

    public double addAndGet(final java.lang.Number operand) {
        org.apache.commons.lang3.mutable.MutableDouble.this.value += operand.doubleValue();
        return value;
    }

    public double getAndAdd(final double operand) {
        final double last = value;
        org.apache.commons.lang3.mutable.MutableDouble.this.value += operand;
        return last;
    }

    public double getAndAdd(final java.lang.Number operand) {
        final double last = value;
        org.apache.commons.lang3.mutable.MutableDouble.this.value += operand.doubleValue();
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
        return ((float) (value));
    }

    @java.lang.Override
    public double doubleValue() {
        return value;
    }

    public java.lang.Double toDouble() {
        return java.lang.Double.valueOf(doubleValue());
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        return (obj instanceof org.apache.commons.lang3.mutable.MutableDouble) && ((java.lang.Double.doubleToLongBits(((org.apache.commons.lang3.mutable.MutableDouble) (obj)).value)) == (java.lang.Double.doubleToLongBits(value)));
    }

    @java.lang.Override
    public int hashCode() {
        final long bits = java.lang.Double.doubleToLongBits(value);
        return ((int) (bits ^ (bits >>> 32)));
    }

    @java.lang.Override
    public int compareTo(final org.apache.commons.lang3.mutable.MutableDouble other) {
        return java.lang.Double.compare(org.apache.commons.lang3.mutable.MutableDouble.this.value, other.value);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return java.lang.String.valueOf(value);
    }
}

