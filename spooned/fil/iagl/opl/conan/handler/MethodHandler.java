

package fil.iagl.opl.conan.handler;


public class MethodHandler {
    private java.util.List<fil.iagl.opl.conan.handler.ElementHandler> elementHandlers;

    public MethodHandler() {
        elementHandlers = new java.util.LinkedList<fil.iagl.opl.conan.handler.ElementHandler>();
    }

    public void addElementHandler(fil.iagl.opl.conan.handler.ElementHandler elementHandler) {
        elementHandlers.add(elementHandler);
    }

    public void handleMethod(spoon.reflect.declaration.CtMethod method, spoon.Launcher launcher) {
        elementHandlers.forEach(( handler) -> handler.handle(method, launcher));
    }
}

