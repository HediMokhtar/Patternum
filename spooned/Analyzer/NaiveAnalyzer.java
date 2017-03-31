

package Analyzer;


public class NaiveAnalyzer extends Analyzer.Analyzer {
    private java.util.HashMap<Model.Stacktrace, Model.Buckets> potentialStackTraceBuckets;

    private java.util.HashMap<Model.Stacktrace, Model.Bucket> stackTraceWhichBelongToOneBucket;

    private java.util.HashMap<Model.Stacktrace, Model.Buckets> stackTraceWhichBelongToFewBuckets;

    public NaiveAnalyzer(Model.Buckets buckets) {
        super(buckets);
        Analyzer.NaiveAnalyzer.this.potentialStackTraceBuckets = new java.util.HashMap<Model.Stacktrace, Model.Buckets>();
        Analyzer.NaiveAnalyzer.this.stackTraceWhichBelongToOneBucket = new java.util.HashMap<Model.Stacktrace, Model.Bucket>();
        stackTraceWhichBelongToFewBuckets = new java.util.HashMap<Model.Stacktrace, Model.Buckets>();
    }

    public Model.Bucket searchBucket(Model.Stacktrace stackTrace) {
        Model.Bucket bucketToReturn = new Model.Bucket("0");
        for (Model.Bucket bucket : Analyzer.NaiveAnalyzer.this.buckets) {
            if (Analyzer.NaiveAnalyzer.stackTraceMatch(stackTrace, bucket)) {
                return bucketToReturn = bucket;
            }
        }
        return bucketToReturn;
    }

    private void searchPotentialBuckets(Model.Stacktrace stackTrace) {
        Model.Buckets potentialBuckets = new Model.Buckets();
        for (Model.Bucket bucket : Analyzer.NaiveAnalyzer.this.buckets) {
            if (Analyzer.NaiveAnalyzer.stackTraceMatch(stackTrace, bucket)) {
                potentialBuckets.add(bucket);
            }
        }
        Analyzer.NaiveAnalyzer.this.potentialStackTraceBuckets.put(stackTrace, potentialBuckets);
    }

    private Model.Buckets getPotentialBuckets(Model.Stacktrace stackTrace) {
        return Analyzer.NaiveAnalyzer.this.potentialStackTraceBuckets.get(stackTrace);
    }

    private java.lang.String printPotentialBuckets(Model.Stacktrace stackTrace) {
        return getPotentialBuckets(stackTrace).toStringBuckets();
    }

    public java.lang.String searchAndGetPotentialBuckets(Model.Stacktrace stackTrace) {
        Analyzer.NaiveAnalyzer.this.searchPotentialBuckets(stackTrace);
        return Analyzer.NaiveAnalyzer.this.printPotentialBuckets(stackTrace);
    }

    private Model.Bucket getValidateBuckets(Model.Stacktrace stackTrace) {
        return Analyzer.NaiveAnalyzer.this.stackTraceWhichBelongToOneBucket.get(stackTrace);
    }

    private java.lang.String printValidateBuckets(Model.Stacktrace stackTrace) {
        if ((getValidateBuckets(stackTrace)) == null) {
            return "";
        }
        return (((stackTrace.getStackTraceNumber()) + " validate bucket : ") + (getValidateBuckets(stackTrace).toString())) + "\n";
    }

    public java.lang.String searchAndGetValidateBuckets(Model.Stacktrace stackTrace) {
        Analyzer.NaiveAnalyzer.this.searchPotentialBuckets(stackTrace);
        Analyzer.NaiveAnalyzer.this.catchValidateBuckets();
        return Analyzer.NaiveAnalyzer.this.printValidateBuckets(stackTrace);
    }

    private Model.Buckets getAlmostValidateBuckets(Model.Stacktrace stackTrace) {
        return Analyzer.NaiveAnalyzer.this.stackTraceWhichBelongToFewBuckets.get(stackTrace);
    }

