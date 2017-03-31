

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Spaghetti4 {
    public Spaghetti4() {
    }

    public static void call() {
        Spaghetti4.letsCallSpaghetti5();
    }

    public static void letsCallSpaghetti5() {
        Spaghetti5 sp5 = new Spaghetti5();
        Spaghetti5.call();
    }
}

