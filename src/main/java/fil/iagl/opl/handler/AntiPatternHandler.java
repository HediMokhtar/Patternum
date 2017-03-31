package fil.iagl.opl.handler;


import fil.iagl.opl.spoon.Method;
import spoon.reflect.declaration.CtClass;

import java.util.LinkedList;
import java.util.List;

/**
 * This interface will be implemented by each AntiPattern, all of them can be called on a project
 * which is represented by CtClass and CtMethod created by the Spoon Process. An AntiPattern can handle a
 * project and also provide a helper which for now give tips to the user.
 */
public interface AntiPatternHandler {

    /**
     * Memory to keep the access to all the antiPattern already found for each Handler
     */
    List<DetectedAntiPattern> antiPatterns = new LinkedList<DetectedAntiPattern>();

    /**
     * The goal of that function is to detect an AntiPattern in a project
     * @param ctClassList All the classes of the project
     * @param ctMethodList All the methods of the project
     */
    List<DetectedAntiPattern> handle(List<CtClass<?>> ctClassList, List<Method> ctMethodList);

    /**
     * The goal of that function is to guide the user through the anti pattern resolving process
     */
     void helper();

}
