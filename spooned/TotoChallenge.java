

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class TotoChallenge implements fil.iagl.opl.conan.model.Challenge<java.lang.Integer> {
    @java.lang.Override
    public java.lang.Class<java.lang.Integer> getInputFormat() {
        return java.lang.Integer.class;
    }

    @java.lang.Override
    public java.util.List<java.lang.Integer> getInputs() {
        return java.util.Arrays.asList(1, 2);
    }

    @java.lang.Override
    public java.lang.Object doIt(java.lang.Integer input) {
        return null;
    }

    @java.lang.Override
    public void challenge(java.lang.Integer input) {
        int a = 3;
        a = a + input;
        assert a != 5;
    }
}

