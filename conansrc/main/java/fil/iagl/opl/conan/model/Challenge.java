package fil.iagl.opl.conan.model;

import java.util.List;

public interface Challenge<I> {

    Class<? extends I> getInputFormat();

    List<I> getInputs();

    Object doIt(I input);

    void challenge(I input);

}
