

package org.apache.commons.lang3;


public class Conversion {
    private static final boolean[] TTTT = new boolean[]{ true , true , true , true };

    private static final boolean[] FTTT = new boolean[]{ false , true , true , true };

    private static final boolean[] TFTT = new boolean[]{ true , false , true , true };

    private static final boolean[] FFTT = new boolean[]{ false , false , true , true };

    private static final boolean[] TTFT = new boolean[]{ true , true , false , true };

    private static final boolean[] FTFT = new boolean[]{ false , true , false , true };

    private static final boolean[] TFFT = new boolean[]{ true , false , false , true };

    private static final boolean[] FFFT = new boolean[]{ false , false , false , true };

    private static final boolean[] TTTF = new boolean[]{ true , true , true , false };

    private static final boolean[] FTTF = new boolean[]{ false , true , true , false };

    private static final boolean[] TFTF = new boolean[]{ true , false , true , false };

    private static final boolean[] FFTF = new boolean[]{ false , false , true , false };

    private static final boolean[] TTFF = new boolean[]{ true , true , false , false };

    private static final boolean[] FTFF = new boolean[]{ false , true , false , false };

    private static final boolean[] TFFF = new boolean[]{ true , false , false , false };

    private static final boolean[] FFFF = new boolean[]{ false , false , false , false };

    public static int hexDigitToInt(final char hexDigit) {
        final int digit = java.lang.Character.digit(hexDigit, 16);
        if (digit < 0) {
            throw new java.lang.IllegalArgumentException((("Cannot interpret '" + hexDigit) + "' as a hexadecimal digit"));
        }
        return digit;
    }

    public static int hexDigitMsb0ToInt(final char hexDigit) {
        switch (hexDigit) {
            case '0' :
                return 0;
            case '1' :
                return 8;
            case '2' :
                return 4;
            case '3' :
                return 12;
            case '4' :
                return 2;
            case '5' :
                return 10;
            case '6' :
                return 6;
            case '7' :
                return 14;
            case '8' :
                return 1;
            case '9' :
                return 9;
            case 'a' :
            case 'A' :
                return 5;
            case 'b' :
            case 'B' :
                return 13;
            case 'c' :
            case 'C' :
                return 3;
            case 'd' :
            case 'D' :
                return 11;
            case 'e' :
            case 'E' :
                return 7;
            case 'f' :
            case 'F' :
                return 15;
            default :
                throw new java.lang.IllegalArgumentException((("Cannot interpret '" + hexDigit) + "' as a hexadecimal digit"));
        }
    }

    public static boolean[] hexDigitToBinary(final char hexDigit) {
        switch (hexDigit) {
            case '0' :
                return org.apache.commons.lang3.Conversion.FFFF.clone();
            case '1' :
                return org.apache.commons.lang3.Conversion.TFFF.clone();
            case '2' :
                return org.apache.commons.lang3.Conversion.FTFF.clone();
            case '3' :
                return org.apache.commons.lang3.Conversion.TTFF.clone();
            case '4' :
                return org.apache.commons.lang3.Conversion.FFTF.clone();
            case '5' :
                return org.apache.commons.lang3.Conversion.TFTF.clone();
            case '6' :
                return org.apache.commons.lang3.Conversion.FTTF.clone();
            case '7' :
                return org.apache.commons.lang3.Conversion.TTTF.clone();
            case '8' :
                return org.apache.commons.lang3.Conversion.FFFT.clone();
            case '9' :
                return org.apache.commons.lang3.Conversion.TFFT.clone();
            case 'a' :
            case 'A' :
                return org.apache.commons.lang3.Conversion.FTFT.clone();
            case 'b' :
            case 'B' :
                return org.apache.commons.lang3.Conversion.TTFT.clone();
            case 'c' :
            case 'C' :
                return org.apache.commons.lang3.Conversion.FFTT.clone();
            case 'd' :
            case 'D' :
                return org.apache.commons.lang3.Conversion.TFTT.clone();
            case 'e' :
            case 'E' :
                return org.apache.commons.lang3.Conversion.FTTT.clone();
            case 'f' :
            case 'F' :
                return org.apache.commons.lang3.Conversion.TTTT.clone();
            default :
                throw new java.lang.IllegalArgumentException((("Cannot interpret '" + hexDigit) + "' as a hexadecimal digit"));
        }
    }

