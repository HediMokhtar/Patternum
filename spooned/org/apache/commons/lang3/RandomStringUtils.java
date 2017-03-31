

package org.apache.commons.lang3;


public class RandomStringUtils {
    private static final java.util.Random RANDOM = new java.util.Random();

    public RandomStringUtils() {
        super();
    }

    public static java.lang.String random(final int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, false, false);
    }

    public static java.lang.String randomAscii(final int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, 32, 127, false, false);
    }

    public static java.lang.String randomAscii(final int minLengthInclusive, final int maxLengthExclusive) {
        return org.apache.commons.lang3.RandomStringUtils.randomAscii(org.apache.commons.lang3.RandomUtils.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static java.lang.String randomAlphabetic(final int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, true, false);
    }

    public static java.lang.String randomAlphabetic(final int minLengthInclusive, final int maxLengthExclusive) {
        return org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(org.apache.commons.lang3.RandomUtils.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static java.lang.String randomAlphanumeric(final int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, true, true);
    }

    public static java.lang.String randomAlphanumeric(final int minLengthInclusive, final int maxLengthExclusive) {
        return org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(org.apache.commons.lang3.RandomUtils.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static java.lang.String randomGraph(final int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, 33, 126, false, false);
    }

    public static java.lang.String randomGraph(final int minLengthInclusive, final int maxLengthExclusive) {
        return org.apache.commons.lang3.RandomStringUtils.randomGraph(org.apache.commons.lang3.RandomUtils.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static java.lang.String randomNumeric(final int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, false, true);
    }

    public static java.lang.String randomNumeric(final int minLengthInclusive, final int maxLengthExclusive) {
        return org.apache.commons.lang3.RandomStringUtils.randomNumeric(org.apache.commons.lang3.RandomUtils.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static java.lang.String randomPrint(final int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, 32, 126, false, false);
    }

    public static java.lang.String randomPrint(final int minLengthInclusive, final int maxLengthExclusive) {
        return org.apache.commons.lang3.RandomStringUtils.randomPrint(org.apache.commons.lang3.RandomUtils.nextInt(minLengthInclusive, maxLengthExclusive));
    }

    public static java.lang.String random(final int count, final boolean letters, final boolean numbers) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, 0, 0, letters, numbers);
    }

    public static java.lang.String random(final int count, final int start, final int end, final boolean letters, final boolean numbers) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, start, end, letters, numbers, null, org.apache.commons.lang3.RandomStringUtils.RANDOM);
    }

    public static java.lang.String random(final int count, final int start, final int end, final boolean letters, final boolean numbers, final char... chars) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, start, end, letters, numbers, chars, org.apache.commons.lang3.RandomStringUtils.RANDOM);
    }

    public static java.lang.String random(int count, int start, int end, final boolean letters, final boolean numbers, final char[] chars, final java.util.Random random) {
        if (count == 0) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }else
            if (count < 0) {
                throw new java.lang.IllegalArgumentException((("Requested random string length " + count) + " is less than 0."));
            }
        
        if ((chars != null) && ((chars.length) == 0)) {
            throw new java.lang.IllegalArgumentException("The chars array must not be empty");
        }
        if ((start == 0) && (end == 0)) {
            if (chars != null) {
                end = chars.length;
            }else {
                if ((!letters) && (!numbers)) {
                    end = java.lang.Character.MAX_CODE_POINT;
                }else {
                    end = 'z' + 1;
                    start = ' ';
                }
            }
        }else {
            if (end <= start) {
                throw new java.lang.IllegalArgumentException((((("Parameter end (" + end) + ") must be greater than start (") + start) + ")"));
            }
        }
        final int zero_digit_ascii = 48;
        final int first_letter_ascii = 65;
        if (chars == null) {
            if ((numbers && (end <= zero_digit_ascii)) || (letters && (end <= first_letter_ascii))) {
                throw new java.lang.IllegalArgumentException(((((((("Parameter end (" + end) + ") must be greater then (") + zero_digit_ascii) + ") for generating digits ") + "or greater then (") + first_letter_ascii) + ") for generating letters."));
            }
        }
        java.lang.StringBuilder builder = new java.lang.StringBuilder(count);
        final int gap = end - start;
        while ((count--) != 0) {
            int codePoint;
            if (chars == null) {
                codePoint = (random.nextInt(gap)) + start;
                switch (java.lang.Character.getType(codePoint)) {
                    case java.lang.Character.UNASSIGNED :
                    case java.lang.Character.PRIVATE_USE :
                    case java.lang.Character.SURROGATE :
                        count++;
                        continue;
                }
            }else {
                codePoint = chars[((random.nextInt(gap)) + start)];
            }
            final int numberOfChars = java.lang.Character.charCount(codePoint);
            if ((count == 0) && (numberOfChars > 1)) {
                count++;
                continue;
            }
            if (((letters && (java.lang.Character.isLetter(codePoint))) || (numbers && (java.lang.Character.isDigit(codePoint)))) || ((!letters) && (!numbers))) {
                builder.appendCodePoint(codePoint);
                if (numberOfChars == 2) {
                    count--;
                }
            }else {
                count++;
            }
        } 
        return builder.toString();
    }

    public static java.lang.String random(final int count, final java.lang.String chars) {
        if (chars == null) {
            return org.apache.commons.lang3.RandomStringUtils.random(count, 0, 0, false, false, null, org.apache.commons.lang3.RandomStringUtils.RANDOM);
        }
        return org.apache.commons.lang3.RandomStringUtils.random(count, chars.toCharArray());
    }

    public static java.lang.String random(final int count, final char... chars) {
        if (chars == null) {
            return org.apache.commons.lang3.RandomStringUtils.random(count, 0, 0, false, false, null, org.apache.commons.lang3.RandomStringUtils.RANDOM);
        }
        return org.apache.commons.lang3.RandomStringUtils.random(count, 0, chars.length, false, false, chars, org.apache.commons.lang3.RandomStringUtils.RANDOM);
    }
}

