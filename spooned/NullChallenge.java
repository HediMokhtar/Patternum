

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class NullChallenge implements fil.iagl.opl.conan.model.Challenge<java.lang.Integer> {
    @java.lang.Override
    public java.lang.Class<? extends java.lang.Integer> getInputFormat() {
        return java.lang.Integer.class;
    }

    @java.lang.Override
    public java.util.List<java.lang.Integer> getInputs() {
        java.util.List<java.lang.Integer> inputs = new java.util.ArrayList<java.lang.Integer>();
        inputs.add(5);
        inputs.add(3);
        return inputs;
    }

    @java.lang.Override
    public java.lang.Object doIt(java.lang.Integer input) {
        java.lang.Integer j = null;
        if (input > 3) {
            j = 0;
        }
        return j;
    }

    @java.lang.Override
    public void challenge(java.lang.Integer input) {
        doIt(input);
    }
}

