

package Model;


@java.lang.SuppressWarnings(value = "serial")
public class Bucket extends java.util.ArrayList<Model.Stacktrace> {
    private java.lang.String bucketNumber;

    private Model.Buckets buckets;

    private java.util.HashMap<java.lang.String, java.lang.Integer> functionNameRanking = new java.util.HashMap<java.lang.String, java.lang.Integer>();

    private java.util.ArrayList<java.lang.String> functionNameProperty;

    private java.util.HashMap<java.lang.String, java.lang.Integer> fileNameRanking = new java.util.HashMap<java.lang.String, java.lang.Integer>();

    private java.util.ArrayList<java.lang.String> fileNameProperty;

    private java.util.HashMap<java.lang.String, java.lang.Integer> libraryNameRanking = new java.util.HashMap<java.lang.String, java.lang.Integer>();

    private java.util.ArrayList<java.lang.String> libraryNameProperty;

    private java.util.HashMap<java.lang.String, java.lang.String> libraryAndFunctionNameRanking = new java.util.HashMap<java.lang.String, java.lang.String>();

    private java.util.ArrayList<java.lang.String> libraryAndFunctionNameProperty;

    private java.util.HashMap<java.lang.String, java.lang.String> fileAndFunctionNameRanking = new java.util.HashMap<java.lang.String, java.lang.String>();

    private java.util.ArrayList<java.lang.String> fileAndFunctionNameProperty;

    public Bucket(Model.Buckets buckets) {
        super();
        Model.Bucket.this.buckets = buckets;
    }

    public Bucket(java.lang.String bucketNumber) {
        super();
        Model.Bucket.this.bucketNumber = bucketNumber;
    }

    public java.lang.String getBucketNumber() {
        return bucketNumber;
    }

    public void setBucketNumber(java.lang.String number) {
        Model.Bucket.this.bucketNumber = number;
    }

    public Model.Buckets getBuckets() {
        return Model.Bucket.this.buckets;
    }

    public java.util.HashMap<java.lang.String, java.lang.Integer> getFunctionNameRanking() {
        return Model.Bucket.this.functionNameRanking;
    }

    public java.util.HashMap<java.lang.String, java.lang.Integer> getFileNameRanking() {
        return Model.Bucket.this.fileNameRanking;
    }

    public java.util.HashMap<java.lang.String, java.lang.Integer> getLibraryNameRanking() {
        return Model.Bucket.this.libraryNameRanking;
    }

    public synchronized java.util.ArrayList<java.lang.String> getFunctionNameProperty() {
        functionNameRanking.remove("?? ");
        if (((functionNameProperty) == null) && ((functionNameRanking) != null)) {
            functionNameProperty = new java.util.ArrayList<java.lang.String>(Main.Tools.sortByValue(functionNameRanking).keySet());
        }
        return functionNameProperty;
    }

    public synchronized java.util.ArrayList<java.lang.String> getFileNameProperty() {
        if (((fileNameProperty) == null) && ((fileNameRanking) != null)) {
            fileNameProperty = new java.util.ArrayList<java.lang.String>(Main.Tools.sortByValue(fileNameRanking).keySet());
        }
        return fileNameProperty;
    }

    public synchronized java.util.ArrayList<java.lang.String> getLibraryNameProperty() {
        if (((libraryNameProperty) == null) && ((libraryNameRanking) != null)) {
            libraryNameProperty = new java.util.ArrayList<java.lang.String>(Main.Tools.sortByValue(libraryNameRanking).keySet());
        }
        return libraryNameProperty;
    }

    public void fill(java.io.File[] directoryOfStacktraces, java.lang.String bucketNumber) {
        Model.Bucket.this.bucketNumber = bucketNumber;
        java.lang.System.out.println(("BUCKET : " + (Model.Bucket.this.bucketNumber)));
        for (java.io.File stackTraceDirectory : directoryOfStacktraces) {
            Model.Stacktrace stackTrace = new Model.Stacktrace(Model.Bucket.this);
            java.lang.System.out.println(("STACKTRACE : " + (stackTraceDirectory.getName())));
            stackTrace.fill(Model.Bucket.getStackTrace(stackTraceDirectory), stackTraceDirectory.getName());
            Model.Bucket.this.add(stackTrace);
        }
        java.lang.System.out.println(((((((("Bucket : " + (Model.Bucket.this.bucketNumber)) + "  --  Size : ") + (functionNameRanking.size())) + " - ") + (fileNameRanking.size())) + " - ") + (libraryNameRanking.size())));
    }

    private static java.io.File getStackTrace(java.io.File bucket) {
        return bucket.listFiles()[0];
    }

    public boolean containFunctionName(java.lang.String functionName) {
        return Model.Bucket.this.functionNameRanking.containsKey(functionName);
    }

    public boolean containFileName(java.lang.String fileName) {
        return Model.Bucket.this.fileNameRanking.containsKey(fileName);
    }

    public boolean containFunctionAndLibraryName(java.lang.String libraryName, java.lang.String functionName) {
        return Model.Bucket.this.libraryAndFunctionNameRanking.containsKey(libraryName.concat(functionName));
    }

    public boolean containLibraryName(java.lang.String libraryName) {
        return Model.Bucket.this.libraryNameRanking.containsKey(libraryName);
    }

    public boolean containFunctionAndFileName(java.lang.String fileName, java.lang.String functionName) {
        return Model.Bucket.this.libraryNameRanking.containsKey(fileName.concat(functionName));
    }

    public boolean add(Model.Stacktrace stackTrace) {
        java.lang.String currentFunctionName;
        java.lang.String currentFileName;
        java.lang.String currentLibraryName;
        for (Model.SubStackTrace subStackTrace : stackTrace) {
            currentFunctionName = subStackTrace.getFunctionName();
            currentFileName = subStackTrace.getFileName();
            currentLibraryName = subStackTrace.getLibraryName();
            if (currentFunctionName != null) {
                int count = functionNameRanking.containsKey(currentFunctionName) ? functionNameRanking.get(currentFunctionName) : 0;
                functionNameRanking.put(currentFunctionName, (count + 1));
            }
            if (currentFileName != null) {
                int count = fileNameRanking.containsKey(currentFileName) ? fileNameRanking.get(currentFileName) : 0;
                fileNameRanking.put(currentFileName, (count + 1));
            }
            if (currentLibraryName != null) {
                int count = libraryNameRanking.containsKey(currentLibraryName) ? libraryNameRanking.get(currentLibraryName) : 0;
                libraryNameRanking.put(currentLibraryName, (count + 1));
            }
            if ((currentLibraryName != null) && (currentFunctionName != null)) {
                libraryAndFunctionNameRanking.put(currentLibraryName.concat(currentFunctionName), "");
            }
            if ((currentFileName != null) && (currentFunctionName != null)) {
                fileAndFunctionNameRanking.put(currentFileName.concat(currentFunctionName), "");
            }
        }
        return super.add(stackTrace);
    }

    public boolean matchFunctionAndFileMap(java.lang.String functionName, java.lang.String fileName) {
        if ((functionName != null) && (fileName != null)) {
            if (Model.Bucket.this.containFunctionAndFileName(fileName, functionName)) {
                return true;
            }
        }
        return false;
    }

    public boolean matchFunctionAndLibraryMap(java.lang.String functionName, java.lang.String libraryName) {
        if ((functionName != null) && (libraryName != null)) {
            if (Model.Bucket.this.containFunctionAndLibraryName(libraryName, functionName)) {
                return true;
            }
        }
        return false;
    }

    public java.lang.String toString() {
        return Model.Bucket.this.bucketNumber;
    }
}

