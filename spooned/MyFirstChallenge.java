

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class MyFirstChallenge implements fil.iagl.opl.conan.model.Challenge<java.lang.String> {
    @java.lang.Override
    public java.lang.Class<? extends java.lang.String> getInputFormat() {
        return java.lang.String.class;
    }

    @java.lang.Override
    public java.util.List<java.lang.String> getInputs() {
        return java.util.Arrays.asList(new java.lang.String[]{ "1" , "azerty" });
    }

    @java.lang.Override
    public void challenge(java.lang.String input) {
        try {
            java.lang.System.out.println(("Do it " + input));
            doIt(input);
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("exception");
        }
    }

    @java.lang.Override
    public java.lang.Object doIt(java.lang.String input) {
        return java.lang.Integer.parseInt(input);
    }
}

