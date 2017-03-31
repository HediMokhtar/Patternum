package fil.iagl.opl.spoon;

import fil.iagl.opl.handler.AntiPatternHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * List used to contain all the anti-Pattern Handlers we want to use
 */
public class MethodHandler {

    private List<AntiPatternHandler> antiPatternHandlers;

    public MethodHandler() {antiPatternHandlers = new LinkedList<AntiPatternHandler>();}

    public List<AntiPatternHandler> getAntiPatternHandlers() {return this.antiPatternHandlers;}

    public void addElementHandler(AntiPatternHandler elementHandler) {
        antiPatternHandlers.add(elementHandler);
    }


}
