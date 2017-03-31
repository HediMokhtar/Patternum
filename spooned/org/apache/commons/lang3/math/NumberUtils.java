

package org.apache.commons.lang3.math;


public class NumberUtils {
    public static final java.lang.Long LONG_ZERO = java.lang.Long.valueOf(0L);

    public static final java.lang.Long LONG_ONE = java.lang.Long.valueOf(1L);

    public static final java.lang.Long LONG_MINUS_ONE = java.lang.Long.valueOf((-1L));

    public static final java.lang.Integer INTEGER_ZERO = java.lang.Integer.valueOf(0);

    public static final java.lang.Integer INTEGER_ONE = java.lang.Integer.valueOf(1);

    public static final java.lang.Integer INTEGER_MINUS_ONE = java.lang.Integer.valueOf((-1));

    public static final java.lang.Short SHORT_ZERO = java.lang.Short.valueOf(((short) (0)));

    public static final java.lang.Short SHORT_ONE = java.lang.Short.valueOf(((short) (1)));

    public static final java.lang.Short SHORT_MINUS_ONE = java.lang.Short.valueOf(((short) (-1)));

    public static final java.lang.Byte BYTE_ZERO = java.lang.Byte.valueOf(((byte) (0)));

    public static final java.lang.Byte BYTE_ONE = java.lang.Byte.valueOf(((byte) (1)));

    public static final java.lang.Byte BYTE_MINUS_ONE = java.lang.Byte.valueOf(((byte) (-1)));

    public static final java.lang.Double DOUBLE_ZERO = java.lang.Double.valueOf(0.0);

    public static final java.lang.Double DOUBLE_ONE = java.lang.Double.valueOf(1.0);

    public static final java.lang.Double DOUBLE_MINUS_ONE = java.lang.Double.valueOf((-1.0));

    public static final java.lang.Float FLOAT_ZERO = java.lang.Float.valueOf(0.0F);

    public static final java.lang.Float FLOAT_ONE = java.lang.Float.valueOf(1.0F);

    public static final java.lang.Float FLOAT_MINUS_ONE = java.lang.Float.valueOf((-1.0F));

    public NumberUtils() {
        super();
    }

    public static int toInt(final java.lang.String str) {
        return org.apache.commons.lang3.math.NumberUtils.toInt(str, 0);
    }

