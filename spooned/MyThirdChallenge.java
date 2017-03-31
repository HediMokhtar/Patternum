

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class MyThirdChallenge implements fil.iagl.opl.conan.model.Challenge<java.lang.String[]> {
    @java.lang.Override
    public java.lang.Class<? extends java.lang.String[]> getInputFormat() {
        return java.lang.String[].class;
    }

    @java.lang.Override
    public java.util.List<java.lang.String[]> getInputs() {
        return java.util.Arrays.asList(new java.lang.String[][]{ new java.lang.String[]{ "azerty" , "t" } , new java.lang.String[]{ "azerty" , "c" } });
    }

    @java.lang.Override
    public void challenge(java.lang.String[] input) {
        try {
            doIt(input);
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("exception");
        }
    }

    @java.lang.Override
    public java.lang.Object doIt(java.lang.String[] input) {
        return recursive(0, input[0], input[1].charAt(0));
    }

    private java.lang.String recursive(int i, java.lang.String word, char c) {
        if ((word.charAt(i)) == c)
            return (((("Char " + c) + " can be found in ") + word) + " at ") + i;
        
        return recursive((i + 1), word, c);
    }
}

