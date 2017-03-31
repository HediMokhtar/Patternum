

package org.apache.commons.lang3.text;


public class WordUtils {
    public WordUtils() {
        super();
    }

    public static java.lang.String wrap(final java.lang.String str, final int wrapLength) {
        return org.apache.commons.lang3.text.WordUtils.wrap(str, wrapLength, null, false);
    }

    public static java.lang.String wrap(final java.lang.String str, final int wrapLength, final java.lang.String newLineStr, final boolean wrapLongWords) {
        return org.apache.commons.lang3.text.WordUtils.wrap(str, wrapLength, newLineStr, wrapLongWords, " ");
    }

    public static java.lang.String wrap(final java.lang.String str, int wrapLength, java.lang.String newLineStr, final boolean wrapLongWords, java.lang.String wrapOn) {
        if (str == null) {
            return null;
        }
        if (newLineStr == null) {
            newLineStr = java.lang.System.lineSeparator();
        }
        if (wrapLength < 1) {
            wrapLength = 1;
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(wrapOn)) {
            wrapOn = " ";
        }
        final java.util.regex.Pattern patternToWrapOn = java.util.regex.Pattern.compile(wrapOn);
        final int inputLineLength = str.length();
        int offset = 0;
        final java.lang.StringBuilder wrappedLine = new java.lang.StringBuilder((inputLineLength + 32));
        while (offset < inputLineLength) {
            int spaceToWrapAt = -1;
            java.util.regex.Matcher matcher = patternToWrapOn.matcher(str.substring(offset, java.lang.Math.min(((offset + wrapLength) + 1), inputLineLength)));
            if (matcher.find()) {
                if ((matcher.start()) == 0) {
                    offset += matcher.end();
                    continue;
                }else {
                    spaceToWrapAt = (matcher.start()) + offset;
                }
            }
            if ((inputLineLength - offset) <= wrapLength) {
                break;
            }
            while (matcher.find()) {
                spaceToWrapAt = (matcher.start()) + offset;
            } 
            if (spaceToWrapAt >= offset) {
                wrappedLine.append(str.substring(offset, spaceToWrapAt));
                wrappedLine.append(newLineStr);
                offset = spaceToWrapAt + 1;
            }else {
                if (wrapLongWords) {
                    wrappedLine.append(str.substring(offset, (wrapLength + offset)));
                    wrappedLine.append(newLineStr);
                    offset += wrapLength;
                }else {
                    matcher = patternToWrapOn.matcher(str.substring((offset + wrapLength)));
                    if (matcher.find()) {
                        spaceToWrapAt = ((matcher.start()) + offset) + wrapLength;
                    }
                    if (spaceToWrapAt >= 0) {
                        wrappedLine.append(str.substring(offset, spaceToWrapAt));
                        wrappedLine.append(newLineStr);
                        offset = spaceToWrapAt + 1;
                    }else {
                        wrappedLine.append(str.substring(offset));
                        offset = inputLineLength;
                    }
                }
            }
        } 
        wrappedLine.append(str.substring(offset));
        return wrappedLine.toString();
    }

    public static java.lang.String capitalize(final java.lang.String str) {
        return org.apache.commons.lang3.text.WordUtils.capitalize(str, null);
    }

    public static java.lang.String capitalize(final java.lang.String str, final char... delimiters) {
        final int delimLen = delimiters == null ? -1 : delimiters.length;
        if ((org.apache.commons.lang3.StringUtils.isEmpty(str)) || (delimLen == 0)) {
            return str;
        }
        final char[] buffer = str.toCharArray();
        boolean capitalizeNext = true;
        for (int i = 0; i < (buffer.length); i++) {
            final char ch = buffer[i];
            if (org.apache.commons.lang3.text.WordUtils.isDelimiter(ch, delimiters)) {
                capitalizeNext = true;
            }else
                if (capitalizeNext) {
                    buffer[i] = java.lang.Character.toTitleCase(ch);
                    capitalizeNext = false;
                }
            
        }
        return new java.lang.String(buffer);
    }

    public static java.lang.String capitalizeFully(final java.lang.String str) {
        return org.apache.commons.lang3.text.WordUtils.capitalizeFully(str, null);
    }

