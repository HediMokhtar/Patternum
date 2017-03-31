

package Analyzer;


public interface IAnalyzer {
    Model.Bucket searchBucket(Model.Stacktrace stackTrace);

    java.lang.String monperrusEvalPrinter(java.io.File stackTraceFile, Model.Stacktrace stackTrace);

    void createAnalyzeResultFile(java.io.File stackTraceFile, Model.Stacktrace stackTrace) throws java.io.IOException;
}

