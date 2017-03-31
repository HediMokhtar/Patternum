

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Spaghetti3 {
    public Spaghetti3() {
    }

    public static void call() {
        Spaghetti3.letsCallSpaghetti4();
    }

    public static void letsCallSpaghetti4() {
        Spaghetti4 sp4 = new Spaghetti4();
        Spaghetti4.call();
    }
}