    public static boolean[] hexDigitMsb0ToBinary(final char hexDigit) {
        switch (hexDigit) {
            case '0' :
                return org.apache.commons.lang3.Conversion.FFFF.clone();
            case '1' :
                return org.apache.commons.lang3.Conversion.FFFT.clone();
            case '2' :
                return org.apache.commons.lang3.Conversion.FFTF.clone();
            case '3' :
                return org.apache.commons.lang3.Conversion.FFTT.clone();
            case '4' :
                return org.apache.commons.lang3.Conversion.FTFF.clone();
            case '5' :
                return org.apache.commons.lang3.Conversion.FTFT.clone();
            case '6' :
                return org.apache.commons.lang3.Conversion.FTTF.clone();
            case '7' :
                return org.apache.commons.lang3.Conversion.FTTT.clone();
            case '8' :
                return org.apache.commons.lang3.Conversion.TFFF.clone();
            case '9' :
                return org.apache.commons.lang3.Conversion.TFFT.clone();
            case 'a' :
            case 'A' :
                return org.apache.commons.lang3.Conversion.TFTF.clone();
            case 'b' :
            case 'B' :
                return org.apache.commons.lang3.Conversion.TFTT.clone();
            case 'c' :
            case 'C' :
                return org.apache.commons.lang3.Conversion.TTFF.clone();
            case 'd' :
            case 'D' :
                return org.apache.commons.lang3.Conversion.TTFT.clone();
            case 'e' :
            case 'E' :
                return org.apache.commons.lang3.Conversion.TTTF.clone();
            case 'f' :
            case 'F' :
                return org.apache.commons.lang3.Conversion.TTTT.clone();
            default :
                throw new java.lang.IllegalArgumentException((("Cannot interpret '" + hexDigit) + "' as a hexadecimal digit"));
        }
    }

    public static char binaryToHexDigit(final boolean[] src) {
        return org.apache.commons.lang3.Conversion.binaryToHexDigit(src, 0);
    }

    public static char binaryToHexDigit(final boolean[] src, final int srcPos) {
        if ((src.length) == 0) {
            throw new java.lang.IllegalArgumentException("Cannot convert an empty array.");
        }
        if (((src.length) > (srcPos + 3)) && (src[(srcPos + 3)])) {
            if (((src.length) > (srcPos + 2)) && (src[(srcPos + 2)])) {
                if (((src.length) > (srcPos + 1)) && (src[(srcPos + 1)])) {
                    return src[srcPos] ? 'f' : 'e';
                }
                return src[srcPos] ? 'd' : 'c';
            }
            if (((src.length) > (srcPos + 1)) && (src[(srcPos + 1)])) {
                return src[srcPos] ? 'b' : 'a';
            }
            return src[srcPos] ? '9' : '8';
        }
        if (((src.length) > (srcPos + 2)) && (src[(srcPos + 2)])) {
            if (((src.length) > (srcPos + 1)) && (src[(srcPos + 1)])) {
                return src[srcPos] ? '7' : '6';
            }
            return src[srcPos] ? '5' : '4';
        }
        if (((src.length) > (srcPos + 1)) && (src[(srcPos + 1)])) {
            return src[srcPos] ? '3' : '2';
        }
        return src[srcPos] ? '1' : '0';
    }

