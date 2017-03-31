

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class FourthChallenge implements fil.iagl.opl.conan.model.Challenge<java.lang.String> {
    @java.lang.Override
    public java.lang.Class<? extends java.lang.String> getInputFormat() {
        return java.lang.String.class;
    }

    @java.lang.Override
    public java.util.List<java.lang.String> getInputs() {
        return java.util.Arrays.asList(new java.lang.String[]{ "azerty" , "QWERTY" });
    }

    @java.lang.Override
    public void challenge(java.lang.String input) {
        try {
            doIt(input);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @java.lang.Override
    public java.lang.String doIt(java.lang.String input) {
        return checkString(input.length(), input.charAt(2), input.charAt(0));
    }

    private java.lang.String checkString(int length, char c, char d) {
        if ((lenghtSuperiorToTwo(length)) && ((charEqualE(c)) || (runTime(d)))) {
            return "OK";
        }else {
            return "Wrong";
        }
    }

    private boolean lenghtSuperiorToTwo(int length) {
        return length > 2;
    }

    private boolean charEqualE(char c) {
        return c == 'e';
    }

    private boolean runTime(char d) {
        throw new java.lang.RuntimeException("The input does not satisfy the given constraints ");
    }
}

