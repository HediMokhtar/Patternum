public class Spaghetti4{

    public Spaghetti4(){}

    public static void call(){
        letsCallSpaghetti5();
    }

    public static void letsCallSpaghetti5(){
        Spaghetti5 sp5 = new Spaghetti5();
        Spaghetti5.call();
    }



}