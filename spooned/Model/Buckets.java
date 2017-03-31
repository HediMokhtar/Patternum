

package Model;


@java.lang.SuppressWarnings(value = "serial")
public class Buckets extends java.util.ArrayList<Model.Bucket> {
    private float totalSubstacktrace = 0;

    private float totalOkSubstacktrace = 0;

    private float totalStackTrace = 0;

    private float totalOkStackTrace = 0;

    public Buckets(java.lang.String directoryBucketPath) {
        super();
        for (java.io.File directory : new java.io.File(directoryBucketPath).listFiles()) {
            Model.Bucket bucket = new Model.Bucket(Model.Buckets.this);
            java.lang.System.out.println(("BUCKET : " + (directory.getName())));
            bucket.fill(directory.listFiles(), directory.getName());
            Model.Buckets.this.add(bucket);
        }
    }

    public Buckets() {
    }

    public float getTotalSubstacktrace() {
        return totalSubstacktrace;
    }

    public void incrementTotalSubstacktrace() {
        (Model.Buckets.this.totalSubstacktrace)++;
    }

    public float getTotalOkSubstacktrace() {
        return totalOkSubstacktrace;
    }

    public void incrementTotalOkSubstacktrace() {
        (Model.Buckets.this.totalOkSubstacktrace)++;
    }

    public void decrementTotalOkSubstacktrace() {
        (Model.Buckets.this.totalOkSubstacktrace)--;
    }

    public float getTotalStackTrace() {
        return totalStackTrace;
    }

    public void incrementTotalStackTrace() {
        (Model.Buckets.this.totalStackTrace)++;
    }

    public float getTotalOkStackTrace() {
        return totalOkStackTrace;
    }

    public void incrementTotalOkStackTrace() {
        (Model.Buckets.this.totalOkStackTrace)++;
    }

    public void decrementTotalOkStackTrace() {
        (Model.Buckets.this.totalOkStackTrace)--;
    }

    public java.lang.String toString() {
        java.lang.String result = "";
        result += (("SubStacktrace OK : " + (Main.Tools.round((((getTotalOkSubstacktrace()) / (getTotalSubstacktrace())) * 100), 2))) + "%") + "\n";
        result += (("Stacktrace OK : " + (Main.Tools.round((((getTotalOkStackTrace()) / (getTotalStackTrace())) * 100), 2))) + "%") + "\n";
        result += ("Stacktrace OK : " + (Main.Tools.round(getTotalOkStackTrace(), 0))) + "\n";
        result += ("Stacktrace : " + (Main.Tools.round(getTotalStackTrace(), 0))) + "\n";
        result += ("Stacktrace NOT OK : " + (Main.Tools.round(((getTotalStackTrace()) - (getTotalOkStackTrace())), 0))) + "\n";
        return result;
    }

    public java.lang.String toStringBuckets() {
        java.lang.String s = "";
        for (Model.Bucket b : Model.Buckets.this) {
            s += (b.toString()) + "\n";
        }
        return s;
    }
}

