

package org.apache.commons.lang3.text.translate;


@java.lang.Deprecated
public class UnicodeEscaper extends org.apache.commons.lang3.text.translate.CodePointTranslator {
    private final int below;

    private final int above;

    private final boolean between;

    public UnicodeEscaper() {
        this(0, java.lang.Integer.MAX_VALUE, true);
    }

    protected UnicodeEscaper(final int below, final int above, final boolean between) {
        this.below = below;
        this.above = above;
        this.between = between;
    }

    public static org.apache.commons.lang3.text.translate.UnicodeEscaper below(final int codepoint) {
        return org.apache.commons.lang3.text.translate.UnicodeEscaper.outsideOf(codepoint, java.lang.Integer.MAX_VALUE);
    }

    public static org.apache.commons.lang3.text.translate.UnicodeEscaper above(final int codepoint) {
        return org.apache.commons.lang3.text.translate.UnicodeEscaper.outsideOf(0, codepoint);
    }

    public static org.apache.commons.lang3.text.translate.UnicodeEscaper outsideOf(final int codepointLow, final int codepointHigh) {
        return new org.apache.commons.lang3.text.translate.UnicodeEscaper(codepointLow, codepointHigh, false);
    }

    public static org.apache.commons.lang3.text.translate.UnicodeEscaper between(final int codepointLow, final int codepointHigh) {
        return new org.apache.commons.lang3.text.translate.UnicodeEscaper(codepointLow, codepointHigh, true);
    }

    @java.lang.Override
    public boolean translate(final int codepoint, final java.io.Writer out) throws java.io.IOException {
        if (between) {
            if ((codepoint < (below)) || (codepoint > (above))) {
                return false;
            }
        }else {
            if ((codepoint >= (below)) && (codepoint <= (above))) {
                return false;
            }
        }
        if (codepoint > 65535) {
            out.write(toUtf16Escape(codepoint));
        }else {
            out.write("\\u");
            out.write(org.apache.commons.lang3.text.translate.CharSequenceTranslator.HEX_DIGITS[((codepoint >> 12) & 15)]);
            out.write(org.apache.commons.lang3.text.translate.CharSequenceTranslator.HEX_DIGITS[((codepoint >> 8) & 15)]);
            out.write(org.apache.commons.lang3.text.translate.CharSequenceTranslator.HEX_DIGITS[((codepoint >> 4) & 15)]);
            out.write(org.apache.commons.lang3.text.translate.CharSequenceTranslator.HEX_DIGITS[(codepoint & 15)]);
        }
        return true;
    }

    protected java.lang.String toUtf16Escape(final int codepoint) {
        return "\\u" + (org.apache.commons.lang3.text.translate.CharSequenceTranslator.hex(codepoint));
    }
}

