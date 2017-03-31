

package Model;


@java.lang.SuppressWarnings(value = "serial")
public class Stacktrace extends java.util.ArrayList<Model.SubStackTrace> {
    private java.lang.String stackTraceNumber;

    private boolean first = true;

    private Model.Bucket bucket;

    private boolean haveBucket;

    public java.lang.String getStackTraceNumber() {
        return stackTraceNumber;
    }

    public Stacktrace() {
        super();
        first = true;
        Model.Stacktrace.this.haveBucket = false;
    }

    public Stacktrace(Model.Bucket bucket) {
        super();
        first = true;
        Model.Stacktrace.this.bucket = bucket;
        Model.Stacktrace.this.haveBucket = true;
    }

    public Model.Bucket getBucket() {
        return Model.Stacktrace.this.bucket;
    }

    public Model.Buckets getBuckets() {
        return Model.Stacktrace.this.getBucket().getBuckets();
    }

    public boolean haveBucket() {
        return Model.Stacktrace.this.haveBucket;
    }

    public void fill(java.io.File fileStacktrace, java.lang.String stackTraceNumber) {
        Model.Stacktrace.this.stackTraceNumber = stackTraceNumber;
        try {
            java.lang.String stacktrace = Main.Tools.readFile(fileStacktrace.getPath(), java.nio.charset.Charset.defaultCharset());
            if ((Model.Stacktrace.this.haveBucket) == true) {
                Model.Stacktrace.this.getBuckets().incrementTotalStackTrace();
                Model.Stacktrace.this.getBuckets().incrementTotalOkStackTrace();
            }
            java.lang.String[] splitedStrackTrace = stacktrace.split(java.util.regex.Pattern.quote("#"));
            java.util.ArrayList<java.lang.String> splitedStrackTraceList = new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(splitedStrackTrace));
            if (splitedStrackTraceList.get(0).equalsIgnoreCase(""))
                splitedStrackTraceList.remove(0);
            
            for (java.lang.String subStackTraceString : splitedStrackTraceList) {
                java.lang.String idSub = "-1";
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("([0-9]*)");
                java.util.regex.Matcher matcher = pattern.matcher(subStackTraceString);
                if (matcher.find()) {
                    if (!(matcher.group(1).equalsIgnoreCase("")))
                        idSub = matcher.group(1);
                    else
                        java.lang.System.out.println(subStackTraceString);
                    
                }else
                    java.lang.System.out.println(("Regex fail for the id of the SubStacktrace : " + subStackTraceString));
                
                Model.SubStackTrace subStackTrace = new Model.SubStackTrace(Model.Stacktrace.this);
                subStackTrace.fill(subStackTraceString, idSub);
                Model.Stacktrace.this.add(subStackTrace);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void notOk() {
        if ((first) && ((Model.Stacktrace.this.haveBucket) == true)) {
            Model.Stacktrace.this.getBuckets().decrementTotalOkStackTrace();
            first = false;
        }
    }
}

