

package Model;


@java.lang.SuppressWarnings(value = "serial")
public class SubStackTrace extends java.util.ArrayList<java.lang.String> {
    private java.lang.String id;

    private java.lang.String functionName = null;

    private java.lang.String fileName = null;

    private java.lang.String libraryName = null;

    private Model.Stacktrace stacktrace;

    private boolean haveStackTrace;

    public java.lang.String getId() {
        return id;
    }

    public java.lang.String getFileName() {
        return fileName;
    }

    public java.lang.String getFunctionName() {
        return functionName;
    }

    public java.lang.String getLibraryName() {
        return libraryName;
    }

    public SubStackTrace() {
        super();
        Model.SubStackTrace.this.haveStackTrace = false;
    }

    public SubStackTrace(java.lang.String id, java.lang.String functionName, java.lang.String fileName, java.lang.String libraryName) {
        Model.SubStackTrace.this.id = id;
        Model.SubStackTrace.this.functionName = functionName;
        Model.SubStackTrace.this.fileName = fileName;
        Model.SubStackTrace.this.libraryName = libraryName;
        Model.SubStackTrace.this.haveStackTrace = false;
    }

    public SubStackTrace(Model.Stacktrace stacktrace) {
        super();
        Model.SubStackTrace.this.stacktrace = stacktrace;
        Model.SubStackTrace.this.haveStackTrace = stacktrace.haveBucket();
    }

    public Model.Stacktrace getStackTrace() {
        return Model.SubStackTrace.this.stacktrace;
    }

    public Model.Bucket getBucket() {
        return Model.SubStackTrace.this.getStackTrace().getBucket();
    }

    public Model.Buckets getBuckets() {
        return Model.SubStackTrace.this.getBucket().getBuckets();
    }

    public boolean isFromLibraryOrFile() {
        if (!(libraryName.equalsIgnoreCase("")))
            return true;
        else
            if (!(fileName.equalsIgnoreCase("")))
                return false;
            else
                return java.lang.Boolean.parseBoolean(null);
            
        
    }

    public void fill(java.lang.String subStackTrace, java.lang.String id) {
        Model.SubStackTrace.this.id = id;
        java.lang.String[] splitedSubStackTrace = null;
        splitedSubStackTrace = subStackTrace.split("(?=\\t\\t{0,500}.{0,500} = |\\t{0,500}.{0,500} = )");
        boolean first = true;
        boolean firstLocal = false;
        java.lang.String string = "";
        for (java.lang.String subStackTraceLine : splitedSubStackTrace) {
            if ((subStackTraceLine.length()) <= 2) {
                if (first)
                    firstLocal = true;
                
                if ((!first) && (subStackTraceLine.equalsIgnoreCase("\t"))) {
                    firstLocal = true;
                }else {
                    if ((!(subStackTraceLine.equalsIgnoreCase("\t"))) && (!(subStackTraceLine.equalsIgnoreCase("\n"))))
                        string = string.concat(subStackTraceLine);
                    
                    first = false;
                }
            }else
                if (firstLocal) {
                    string = string.concat(subStackTraceLine);
                    firstLocal = false;
                    Model.SubStackTrace.this.add(string);
                    string = "";
                }else
                    Model.SubStackTrace.this.add(subStackTraceLine);
                
            
        }
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(" (.*)\\(.*\\).*at (.*.:[0-9]*)| in (.*)\\(.*\\) from (.+?(?=No )|.*)|( in \\?\\? .*)| in (.*)\\(.+?(?=No )", (((java.util.regex.Pattern.CASE_INSENSITIVE) | (java.util.regex.Pattern.DOTALL)) | (java.util.regex.Pattern.MULTILINE)));
        java.util.regex.Matcher matcher = pattern.matcher(splitedSubStackTrace[0]);
        if ((Model.SubStackTrace.this.haveStackTrace) == true) {
            Model.SubStackTrace.this.getBuckets().incrementTotalSubstacktrace();
            Model.SubStackTrace.this.getBuckets().incrementTotalOkSubstacktrace();
        }
        if (matcher.find()) {
            if ((matcher.group(1)) != null) {
                Model.SubStackTrace.this.functionName = matcher.group(1);
                if ((functionName.split(java.util.regex.Pattern.quote(" in ")).length) > 1)
                    functionName = functionName.split(java.util.regex.Pattern.quote(" in "))[1];
                
                Model.SubStackTrace.this.fileName = matcher.group(2);
            }else
                if ((matcher.group(3)) != null) {
                    Model.SubStackTrace.this.functionName = matcher.group(3);
                    Model.SubStackTrace.this.libraryName = matcher.group(4);
                }
            
        }else {
            if ((Model.SubStackTrace.this.haveStackTrace) == true) {
                Model.SubStackTrace.this.getBuckets().decrementTotalOkSubstacktrace();
                Model.SubStackTrace.this.getStackTrace().notOk();
            }
        }
    }
}

