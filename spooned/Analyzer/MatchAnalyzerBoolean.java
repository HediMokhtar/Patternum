

package Analyzer;


public class MatchAnalyzerBoolean extends Analyzer.Analyzer {
    private boolean isMatched = false;

    public MatchAnalyzerBoolean(Model.Buckets buckets) {
        super(buckets);
    }

    @java.lang.Override
    public Model.Bucket searchBucket(Model.Stacktrace stackTrace) {
        Model.Bucket bucketToReturn = new Model.Bucket("0");
        boolean isFunctionMatched = false;
        boolean isLibraryMatched = false;
        boolean isFileNameMatched = false;
        for (Model.Bucket bucket : Analyzer.MatchAnalyzerBoolean.this.buckets) {
            for (Model.SubStackTrace subStackTrace : stackTrace) {
                if (((bucket.getFunctionNameProperty()) != null) && ((bucket.getFunctionNameProperty().size()) > 0)) {
                    if (((subStackTrace.getFunctionName()) != null) && (subStackTrace.getFunctionName().equalsIgnoreCase(bucket.getFunctionNameProperty().get(0))))
                        isFunctionMatched = true;
                    
                }else
                    isFunctionMatched = true;
                
                if (((bucket.getFileNameProperty()) != null) && ((bucket.getFileNameProperty().size()) > 0)) {
                    if (((subStackTrace.getFileName()) != null) && (subStackTrace.getFileName().equalsIgnoreCase(bucket.getFileNameProperty().get(0))))
                        isFileNameMatched = true;
                    
                }else
                    isFunctionMatched = true;
                
                if (((bucket.getLibraryNameProperty()) != null) && ((bucket.getLibraryNameProperty().size()) > 0)) {
                    if (((subStackTrace.getLibraryName()) != null) && (subStackTrace.getLibraryName().equalsIgnoreCase(bucket.getLibraryNameProperty().get(0))))
                        isLibraryMatched = true;
                    
                }else
                    isFunctionMatched = true;
                
            }
            if ((isFunctionMatched && isFileNameMatched) || isLibraryMatched)
                return bucketToReturn = bucket;
            
        }
        return bucketToReturn;
    }

    private int keyValue(java.util.HashMap<java.lang.String, java.lang.Integer> rankMap, java.lang.String name) {
        if ((rankMap.get(name)) == null) {
            return 0;
        }else {
            return rankMap.get(name);
        }
    }
}

