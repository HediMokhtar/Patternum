

package Analyzer;


public class MatchAnalyzerGeneralCount extends Analyzer.Analyzer {
    public MatchAnalyzerGeneralCount(Model.Buckets buckets) {
        super(buckets);
    }

    @java.lang.Override
    public Model.Bucket searchBucket(Model.Stacktrace stackTrace) {
        Model.Bucket bucketToReturn = new Model.Bucket("0");
        int deepOfMatch = 1;
        int generalMatchLimit = 2;
        for (Model.Bucket bucket : Analyzer.MatchAnalyzerGeneralCount.this.buckets) {
            int generalCount = 0;
            for (Model.SubStackTrace subStackTrace : stackTrace) {
                if (((bucket.getFunctionNameProperty()) != null) && ((bucket.getFunctionNameProperty().size()) >= deepOfMatch)) {
                    for (int i = 0; i < deepOfMatch; i++) {
                        if (((subStackTrace.getFunctionName()) != null) && (subStackTrace.getFunctionName().equalsIgnoreCase(bucket.getFunctionNameProperty().get(i)))) {
                            generalCount++;
                        }
                    }
                }
                if (((bucket.getFileNameProperty()) != null) && ((bucket.getFileNameProperty().size()) >= deepOfMatch)) {
                    for (int i = 0; i < deepOfMatch; i++) {
                        if (((subStackTrace.getFileName()) != null) && (subStackTrace.getFileName().equalsIgnoreCase(bucket.getFileNameProperty().get(i)))) {
                            generalCount++;
                        }
                    }
                }
                if (((bucket.getLibraryNameProperty()) != null) && ((bucket.getLibraryNameProperty().size()) >= deepOfMatch)) {
                    for (int i = 0; i < deepOfMatch; i++) {
                        if (((subStackTrace.getLibraryName()) != null) && (subStackTrace.getLibraryName().equalsIgnoreCase(bucket.getLibraryNameProperty().get(i)))) {
                            generalCount++;
                        }
                    }
                }
                if (generalCount >= generalMatchLimit)
                    return bucketToReturn = bucket;
                
            }
        }
        return bucketToReturn;
    }
}

