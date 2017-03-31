package fil.iagl.opl.conan;

import fil.iagl.opl.conan.handler.*;

public class MethodHandlerBuilder {

    public MethodHandler buildMethodHandler() {
        final MethodHandler methodHandler = new MethodHandler();
        methodHandler.addElementHandler(new AssignmentHandler());
        methodHandler.addElementHandler(new InvocationHandler());
        methodHandler.addElementHandler(new LoopHandler());
        methodHandler.addElementHandler(new UnaryOperatorHandler());
        methodHandler.addElementHandler(new VariableHandler());
        methodHandler.addElementHandler(new VariableReadHandler());
        return methodHandler;
    }

}
