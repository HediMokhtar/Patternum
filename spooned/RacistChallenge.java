

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class RacistChallenge implements fil.iagl.opl.conan.model.Challenge<java.awt.Color> {
    @java.lang.Override
    public java.lang.Class<java.awt.Color> getInputFormat() {
        return java.awt.Color.class;
    }

    @java.lang.Override
    public java.util.List<java.awt.Color> getInputs() {
        return java.util.Arrays.asList(java.awt.Color.WHITE, java.awt.Color.BLUE, java.awt.Color.CYAN, java.awt.Color.RED);
    }

    @java.lang.Override
    public java.lang.Object doIt(java.awt.Color input) {
        return null;
    }

    @java.lang.Override
    public void challenge(java.awt.Color input) {
        for (int i = 0; i < 10; i++) {
            java.lang.System.out.println("toto");
        }
        if (input != null) {
            int blueLevel = input.getBlue();
            assert blueLevel != 0;
        }
    }
}

