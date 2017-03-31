package fil.iagl.opl.spoon;

import fil.iagl.opl.handler.*;

/**
 * class used to build our MethodHandler
 */
public class HandlerBuilder {

    /**
     * Build all anti-pattern handler in the MethodHandler in a row
     */
    public static MethodHandler buildMethodHandler() {
        final MethodHandler methodHandler = new MethodHandler();
        methodHandler.addElementHandler(new Blob());
        methodHandler.addElementHandler(new BooleanParameter());
        methodHandler.addElementHandler(new TooManyParameters());
        methodHandler.addElementHandler(new SpaghettiCode());
        return methodHandler;
    }

}
