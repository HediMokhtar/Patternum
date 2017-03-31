

package fil.iagl.opl.conan.model;


public interface Challenge<I> {
    java.lang.Class<? extends I> getInputFormat();

    java.util.List<I> getInputs();

    java.lang.Object doIt(I input);

    void challenge(I input);
}

