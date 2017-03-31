public class Spaghetti2{

    public Spaghetti2(){}

    public static void call(){
        letsCallSpaghetti3();
    }

    public static void letsCallSpaghetti3(){
        Spaghetti3 sp3 = new Spaghetti3();
        Spaghetti3.call();
    }



}