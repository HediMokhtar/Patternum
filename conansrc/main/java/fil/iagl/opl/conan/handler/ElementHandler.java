package fil.iagl.opl.conan.handler;

import spoon.Launcher;
import spoon.reflect.declaration.CtMethod;

public interface ElementHandler {

    void handle(CtMethod method, Launcher launcher);

}
