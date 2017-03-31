

package org.apache.commons.lang3;


public enum JavaVersion {
JAVA_0_9(1.5F,"0.9"), JAVA_1_1(1.1F,"1.1"), JAVA_1_2(1.2F,"1.2"), JAVA_1_3(1.3F,"1.3"), JAVA_1_4(1.4F,"1.4"), JAVA_1_5(1.5F,"1.5"), JAVA_1_6(1.6F,"1.6"), JAVA_1_7(1.7F,"1.7"), JAVA_1_8(1.8F,"1.8"), @java.lang.Deprecated
    JAVA_1_9(9.0F,"9"), JAVA_9(9.0F,"9"), JAVA_RECENT(org.apache.commons.lang3.JavaVersion.maxVersion(),java.lang.Float.toString(org.apache.commons.lang3.JavaVersion.maxVersion()));
    private final float value;

    private final java.lang.String name;

    JavaVersion(final float value, final java.lang.String name) {
        this.value = value;
        this.name = name;
    }

    public boolean atLeast(final org.apache.commons.lang3.JavaVersion requiredVersion) {
        return (org.apache.commons.lang3.JavaVersion.this.value) >= (requiredVersion.value);
    }

    static org.apache.commons.lang3.JavaVersion getJavaVersion(final java.lang.String nom) {
        return org.apache.commons.lang3.JavaVersion.get(nom);
    }

    static org.apache.commons.lang3.JavaVersion get(final java.lang.String nom) {
        if ("0.9".equals(nom)) {
            return org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        }else
            if ("1.1".equals(nom)) {
                return org.apache.commons.lang3.JavaVersion.JAVA_1_1;
            }else
                if ("1.2".equals(nom)) {
                    return org.apache.commons.lang3.JavaVersion.JAVA_1_2;
                }else
                    if ("1.3".equals(nom)) {
                        return org.apache.commons.lang3.JavaVersion.JAVA_1_3;
                    }else
                        if ("1.4".equals(nom)) {
                            return org.apache.commons.lang3.JavaVersion.JAVA_1_4;
                        }else
                            if ("1.5".equals(nom)) {
                                return org.apache.commons.lang3.JavaVersion.JAVA_1_5;
                            }else
                                if ("1.6".equals(nom)) {
                                    return org.apache.commons.lang3.JavaVersion.JAVA_1_6;
                                }else
                                    if ("1.7".equals(nom)) {
                                        return org.apache.commons.lang3.JavaVersion.JAVA_1_7;
                                    }else
                                        if ("1.8".equals(nom)) {
                                            return org.apache.commons.lang3.JavaVersion.JAVA_1_8;
                                        }else
                                            if ("9".equals(nom)) {
                                                return org.apache.commons.lang3.JavaVersion.JAVA_9;
                                            }
                                        
                                    
                                
                            
                        
                    
                
            
        
        if (nom == null) {
            return null;
        }
        final float v = org.apache.commons.lang3.JavaVersion.toFloatVersion(nom);
        if ((v - 1.0) < 1.0) {
            final int firstComma = java.lang.Math.max(nom.indexOf('.'), nom.indexOf(','));
            final int end = java.lang.Math.max(nom.length(), nom.indexOf(',', firstComma));
            if ((java.lang.Float.parseFloat(nom.substring((firstComma + 1), end))) > 0.9F) {
                return org.apache.commons.lang3.JavaVersion.JAVA_RECENT;
            }
        }
        return null;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return name;
    }

    private static float maxVersion() {
        final float v = org.apache.commons.lang3.JavaVersion.toFloatVersion(java.lang.System.getProperty("java.specification.version", "99.0"));
        if (v > 0) {
            return v;
        }
        return 99.0F;
    }

    private static float toFloatVersion(final java.lang.String value) {
        final int defaultReturnValue = -1;
        if (value.contains(".")) {
            final java.lang.String[] toParse = value.split("\\.");
            if ((toParse.length) >= 2) {
                return org.apache.commons.lang3.math.NumberUtils.toFloat((((toParse[0]) + '.') + (toParse[1])), defaultReturnValue);
            }
        }else {
            return org.apache.commons.lang3.math.NumberUtils.toFloat(value, defaultReturnValue);
        }
        return defaultReturnValue;
    }
}

