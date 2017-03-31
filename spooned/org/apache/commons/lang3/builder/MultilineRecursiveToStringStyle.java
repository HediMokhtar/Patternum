

package org.apache.commons.lang3.builder;


public class MultilineRecursiveToStringStyle extends org.apache.commons.lang3.builder.RecursiveToStringStyle {
    private static final long serialVersionUID = 1L;

    private static final int INDENT = 2;

    private int spaces = 2;

    public MultilineRecursiveToStringStyle() {
        super();
        resetIndent();
    }

    private void resetIndent() {
        setArrayStart((("{" + (java.lang.System.lineSeparator())) + (spacer(spaces))));
        setArraySeparator((("," + (java.lang.System.lineSeparator())) + (spacer(spaces))));
        setArrayEnd((((java.lang.System.lineSeparator()) + (spacer(((spaces) - (org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT))))) + "}"));
        setContentStart((("[" + (java.lang.System.lineSeparator())) + (spacer(spaces))));
        setFieldSeparator((("," + (java.lang.System.lineSeparator())) + (spacer(spaces))));
        setContentEnd((((java.lang.System.lineSeparator()) + (spacer(((spaces) - (org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT))))) + "]"));
    }

    private java.lang.StringBuilder spacer(final int spaces) {
        final java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
        return sb;
    }

    @java.lang.Override
    public void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final java.lang.Object value) {
        if (((!(org.apache.commons.lang3.ClassUtils.isPrimitiveWrapper(value.getClass()))) && (!(java.lang.String.class.equals(value.getClass())))) && (accept(value.getClass()))) {
            spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
            resetIndent();
            buffer.append(org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(value, org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.this));
            spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
            resetIndent();
        }else {
            super.appendDetail(buffer, fieldName, value);
        }
    }

    @java.lang.Override
    protected void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final java.lang.Object[] array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }

    @java.lang.Override
    protected void reflectionAppendArrayDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final java.lang.Object array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }

    @java.lang.Override
    protected void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final long[] array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }

    @java.lang.Override
    protected void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final int[] array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }

    @java.lang.Override
    protected void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final short[] array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }

    @java.lang.Override
    protected void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final byte[] array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }

    @java.lang.Override
    protected void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final char[] array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }

    @java.lang.Override
    protected void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final double[] array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }

    @java.lang.Override
    protected void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final float[] array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }

    @java.lang.Override
    protected void appendDetail(final java.lang.StringBuffer buffer, final java.lang.String fieldName, final boolean[] array) {
        spaces += org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
        super.appendDetail(buffer, fieldName, array);
        spaces -= org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle.INDENT;
        resetIndent();
    }
}