    public static java.lang.String capitalizeFully(java.lang.String str, final char... delimiters) {
        final int delimLen = delimiters == null ? -1 : delimiters.length;
        if ((org.apache.commons.lang3.StringUtils.isEmpty(str)) || (delimLen == 0)) {
            return str;
        }
        str = str.toLowerCase();
        return org.apache.commons.lang3.text.WordUtils.capitalize(str, delimiters);
    }

    public static java.lang.String uncapitalize(final java.lang.String str) {
        return org.apache.commons.lang3.text.WordUtils.uncapitalize(str, null);
    }

    public static java.lang.String uncapitalize(final java.lang.String str, final char... delimiters) {
        final int delimLen = delimiters == null ? -1 : delimiters.length;
        if ((org.apache.commons.lang3.StringUtils.isEmpty(str)) || (delimLen == 0)) {
            return str;
        }
        final char[] buffer = str.toCharArray();
        boolean uncapitalizeNext = true;
        for (int i = 0; i < (buffer.length); i++) {
            final char ch = buffer[i];
            if (org.apache.commons.lang3.text.WordUtils.isDelimiter(ch, delimiters)) {
                uncapitalizeNext = true;
            }else
                if (uncapitalizeNext) {
                    buffer[i] = java.lang.Character.toLowerCase(ch);
                    uncapitalizeNext = false;
                }
            
        }
        return new java.lang.String(buffer);
    }

    public static java.lang.String swapCase(final java.lang.String str) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(str)) {
            return str;
        }
        final char[] buffer = str.toCharArray();
        boolean whitespace = true;
        for (int i = 0; i < (buffer.length); i++) {
            final char ch = buffer[i];
            if (java.lang.Character.isUpperCase(ch)) {
                buffer[i] = java.lang.Character.toLowerCase(ch);
                whitespace = false;
            }else
                if (java.lang.Character.isTitleCase(ch)) {
                    buffer[i] = java.lang.Character.toLowerCase(ch);
                    whitespace = false;
                }else
                    if (java.lang.Character.isLowerCase(ch)) {
                        if (whitespace) {
                            buffer[i] = java.lang.Character.toTitleCase(ch);
                            whitespace = false;
                        }else {
                            buffer[i] = java.lang.Character.toUpperCase(ch);
                        }
                    }else {
                        whitespace = java.lang.Character.isWhitespace(ch);
                    }
                
            
        }
        return new java.lang.String(buffer);
    }

    public static java.lang.String initials(final java.lang.String str) {
        return org.apache.commons.lang3.text.WordUtils.initials(str, null);
    }

    public static java.lang.String initials(final java.lang.String str, final char... delimiters) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(str)) {
            return str;
        }
        if ((delimiters != null) && ((delimiters.length) == 0)) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        final int strLen = str.length();
        final char[] buf = new char[(strLen / 2) + 1];
        int count = 0;
        boolean lastWasGap = true;
        for (int i = 0; i < strLen; i++) {
            final char ch = str.charAt(i);
            if (org.apache.commons.lang3.text.WordUtils.isDelimiter(ch, delimiters)) {
                lastWasGap = true;
            }else
                if (lastWasGap) {
                    buf[(count++)] = ch;
                    lastWasGap = false;
                }else {
                    continue;
                }
            
        }
        return new java.lang.String(buf, 0, count);
    }

    public static boolean containsAllWords(final java.lang.CharSequence word, final java.lang.CharSequence... words) {
        if ((org.apache.commons.lang3.StringUtils.isEmpty(word)) || (org.apache.commons.lang3.ArrayUtils.isEmpty(words))) {
            return false;
        }
        for (final java.lang.CharSequence w : words) {
            if (org.apache.commons.lang3.StringUtils.isBlank(w)) {
                return false;
            }
            final java.util.regex.Pattern p = java.util.regex.Pattern.compile(((".*\\b" + w) + "\\b.*"));
            if (!(p.matcher(word).matches())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDelimiter(final char ch, final char[] delimiters) {
        if (delimiters == null) {
            return java.lang.Character.isWhitespace(ch);
        }
        for (final char delimiter : delimiters) {
            if (ch == delimiter) {
                return true;
            }
        }
        return false;
    }
}

