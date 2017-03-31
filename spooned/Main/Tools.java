

package Main;


public class Tools {
    public static java.lang.String readFile(java.lang.String path, java.nio.charset.Charset encoding) throws java.io.IOException {
        byte[] encoded = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(path));
        return new java.lang.String(encoded, encoding);
    }

    public static java.math.BigDecimal round(float d, int decimalPlace) {
        java.math.BigDecimal bd = new java.math.BigDecimal(java.lang.Float.toString(d));
        bd = bd.setScale(decimalPlace, java.math.BigDecimal.ROUND_HALF_UP);
        return bd;
    }

    public static synchronized java.lang.String getKeyOfMaxValue(java.util.HashMap<java.lang.String, java.lang.Integer> map) {
        java.util.Map.Entry<java.lang.String, java.lang.Integer> maxEntry = null;
        if ((map.size()) > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : map.entrySet()) {
                if ((entry != null) && ((maxEntry == null) || ((entry.getValue().compareTo(maxEntry.getValue())) > 0))) {
                    maxEntry = entry;
                }
            }
            return maxEntry.getKey();
        }else
            return null;
        
    }

    public static <K, V extends java.lang.Comparable<? super V>> java.util.Map<K, V> sortByValue(java.util.Map<K, V> map) {
        return map.entrySet().stream().sorted(java.util.Map.Entry.comparingByValue()).collect(java.util.stream.Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, ( e1, e2) -> e1, java.util.LinkedHashMap::new));
    }
}