    public static char binaryToHexDigitMsb0_4bits(final boolean[] src) {
        return org.apache.commons.lang3.Conversion.binaryToHexDigitMsb0_4bits(src, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(final boolean[] src, final int srcPos) {
        if ((src.length) > 8) {
            throw new java.lang.IllegalArgumentException(("src.length>8: src.length=" + (src.length)));
        }
        if (((src.length) - srcPos) < 4) {
            throw new java.lang.IllegalArgumentException(((("src.length-srcPos<4: src.length=" + (src.length)) + ", srcPos=") + srcPos));
        }
        if (src[(srcPos + 3)]) {
            if (src[(srcPos + 2)]) {
                if (src[(srcPos + 1)]) {
                    return src[srcPos] ? 'f' : '7';
                }
                return src[srcPos] ? 'b' : '3';
            }
            if (src[(srcPos + 1)]) {
                return src[srcPos] ? 'd' : '5';
            }
            return src[srcPos] ? '9' : '1';
        }
        if (src[(srcPos + 2)]) {
            if (src[(srcPos + 1)]) {
                return src[srcPos] ? 'e' : '6';
            }
            return src[srcPos] ? 'a' : '2';
        }
        if (src[(srcPos + 1)]) {
            return src[srcPos] ? 'c' : '4';
        }
        return src[srcPos] ? '8' : '0';
    }

    public static char binaryBeMsb0ToHexDigit(final boolean[] src) {
        return org.apache.commons.lang3.Conversion.binaryBeMsb0ToHexDigit(src, 0);
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] src, int srcPos) {
        if ((src.length) == 0) {
            throw new java.lang.IllegalArgumentException("Cannot convert an empty array.");
        }
        final int beSrcPos = ((src.length) - 1) - srcPos;
        final int srcLen = java.lang.Math.min(4, (beSrcPos + 1));
        final boolean[] paddedSrc = new boolean[4];
        java.lang.System.arraycopy(src, ((beSrcPos + 1) - srcLen), paddedSrc, (4 - srcLen), srcLen);
        src = paddedSrc;
        srcPos = 0;
        if (src[srcPos]) {
            if (((src.length) > (srcPos + 1)) && (src[(srcPos + 1)])) {
                if (((src.length) > (srcPos + 2)) && (src[(srcPos + 2)])) {
                    return ((src.length) > (srcPos + 3)) && (src[(srcPos + 3)]) ? 'f' : 'e';
                }
                return ((src.length) > (srcPos + 3)) && (src[(srcPos + 3)]) ? 'd' : 'c';
            }
            if (((src.length) > (srcPos + 2)) && (src[(srcPos + 2)])) {
                return ((src.length) > (srcPos + 3)) && (src[(srcPos + 3)]) ? 'b' : 'a';
            }
            return ((src.length) > (srcPos + 3)) && (src[(srcPos + 3)]) ? '9' : '8';
        }
        if (((src.length) > (srcPos + 1)) && (src[(srcPos + 1)])) {
            if (((src.length) > (srcPos + 2)) && (src[(srcPos + 2)])) {
                return ((src.length) > (srcPos + 3)) && (src[(srcPos + 3)]) ? '7' : '6';
            }
            return ((src.length) > (srcPos + 3)) && (src[(srcPos + 3)]) ? '5' : '4';
        }
        if (((src.length) > (srcPos + 2)) && (src[(srcPos + 2)])) {
            return ((src.length) > (srcPos + 3)) && (src[(srcPos + 3)]) ? '3' : '2';
        }
        return ((src.length) > (srcPos + 3)) && (src[(srcPos + 3)]) ? '1' : '0';
    }

    public static char intToHexDigit(final int nibble) {
        final char c = java.lang.Character.forDigit(nibble, 16);
        if (c == (java.lang.Character.MIN_VALUE)) {
            throw new java.lang.IllegalArgumentException(("nibble value not between 0 and 15: " + nibble));
        }
        return c;
    }

    public static char intToHexDigitMsb0(final int nibble) {
        switch (nibble) {
            case 0 :
                return '0';
            case 1 :
                return '8';
            case 2 :
                return '4';
            case 3 :
                return 'c';
            case 4 :
                return '2';
            case 5 :
                return 'a';
            case 6 :
                return '6';
            case 7 :
                return 'e';
            case 8 :
                return '1';
            case 9 :
                return '9';
            case 10 :
                return '5';
            case 11 :
                return 'd';
            case 12 :
                return '3';
            case 13 :
                return 'b';
            case 14 :
                return '7';
            case 15 :
                return 'f';
            default :
                throw new java.lang.IllegalArgumentException(("nibble value not between 0 and 15: " + nibble));
        }
    }

    public static long intArrayToLong(final int[] src, final int srcPos, final long dstInit, final int dstPos, final int nInts) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nInts)) {
            return dstInit;
        }
        if ((((nInts - 1) * 32) + dstPos) >= 64) {
            throw new java.lang.IllegalArgumentException("(nInts-1)*32+dstPos is greater or equal to than 64");
        }
        long out = dstInit;
        for (int i = 0; i < nInts; i++) {
            final int shift = (i * 32) + dstPos;
            final long bits = (4294967295L & (src[(i + srcPos)])) << shift;
            final long mask = 4294967295L << shift;
            out = (out & (~mask)) | bits;
        }
        return out;
    }

    public static long shortArrayToLong(final short[] src, final int srcPos, final long dstInit, final int dstPos, final int nShorts) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nShorts)) {
            return dstInit;
        }
        if ((((nShorts - 1) * 16) + dstPos) >= 64) {
            throw new java.lang.IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 64");
        }
        long out = dstInit;
        for (int i = 0; i < nShorts; i++) {
            final int shift = (i * 16) + dstPos;
            final long bits = (65535L & (src[(i + srcPos)])) << shift;
            final long mask = 65535L << shift;
            out = (out & (~mask)) | bits;
        }
        return out;
    }

    public static int shortArrayToInt(final short[] src, final int srcPos, final int dstInit, final int dstPos, final int nShorts) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nShorts)) {
            return dstInit;
        }
        if ((((nShorts - 1) * 16) + dstPos) >= 32) {
            throw new java.lang.IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 32");
        }
        int out = dstInit;
        for (int i = 0; i < nShorts; i++) {
            final int shift = (i * 16) + dstPos;
            final int bits = (65535 & (src[(i + srcPos)])) << shift;
            final int mask = 65535 << shift;
            out = (out & (~mask)) | bits;
        }
        return out;
    }

    public static long byteArrayToLong(final byte[] src, final int srcPos, final long dstInit, final int dstPos, final int nBytes) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nBytes)) {
            return dstInit;
        }
        if ((((nBytes - 1) * 8) + dstPos) >= 64) {
            throw new java.lang.IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 64");
        }
        long out = dstInit;
        for (int i = 0; i < nBytes; i++) {
            final int shift = (i * 8) + dstPos;
            final long bits = (255L & (src[(i + srcPos)])) << shift;
            final long mask = 255L << shift;
            out = (out & (~mask)) | bits;
        }
        return out;
    }

    public static int byteArrayToInt(final byte[] src, final int srcPos, final int dstInit, final int dstPos, final int nBytes) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nBytes)) {
            return dstInit;
        }
        if ((((nBytes - 1) * 8) + dstPos) >= 32) {
            throw new java.lang.IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 32");
        }
        int out = dstInit;
        for (int i = 0; i < nBytes; i++) {
            final int shift = (i * 8) + dstPos;
            final int bits = (255 & (src[(i + srcPos)])) << shift;
            final int mask = 255 << shift;
            out = (out & (~mask)) | bits;
        }
        return out;
    }

    public static short byteArrayToShort(final byte[] src, final int srcPos, final short dstInit, final int dstPos, final int nBytes) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nBytes)) {
            return dstInit;
        }
        if ((((nBytes - 1) * 8) + dstPos) >= 16) {
            throw new java.lang.IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 16");
        }
        short out = dstInit;
        for (int i = 0; i < nBytes; i++) {
            final int shift = (i * 8) + dstPos;
            final int bits = (255 & (src[(i + srcPos)])) << shift;
            final int mask = 255 << shift;
            out = ((short) ((out & (~mask)) | bits));
        }
        return out;
    }

    public static long hexToLong(final java.lang.String src, final int srcPos, final long dstInit, final int dstPos, final int nHex) {
        if (0 == nHex) {
            return dstInit;
        }
        if ((((nHex - 1) * 4) + dstPos) >= 64) {
            throw new java.lang.IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 64");
        }
        long out = dstInit;
        for (int i = 0; i < nHex; i++) {
            final int shift = (i * 4) + dstPos;
            final long bits = (15L & (org.apache.commons.lang3.Conversion.hexDigitToInt(src.charAt((i + srcPos))))) << shift;
            final long mask = 15L << shift;
            out = (out & (~mask)) | bits;
        }
        return out;
    }

    public static int hexToInt(final java.lang.String src, final int srcPos, final int dstInit, final int dstPos, final int nHex) {
        if (0 == nHex) {
            return dstInit;
        }
        if ((((nHex - 1) * 4) + dstPos) >= 32) {
            throw new java.lang.IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 32");
        }
        int out = dstInit;
        for (int i = 0; i < nHex; i++) {
            final int shift = (i * 4) + dstPos;
            final int bits = (15 & (org.apache.commons.lang3.Conversion.hexDigitToInt(src.charAt((i + srcPos))))) << shift;
            final int mask = 15 << shift;
            out = (out & (~mask)) | bits;
        }
        return out;
    }

    public static short hexToShort(final java.lang.String src, final int srcPos, final short dstInit, final int dstPos, final int nHex) {
        if (0 == nHex) {
            return dstInit;
        }
        if ((((nHex - 1) * 4) + dstPos) >= 16) {
            throw new java.lang.IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 16");
        }
        short out = dstInit;
        for (int i = 0; i < nHex; i++) {
            final int shift = (i * 4) + dstPos;
            final int bits = (15 & (org.apache.commons.lang3.Conversion.hexDigitToInt(src.charAt((i + srcPos))))) << shift;
            final int mask = 15 << shift;
            out = ((short) ((out & (~mask)) | bits));
        }
        return out;
    }

    public static byte hexToByte(final java.lang.String src, final int srcPos, final byte dstInit, final int dstPos, final int nHex) {
        if (0 == nHex) {
            return dstInit;
        }
        if ((((nHex - 1) * 4) + dstPos) >= 8) {
            throw new java.lang.IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 8");
        }
        byte out = dstInit;
        for (int i = 0; i < nHex; i++) {
            final int shift = (i * 4) + dstPos;
            final int bits = (15 & (org.apache.commons.lang3.Conversion.hexDigitToInt(src.charAt((i + srcPos))))) << shift;
            final int mask = 15 << shift;
            out = ((byte) ((out & (~mask)) | bits));
        }
        return out;
    }

    public static long binaryToLong(final boolean[] src, final int srcPos, final long dstInit, final int dstPos, final int nBools) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nBools)) {
            return dstInit;
        }
        if (((nBools - 1) + dstPos) >= 64) {
            throw new java.lang.IllegalArgumentException("nBools-1+dstPos is greater or equal to than 64");
        }
        long out = dstInit;
        for (int i = 0; i < nBools; i++) {
            final int shift = i + dstPos;
            final long bits = (src[(i + srcPos)] ? 1L : 0) << shift;
            final long mask = 1L << shift;
            out = (out & (~mask)) | bits;
        }
        return out;
    }

    public static int binaryToInt(final boolean[] src, final int srcPos, final int dstInit, final int dstPos, final int nBools) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nBools)) {
            return dstInit;
        }
        if (((nBools - 1) + dstPos) >= 32) {
            throw new java.lang.IllegalArgumentException("nBools-1+dstPos is greater or equal to than 32");
        }
        int out = dstInit;
        for (int i = 0; i < nBools; i++) {
            final int shift = i + dstPos;
            final int bits = (src[(i + srcPos)] ? 1 : 0) << shift;
            final int mask = 1 << shift;
            out = (out & (~mask)) | bits;
        }
        return out;
    }

    public static short binaryToShort(final boolean[] src, final int srcPos, final short dstInit, final int dstPos, final int nBools) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nBools)) {
            return dstInit;
        }
        if (((nBools - 1) + dstPos) >= 16) {
            throw new java.lang.IllegalArgumentException("nBools-1+dstPos is greater or equal to than 16");
        }
        short out = dstInit;
        for (int i = 0; i < nBools; i++) {
            final int shift = i + dstPos;
            final int bits = (src[(i + srcPos)] ? 1 : 0) << shift;
            final int mask = 1 << shift;
            out = ((short) ((out & (~mask)) | bits));
        }
        return out;
    }

    public static byte binaryToByte(final boolean[] src, final int srcPos, final byte dstInit, final int dstPos, final int nBools) {
        if ((((src.length) == 0) && (srcPos == 0)) || (0 == nBools)) {
            return dstInit;
        }
        if (((nBools - 1) + dstPos) >= 8) {
            throw new java.lang.IllegalArgumentException("nBools-1+dstPos is greater or equal to than 8");
        }
        byte out = dstInit;
        for (int i = 0; i < nBools; i++) {
            final int shift = i + dstPos;
            final int bits = (src[(i + srcPos)] ? 1 : 0) << shift;
            final int mask = 1 << shift;
            out = ((byte) ((out & (~mask)) | bits));
        }
        return out;
    }

    public static int[] longToIntArray(final long src, final int srcPos, final int[] dst, final int dstPos, final int nInts) {
        if (0 == nInts) {
            return dst;
        }
        if ((((nInts - 1) * 32) + srcPos) >= 64) {
            throw new java.lang.IllegalArgumentException("(nInts-1)*32+srcPos is greater or equal to than 64");
        }
        for (int i = 0; i < nInts; i++) {
            final int shift = (i * 32) + srcPos;
            dst[(dstPos + i)] = ((int) (-1 & (src >> shift)));
        }
        return dst;
    }

    public static short[] longToShortArray(final long src, final int srcPos, final short[] dst, final int dstPos, final int nShorts) {
        if (0 == nShorts) {
            return dst;
        }
        if ((((nShorts - 1) * 16) + srcPos) >= 64) {
            throw new java.lang.IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 64");
        }
        for (int i = 0; i < nShorts; i++) {
            final int shift = (i * 16) + srcPos;
            dst[(dstPos + i)] = ((short) (65535 & (src >> shift)));
        }
        return dst;
    }

    public static short[] intToShortArray(final int src, final int srcPos, final short[] dst, final int dstPos, final int nShorts) {
        if (0 == nShorts) {
            return dst;
        }
        if ((((nShorts - 1) * 16) + srcPos) >= 32) {
            throw new java.lang.IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 32");
        }
        for (int i = 0; i < nShorts; i++) {
            final int shift = (i * 16) + srcPos;
            dst[(dstPos + i)] = ((short) (65535 & (src >> shift)));
        }
        return dst;
    }

    public static byte[] longToByteArray(final long src, final int srcPos, final byte[] dst, final int dstPos, final int nBytes) {
        if (0 == nBytes) {
            return dst;
        }
        if ((((nBytes - 1) * 8) + srcPos) >= 64) {
            throw new java.lang.IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 64");
        }
        for (int i = 0; i < nBytes; i++) {
            final int shift = (i * 8) + srcPos;
            dst[(dstPos + i)] = ((byte) (255 & (src >> shift)));
        }
        return dst;
    }

    public static byte[] intToByteArray(final int src, final int srcPos, final byte[] dst, final int dstPos, final int nBytes) {
        if (0 == nBytes) {
            return dst;
        }
        if ((((nBytes - 1) * 8) + srcPos) >= 32) {
            throw new java.lang.IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 32");
        }
        for (int i = 0; i < nBytes; i++) {
            final int shift = (i * 8) + srcPos;
            dst[(dstPos + i)] = ((byte) (255 & (src >> shift)));
        }
        return dst;
    }

    public static byte[] shortToByteArray(final short src, final int srcPos, final byte[] dst, final int dstPos, final int nBytes) {
        if (0 == nBytes) {
            return dst;
        }
        if ((((nBytes - 1) * 8) + srcPos) >= 16) {
            throw new java.lang.IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 16");
        }
        for (int i = 0; i < nBytes; i++) {
            final int shift = (i * 8) + srcPos;
            dst[(dstPos + i)] = ((byte) (255 & (src >> shift)));
        }
        return dst;
    }

    public static java.lang.String longToHex(final long src, final int srcPos, final java.lang.String dstInit, final int dstPos, final int nHexs) {
        if (0 == nHexs) {
            return dstInit;
        }
        if ((((nHexs - 1) * 4) + srcPos) >= 64) {
            throw new java.lang.IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 64");
        }
        final java.lang.StringBuilder sb = new java.lang.StringBuilder(dstInit);
        int append = sb.length();
        for (int i = 0; i < nHexs; i++) {
            final int shift = (i * 4) + srcPos;
            final int bits = ((int) (15 & (src >> shift)));
            if ((dstPos + i) == append) {
                ++append;
                sb.append(org.apache.commons.lang3.Conversion.intToHexDigit(bits));
            }else {
                sb.setCharAt((dstPos + i), org.apache.commons.lang3.Conversion.intToHexDigit(bits));
            }
        }
        return sb.toString();
    }

    public static java.lang.String intToHex(final int src, final int srcPos, final java.lang.String dstInit, final int dstPos, final int nHexs) {
        if (0 == nHexs) {
            return dstInit;
        }
        if ((((nHexs - 1) * 4) + srcPos) >= 32) {
            throw new java.lang.IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 32");
        }
        final java.lang.StringBuilder sb = new java.lang.StringBuilder(dstInit);
        int append = sb.length();
        for (int i = 0; i < nHexs; i++) {
            final int shift = (i * 4) + srcPos;
            final int bits = 15 & (src >> shift);
            if ((dstPos + i) == append) {
                ++append;
                sb.append(org.apache.commons.lang3.Conversion.intToHexDigit(bits));
            }else {
                sb.setCharAt((dstPos + i), org.apache.commons.lang3.Conversion.intToHexDigit(bits));
            }
        }
        return sb.toString();
    }

    public static java.lang.String shortToHex(final short src, final int srcPos, final java.lang.String dstInit, final int dstPos, final int nHexs) {
        if (0 == nHexs) {
            return dstInit;
        }
        if ((((nHexs - 1) * 4) + srcPos) >= 16) {
            throw new java.lang.IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 16");
        }
        final java.lang.StringBuilder sb = new java.lang.StringBuilder(dstInit);
        int append = sb.length();
        for (int i = 0; i < nHexs; i++) {
            final int shift = (i * 4) + srcPos;
            final int bits = 15 & (src >> shift);
            if ((dstPos + i) == append) {
                ++append;
                sb.append(org.apache.commons.lang3.Conversion.intToHexDigit(bits));
            }else {
                sb.setCharAt((dstPos + i), org.apache.commons.lang3.Conversion.intToHexDigit(bits));
            }
        }
        return sb.toString();
    }

    public static java.lang.String byteToHex(final byte src, final int srcPos, final java.lang.String dstInit, final int dstPos, final int nHexs) {
        if (0 == nHexs) {
            return dstInit;
        }
        if ((((nHexs - 1) * 4) + srcPos) >= 8) {
            throw new java.lang.IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 8");
        }
        final java.lang.StringBuilder sb = new java.lang.StringBuilder(dstInit);
        int append = sb.length();
        for (int i = 0; i < nHexs; i++) {
            final int shift = (i * 4) + srcPos;
            final int bits = 15 & (src >> shift);
            if ((dstPos + i) == append) {
                ++append;
                sb.append(org.apache.commons.lang3.Conversion.intToHexDigit(bits));
            }else {
                sb.setCharAt((dstPos + i), org.apache.commons.lang3.Conversion.intToHexDigit(bits));
            }
        }
        return sb.toString();
    }

    public static boolean[] longToBinary(final long src, final int srcPos, final boolean[] dst, final int dstPos, final int nBools) {
        if (0 == nBools) {
            return dst;
        }
        if (((nBools - 1) + srcPos) >= 64) {
            throw new java.lang.IllegalArgumentException("nBools-1+srcPos is greater or equal to than 64");
        }
        for (int i = 0; i < nBools; i++) {
            final int shift = i + srcPos;
            dst[(dstPos + i)] = (1 & (src >> shift)) != 0;
        }
        return dst;
    }

    public static boolean[] intToBinary(final int src, final int srcPos, final boolean[] dst, final int dstPos, final int nBools) {
        if (0 == nBools) {
            return dst;
        }
        if (((nBools - 1) + srcPos) >= 32) {
            throw new java.lang.IllegalArgumentException("nBools-1+srcPos is greater or equal to than 32");
        }
        for (int i = 0; i < nBools; i++) {
            final int shift = i + srcPos;
            dst[(dstPos + i)] = (1 & (src >> shift)) != 0;
        }
        return dst;
    }

    public static boolean[] shortToBinary(final short src, final int srcPos, final boolean[] dst, final int dstPos, final int nBools) {
        if (0 == nBools) {
            return dst;
        }
        if (((nBools - 1) + srcPos) >= 16) {
            throw new java.lang.IllegalArgumentException("nBools-1+srcPos is greater or equal to than 16");
        }
        assert (nBools - 1) < (16 - srcPos);
        for (int i = 0; i < nBools; i++) {
            final int shift = i + srcPos;
            dst[(dstPos + i)] = (1 & (src >> shift)) != 0;
        }
        return dst;
    }

    public static boolean[] byteToBinary(final byte src, final int srcPos, final boolean[] dst, final int dstPos, final int nBools) {
        if (0 == nBools) {
            return dst;
        }
        if (((nBools - 1) + srcPos) >= 8) {
            throw new java.lang.IllegalArgumentException("nBools-1+srcPos is greater or equal to than 8");
        }
        for (int i = 0; i < nBools; i++) {
            final int shift = i + srcPos;
            dst[(dstPos + i)] = (1 & (src >> shift)) != 0;
        }
        return dst;
    }

    public static byte[] uuidToByteArray(final java.util.UUID src, final byte[] dst, final int dstPos, final int nBytes) {
        if (0 == nBytes) {
            return dst;
        }
        if (nBytes > 16) {
            throw new java.lang.IllegalArgumentException("nBytes is greater than 16");
        }
        org.apache.commons.lang3.Conversion.longToByteArray(src.getMostSignificantBits(), 0, dst, dstPos, (nBytes > 8 ? 8 : nBytes));
        if (nBytes >= 8) {
            org.apache.commons.lang3.Conversion.longToByteArray(src.getLeastSignificantBits(), 0, dst, (dstPos + 8), (nBytes - 8));
        }
        return dst;
    }

    public static java.util.UUID byteArrayToUuid(final byte[] src, final int srcPos) {
        if (((src.length) - srcPos) < 16) {
            throw new java.lang.IllegalArgumentException("Need at least 16 bytes for UUID");
        }
        return new java.util.UUID(org.apache.commons.lang3.Conversion.byteArrayToLong(src, srcPos, 0, 0, 8), org.apache.commons.lang3.Conversion.byteArrayToLong(src, (srcPos + 8), 0, 0, 8));
    }
}

