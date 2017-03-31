

package fil.iagl.opl.conan;


public class MethodHandlerBuilder {
    public fil.iagl.opl.conan.handler.MethodHandler buildMethodHandler() {
        final fil.iagl.opl.conan.handler.MethodHandler methodHandler = new fil.iagl.opl.conan.handler.MethodHandler();
        methodHandler.addElementHandler(new fil.iagl.opl.conan.handler.AssignmentHandler());
        methodHandler.addElementHandler(new fil.iagl.opl.conan.handler.InvocationHandler());
        methodHandler.addElementHandler(new fil.iagl.opl.conan.handler.LoopHandler());
        methodHandler.addElementHandler(new fil.iagl.opl.conan.handler.UnaryOperatorHandler());
        methodHandler.addElementHandler(new fil.iagl.opl.conan.handler.VariableHandler());
        methodHandler.addElementHandler(new fil.iagl.opl.conan.handler.VariableReadHandler());
        return methodHandler;
    }
}

