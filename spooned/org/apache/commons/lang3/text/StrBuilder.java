

package org.apache.commons.lang3.text;


@java.lang.Deprecated
public class StrBuilder implements java.io.Serializable , java.lang.Appendable , java.lang.CharSequence , org.apache.commons.lang3.builder.Builder<java.lang.String> {
    static final int CAPACITY = 32;

    private static final long serialVersionUID = 7628716375283629643L;

    protected char[] buffer;

    protected int size;

    private java.lang.String newLine;

    private java.lang.String nullText;

    public StrBuilder() {
        this(org.apache.commons.lang3.text.StrBuilder.CAPACITY);
    }

    public StrBuilder(int initialCapacity) {
        super();
        if (initialCapacity <= 0) {
            initialCapacity = org.apache.commons.lang3.text.StrBuilder.CAPACITY;
        }
        buffer = new char[initialCapacity];
    }

    public StrBuilder(final java.lang.String str) {
        super();
        if (str == null) {
            buffer = new char[org.apache.commons.lang3.text.StrBuilder.CAPACITY];
        }else {
            buffer = new char[(str.length()) + (org.apache.commons.lang3.text.StrBuilder.CAPACITY)];
            append(str);
        }
    }

    public java.lang.String getNewLineText() {
        return newLine;
    }