    private java.lang.String printAlmostValidateBuckets(Model.Stacktrace stackTrace) {
        if ((getAlmostValidateBuckets(stackTrace)) == null) {
            return "";
        }
        return (((stackTrace.getStackTraceNumber()) + " almost validate buckets :  \n ") + (getAlmostValidateBuckets(stackTrace).toStringBuckets())) + "\n";
    }

    public java.lang.String searchAndGetAlmostValidateBuckets(Model.Stacktrace stackTrace) {
        Analyzer.NaiveAnalyzer.this.catchAlmostValidateBuckets();
        return Analyzer.NaiveAnalyzer.this.printAlmostValidateBuckets(stackTrace);
    }

    private void catchValidateBuckets() {
        Model.Buckets target;
        for (Model.Stacktrace key : potentialStackTraceBuckets.keySet()) {
            target = potentialStackTraceBuckets.get(key);
            if ((target.size()) == 1) {
                Analyzer.NaiveAnalyzer.this.stackTraceWhichBelongToOneBucket.put(key, target.get(0));
            }
        }
    }

    private void catchAlmostValidateBuckets() {
        Model.Buckets target;
        for (Model.Stacktrace key : potentialStackTraceBuckets.keySet()) {
            target = potentialStackTraceBuckets.get(key);
            if (((target.size()) < 10) && ((target.size()) > 1)) {
                Analyzer.NaiveAnalyzer.this.stackTraceWhichBelongToFewBuckets.put(key, target);
            }
        }
    }

    private java.util.HashMap<Model.Stacktrace, Model.Bucket> getValidateBucket(Model.Stacktrace stackTrace) {
        Analyzer.NaiveAnalyzer.this.searchPotentialBuckets(stackTrace);
        Analyzer.NaiveAnalyzer.this.catchValidateBuckets();
        return Analyzer.NaiveAnalyzer.this.stackTraceWhichBelongToOneBucket;
    }

    public java.lang.String monperrusEvalPrinter(Model.Stacktrace stacktrace) {
        java.util.HashMap<Model.Stacktrace, Model.Bucket> result = getValidateBucket(stacktrace);
        return Analyzer.NaiveAnalyzer.this.monperrusEvalPrinter(stacktrace, result.get(stacktrace));
    }

    public int searchNumberOfMatchingBuckets(Model.Stacktrace stackTrace) {
        int numbersOfMatch = 0;
        for (Model.Bucket bucket : Analyzer.NaiveAnalyzer.this.buckets) {
            if (Analyzer.NaiveAnalyzer.stackTraceMatch(stackTrace, bucket)) {
                numbersOfMatch++;
            }
        }
        return numbersOfMatch;
    }

    public java.lang.String monperrusEvalPrinter(java.io.File stackTraceFile, Model.Stacktrace stackTrace) {
        java.lang.String result = "";
        result += java.lang.Integer.parseInt(stackTraceFile.getName().substring(0, ((stackTraceFile.getName().length()) - 4)));
        result += "  ->  ";
        result += (Analyzer.NaiveAnalyzer.this.searchBucket(stackTrace).getBucketNumber()) + "\n";
        result += (Analyzer.NaiveAnalyzer.this.searchNumberOfMatchingBuckets(stackTrace)) + "\n";
        return result;
    }

    private static boolean stackTraceMatch(Model.Stacktrace stackTrace, Model.Bucket bucket) {
        for (Model.SubStackTrace subStackTrace : stackTrace) {
            if (Analyzer.NaiveAnalyzer.isPartOfSubStackTraceInTheBucket(subStackTrace, bucket)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPartOfSubStackTraceInTheBucket(Model.SubStackTrace subStackTrace, Model.Bucket bucket) {
        if ((bucket.containFunctionName(subStackTrace.getFunctionName())) && (bucket.containFileName(subStackTrace.getFileName()))) {
            return true;
        }
        if ((bucket.containFunctionName(subStackTrace.getFunctionName())) && (bucket.containLibraryName(subStackTrace.getLibraryName()))) {
            return true;
        }
        return false;
    }
}

