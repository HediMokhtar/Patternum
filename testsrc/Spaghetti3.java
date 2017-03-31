public class Spaghetti3{

    public Spaghetti3(){}

    public static void call(){
        letsCallSpaghetti4();
    }

    public static void letsCallSpaghetti4(){
        Spaghetti4 sp4 = new Spaghetti4();
        Spaghetti4.call();
    }
}