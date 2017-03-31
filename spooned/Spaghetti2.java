

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Spaghetti2 {
    public Spaghetti2() {
    }

    public static void call() {
        Spaghetti2.letsCallSpaghetti3();
    }

    public static void letsCallSpaghetti3() {
        Spaghetti3 sp3 = new Spaghetti3();
        Spaghetti3.call();
    }
}