    public org.apache.commons.lang3.text.StrBuilder setNewLineText(final java.lang.String newLine) {
        org.apache.commons.lang3.text.StrBuilder.this.newLine = newLine;
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public java.lang.String getNullText() {
        return nullText;
    }

    public org.apache.commons.lang3.text.StrBuilder setNullText(java.lang.String nullText) {
        if ((nullText != null) && (nullText.isEmpty())) {
            nullText = null;
        }
        org.apache.commons.lang3.text.StrBuilder.this.nullText = nullText;
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    @java.lang.Override
    public int length() {
        return size;
    }

    public org.apache.commons.lang3.text.StrBuilder setLength(final int length) {
        if (length < 0) {
            throw new java.lang.StringIndexOutOfBoundsException(length);
        }
        if (length < (size)) {
            size = length;
        }else
            if (length > (size)) {
                ensureCapacity(length);
                final int oldEnd = size;
                final int newEnd = length;
                size = length;
                for (int i = oldEnd; i < newEnd; i++) {
                    buffer[i] = ' ';
                }
            }
        
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public int capacity() {
        return buffer.length;
    }

    public org.apache.commons.lang3.text.StrBuilder ensureCapacity(final int capacity) {
        if (capacity > (buffer.length)) {
            final char[] old = buffer;
            buffer = new char[capacity * 2];
            java.lang.System.arraycopy(old, 0, buffer, 0, size);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder minimizeCapacity() {
        if ((buffer.length) > (length())) {
            final char[] old = buffer;
            buffer = new char[length()];
            java.lang.System.arraycopy(old, 0, buffer, 0, size);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size) == 0;
    }

    public org.apache.commons.lang3.text.StrBuilder clear() {
        size = 0;
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    @java.lang.Override
    public char charAt(final int index) {
        if ((index < 0) || (index >= (length()))) {
            throw new java.lang.StringIndexOutOfBoundsException(index);
        }
        return buffer[index];
    }

    public org.apache.commons.lang3.text.StrBuilder setCharAt(final int index, final char ch) {
        if ((index < 0) || (index >= (length()))) {
            throw new java.lang.StringIndexOutOfBoundsException(index);
        }
        buffer[index] = ch;
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder deleteCharAt(final int index) {
        if ((index < 0) || (index >= (size))) {
            throw new java.lang.StringIndexOutOfBoundsException(index);
        }
        deleteImpl(index, (index + 1), 1);
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public char[] toCharArray() {
        if ((size) == 0) {
            return org.apache.commons.lang3.ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        final char[] chars = new char[size];
        java.lang.System.arraycopy(buffer, 0, chars, 0, size);
        return chars;
    }

    public char[] toCharArray(final int startIndex, int endIndex) {
        endIndex = validateRange(startIndex, endIndex);
        final int len = endIndex - startIndex;
        if (len == 0) {
            return org.apache.commons.lang3.ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        final char[] chars = new char[len];
        java.lang.System.arraycopy(buffer, startIndex, chars, 0, len);
        return chars;
    }

    public char[] getChars(char[] destination) {
        final int len = length();
        if ((destination == null) || ((destination.length) < len)) {
            destination = new char[len];
        }
        java.lang.System.arraycopy(buffer, 0, destination, 0, len);
        return destination;
    }

    public void getChars(final int startIndex, final int endIndex, final char[] destination, final int destinationIndex) {
        if (startIndex < 0) {
            throw new java.lang.StringIndexOutOfBoundsException(startIndex);
        }
        if ((endIndex < 0) || (endIndex > (length()))) {
            throw new java.lang.StringIndexOutOfBoundsException(endIndex);
        }
        if (startIndex > endIndex) {
            throw new java.lang.StringIndexOutOfBoundsException("end < start");
        }
        java.lang.System.arraycopy(buffer, startIndex, destination, destinationIndex, (endIndex - startIndex));
    }

    public int readFrom(final java.lang.Readable readable) throws java.io.IOException {
        final int oldSize = size;
        if (readable instanceof java.io.Reader) {
            final java.io.Reader r = ((java.io.Reader) (readable));
            ensureCapacity(((size) + 1));
            int read;
            while ((read = r.read(buffer, size, ((buffer.length) - (size)))) != (-1)) {
                size += read;
                ensureCapacity(((size) + 1));
            } 
        }else
            if (readable instanceof java.nio.CharBuffer) {
                final java.nio.CharBuffer cb = ((java.nio.CharBuffer) (readable));
                final int remaining = cb.remaining();
                ensureCapacity(((size) + remaining));
                cb.get(buffer, size, remaining);
                size += remaining;
            }else {
                while (true) {
                    ensureCapacity(((size) + 1));
                    final java.nio.CharBuffer buf = java.nio.CharBuffer.wrap(buffer, size, ((buffer.length) - (size)));
                    final int read = readable.read(buf);
                    if (read == (-1)) {
                        break;
                    }
                    size += read;
                } 
            }
        
        return (size) - oldSize;
    }

    public org.apache.commons.lang3.text.StrBuilder appendNewLine() {
        if ((newLine) == null) {
            append(java.lang.System.lineSeparator());
            return org.apache.commons.lang3.text.StrBuilder.this;
        }
        return append(newLine);
    }

    public org.apache.commons.lang3.text.StrBuilder appendNull() {
        if ((nullText) == null) {
            return org.apache.commons.lang3.text.StrBuilder.this;
        }
        return append(nullText);
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.Object obj) {
        if (obj == null) {
            return appendNull();
        }
        if (obj instanceof java.lang.CharSequence) {
            return append(((java.lang.CharSequence) (obj)));
        }
        return append(obj.toString());
    }

    @java.lang.Override
    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.CharSequence seq) {
        if (seq == null) {
            return appendNull();
        }
        if (seq instanceof org.apache.commons.lang3.text.StrBuilder) {
            return append(((org.apache.commons.lang3.text.StrBuilder) (seq)));
        }
        if (seq instanceof java.lang.StringBuilder) {
            return append(((java.lang.StringBuilder) (seq)));
        }
        if (seq instanceof java.lang.StringBuffer) {
            return append(((java.lang.StringBuffer) (seq)));
        }
        if (seq instanceof java.nio.CharBuffer) {
            return append(((java.nio.CharBuffer) (seq)));
        }
        return append(seq.toString());
    }

    @java.lang.Override
    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.CharSequence seq, final int startIndex, final int length) {
        if (seq == null) {
            return appendNull();
        }
        return append(seq.toString(), startIndex, length);
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.String str) {
        if (str == null) {
            return appendNull();
        }
        final int strLen = str.length();
        if (strLen > 0) {
            final int len = length();
            ensureCapacity((len + strLen));
            str.getChars(0, strLen, buffer, len);
            size += strLen;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.String str, final int startIndex, final int length) {
        if (str == null) {
            return appendNull();
        }
        if ((startIndex < 0) || (startIndex > (str.length()))) {
            throw new java.lang.StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if ((length < 0) || ((startIndex + length) > (str.length()))) {
            throw new java.lang.StringIndexOutOfBoundsException("length must be valid");
        }
        if (length > 0) {
            final int len = length();
            ensureCapacity((len + length));
            str.getChars(startIndex, (startIndex + length), buffer, len);
            size += length;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.String format, final java.lang.Object... objs) {
        return append(java.lang.String.format(format, objs));
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.nio.CharBuffer buf) {
        if (buf == null) {
            return appendNull();
        }
        if (buf.hasArray()) {
            final int length = buf.remaining();
            final int len = length();
            ensureCapacity((len + length));
            java.lang.System.arraycopy(buf.array(), ((buf.arrayOffset()) + (buf.position())), buffer, len, length);
            size += length;
        }else {
            append(buf.toString());
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.nio.CharBuffer buf, final int startIndex, final int length) {
        if (buf == null) {
            return appendNull();
        }
        if (buf.hasArray()) {
            final int totalLength = buf.remaining();
            if ((startIndex < 0) || (startIndex > totalLength)) {
                throw new java.lang.StringIndexOutOfBoundsException("startIndex must be valid");
            }
            if ((length < 0) || ((startIndex + length) > totalLength)) {
                throw new java.lang.StringIndexOutOfBoundsException("length must be valid");
            }
            final int len = length();
            ensureCapacity((len + length));
            java.lang.System.arraycopy(buf.array(), (((buf.arrayOffset()) + (buf.position())) + startIndex), buffer, len, length);
            size += length;
        }else {
            append(buf.toString(), startIndex, length);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.StringBuffer str) {
        if (str == null) {
            return appendNull();
        }
        final int strLen = str.length();
        if (strLen > 0) {
            final int len = length();
            ensureCapacity((len + strLen));
            str.getChars(0, strLen, buffer, len);
            size += strLen;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.StringBuffer str, final int startIndex, final int length) {
        if (str == null) {
            return appendNull();
        }
        if ((startIndex < 0) || (startIndex > (str.length()))) {
            throw new java.lang.StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if ((length < 0) || ((startIndex + length) > (str.length()))) {
            throw new java.lang.StringIndexOutOfBoundsException("length must be valid");
        }
        if (length > 0) {
            final int len = length();
            ensureCapacity((len + length));
            str.getChars(startIndex, (startIndex + length), buffer, len);
            size += length;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.StringBuilder str) {
        if (str == null) {
            return appendNull();
        }
        final int strLen = str.length();
        if (strLen > 0) {
            final int len = length();
            ensureCapacity((len + strLen));
            str.getChars(0, strLen, buffer, len);
            size += strLen;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final java.lang.StringBuilder str, final int startIndex, final int length) {
        if (str == null) {
            return appendNull();
        }
        if ((startIndex < 0) || (startIndex > (str.length()))) {
            throw new java.lang.StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if ((length < 0) || ((startIndex + length) > (str.length()))) {
            throw new java.lang.StringIndexOutOfBoundsException("length must be valid");
        }
        if (length > 0) {
            final int len = length();
            ensureCapacity((len + length));
            str.getChars(startIndex, (startIndex + length), buffer, len);
            size += length;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final org.apache.commons.lang3.text.StrBuilder str) {
        if (str == null) {
            return appendNull();
        }
        final int strLen = str.length();
        if (strLen > 0) {
            final int len = length();
            ensureCapacity((len + strLen));
            java.lang.System.arraycopy(str.buffer, 0, buffer, len, strLen);
            size += strLen;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final org.apache.commons.lang3.text.StrBuilder str, final int startIndex, final int length) {
        if (str == null) {
            return appendNull();
        }
        if ((startIndex < 0) || (startIndex > (str.length()))) {
            throw new java.lang.StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if ((length < 0) || ((startIndex + length) > (str.length()))) {
            throw new java.lang.StringIndexOutOfBoundsException("length must be valid");
        }
        if (length > 0) {
            final int len = length();
            ensureCapacity((len + length));
            str.getChars(startIndex, (startIndex + length), buffer, len);
            size += length;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final char[] chars) {
        if (chars == null) {
            return appendNull();
        }
        final int strLen = chars.length;
        if (strLen > 0) {
            final int len = length();
            ensureCapacity((len + strLen));
            java.lang.System.arraycopy(chars, 0, buffer, len, strLen);
            size += strLen;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final char[] chars, final int startIndex, final int length) {
        if (chars == null) {
            return appendNull();
        }
        if ((startIndex < 0) || (startIndex > (chars.length))) {
            throw new java.lang.StringIndexOutOfBoundsException(("Invalid startIndex: " + length));
        }
        if ((length < 0) || ((startIndex + length) > (chars.length))) {
            throw new java.lang.StringIndexOutOfBoundsException(("Invalid length: " + length));
        }
        if (length > 0) {
            final int len = length();
            ensureCapacity((len + length));
            java.lang.System.arraycopy(chars, startIndex, buffer, len, length);
            size += length;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final boolean value) {
        if (value) {
            ensureCapacity(((size) + 4));
            buffer[((size)++)] = 't';
            buffer[((size)++)] = 'r';
            buffer[((size)++)] = 'u';
            buffer[((size)++)] = 'e';
        }else {
            ensureCapacity(((size) + 5));
            buffer[((size)++)] = 'f';
            buffer[((size)++)] = 'a';
            buffer[((size)++)] = 'l';
            buffer[((size)++)] = 's';
            buffer[((size)++)] = 'e';
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    @java.lang.Override
    public org.apache.commons.lang3.text.StrBuilder append(final char ch) {
        final int len = length();
        ensureCapacity((len + 1));
        buffer[((size)++)] = ch;
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder append(final int value) {
        return append(java.lang.String.valueOf(value));
    }

    public org.apache.commons.lang3.text.StrBuilder append(final long value) {
        return append(java.lang.String.valueOf(value));
    }

    public org.apache.commons.lang3.text.StrBuilder append(final float value) {
        return append(java.lang.String.valueOf(value));
    }

    public org.apache.commons.lang3.text.StrBuilder append(final double value) {
        return append(java.lang.String.valueOf(value));
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final java.lang.Object obj) {
        return append(obj).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final java.lang.String str) {
        return append(str).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final java.lang.String str, final int startIndex, final int length) {
        return append(str, startIndex, length).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final java.lang.String format, final java.lang.Object... objs) {
        return append(format, objs).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final java.lang.StringBuffer str) {
        return append(str).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final java.lang.StringBuilder str) {
        return append(str).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final java.lang.StringBuilder str, final int startIndex, final int length) {
        return append(str, startIndex, length).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final java.lang.StringBuffer str, final int startIndex, final int length) {
        return append(str, startIndex, length).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final org.apache.commons.lang3.text.StrBuilder str) {
        return append(str).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final org.apache.commons.lang3.text.StrBuilder str, final int startIndex, final int length) {
        return append(str, startIndex, length).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final char[] chars) {
        return append(chars).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final char[] chars, final int startIndex, final int length) {
        return append(chars, startIndex, length).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final boolean value) {
        return append(value).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final char ch) {
        return append(ch).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final int value) {
        return append(value).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final long value) {
        return append(value).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final float value) {
        return append(value).appendNewLine();
    }

    public org.apache.commons.lang3.text.StrBuilder appendln(final double value) {
        return append(value).appendNewLine();
    }

    public <T> org.apache.commons.lang3.text.StrBuilder appendAll(@java.lang.SuppressWarnings(value = "unchecked")
    final T... array) {
        if ((array != null) && ((array.length) > 0)) {
            for (final java.lang.Object element : array) {
                append(element);
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendAll(final java.lang.Iterable<?> iterable) {
        if (iterable != null) {
            for (final java.lang.Object o : iterable) {
                append(o);
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendAll(final java.util.Iterator<?> it) {
        if (it != null) {
            while (it.hasNext()) {
                append(it.next());
            } 
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendWithSeparators(final java.lang.Object[] array, final java.lang.String separator) {
        if ((array != null) && ((array.length) > 0)) {
            final java.lang.String sep = java.util.Objects.toString(separator, "");
            append(array[0]);
            for (int i = 1; i < (array.length); i++) {
                append(sep);
                append(array[i]);
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendWithSeparators(final java.lang.Iterable<?> iterable, final java.lang.String separator) {
        if (iterable != null) {
            final java.lang.String sep = java.util.Objects.toString(separator, "");
            final java.util.Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(sep);
                }
            } 
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendWithSeparators(final java.util.Iterator<?> it, final java.lang.String separator) {
        if (it != null) {
            final java.lang.String sep = java.util.Objects.toString(separator, "");
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(sep);
                }
            } 
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendSeparator(final java.lang.String separator) {
        return appendSeparator(separator, null);
    }

    public org.apache.commons.lang3.text.StrBuilder appendSeparator(final java.lang.String standard, final java.lang.String defaultIfEmpty) {
        final java.lang.String str = isEmpty() ? defaultIfEmpty : standard;
        if (str != null) {
            append(str);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendSeparator(final char separator) {
        if ((size()) > 0) {
            append(separator);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendSeparator(final char standard, final char defaultIfEmpty) {
        if ((size()) > 0) {
            append(standard);
        }else {
            append(defaultIfEmpty);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendSeparator(final java.lang.String separator, final int loopIndex) {
        if ((separator != null) && (loopIndex > 0)) {
            append(separator);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendSeparator(final char separator, final int loopIndex) {
        if (loopIndex > 0) {
            append(separator);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendPadding(final int length, final char padChar) {
        if (length >= 0) {
            ensureCapacity(((size) + length));
            for (int i = 0; i < length; i++) {
                buffer[((size)++)] = padChar;
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendFixedWidthPadLeft(final java.lang.Object obj, final int width, final char padChar) {
        if (width > 0) {
            ensureCapacity(((size) + width));
            java.lang.String str = obj == null ? getNullText() : obj.toString();
            if (str == null) {
                str = org.apache.commons.lang3.StringUtils.EMPTY;
            }
            final int strLen = str.length();
            if (strLen >= width) {
                str.getChars((strLen - width), strLen, buffer, size);
            }else {
                final int padLen = width - strLen;
                for (int i = 0; i < padLen; i++) {
                    buffer[((size) + i)] = padChar;
                }
                str.getChars(0, strLen, buffer, ((size) + padLen));
            }
            size += width;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendFixedWidthPadLeft(final int value, final int width, final char padChar) {
        return appendFixedWidthPadLeft(java.lang.String.valueOf(value), width, padChar);
    }

    public org.apache.commons.lang3.text.StrBuilder appendFixedWidthPadRight(final java.lang.Object obj, final int width, final char padChar) {
        if (width > 0) {
            ensureCapacity(((size) + width));
            java.lang.String str = obj == null ? getNullText() : obj.toString();
            if (str == null) {
                str = org.apache.commons.lang3.StringUtils.EMPTY;
            }
            final int strLen = str.length();
            if (strLen >= width) {
                str.getChars(0, width, buffer, size);
            }else {
                final int padLen = width - strLen;
                str.getChars(0, strLen, buffer, size);
                for (int i = 0; i < padLen; i++) {
                    buffer[(((size) + strLen) + i)] = padChar;
                }
            }
            size += width;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder appendFixedWidthPadRight(final int value, final int width, final char padChar) {
        return appendFixedWidthPadRight(java.lang.String.valueOf(value), width, padChar);
    }

    public org.apache.commons.lang3.text.StrBuilder insert(final int index, final java.lang.Object obj) {
        if (obj == null) {
            return insert(index, nullText);
        }
        return insert(index, obj.toString());
    }

    public org.apache.commons.lang3.text.StrBuilder insert(final int index, java.lang.String str) {
        validateIndex(index);
        if (str == null) {
            str = nullText;
        }
        if (str != null) {
            final int strLen = str.length();
            if (strLen > 0) {
                final int newSize = (size) + strLen;
                ensureCapacity(newSize);
                java.lang.System.arraycopy(buffer, index, buffer, (index + strLen), ((size) - index));
                size = newSize;
                str.getChars(0, strLen, buffer, index);
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder insert(final int index, final char[] chars) {
        validateIndex(index);
        if (chars == null) {
            return insert(index, nullText);
        }
        final int len = chars.length;
        if (len > 0) {
            ensureCapacity(((size) + len));
            java.lang.System.arraycopy(buffer, index, buffer, (index + len), ((size) - index));
            java.lang.System.arraycopy(chars, 0, buffer, index, len);
            size += len;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder insert(final int index, final char[] chars, final int offset, final int length) {
        validateIndex(index);
        if (chars == null) {
            return insert(index, nullText);
        }
        if ((offset < 0) || (offset > (chars.length))) {
            throw new java.lang.StringIndexOutOfBoundsException(("Invalid offset: " + offset));
        }
        if ((length < 0) || ((offset + length) > (chars.length))) {
            throw new java.lang.StringIndexOutOfBoundsException(("Invalid length: " + length));
        }
        if (length > 0) {
            ensureCapacity(((size) + length));
            java.lang.System.arraycopy(buffer, index, buffer, (index + length), ((size) - index));
            java.lang.System.arraycopy(chars, offset, buffer, index, length);
            size += length;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder insert(int index, final boolean value) {
        validateIndex(index);
        if (value) {
            ensureCapacity(((size) + 4));
            java.lang.System.arraycopy(buffer, index, buffer, (index + 4), ((size) - index));
            buffer[(index++)] = 't';
            buffer[(index++)] = 'r';
            buffer[(index++)] = 'u';
            buffer[index] = 'e';
            size += 4;
        }else {
            ensureCapacity(((size) + 5));
            java.lang.System.arraycopy(buffer, index, buffer, (index + 5), ((size) - index));
            buffer[(index++)] = 'f';
            buffer[(index++)] = 'a';
            buffer[(index++)] = 'l';
            buffer[(index++)] = 's';
            buffer[index] = 'e';
            size += 5;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder insert(final int index, final char value) {
        validateIndex(index);
        ensureCapacity(((size) + 1));
        java.lang.System.arraycopy(buffer, index, buffer, (index + 1), ((size) - index));
        buffer[index] = value;
        (size)++;
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder insert(final int index, final int value) {
        return insert(index, java.lang.String.valueOf(value));
    }

    public org.apache.commons.lang3.text.StrBuilder insert(final int index, final long value) {
        return insert(index, java.lang.String.valueOf(value));
    }

    public org.apache.commons.lang3.text.StrBuilder insert(final int index, final float value) {
        return insert(index, java.lang.String.valueOf(value));
    }

    public org.apache.commons.lang3.text.StrBuilder insert(final int index, final double value) {
        return insert(index, java.lang.String.valueOf(value));
    }

    private void deleteImpl(final int startIndex, final int endIndex, final int len) {
        java.lang.System.arraycopy(buffer, endIndex, buffer, startIndex, ((size) - endIndex));
        size -= len;
    }

    public org.apache.commons.lang3.text.StrBuilder delete(final int startIndex, int endIndex) {
        endIndex = validateRange(startIndex, endIndex);
        final int len = endIndex - startIndex;
        if (len > 0) {
            deleteImpl(startIndex, endIndex, len);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder deleteAll(final char ch) {
        for (int i = 0; i < (size); i++) {
            if ((buffer[i]) == ch) {
                final int start = i;
                while ((++i) < (size)) {
                    if ((buffer[i]) != ch) {
                        break;
                    }
                } 
                final int len = i - start;
                deleteImpl(start, i, len);
                i -= len;
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder deleteFirst(final char ch) {
        for (int i = 0; i < (size); i++) {
            if ((buffer[i]) == ch) {
                deleteImpl(i, (i + 1), 1);
                break;
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder deleteAll(final java.lang.String str) {
        final int len = str == null ? 0 : str.length();
        if (len > 0) {
            int index = indexOf(str, 0);
            while (index >= 0) {
                deleteImpl(index, (index + len), len);
                index = indexOf(str, index);
            } 
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder deleteFirst(final java.lang.String str) {
        final int len = str == null ? 0 : str.length();
        if (len > 0) {
            final int index = indexOf(str, 0);
            if (index >= 0) {
                deleteImpl(index, (index + len), len);
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder deleteAll(final org.apache.commons.lang3.text.StrMatcher matcher) {
        return replace(matcher, null, 0, size, (-1));
    }

    public org.apache.commons.lang3.text.StrBuilder deleteFirst(final org.apache.commons.lang3.text.StrMatcher matcher) {
        return replace(matcher, null, 0, size, 1);
    }

    private void replaceImpl(final int startIndex, final int endIndex, final int removeLen, final java.lang.String insertStr, final int insertLen) {
        final int newSize = ((size) - removeLen) + insertLen;
        if (insertLen != removeLen) {
            ensureCapacity(newSize);
            java.lang.System.arraycopy(buffer, endIndex, buffer, (startIndex + insertLen), ((size) - endIndex));
            size = newSize;
        }
        if (insertLen > 0) {
            insertStr.getChars(0, insertLen, buffer, startIndex);
        }
    }

    public org.apache.commons.lang3.text.StrBuilder replace(final int startIndex, int endIndex, final java.lang.String replaceStr) {
        endIndex = validateRange(startIndex, endIndex);
        final int insertLen = replaceStr == null ? 0 : replaceStr.length();
        replaceImpl(startIndex, endIndex, (endIndex - startIndex), replaceStr, insertLen);
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder replaceAll(final char search, final char replace) {
        if (search != replace) {
            for (int i = 0; i < (size); i++) {
                if ((buffer[i]) == search) {
                    buffer[i] = replace;
                }
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder replaceFirst(final char search, final char replace) {
        if (search != replace) {
            for (int i = 0; i < (size); i++) {
                if ((buffer[i]) == search) {
                    buffer[i] = replace;
                    break;
                }
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder replaceAll(final java.lang.String searchStr, final java.lang.String replaceStr) {
        final int searchLen = searchStr == null ? 0 : searchStr.length();
        if (searchLen > 0) {
            final int replaceLen = replaceStr == null ? 0 : replaceStr.length();
            int index = indexOf(searchStr, 0);
            while (index >= 0) {
                replaceImpl(index, (index + searchLen), searchLen, replaceStr, replaceLen);
                index = indexOf(searchStr, (index + replaceLen));
            } 
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder replaceFirst(final java.lang.String searchStr, final java.lang.String replaceStr) {
        final int searchLen = searchStr == null ? 0 : searchStr.length();
        if (searchLen > 0) {
            final int index = indexOf(searchStr, 0);
            if (index >= 0) {
                final int replaceLen = replaceStr == null ? 0 : replaceStr.length();
                replaceImpl(index, (index + searchLen), searchLen, replaceStr, replaceLen);
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder replaceAll(final org.apache.commons.lang3.text.StrMatcher matcher, final java.lang.String replaceStr) {
        return replace(matcher, replaceStr, 0, size, (-1));
    }

    public org.apache.commons.lang3.text.StrBuilder replaceFirst(final org.apache.commons.lang3.text.StrMatcher matcher, final java.lang.String replaceStr) {
        return replace(matcher, replaceStr, 0, size, 1);
    }

    public org.apache.commons.lang3.text.StrBuilder replace(final org.apache.commons.lang3.text.StrMatcher matcher, final java.lang.String replaceStr, final int startIndex, int endIndex, final int replaceCount) {
        endIndex = validateRange(startIndex, endIndex);
        return replaceImpl(matcher, replaceStr, startIndex, endIndex, replaceCount);
    }

    private org.apache.commons.lang3.text.StrBuilder replaceImpl(final org.apache.commons.lang3.text.StrMatcher matcher, final java.lang.String replaceStr, final int from, int to, int replaceCount) {
        if ((matcher == null) || ((size) == 0)) {
            return org.apache.commons.lang3.text.StrBuilder.this;
        }
        final int replaceLen = replaceStr == null ? 0 : replaceStr.length();
        for (int i = from; (i < to) && (replaceCount != 0); i++) {
            final char[] buf = buffer;
            final int removeLen = matcher.isMatch(buf, i, from, to);
            if (removeLen > 0) {
                replaceImpl(i, (i + removeLen), removeLen, replaceStr, replaceLen);
                to = (to - removeLen) + replaceLen;
                i = (i + replaceLen) - 1;
                if (replaceCount > 0) {
                    replaceCount--;
                }
            }
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder reverse() {
        if ((size) == 0) {
            return org.apache.commons.lang3.text.StrBuilder.this;
        }
        final int half = (size) / 2;
        final char[] buf = buffer;
        for (int leftIdx = 0, rightIdx = (size) - 1; leftIdx < half; leftIdx++ , rightIdx--) {
            final char swap = buf[leftIdx];
            buf[leftIdx] = buf[rightIdx];
            buf[rightIdx] = swap;
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public org.apache.commons.lang3.text.StrBuilder trim() {
        if ((size) == 0) {
            return org.apache.commons.lang3.text.StrBuilder.this;
        }
        int len = size;
        final char[] buf = buffer;
        int pos = 0;
        while ((pos < len) && ((buf[pos]) <= ' ')) {
            pos++;
        } 
        while ((pos < len) && ((buf[(len - 1)]) <= ' ')) {
            len--;
        } 
        if (len < (size)) {
            delete(len, size);
        }
        if (pos > 0) {
            delete(0, pos);
        }
        return org.apache.commons.lang3.text.StrBuilder.this;
    }

    public boolean startsWith(final java.lang.String str) {
        if (str == null) {
            return false;
        }
        final int len = str.length();
        if (len == 0) {
            return true;
        }
        if (len > (size)) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if ((buffer[i]) != (str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean endsWith(final java.lang.String str) {
        if (str == null) {
            return false;
        }
        final int len = str.length();
        if (len == 0) {
            return true;
        }
        if (len > (size)) {
            return false;
        }
        int pos = (size) - len;
        for (int i = 0; i < len; i++ , pos++) {
            if ((buffer[pos]) != (str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @java.lang.Override
    public java.lang.CharSequence subSequence(final int startIndex, final int endIndex) {
        if (startIndex < 0) {
            throw new java.lang.StringIndexOutOfBoundsException(startIndex);
        }
        if (endIndex > (size)) {
            throw new java.lang.StringIndexOutOfBoundsException(endIndex);
        }
        if (startIndex > endIndex) {
            throw new java.lang.StringIndexOutOfBoundsException((endIndex - startIndex));
        }
        return substring(startIndex, endIndex);
    }

    public java.lang.String substring(final int start) {
        return substring(start, size);
    }

    public java.lang.String substring(final int startIndex, int endIndex) {
        endIndex = validateRange(startIndex, endIndex);
        return new java.lang.String(buffer, startIndex, (endIndex - startIndex));
    }

    public java.lang.String leftString(final int length) {
        if (length <= 0) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }else
            if (length >= (size)) {
                return new java.lang.String(buffer, 0, size);
            }else {
                return new java.lang.String(buffer, 0, length);
            }
        
    }

    public java.lang.String rightString(final int length) {
        if (length <= 0) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }else
            if (length >= (size)) {
                return new java.lang.String(buffer, 0, size);
            }else {
                return new java.lang.String(buffer, ((size) - length), length);
            }
        
    }

    public java.lang.String midString(int index, final int length) {
        if (index < 0) {
            index = 0;
        }
        if ((length <= 0) || (index >= (size))) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        if ((size) <= (index + length)) {
            return new java.lang.String(buffer, index, ((size) - index));
        }
        return new java.lang.String(buffer, index, length);
    }

    public boolean contains(final char ch) {
        final char[] thisBuf = buffer;
        for (int i = 0; i < (org.apache.commons.lang3.text.StrBuilder.this.size); i++) {
            if ((thisBuf[i]) == ch) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(final java.lang.String str) {
        return (indexOf(str, 0)) >= 0;
    }

    public boolean contains(final org.apache.commons.lang3.text.StrMatcher matcher) {
        return (indexOf(matcher, 0)) >= 0;
    }

    public int indexOf(final char ch) {
        return indexOf(ch, 0);
    }

    public int indexOf(final char ch, int startIndex) {
        startIndex = (startIndex < 0) ? 0 : startIndex;
        if (startIndex >= (size)) {
            return -1;
        }
        final char[] thisBuf = buffer;
        for (int i = startIndex; i < (size); i++) {
            if ((thisBuf[i]) == ch) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(final java.lang.String str) {
        return indexOf(str, 0);
    }

    public int indexOf(final java.lang.String str, int startIndex) {
        startIndex = (startIndex < 0) ? 0 : startIndex;
        if ((str == null) || (startIndex >= (size))) {
            return -1;
        }
        final int strLen = str.length();
        if (strLen == 1) {
            return indexOf(str.charAt(0), startIndex);
        }
        if (strLen == 0) {
            return startIndex;
        }
        if (strLen > (size)) {
            return -1;
        }
        final char[] thisBuf = buffer;
        final int len = ((size) - strLen) + 1;
        outer : for (int i = startIndex; i < len; i++) {
            for (int j = 0; j < strLen; j++) {
                if ((str.charAt(j)) != (thisBuf[(i + j)])) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    public int indexOf(final org.apache.commons.lang3.text.StrMatcher matcher) {
        return indexOf(matcher, 0);
    }

    public int indexOf(final org.apache.commons.lang3.text.StrMatcher matcher, int startIndex) {
        startIndex = (startIndex < 0) ? 0 : startIndex;
        if ((matcher == null) || (startIndex >= (size))) {
            return -1;
        }
        final int len = size;
        final char[] buf = buffer;
        for (int i = startIndex; i < len; i++) {
            if ((matcher.isMatch(buf, i, startIndex, len)) > 0) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(final char ch) {
        return lastIndexOf(ch, ((size) - 1));
    }

    public int lastIndexOf(final char ch, int startIndex) {
        startIndex = (startIndex >= (size)) ? (size) - 1 : startIndex;
        if (startIndex < 0) {
            return -1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if ((buffer[i]) == ch) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(final java.lang.String str) {
        return lastIndexOf(str, ((size) - 1));
    }

    public int lastIndexOf(final java.lang.String str, int startIndex) {
        startIndex = (startIndex >= (size)) ? (size) - 1 : startIndex;
        if ((str == null) || (startIndex < 0)) {
            return -1;
        }
        final int strLen = str.length();
        if ((strLen > 0) && (strLen <= (size))) {
            if (strLen == 1) {
                return lastIndexOf(str.charAt(0), startIndex);
            }
            outer : for (int i = (startIndex - strLen) + 1; i >= 0; i--) {
                for (int j = 0; j < strLen; j++) {
                    if ((str.charAt(j)) != (buffer[(i + j)])) {
                        continue outer;
                    }
                }
                return i;
            }
        }else
            if (strLen == 0) {
                return startIndex;
            }
        
        return -1;
    }

    public int lastIndexOf(final org.apache.commons.lang3.text.StrMatcher matcher) {
        return lastIndexOf(matcher, size);
    }

    public int lastIndexOf(final org.apache.commons.lang3.text.StrMatcher matcher, int startIndex) {
        startIndex = (startIndex >= (size)) ? (size) - 1 : startIndex;
        if ((matcher == null) || (startIndex < 0)) {
            return -1;
        }
        final char[] buf = buffer;
        final int endIndex = startIndex + 1;
        for (int i = startIndex; i >= 0; i--) {
            if ((matcher.isMatch(buf, i, 0, endIndex)) > 0) {
                return i;
            }
        }
        return -1;
    }

    public org.apache.commons.lang3.text.StrTokenizer asTokenizer() {
        return new org.apache.commons.lang3.text.StrBuilder.StrBuilderTokenizer();
    }

    public java.io.Reader asReader() {
        return new org.apache.commons.lang3.text.StrBuilder.StrBuilderReader();
    }

    public java.io.Writer asWriter() {
        return new org.apache.commons.lang3.text.StrBuilder.StrBuilderWriter();
    }

    public void appendTo(final java.lang.Appendable appendable) throws java.io.IOException {
        if (appendable instanceof java.io.Writer) {
            ((java.io.Writer) (appendable)).write(buffer, 0, size);
        }else
            if (appendable instanceof java.lang.StringBuilder) {
                ((java.lang.StringBuilder) (appendable)).append(buffer, 0, size);
            }else
                if (appendable instanceof java.lang.StringBuffer) {
                    ((java.lang.StringBuffer) (appendable)).append(buffer, 0, size);
                }else
                    if (appendable instanceof java.nio.CharBuffer) {
                        ((java.nio.CharBuffer) (appendable)).put(buffer, 0, size);
                    }else {
                        appendable.append(org.apache.commons.lang3.text.StrBuilder.this);
                    }
                
            
        
    }

    public boolean equalsIgnoreCase(final org.apache.commons.lang3.text.StrBuilder other) {
        if ((org.apache.commons.lang3.text.StrBuilder.this) == other) {
            return true;
        }
        if ((org.apache.commons.lang3.text.StrBuilder.this.size) != (other.size)) {
            return false;
        }
        final char[] thisBuf = org.apache.commons.lang3.text.StrBuilder.this.buffer;
        final char[] otherBuf = other.buffer;
        for (int i = (size) - 1; i >= 0; i--) {
            final char c1 = thisBuf[i];
            final char c2 = otherBuf[i];
            if ((c1 != c2) && ((java.lang.Character.toUpperCase(c1)) != (java.lang.Character.toUpperCase(c2)))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(final org.apache.commons.lang3.text.StrBuilder other) {
        if ((org.apache.commons.lang3.text.StrBuilder.this) == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if ((org.apache.commons.lang3.text.StrBuilder.this.size) != (other.size)) {
            return false;
        }
        final char[] thisBuf = org.apache.commons.lang3.text.StrBuilder.this.buffer;
        final char[] otherBuf = other.buffer;
        for (int i = (size) - 1; i >= 0; i--) {
            if ((thisBuf[i]) != (otherBuf[i])) {
                return false;
            }
        }
        return true;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        return (obj instanceof org.apache.commons.lang3.text.StrBuilder) && (equals(((org.apache.commons.lang3.text.StrBuilder) (obj))));
    }

    @java.lang.Override
    public int hashCode() {
        final char[] buf = buffer;
        int hash = 0;
        for (int i = (size) - 1; i >= 0; i--) {
            hash = (31 * hash) + (buf[i]);
        }
        return hash;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return new java.lang.String(buffer, 0, size);
    }

    public java.lang.StringBuffer toStringBuffer() {
        return new java.lang.StringBuffer(size).append(buffer, 0, size);
    }

    public java.lang.StringBuilder toStringBuilder() {
        return new java.lang.StringBuilder(size).append(buffer, 0, size);
    }

    @java.lang.Override
    public java.lang.String build() {
        return toString();
    }

    protected int validateRange(final int startIndex, int endIndex) {
        if (startIndex < 0) {
            throw new java.lang.StringIndexOutOfBoundsException(startIndex);
        }
        if (endIndex > (size)) {
            endIndex = size;
        }
        if (startIndex > endIndex) {
            throw new java.lang.StringIndexOutOfBoundsException("end < start");
        }
        return endIndex;
    }

    protected void validateIndex(final int index) {
        if ((index < 0) || (index > (size))) {
            throw new java.lang.StringIndexOutOfBoundsException(index);
        }
    }

    class StrBuilderTokenizer extends org.apache.commons.lang3.text.StrTokenizer {
        StrBuilderTokenizer() {
            super();
        }

        @java.lang.Override
        protected java.util.List<java.lang.String> tokenize(final char[] chars, final int offset, final int count) {
            if (chars == null) {
                return super.tokenize(org.apache.commons.lang3.text.StrBuilder.this.buffer, 0, org.apache.commons.lang3.text.StrBuilder.this.size());
            }
            return super.tokenize(chars, offset, count);
        }

        @java.lang.Override
        public java.lang.String getContent() {
            final java.lang.String str = super.getContent();
            if (str == null) {
                return org.apache.commons.lang3.text.StrBuilder.this.toString();
            }
            return str;
        }
    }

    class StrBuilderReader extends java.io.Reader {
        private int pos;

        private int mark;

        StrBuilderReader() {
            super();
        }

        @java.lang.Override
        public void close() {
        }

        @java.lang.Override
        public int read() {
            if ((ready()) == false) {
                return -1;
            }
            return org.apache.commons.lang3.text.StrBuilder.this.charAt(((pos)++));
        }

        @java.lang.Override
        public int read(final char[] b, final int off, int len) {
            if (((((off < 0) || (len < 0)) || (off > (b.length))) || ((off + len) > (b.length))) || ((off + len) < 0)) {
                throw new java.lang.IndexOutOfBoundsException();
            }
            if (len == 0) {
                return 0;
            }
            if ((pos) >= (org.apache.commons.lang3.text.StrBuilder.this.size())) {
                return -1;
            }
            if (((pos) + len) > (size())) {
                len = (org.apache.commons.lang3.text.StrBuilder.this.size()) - (pos);
            }
            org.apache.commons.lang3.text.StrBuilder.this.getChars(pos, ((pos) + len), b, off);
            pos += len;
            return len;
        }

        @java.lang.Override
        public long skip(long n) {
            if (((pos) + n) > (org.apache.commons.lang3.text.StrBuilder.this.size())) {
                n = (org.apache.commons.lang3.text.StrBuilder.this.size()) - (pos);
            }
            if (n < 0) {
                return 0;
            }
            pos += n;
            return n;
        }

        @java.lang.Override
        public boolean ready() {
            return (pos) < (org.apache.commons.lang3.text.StrBuilder.this.size());
        }

        @java.lang.Override
        public boolean markSupported() {
            return true;
        }

        @java.lang.Override
        public void mark(final int readAheadLimit) {
            mark = pos;
        }

        @java.lang.Override
        public void reset() {
            pos = mark;
        }
    }

    class StrBuilderWriter extends java.io.Writer {
        StrBuilderWriter() {
            super();
        }

        @java.lang.Override
        public void close() {
        }

        @java.lang.Override
        public void flush() {
        }

        @java.lang.Override
        public void write(final int c) {
            org.apache.commons.lang3.text.StrBuilder.this.append(((char) (c)));
        }

        @java.lang.Override
        public void write(final char[] cbuf) {
            org.apache.commons.lang3.text.StrBuilder.this.append(cbuf);
        }

        @java.lang.Override
        public void write(final char[] cbuf, final int off, final int len) {
            org.apache.commons.lang3.text.StrBuilder.this.append(cbuf, off, len);
        }

        @java.lang.Override
        public void write(final java.lang.String str) {
            org.apache.commons.lang3.text.StrBuilder.this.append(str);
        }

        @java.lang.Override
        public void write(final java.lang.String str, final int off, final int len) {
            org.apache.commons.lang3.text.StrBuilder.this.append(str, off, len);
        }
    }
}