    public static int toInt(final java.lang.String str, final int defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return java.lang.Integer.parseInt(str);
        } catch (final java.lang.NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static long toLong(final java.lang.String str) {
        return org.apache.commons.lang3.math.NumberUtils.toLong(str, 0L);
    }

    public static long toLong(final java.lang.String str, final long defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return java.lang.Long.parseLong(str);
        } catch (final java.lang.NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static float toFloat(final java.lang.String str) {
        return org.apache.commons.lang3.math.NumberUtils.toFloat(str, 0.0F);
    }

    public static float toFloat(final java.lang.String str, final float defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return java.lang.Float.parseFloat(str);
        } catch (final java.lang.NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static double toDouble(final java.lang.String str) {
        return org.apache.commons.lang3.math.NumberUtils.toDouble(str, 0.0);
    }

    public static double toDouble(final java.lang.String str, final double defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return java.lang.Double.parseDouble(str);
        } catch (final java.lang.NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static byte toByte(final java.lang.String str) {
        return org.apache.commons.lang3.math.NumberUtils.toByte(str, ((byte) (0)));
    }

    public static byte toByte(final java.lang.String str, final byte defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return java.lang.Byte.parseByte(str);
        } catch (final java.lang.NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static short toShort(final java.lang.String str) {
        return org.apache.commons.lang3.math.NumberUtils.toShort(str, ((short) (0)));
    }

    public static short toShort(final java.lang.String str, final short defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return java.lang.Short.parseShort(str);
        } catch (final java.lang.NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static java.lang.Number createNumber(final java.lang.String str) throws java.lang.NumberFormatException {
        if (str == null) {
            return null;
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
            throw new java.lang.NumberFormatException("A blank string is not a valid number");
        }
        final java.lang.String[] hex_prefixes = new java.lang.String[]{ "0x" , "0X" , "-0x" , "-0X" , "#" , "-#" };
        int pfxLen = 0;
        for (final java.lang.String pfx : hex_prefixes) {
            if (str.startsWith(pfx)) {
                pfxLen += pfx.length();
                break;
            }
        }
        if (pfxLen > 0) {
            char firstSigDigit = 0;
            for (int i = pfxLen; i < (str.length()); i++) {
                firstSigDigit = str.charAt(i);
                if (firstSigDigit == '0') {
                    pfxLen++;
                }else {
                    break;
                }
            }
            final int hexDigits = (str.length()) - pfxLen;
            if ((hexDigits > 16) || ((hexDigits == 16) && (firstSigDigit > '7'))) {
                return org.apache.commons.lang3.math.NumberUtils.createBigInteger(str);
            }
            if ((hexDigits > 8) || ((hexDigits == 8) && (firstSigDigit > '7'))) {
                return org.apache.commons.lang3.math.NumberUtils.createLong(str);
            }
            return org.apache.commons.lang3.math.NumberUtils.createInteger(str);
        }
        final char lastChar = str.charAt(((str.length()) - 1));
        java.lang.String mant;
        java.lang.String dec;
        java.lang.String exp;
        final int decPos = str.indexOf('.');
        final int expPos = ((str.indexOf('e')) + (str.indexOf('E'))) + 1;
        if (decPos > (-1)) {
            if (expPos > (-1)) {
                if ((expPos < decPos) || (expPos > (str.length()))) {
                    throw new java.lang.NumberFormatException((str + " is not a valid number."));
                }
                dec = str.substring((decPos + 1), expPos);
            }else {
                dec = str.substring((decPos + 1));
            }
            mant = org.apache.commons.lang3.math.NumberUtils.getMantissa(str, decPos);
        }else {
            if (expPos > (-1)) {
                if (expPos > (str.length())) {
                    throw new java.lang.NumberFormatException((str + " is not a valid number."));
                }
                mant = org.apache.commons.lang3.math.NumberUtils.getMantissa(str, expPos);
            }else {
                mant = org.apache.commons.lang3.math.NumberUtils.getMantissa(str);
            }
            dec = null;
        }
        if ((!(java.lang.Character.isDigit(lastChar))) && (lastChar != '.')) {
            if ((expPos > (-1)) && (expPos < ((str.length()) - 1))) {
                exp = str.substring((expPos + 1), ((str.length()) - 1));
            }else {
                exp = null;
            }
            final java.lang.String numeric = str.substring(0, ((str.length()) - 1));
            final boolean allZeros = (org.apache.commons.lang3.math.NumberUtils.isAllZeros(mant)) && (org.apache.commons.lang3.math.NumberUtils.isAllZeros(exp));
            switch (lastChar) {
                case 'l' :
                case 'L' :
                    if (((dec == null) && (exp == null)) && ((((numeric.charAt(0)) == '-') && (org.apache.commons.lang3.math.NumberUtils.isDigits(numeric.substring(1)))) || (org.apache.commons.lang3.math.NumberUtils.isDigits(numeric)))) {
                        try {
                            return org.apache.commons.lang3.math.NumberUtils.createLong(numeric);
                        } catch (final java.lang.NumberFormatException nfe) {
                        }
                        return org.apache.commons.lang3.math.NumberUtils.createBigInteger(numeric);
                    }
                    throw new java.lang.NumberFormatException((str + " is not a valid number."));
                case 'f' :
                case 'F' :
                    try {
                        final java.lang.Float f = org.apache.commons.lang3.math.NumberUtils.createFloat(str);
                        if (!((f.isInfinite()) || (((f.floatValue()) == 0.0F) && (!allZeros)))) {
                            return f;
                        }
                    } catch (final java.lang.NumberFormatException nfe) {
                    }
                case 'd' :
                case 'D' :
                    try {
                        final java.lang.Double d = org.apache.commons.lang3.math.NumberUtils.createDouble(str);
                        if (!((d.isInfinite()) || (((d.floatValue()) == 0.0) && (!allZeros)))) {
                            return d;
                        }
                    } catch (final java.lang.NumberFormatException nfe) {
                    }
                    try {
                        return org.apache.commons.lang3.math.NumberUtils.createBigDecimal(numeric);
                    } catch (final java.lang.NumberFormatException e) {
                    }
                default :
                    throw new java.lang.NumberFormatException((str + " is not a valid number."));
            }
        }
        if ((expPos > (-1)) && (expPos < ((str.length()) - 1))) {
            exp = str.substring((expPos + 1), str.length());
        }else {
            exp = null;
        }
        if ((dec == null) && (exp == null)) {
            try {
                return org.apache.commons.lang3.math.NumberUtils.createInteger(str);
            } catch (final java.lang.NumberFormatException nfe) {
            }
            try {
                return org.apache.commons.lang3.math.NumberUtils.createLong(str);
            } catch (final java.lang.NumberFormatException nfe) {
            }
            return org.apache.commons.lang3.math.NumberUtils.createBigInteger(str);
        }
        final boolean allZeros = (org.apache.commons.lang3.math.NumberUtils.isAllZeros(mant)) && (org.apache.commons.lang3.math.NumberUtils.isAllZeros(exp));
        try {
            final java.lang.Float f = org.apache.commons.lang3.math.NumberUtils.createFloat(str);
            final java.lang.Double d = org.apache.commons.lang3.math.NumberUtils.createDouble(str);
            if (((!(f.isInfinite())) && (!(((f.floatValue()) == 0.0F) && (!allZeros)))) && (f.toString().equals(d.toString()))) {
                return f;
            }
            if ((!(d.isInfinite())) && (!(((d.doubleValue()) == 0.0) && (!allZeros)))) {
                final java.math.BigDecimal b = org.apache.commons.lang3.math.NumberUtils.createBigDecimal(str);
                if ((b.compareTo(java.math.BigDecimal.valueOf(d.doubleValue()))) == 0) {
                    return d;
                }
                return b;
            }
        } catch (final java.lang.NumberFormatException nfe) {
        }
        return org.apache.commons.lang3.math.NumberUtils.createBigDecimal(str);
    }

    private static java.lang.String getMantissa(final java.lang.String str) {
        return org.apache.commons.lang3.math.NumberUtils.getMantissa(str, str.length());
    }

    private static java.lang.String getMantissa(final java.lang.String str, final int stopPos) {
        final char firstChar = str.charAt(0);
        final boolean hasSign = (firstChar == '-') || (firstChar == '+');
        return hasSign ? str.substring(1, stopPos) : str.substring(0, stopPos);
    }

    private static boolean isAllZeros(final java.lang.String str) {
        if (str == null) {
            return true;
        }
        for (int i = (str.length()) - 1; i >= 0; i--) {
            if ((str.charAt(i)) != '0') {
                return false;
            }
        }
        return (str.length()) > 0;
    }

    public static java.lang.Float createFloat(final java.lang.String str) {
        if (str == null) {
            return null;
        }
        return java.lang.Float.valueOf(str);
    }

    public static java.lang.Double createDouble(final java.lang.String str) {
        if (str == null) {
            return null;
        }
        return java.lang.Double.valueOf(str);
    }

    public static java.lang.Integer createInteger(final java.lang.String str) {
        if (str == null) {
            return null;
        }
        return java.lang.Integer.decode(str);
    }

    public static java.lang.Long createLong(final java.lang.String str) {
        if (str == null) {
            return null;
        }
        return java.lang.Long.decode(str);
    }

    public static java.math.BigInteger createBigInteger(final java.lang.String str) {
        if (str == null) {
            return null;
        }
        int pos = 0;
        int radix = 10;
        boolean negate = false;
        if (str.startsWith("-")) {
            negate = true;
            pos = 1;
        }
        if ((str.startsWith("0x", pos)) || (str.startsWith("0X", pos))) {
            radix = 16;
            pos += 2;
        }else
            if (str.startsWith("#", pos)) {
                radix = 16;
                pos++;
            }else
                if ((str.startsWith("0", pos)) && ((str.length()) > (pos + 1))) {
                    radix = 8;
                    pos++;
                }
            
        
        final java.math.BigInteger value = new java.math.BigInteger(str.substring(pos), radix);
        return negate ? value.negate() : value;
    }

    public static java.math.BigDecimal createBigDecimal(final java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
            throw new java.lang.NumberFormatException("A blank string is not a valid number");
        }
        if (str.trim().startsWith("--")) {
            throw new java.lang.NumberFormatException((str + " is not a valid number."));
        }
        return new java.math.BigDecimal(str);
    }

    public static long min(final long... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        long min = array[0];
        for (int i = 1; i < (array.length); i++) {
            if ((array[i]) < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int min(final int... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        int min = array[0];
        for (int j = 1; j < (array.length); j++) {
            if ((array[j]) < min) {
                min = array[j];
            }
        }
        return min;
    }

    public static short min(final short... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        short min = array[0];
        for (int i = 1; i < (array.length); i++) {
            if ((array[i]) < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static byte min(final byte... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        byte min = array[0];
        for (int i = 1; i < (array.length); i++) {
            if ((array[i]) < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static double min(final double... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        double min = array[0];
        for (int i = 1; i < (array.length); i++) {
            if (java.lang.Double.isNaN(array[i])) {
                return java.lang.Double.NaN;
            }
            if ((array[i]) < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static float min(final float... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        float min = array[0];
        for (int i = 1; i < (array.length); i++) {
            if (java.lang.Float.isNaN(array[i])) {
                return java.lang.Float.NaN;
            }
            if ((array[i]) < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static long max(final long... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        long max = array[0];
        for (int j = 1; j < (array.length); j++) {
            if ((array[j]) > max) {
                max = array[j];
            }
        }
        return max;
    }

    public static int max(final int... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        int max = array[0];
        for (int j = 1; j < (array.length); j++) {
            if ((array[j]) > max) {
                max = array[j];
            }
        }
        return max;
    }

    public static short max(final short... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        short max = array[0];
        for (int i = 1; i < (array.length); i++) {
            if ((array[i]) > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static byte max(final byte... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        byte max = array[0];
        for (int i = 1; i < (array.length); i++) {
            if ((array[i]) > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static double max(final double... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        double max = array[0];
        for (int j = 1; j < (array.length); j++) {
            if (java.lang.Double.isNaN(array[j])) {
                return java.lang.Double.NaN;
            }
            if ((array[j]) > max) {
                max = array[j];
            }
        }
        return max;
    }

    public static float max(final float... array) {
        org.apache.commons.lang3.math.NumberUtils.validateArray(array);
        float max = array[0];
        for (int j = 1; j < (array.length); j++) {
            if (java.lang.Float.isNaN(array[j])) {
                return java.lang.Float.NaN;
            }
            if ((array[j]) > max) {
                max = array[j];
            }
        }
        return max;
    }

    private static void validateArray(final java.lang.Object array) {
        if (array == null) {
            throw new java.lang.IllegalArgumentException("The Array must not be null");
        }
        org.apache.commons.lang3.Validate.isTrue(((java.lang.reflect.Array.getLength(array)) != 0), "Array cannot be empty.");
    }

    public static long min(long a, final long b, final long c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }

    public static int min(int a, final int b, final int c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }

    public static short min(short a, final short b, final short c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }

    public static byte min(byte a, final byte b, final byte c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }

    public static double min(final double a, final double b, final double c) {
        return java.lang.Math.min(java.lang.Math.min(a, b), c);
    }

    public static float min(final float a, final float b, final float c) {
        return java.lang.Math.min(java.lang.Math.min(a, b), c);
    }

    public static long max(long a, final long b, final long c) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        return a;
    }

    public static int max(int a, final int b, final int c) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        return a;
    }

    public static short max(short a, final short b, final short c) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        return a;
    }

    public static byte max(byte a, final byte b, final byte c) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        return a;
    }

    public static double max(final double a, final double b, final double c) {
        return java.lang.Math.max(java.lang.Math.max(a, b), c);
    }

    public static float max(final float a, final float b, final float c) {
        return java.lang.Math.max(java.lang.Math.max(a, b), c);
    }

    public static boolean isDigits(final java.lang.String str) {
        return org.apache.commons.lang3.StringUtils.isNumeric(str);
    }

    @java.lang.Deprecated
    public static boolean isNumber(final java.lang.String str) {
        return org.apache.commons.lang3.math.NumberUtils.isCreatable(str);
    }

    public static boolean isCreatable(final java.lang.String str) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(str)) {
            return false;
        }
        final char[] chars = str.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;
        final int start = ((chars[0]) == '-') || ((chars[0]) == '+') ? 1 : 0;
        final boolean hasLeadingPlusSign = (start == 1) && ((chars[0]) == '+');
        if ((sz > (start + 1)) && ((chars[start]) == '0')) {
            if (((chars[(start + 1)]) == 'x') || ((chars[(start + 1)]) == 'X')) {
                int i = start + 2;
                if (i == sz) {
                    return false;
                }
                for (; i < (chars.length); i++) {
                    if (((((chars[i]) < '0') || ((chars[i]) > '9')) && (((chars[i]) < 'a') || ((chars[i]) > 'f'))) && (((chars[i]) < 'A') || ((chars[i]) > 'F'))) {
                        return false;
                    }
                }
                return true;
            }else
                if (java.lang.Character.isDigit(chars[(start + 1)])) {
                    int i = start + 1;
                    for (; i < (chars.length); i++) {
                        if (((chars[i]) < '0') || ((chars[i]) > '7')) {
                            return false;
                        }
                    }
                    return true;
                }
            
        }
        sz--;
        int i = start;
        while ((i < sz) || (((i < (sz + 1)) && allowSigns) && (!foundDigit))) {
            if (((chars[i]) >= '0') && ((chars[i]) <= '9')) {
                foundDigit = true;
                allowSigns = false;
            }else
                if ((chars[i]) == '.') {
                    if (hasDecPoint || hasExp) {
                        return false;
                    }
                    hasDecPoint = true;
                }else
                    if (((chars[i]) == 'e') || ((chars[i]) == 'E')) {
                        if (hasExp) {
                            return false;
                        }
                        if (!foundDigit) {
                            return false;
                        }
                        hasExp = true;
                        allowSigns = true;
                    }else
                        if (((chars[i]) == '+') || ((chars[i]) == '-')) {
                            if (!allowSigns) {
                                return false;
                            }
                            allowSigns = false;
                            foundDigit = false;
                        }else {
                            return false;
                        }
                    
                
            
            i++;
        } 
        if (i < (chars.length)) {
            if (((chars[i]) >= '0') && ((chars[i]) <= '9')) {
                if (((org.apache.commons.lang3.SystemUtils.IS_JAVA_1_6) && hasLeadingPlusSign) && (!hasDecPoint)) {
                    return false;
                }
                return true;
            }
            if (((chars[i]) == 'e') || ((chars[i]) == 'E')) {
                return false;
            }
            if ((chars[i]) == '.') {
                if (hasDecPoint || hasExp) {
                    return false;
                }
                return foundDigit;
            }
            if ((!allowSigns) && (((((chars[i]) == 'd') || ((chars[i]) == 'D')) || ((chars[i]) == 'f')) || ((chars[i]) == 'F'))) {
                return foundDigit;
            }
            if (((chars[i]) == 'l') || ((chars[i]) == 'L')) {
                return (foundDigit && (!hasExp)) && (!hasDecPoint);
            }
            return false;
        }
        return (!allowSigns) && foundDigit;
    }

    public static boolean isParsable(final java.lang.String str) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(str)) {
            return false;
        }
        if ((str.charAt(((str.length()) - 1))) == '.') {
            return false;
        }
        if ((str.charAt(0)) == '-') {
            if ((str.length()) == 1) {
                return false;
            }
            return org.apache.commons.lang3.math.NumberUtils.withDecimalsParsing(str, 1);
        }else {
            return org.apache.commons.lang3.math.NumberUtils.withDecimalsParsing(str, 0);
        }
    }

    private static boolean withDecimalsParsing(final java.lang.String str, final int beginIdx) {
        int decimalPoints = 0;
        for (int i = beginIdx; i < (str.length()); i++) {
            final boolean isDecimalPoint = (str.charAt(i)) == '.';
            if (isDecimalPoint) {
                decimalPoints++;
            }
            if (decimalPoints > 1) {
                return false;
            }
            if ((!isDecimalPoint) && (!(java.lang.Character.isDigit(str.charAt(i))))) {
                return false;
            }
        }
        return true;
    }

    public static int compare(final int x, final int y) {
        if (x == y) {
            return 0;
        }
        return x < y ? -1 : 1;
    }

    public static int compare(final long x, final long y) {
        if (x == y) {
            return 0;
        }
        return x < y ? -1 : 1;
    }

    public static int compare(final short x, final short y) {
        if (x == y) {
            return 0;
        }
        return x < y ? -1 : 1;
    }

    public static int compare(final byte x, final byte y) {
        return x - y;
    }
}

