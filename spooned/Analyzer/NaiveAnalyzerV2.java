

package Analyzer;


public class NaiveAnalyzerV2 extends Analyzer.Analyzer {
    public NaiveAnalyzerV2(Model.Buckets buckets) {
        super(buckets);
    }

    public Model.Bucket searchBucket(Model.Stacktrace stackTrace) {
        Model.Bucket bucketToReturn = new Model.Bucket("0");
        for (Model.Bucket bucket : Analyzer.NaiveAnalyzerV2.this.buckets) {
            if (Analyzer.NaiveAnalyzerV2.stackTraceMatch(stackTrace, bucket)) {
                return bucketToReturn = bucket;
            }
        }
        return bucketToReturn;
    }

    public Model.Buckets searchPotentialBuckets(Model.Stacktrace stackTrace) {
        Model.Buckets bucketsToReturn = new Model.Buckets();
        for (Model.Bucket bucket : Analyzer.NaiveAnalyzerV2.this.buckets) {
            if (Analyzer.NaiveAnalyzerV2.stackTraceMatch(stackTrace, bucket)) {
                bucketsToReturn.add(bucket);
            }
        }
        return bucketsToReturn;
    }

    public int searchNumberOfPotentialBuckets(Model.Stacktrace stackTrace) {
        int result = 0;
        for (Model.Bucket bucket : Analyzer.NaiveAnalyzerV2.this.buckets) {
            if (Analyzer.NaiveAnalyzerV2.stackTraceMatch(stackTrace, bucket)) {
                result++;
            }
        }
        return result;
    }

    public int searchNumberOfMatchingBuckets(Model.Stacktrace stackTrace) {
        int numbersOfMatch = 0;
        for (Model.Bucket bucket : Analyzer.NaiveAnalyzerV2.this.buckets) {
            if (Analyzer.NaiveAnalyzerV2.stackTraceMatch(stackTrace, bucket)) {
                numbersOfMatch++;
            }
        }
        return numbersOfMatch;
    }

    public java.lang.String monperrusEvalPrinter(java.io.File stackTraceFile, Model.Stacktrace stackTrace) {
        java.lang.String result = "";
        result += java.lang.Integer.parseInt(stackTraceFile.getName().substring(0, ((stackTraceFile.getName().length()) - 4)));
        result += "  ->  ";
        result += (Analyzer.NaiveAnalyzerV2.this.searchBucket(stackTrace).getBucketNumber()) + "\n";
        result += (Analyzer.NaiveAnalyzerV2.this.searchNumberOfMatchingBuckets(stackTrace)) + "\n";
        return result;
    }

    private static boolean stackTraceMatch(Model.Stacktrace stackTrace, Model.Bucket bucket) {
        for (Model.SubStackTrace subStackTrace : stackTrace) {
            if (Analyzer.NaiveAnalyzerV2.isPartOfSubStackTraceInTheBucket(subStackTrace, bucket)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPartOfSubStackTraceInTheBucket(Model.SubStackTrace subStackTrace, Model.Bucket bucket) {
        if (bucket.matchFunctionAndFileMap(subStackTrace.getFunctionName(), subStackTrace.getFileName())) {
            return true;
        }
        if (bucket.matchFunctionAndLibraryMap(subStackTrace.getFunctionName(), subStackTrace.getLibraryName())) {
            return true;
        }
        return false;
    }
}

