package fil.iagl.opl.conan.handler;

import spoon.Launcher;
import spoon.reflect.declaration.CtMethod;

import java.util.LinkedList;
import java.util.List;

public class MethodHandler {

    private List<ElementHandler> elementHandlers;

    public MethodHandler() {
        elementHandlers = new LinkedList<ElementHandler>();
    }

    public void addElementHandler(ElementHandler elementHandler) {
        elementHandlers.add(elementHandler);
    }

    public void handleMethod(CtMethod method, Launcher launcher) {
        elementHandlers.forEach(handler -> handler.handle(method, launcher));
    }

}
