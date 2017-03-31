

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class NewYearChallenge implements fil.iagl.opl.conan.model.Challenge<java.lang.Integer> {
    @java.lang.Override
    public java.lang.Class<? extends java.lang.Integer> getInputFormat() {
        return null;
    }

    @java.lang.Override
    public java.util.List<java.lang.Integer> getInputs() {
        java.util.List<java.lang.Integer> inputs = new java.util.ArrayList<java.lang.Integer>();
        inputs.add(java.util.Calendar.getInstance().getWeekYear());
        inputs.add(((java.util.Calendar.getInstance().getWeekYear()) - 1));
        return inputs;
    }

    @java.lang.Override
    public java.lang.Object doIt(java.lang.Integer input) {
        assert input.equals(java.util.Calendar.getInstance().getWeekYear());
        return input;
    }

    @java.lang.Override
    public void challenge(java.lang.Integer input) {
        int currentYear = 0;
        assert input.equals(java.util.Calendar.getInstance().getWeekYear());
        currentYear = input;
    }
}

