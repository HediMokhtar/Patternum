

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class ReverseChallenge implements fil.iagl.opl.conan.model.Challenge<java.lang.String> {
    public java.lang.Class<java.lang.String> getInputFormat() {
        return java.lang.String.class;
    }

    public java.util.List<java.lang.String> getInputs() {
        return java.util.Arrays.asList("Cornichon de Bordeaux", "Carotte de Chamonixx\n");
    }

    public java.lang.Object doIt(java.lang.String input) {
        java.lang.String inputReverse = "";
        for (int i = (input.length()) - 1; i >= 0; i--) {
            inputReverse += input.charAt(i);
        }
        return inputReverse;
    }

    public void challenge(java.lang.String input) {
        java.lang.String inputReverse = "";
        for (int i = (input.length()) - 1; i >= 0; i--) {
            inputReverse += input.charAt(i);
        }
        if (inputReverse.substring(0, 1).equals("x"))
            return ;
        else
            throw new java.lang.RuntimeException();
        
    }
}

