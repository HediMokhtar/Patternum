

package Analyzer;


public abstract class Analyzer implements Analyzer.IAnalyzer {
    Model.Buckets buckets;

    java.io.File analyzeResultFile;

    public Analyzer(Model.Buckets buckets) {
        Analyzer.Analyzer.this.buckets = buckets;
        java.lang.String path = (Analyzer.Analyzer.this.getClass().getSimpleName()) + ".txt";
        if (new java.io.File(path).exists()) {
            new java.io.File(path).delete();
        }
        analyzeResultFile = new java.io.File(path);
    }

    public abstract Model.Bucket searchBucket(Model.Stacktrace stackTrace);

    public java.lang.String monperrusEvalPrinter(java.io.File stackTraceFile, Model.Stacktrace stackTrace) {
        java.lang.String result = "";
        result += java.lang.Integer.parseInt(stackTraceFile.getName().substring(0, ((stackTraceFile.getName().length()) - 4)));
        result += "  ->  ";
        result += (Analyzer.Analyzer.this.searchBucket(stackTrace).getBucketNumber()) + "\n";
        return result;
    }

    public java.lang.String monperrusEvalPrinter(Model.Stacktrace stackTrace, Model.Bucket bucket) {
        java.lang.String result = "";
        result += stackTrace.getStackTraceNumber();
        result += "  ->  ";
        result += (bucket.getBucketNumber()) + "\n";
        return result;
    }

    public void createAnalyzeResultFile(java.io.File stackTraceFile, Model.Stacktrace stackTrace) throws java.io.IOException {
        java.io.FileWriter output = new java.io.FileWriter(Analyzer.Analyzer.this.analyzeResultFile, true);
        java.lang.String analyzeResult = monperrusEvalPrinter(stackTraceFile, stackTrace);
        output.write(analyzeResult);
        output.close();
    }

    public java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.String>> getAnalyzeResults() {
        return new java.util.HashMap();
    }
}

