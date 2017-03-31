

package org.apache.commons.lang3.text.translate;


@java.lang.Deprecated
public class OctalUnescaper extends org.apache.commons.lang3.text.translate.CharSequenceTranslator {
    @java.lang.Override
    public int translate(final java.lang.CharSequence input, final int index, final java.io.Writer out) throws java.io.IOException {
        final int remaining = ((input.length()) - index) - 1;
        final java.lang.StringBuilder builder = new java.lang.StringBuilder();
        if ((((input.charAt(index)) == '\\') && (remaining > 0)) && (isOctalDigit(input.charAt((index + 1))))) {
            final int next = index + 1;
            final int next2 = index + 2;
            final int next3 = index + 3;
            builder.append(input.charAt(next));
            if ((remaining > 1) && (isOctalDigit(input.charAt(next2)))) {
                builder.append(input.charAt(next2));
                if (((remaining > 2) && (isZeroToThree(input.charAt(next)))) && (isOctalDigit(input.charAt(next3)))) {
                    builder.append(input.charAt(next3));
                }
            }
            out.write(java.lang.Integer.parseInt(builder.toString(), 8));
            return 1 + (builder.length());
        }
        return 0;
    }

    private boolean isOctalDigit(final char ch) {
        return (ch >= '0') && (ch <= '7');
    }

    private boolean isZeroToThree(final char ch) {
        return (ch >= '0') && (ch <= '3');
    }
}

