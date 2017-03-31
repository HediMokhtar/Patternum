

package org.apache.commons.lang3;


public class CharSequenceUtils {
    private static final int NOT_FOUND = -1;

    public CharSequenceUtils() {
        super();
    }

    public static java.lang.CharSequence subSequence(final java.lang.CharSequence cs, final int start) {
        return cs == null ? null : cs.subSequence(start, cs.length());
    }

    static int indexOf(final java.lang.CharSequence cs, final int searchChar, int start) {
        if (cs instanceof java.lang.String) {
            return ((java.lang.String) (cs)).indexOf(searchChar, start);
        }
        final int sz = cs.length();
        if (start < 0) {
            start = 0;
        }
        if (searchChar < (java.lang.Character.MIN_SUPPLEMENTARY_CODE_POINT)) {
            for (int i = start; i < sz; i++) {
                if ((cs.charAt(i)) == searchChar) {
                    return i;
                }
            }
        }
        if (searchChar <= (java.lang.Character.MAX_CODE_POINT)) {
            char[] chars = java.lang.Character.toChars(searchChar);
            for (int i = start; i < (sz - 1); i++) {
                char high = cs.charAt(i);
                char low = cs.charAt((i + 1));
                if ((high == (chars[0])) && (low == (chars[1]))) {
                    return i;
                }
            }
        }
        return org.apache.commons.lang3.CharSequenceUtils.NOT_FOUND;
    }

    static int indexOf(final java.lang.CharSequence cs, final java.lang.CharSequence searchChar, final int start) {
        return cs.toString().indexOf(searchChar.toString(), start);
    }

    static int lastIndexOf(final java.lang.CharSequence cs, final int searchChar, int start) {
        if (cs instanceof java.lang.String) {
            return ((java.lang.String) (cs)).lastIndexOf(searchChar, start);
        }
        final int sz = cs.length();
        if (start < 0) {
            return org.apache.commons.lang3.CharSequenceUtils.NOT_FOUND;
        }
        if (start >= sz) {
            start = sz - 1;
        }
        if (searchChar < (java.lang.Character.MIN_SUPPLEMENTARY_CODE_POINT)) {
            for (int i = start; i >= 0; --i) {
                if ((cs.charAt(i)) == searchChar) {
                    return i;
                }
            }
        }
        if (searchChar <= (java.lang.Character.MAX_CODE_POINT)) {
            char[] chars = java.lang.Character.toChars(searchChar);
            if (start == (sz - 1)) {
                return org.apache.commons.lang3.CharSequenceUtils.NOT_FOUND;
            }
            for (int i = start; i >= 0; i--) {
                char high = cs.charAt(i);
                char low = cs.charAt((i + 1));
                if (((chars[0]) == high) && ((chars[1]) == low)) {
                    return i;
                }
            }
        }
        return org.apache.commons.lang3.CharSequenceUtils.NOT_FOUND;
    }

    static int lastIndexOf(final java.lang.CharSequence cs, final java.lang.CharSequence searchChar, final int start) {
        return cs.toString().lastIndexOf(searchChar.toString(), start);
    }

    static char[] toCharArray(final java.lang.CharSequence cs) {
        if (cs instanceof java.lang.String) {
            return ((java.lang.String) (cs)).toCharArray();
        }
        final int sz = cs.length();
        final char[] array = new char[cs.length()];
        for (int i = 0; i < sz; i++) {
            array[i] = cs.charAt(i);
        }
        return array;
    }

    static boolean regionMatches(final java.lang.CharSequence cs, final boolean ignoreCase, final int thisStart, final java.lang.CharSequence substring, final int start, final int length) {
        if ((cs instanceof java.lang.String) && (substring instanceof java.lang.String)) {
            return ((java.lang.String) (cs)).regionMatches(ignoreCase, thisStart, ((java.lang.String) (substring)), start, length);
        }
        int index1 = thisStart;
        int index2 = start;
        int tmpLen = length;
        final int srcLen = (cs.length()) - thisStart;
        final int otherLen = (substring.length()) - start;
        if (((thisStart < 0) || (start < 0)) || (length < 0)) {
            return false;
        }
        if ((srcLen < length) || (otherLen < length)) {
            return false;
        }
        while ((tmpLen--) > 0) {
            final char c1 = cs.charAt((index1++));
            final char c2 = substring.charAt((index2++));
            if (c1 == c2) {
                continue;
            }
            if (!ignoreCase) {
                return false;
            }
            if (((java.lang.Character.toUpperCase(c1)) != (java.lang.Character.toUpperCase(c2))) && ((java.lang.Character.toLowerCase(c1)) != (java.lang.Character.toLowerCase(c2)))) {
                return false;
            }
        } 
        return true;
    }
}

