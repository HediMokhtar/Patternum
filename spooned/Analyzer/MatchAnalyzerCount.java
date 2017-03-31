

package Analyzer;


public class MatchAnalyzerCount extends Analyzer.Analyzer {
    public MatchAnalyzerCount(Model.Buckets buckets) {
        super(buckets);
    }

    @java.lang.Override
    public Model.Bucket searchBucket(Model.Stacktrace stackTrace) {
        Model.Bucket bucketToReturn = new Model.Bucket("0");
        int deepOfMatch = 2;
        int functionMatchLimitOk = 1;
        int fileMatchLimitOk = 1;
        int libraryMatchLimitOk = 1;
        for (Model.Bucket bucket : Analyzer.MatchAnalyzerCount.this.buckets) {
            int functionMatchCount = 0;
            int fileMatchCount = 0;
            int libraryMatchCount = 0;
            for (Model.SubStackTrace subStackTrace : stackTrace) {
                if (((bucket.getFunctionNameProperty()) != null) && ((bucket.getFunctionNameProperty().size()) >= deepOfMatch)) {
                    for (int i = 0; i < deepOfMatch; i++) {
                        if (((subStackTrace.getFunctionName()) != null) && (subStackTrace.getFunctionName().equalsIgnoreCase(bucket.getFunctionNameProperty().get(i)))) {
                            functionMatchCount++;
                        }
                    }
                }
                if (((bucket.getFileNameProperty()) != null) && ((bucket.getFileNameProperty().size()) >= deepOfMatch)) {
                    for (int i = 0; i < deepOfMatch; i++) {
                        if (((subStackTrace.getFileName()) != null) && (subStackTrace.getFileName().equalsIgnoreCase(bucket.getFileNameProperty().get(i)))) {
                            fileMatchCount++;
                        }
                    }
                }
                if (((bucket.getLibraryNameProperty()) != null) && ((bucket.getLibraryNameProperty().size()) >= deepOfMatch)) {
                    for (int i = 0; i < deepOfMatch; i++) {
                        if (((subStackTrace.getLibraryName()) != null) && (subStackTrace.getLibraryName().equalsIgnoreCase(bucket.getLibraryNameProperty().get(i)))) {
                            libraryMatchCount++;
                        }
                    }
                }
                if ((functionMatchCount >= functionMatchLimitOk) && ((fileMatchCount >= fileMatchLimitOk) || (libraryMatchCount >= libraryMatchLimitOk)))
                    return bucketToReturn = bucket;
                
            }
        }
        return bucketToReturn;
    }
}

