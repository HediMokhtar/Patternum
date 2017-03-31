

package Main;


public class Main {
    public static final java.lang.String PATH_BUCKETS_TRAINING = "./nautilus/nautilus-training";

    public static final java.lang.String PATH_BUCKETS_TESTING = "./nautilus/nautilus-testing";

    public static java.util.HashMap<java.lang.String, java.lang.Integer> functionMap = new java.util.HashMap<java.lang.String, java.lang.Integer>();

    public static java.util.HashMap<java.lang.String, java.lang.Integer> fileMap = new java.util.HashMap<java.lang.String, java.lang.Integer>();

    public static java.util.HashMap<java.lang.String, java.lang.Integer> libraryMap = new java.util.HashMap<java.lang.String, java.lang.Integer>();

    public static void main(java.lang.String[] arg) throws java.io.IOException {
        Model.Buckets buckets = new Model.Buckets(Main.Main.PATH_BUCKETS_TRAINING);
        java.lang.System.out.println(buckets.toString());
        java.io.File stacktraceFile = new java.io.File(Main.Main.PATH_BUCKETS_TESTING);
        java.io.File[] stacktraceFiles = stacktraceFile.listFiles();
        Analyzer.NaiveAnalyzer naive = new Analyzer.NaiveAnalyzer(buckets);
        java.lang.System.out.println("=====================================================");
        java.lang.System.out.println(("TESTING with : " + (naive.getClass().getSimpleName())));
        java.lang.System.out.println("=====================================================");
        Model.Stacktrace stacktraceTesting;
        for (java.io.File stackTraceTest : stacktraceFiles) {
            stacktraceTesting = new Model.Stacktrace();
            stacktraceTesting.fill(stackTraceTest, stackTraceTest.getName().substring(0, ((stackTraceTest.getName().length()) - 4)));
            java.lang.System.out.print(naive.searchAndGetValidateBuckets(stacktraceTesting));
            java.lang.System.out.print(naive.searchAndGetAlmostValidateBuckets(stacktraceTesting));
            naive.createAnalyzeResultFile(stackTraceTest, stacktraceTesting);
        }
    }

    public static void Analyze(Analyzer.IAnalyzer analyzer, java.io.File[] stacktraceFiles) throws java.io.IOException {
        java.lang.System.out.println("=====================================================");
        java.lang.System.out.println(("TESTING with : " + (analyzer.getClass().getSimpleName())));
        java.lang.System.out.println("=====================================================");
        Model.Stacktrace stacktraceTesting;
        for (java.io.File stackTraceTest : stacktraceFiles) {
            stacktraceTesting = new Model.Stacktrace();
            stacktraceTesting.fill(stackTraceTest, stackTraceTest.getName().substring(0, ((stackTraceTest.getName().length()) - 4)));
            java.lang.System.out.print(analyzer.monperrusEvalPrinter(stackTraceTest, stacktraceTesting));
            analyzer.createAnalyzeResultFile(stackTraceTest, stacktraceTesting);
        }
    }
}

