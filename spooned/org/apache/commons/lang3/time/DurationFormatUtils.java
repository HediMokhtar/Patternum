

package org.apache.commons.lang3.time;


public class DurationFormatUtils {
    public DurationFormatUtils() {
        super();
    }

    public static final java.lang.String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";

    public static java.lang.String formatDurationHMS(final long durationMillis) {
        return org.apache.commons.lang3.time.DurationFormatUtils.formatDuration(durationMillis, "HH:mm:ss.SSS");
    }

    public static java.lang.String formatDurationISO(final long durationMillis) {
        return org.apache.commons.lang3.time.DurationFormatUtils.formatDuration(durationMillis, org.apache.commons.lang3.time.DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static java.lang.String formatDuration(final long durationMillis, final java.lang.String format) {
        return org.apache.commons.lang3.time.DurationFormatUtils.formatDuration(durationMillis, format, true);
    }

    public static java.lang.String formatDuration(final long durationMillis, final java.lang.String format, final boolean padWithZeros) {
        org.apache.commons.lang3.Validate.inclusiveBetween(0, java.lang.Long.MAX_VALUE, durationMillis, "durationMillis must not be negative");
        final org.apache.commons.lang3.time.DurationFormatUtils.Token[] tokens = org.apache.commons.lang3.time.DurationFormatUtils.lexx(format);
        long days = 0;
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        long milliseconds = durationMillis;
        if (org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.d)) {
            days = milliseconds / (org.apache.commons.lang3.time.DateUtils.MILLIS_PER_DAY);
            milliseconds = milliseconds - (days * (org.apache.commons.lang3.time.DateUtils.MILLIS_PER_DAY));
        }
        if (org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.H)) {
            hours = milliseconds / (org.apache.commons.lang3.time.DateUtils.MILLIS_PER_HOUR);
            milliseconds = milliseconds - (hours * (org.apache.commons.lang3.time.DateUtils.MILLIS_PER_HOUR));
        }
        if (org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.m)) {
            minutes = milliseconds / (org.apache.commons.lang3.time.DateUtils.MILLIS_PER_MINUTE);
            milliseconds = milliseconds - (minutes * (org.apache.commons.lang3.time.DateUtils.MILLIS_PER_MINUTE));
        }
        if (org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.s)) {
            seconds = milliseconds / (org.apache.commons.lang3.time.DateUtils.MILLIS_PER_SECOND);
            milliseconds = milliseconds - (seconds * (org.apache.commons.lang3.time.DateUtils.MILLIS_PER_SECOND));
        }
        return org.apache.commons.lang3.time.DurationFormatUtils.format(tokens, 0, 0, days, hours, minutes, seconds, milliseconds, padWithZeros);
    }

    public static java.lang.String formatDurationWords(final long durationMillis, final boolean suppressLeadingZeroElements, final boolean suppressTrailingZeroElements) {
        java.lang.String duration = org.apache.commons.lang3.time.DurationFormatUtils.formatDuration(durationMillis, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (suppressLeadingZeroElements) {
            duration = " " + duration;
            java.lang.String tmp = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 0 days", org.apache.commons.lang3.StringUtils.EMPTY);
            if ((tmp.length()) != (duration.length())) {
                duration = tmp;
                tmp = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 0 hours", org.apache.commons.lang3.StringUtils.EMPTY);
                if ((tmp.length()) != (duration.length())) {
                    duration = tmp;
                    tmp = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 0 minutes", org.apache.commons.lang3.StringUtils.EMPTY);
                    duration = tmp;
                    if ((tmp.length()) != (duration.length())) {
                        duration = org.apache.commons.lang3.StringUtils.replaceOnce(tmp, " 0 seconds", org.apache.commons.lang3.StringUtils.EMPTY);
                    }
                }
            }
            if ((duration.length()) != 0) {
                duration = duration.substring(1);
            }
        }
        if (suppressTrailingZeroElements) {
            java.lang.String tmp = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 0 seconds", org.apache.commons.lang3.StringUtils.EMPTY);
            if ((tmp.length()) != (duration.length())) {
                duration = tmp;
                tmp = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 0 minutes", org.apache.commons.lang3.StringUtils.EMPTY);
                if ((tmp.length()) != (duration.length())) {
                    duration = tmp;
                    tmp = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 0 hours", org.apache.commons.lang3.StringUtils.EMPTY);
                    if ((tmp.length()) != (duration.length())) {
                        duration = org.apache.commons.lang3.StringUtils.replaceOnce(tmp, " 0 days", org.apache.commons.lang3.StringUtils.EMPTY);
                    }
                }
            }
        }
        duration = " " + duration;
        duration = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 1 seconds", " 1 second");
        duration = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 1 minutes", " 1 minute");
        duration = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 1 hours", " 1 hour");
        duration = org.apache.commons.lang3.StringUtils.replaceOnce(duration, " 1 days", " 1 day");
        return duration.trim();
    }

    public static java.lang.String formatPeriodISO(final long startMillis, final long endMillis) {
        return org.apache.commons.lang3.time.DurationFormatUtils.formatPeriod(startMillis, endMillis, org.apache.commons.lang3.time.DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, java.util.TimeZone.getDefault());
    }

    public static java.lang.String formatPeriod(final long startMillis, final long endMillis, final java.lang.String format) {
        return org.apache.commons.lang3.time.DurationFormatUtils.formatPeriod(startMillis, endMillis, format, true, java.util.TimeZone.getDefault());
    }

    public static java.lang.String formatPeriod(final long startMillis, final long endMillis, final java.lang.String format, final boolean padWithZeros, final java.util.TimeZone timezone) {
        org.apache.commons.lang3.Validate.isTrue((startMillis <= endMillis), "startMillis must not be greater than endMillis");
        final org.apache.commons.lang3.time.DurationFormatUtils.Token[] tokens = org.apache.commons.lang3.time.DurationFormatUtils.lexx(format);
        final java.util.Calendar start = java.util.Calendar.getInstance(timezone);
        start.setTime(new java.util.Date(startMillis));
        final java.util.Calendar end = java.util.Calendar.getInstance(timezone);
        end.setTime(new java.util.Date(endMillis));
        int milliseconds = (end.get(java.util.Calendar.MILLISECOND)) - (start.get(java.util.Calendar.MILLISECOND));
        int seconds = (end.get(java.util.Calendar.SECOND)) - (start.get(java.util.Calendar.SECOND));
        int minutes = (end.get(java.util.Calendar.MINUTE)) - (start.get(java.util.Calendar.MINUTE));
        int hours = (end.get(java.util.Calendar.HOUR_OF_DAY)) - (start.get(java.util.Calendar.HOUR_OF_DAY));
        int days = (end.get(java.util.Calendar.DAY_OF_MONTH)) - (start.get(java.util.Calendar.DAY_OF_MONTH));
        int months = (end.get(java.util.Calendar.MONTH)) - (start.get(java.util.Calendar.MONTH));
        int years = (end.get(java.util.Calendar.YEAR)) - (start.get(java.util.Calendar.YEAR));
        while (milliseconds < 0) {
            milliseconds += 1000;
            seconds -= 1;
        } 
        while (seconds < 0) {
            seconds += 60;
            minutes -= 1;
        } 
        while (minutes < 0) {
            minutes += 60;
            hours -= 1;
        } 
        while (hours < 0) {
            hours += 24;
            days -= 1;
        } 
        if (org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.M)) {
            while (days < 0) {
                days += start.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
                months -= 1;
                start.add(java.util.Calendar.MONTH, 1);
            } 
            while (months < 0) {
                months += 12;
                years -= 1;
            } 
            if ((!(org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.y))) && (years != 0)) {
                while (years != 0) {
                    months += 12 * years;
                    years = 0;
                } 
            }
        }else {
            if (!(org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.y))) {
                int target = end.get(java.util.Calendar.YEAR);
                if (months < 0) {
                    target -= 1;
                }
                while ((start.get(java.util.Calendar.YEAR)) != target) {
                    days += (start.getActualMaximum(java.util.Calendar.DAY_OF_YEAR)) - (start.get(java.util.Calendar.DAY_OF_YEAR));
                    if (((start instanceof java.util.GregorianCalendar) && ((start.get(java.util.Calendar.MONTH)) == (java.util.Calendar.FEBRUARY))) && ((start.get(java.util.Calendar.DAY_OF_MONTH)) == 29)) {
                        days += 1;
                    }
                    start.add(java.util.Calendar.YEAR, 1);
                    days += start.get(java.util.Calendar.DAY_OF_YEAR);
                } 
                years = 0;
            }
            while ((start.get(java.util.Calendar.MONTH)) != (end.get(java.util.Calendar.MONTH))) {
                days += start.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
                start.add(java.util.Calendar.MONTH, 1);
            } 
            months = 0;
            while (days < 0) {
                days += start.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
                months -= 1;
                start.add(java.util.Calendar.MONTH, 1);
            } 
        }
        if (!(org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.d))) {
            hours += 24 * days;
            days = 0;
        }
        if (!(org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.H))) {
            minutes += 60 * hours;
            hours = 0;
        }
        if (!(org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.m))) {
            seconds += 60 * minutes;
            minutes = 0;
        }
        if (!(org.apache.commons.lang3.time.DurationFormatUtils.Token.containsTokenWithValue(tokens, org.apache.commons.lang3.time.DurationFormatUtils.s))) {
            milliseconds += 1000 * seconds;
            seconds = 0;
        }
        return org.apache.commons.lang3.time.DurationFormatUtils.format(tokens, years, months, days, hours, minutes, seconds, milliseconds, padWithZeros);
    }

    static java.lang.String format(final org.apache.commons.lang3.time.DurationFormatUtils.Token[] tokens, final long years, final long months, final long days, final long hours, final long minutes, final long seconds, final long milliseconds, final boolean padWithZeros) {
        final java.lang.StringBuilder buffer = new java.lang.StringBuilder();
        boolean lastOutputSeconds = false;
        for (final org.apache.commons.lang3.time.DurationFormatUtils.Token token : tokens) {
            final java.lang.Object value = token.getValue();
            final int count = token.getCount();
            if (value instanceof java.lang.StringBuilder) {
                buffer.append(value.toString());
            }else {
                if (value.equals(org.apache.commons.lang3.time.DurationFormatUtils.y)) {
                    buffer.append(org.apache.commons.lang3.time.DurationFormatUtils.paddedValue(years, padWithZeros, count));
                    lastOutputSeconds = false;
                }else
                    if (value.equals(org.apache.commons.lang3.time.DurationFormatUtils.M)) {
                        buffer.append(org.apache.commons.lang3.time.DurationFormatUtils.paddedValue(months, padWithZeros, count));
                        lastOutputSeconds = false;
                    }else
                        if (value.equals(org.apache.commons.lang3.time.DurationFormatUtils.d)) {
                            buffer.append(org.apache.commons.lang3.time.DurationFormatUtils.paddedValue(days, padWithZeros, count));
                            lastOutputSeconds = false;
                        }else
                            if (value.equals(org.apache.commons.lang3.time.DurationFormatUtils.H)) {
                                buffer.append(org.apache.commons.lang3.time.DurationFormatUtils.paddedValue(hours, padWithZeros, count));
                                lastOutputSeconds = false;
                            }else
                                if (value.equals(org.apache.commons.lang3.time.DurationFormatUtils.m)) {
                                    buffer.append(org.apache.commons.lang3.time.DurationFormatUtils.paddedValue(minutes, padWithZeros, count));
                                    lastOutputSeconds = false;
                                }else
                                    if (value.equals(org.apache.commons.lang3.time.DurationFormatUtils.s)) {
                                        buffer.append(org.apache.commons.lang3.time.DurationFormatUtils.paddedValue(seconds, padWithZeros, count));
                                        lastOutputSeconds = true;
                                    }else
                                        if (value.equals(org.apache.commons.lang3.time.DurationFormatUtils.S)) {
                                            if (lastOutputSeconds) {
                                                final int width = padWithZeros ? java.lang.Math.max(3, count) : 3;
                                                buffer.append(org.apache.commons.lang3.time.DurationFormatUtils.paddedValue(milliseconds, true, width));
                                            }else {
                                                buffer.append(org.apache.commons.lang3.time.DurationFormatUtils.paddedValue(milliseconds, padWithZeros, count));
                                            }
                                            lastOutputSeconds = false;
                                        }
                                    
                                
                            
                        
                    
                
            }
        }
        return buffer.toString();
    }

    private static java.lang.String paddedValue(final long value, final boolean padWithZeros, final int count) {
        final java.lang.String longString = java.lang.Long.toString(value);
        return padWithZeros ? org.apache.commons.lang3.StringUtils.leftPad(longString, count, '0') : longString;
    }

    static final java.lang.Object y = "y";

    static final java.lang.Object M = "M";

    static final java.lang.Object d = "d";

    static final java.lang.Object H = "H";

    static final java.lang.Object m = "m";

    static final java.lang.Object s = "s";

    static final java.lang.Object S = "S";

    static org.apache.commons.lang3.time.DurationFormatUtils.Token[] lexx(final java.lang.String format) {
        final java.util.ArrayList<org.apache.commons.lang3.time.DurationFormatUtils.Token> list = new java.util.ArrayList<>(format.length());
        boolean inLiteral = false;
        java.lang.StringBuilder buffer = null;
        org.apache.commons.lang3.time.DurationFormatUtils.Token previous = null;
        for (int i = 0; i < (format.length()); i++) {
            final char ch = format.charAt(i);
            if (inLiteral && (ch != '\'')) {
                buffer.append(ch);
                continue;
            }
            java.lang.Object value = null;
            switch (ch) {
                case '\'' :
                    if (inLiteral) {
                        buffer = null;
                        inLiteral = false;
                    }else {
                        buffer = new java.lang.StringBuilder();
                        list.add(new org.apache.commons.lang3.time.DurationFormatUtils.Token(buffer));
                        inLiteral = true;
                    }
                    break;
                case 'y' :
                    value = org.apache.commons.lang3.time.DurationFormatUtils.y;
                    break;
                case 'M' :
                    value = org.apache.commons.lang3.time.DurationFormatUtils.M;
                    break;
                case 'd' :
                    value = org.apache.commons.lang3.time.DurationFormatUtils.d;
                    break;
                case 'H' :
                    value = org.apache.commons.lang3.time.DurationFormatUtils.H;
                    break;
                case 'm' :
                    value = org.apache.commons.lang3.time.DurationFormatUtils.m;
                    break;
                case 's' :
                    value = org.apache.commons.lang3.time.DurationFormatUtils.s;
                    break;
                case 'S' :
                    value = org.apache.commons.lang3.time.DurationFormatUtils.S;
                    break;
                default :
                    if (buffer == null) {
                        buffer = new java.lang.StringBuilder();
                        list.add(new org.apache.commons.lang3.time.DurationFormatUtils.Token(buffer));
                    }
                    buffer.append(ch);
            }
            if (value != null) {
                if ((previous != null) && (previous.getValue().equals(value))) {
                    previous.increment();
                }else {
                    final org.apache.commons.lang3.time.DurationFormatUtils.Token token = new org.apache.commons.lang3.time.DurationFormatUtils.Token(value);
                    list.add(token);
                    previous = token;
                }
                buffer = null;
            }
        }
        if (inLiteral) {
            throw new java.lang.IllegalArgumentException(("Unmatched quote in format: " + format));
        }
        return list.toArray(new org.apache.commons.lang3.time.DurationFormatUtils.Token[list.size()]);
    }

    static class Token {
        static boolean containsTokenWithValue(final org.apache.commons.lang3.time.DurationFormatUtils.Token[] tokens, final java.lang.Object value) {
            for (final org.apache.commons.lang3.time.DurationFormatUtils.Token token : tokens) {
                if ((token.getValue()) == value) {
                    return true;
                }
            }
            return false;
        }

        private final java.lang.Object value;

        private int count;

        Token(final java.lang.Object value) {
            this.value = value;
            org.apache.commons.lang3.time.DurationFormatUtils.Token.this.count = 1;
        }

        Token(final java.lang.Object value, final int count) {
            this.value = value;
            org.apache.commons.lang3.time.DurationFormatUtils.Token.this.count = count;
        }

        void increment() {
            (count)++;
        }

        int getCount() {
            return count;
        }

        java.lang.Object getValue() {
            return value;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj2) {
            if (obj2 instanceof org.apache.commons.lang3.time.DurationFormatUtils.Token) {
                final org.apache.commons.lang3.time.DurationFormatUtils.Token tok2 = ((org.apache.commons.lang3.time.DurationFormatUtils.Token) (obj2));
                if ((org.apache.commons.lang3.time.DurationFormatUtils.Token.this.value.getClass()) != (tok2.value.getClass())) {
                    return false;
                }
                if ((org.apache.commons.lang3.time.DurationFormatUtils.Token.this.count) != (tok2.count)) {
                    return false;
                }
                if ((org.apache.commons.lang3.time.DurationFormatUtils.Token.this.value) instanceof java.lang.StringBuilder) {
                    return org.apache.commons.lang3.time.DurationFormatUtils.Token.this.value.toString().equals(tok2.value.toString());
                }else
                    if ((org.apache.commons.lang3.time.DurationFormatUtils.Token.this.value) instanceof java.lang.Number) {
                        return org.apache.commons.lang3.time.DurationFormatUtils.Token.this.value.equals(tok2.value);
                    }else {
                        return (org.apache.commons.lang3.time.DurationFormatUtils.Token.this.value) == (tok2.value);
                    }
                
            }
            return false;
        }

        @java.lang.Override
        public int hashCode() {
            return org.apache.commons.lang3.time.DurationFormatUtils.Token.this.value.hashCode();
        }

        @java.lang.Override
        public java.lang.String toString() {
            return org.apache.commons.lang3.StringUtils.repeat(org.apache.commons.lang3.time.DurationFormatUtils.Token.this.value.toString(), org.apache.commons.lang3.time.DurationFormatUtils.Token.this.count);
        }
    }
}

