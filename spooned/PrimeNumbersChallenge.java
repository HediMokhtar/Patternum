

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class PrimeNumbersChallenge implements fil.iagl.opl.conan.model.Challenge<java.lang.Integer> {
    @java.lang.Override
    public java.lang.Class<? extends java.lang.Integer> getInputFormat() {
        return null;
    }

    @java.lang.Override
    public java.util.List<java.lang.Integer> getInputs() {
        int[] numbers = new int[]{ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 35 , 60 };
        java.util.List<java.lang.Integer> inputs = new java.util.ArrayList(java.util.Arrays.asList(numbers));
        return inputs;
    }

    @java.lang.Override
    public java.lang.Object doIt(java.lang.Integer input) {
        boolean isPrime = true;
        if (input < 0) {
            isPrime = false;
        }else
            if ((input != 0) && (input != 1)) {
                for (int i = 2; i <= (input / 2); i++) {
                    if ((input != i) && ((input % i) == 0)) {
                        isPrime = false;
                        break;
                    }
                }
            }
        
        if (!isPrime)
            throw new java.lang.RuntimeException("Value is not a prime number");
        
        return input;
    }

    @java.lang.Override
    public void challenge(java.lang.Integer input) {
        doIt(input);
    }
}

