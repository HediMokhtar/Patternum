package fil.iagl.opl.spoon;

import java.util.LinkedList;
import java.util.List;

import fil.iagl.opl.handler.*;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;

/**
 * Spoon process
 * Two main interest : First keep a fast access to the spooned elements in memory and call spoon the less time as possible
 * Second it contain all the data we need to launch our anti-pattern handlers
 */
public class ClassProcessor extends AbstractProcessor<CtClass<?>> {

    private static ClassListing ctClassList = new ClassListing();
    private static List<CtClass<?>> classList = new LinkedList<CtClass<?>>();

    @Override
    public boolean isToBeProcessed(CtClass<?> candidate) {
        ctClassList.addClass(candidate);
        return true;
    }

    public static ClassListing getCtClassList() {
        return ctClassList;
    }

    public void process(CtClass<?> arg0) {
        classList.add(arg0);
    }


    public static List<DetectedAntiPattern> analyzeOn(AntiPatternHandler antiPatternHandler){
        return antiPatternHandler.handle(ctClassList.getCtClasses(), ctClassList.getAllMethods());
    }

    public static List<DetectedAntiPattern> analyse() {
        MethodHandler antiPatternHandlers = HandlerBuilder.buildMethodHandler();

        List<DetectedAntiPattern> allDetectedPatterns = new LinkedList<DetectedAntiPattern>();

        for(AntiPatternHandler antiPatternHandler : antiPatternHandlers.getAntiPatternHandlers()){
           final  List<DetectedAntiPattern> handlerDetectedPattern =  analyzeOn(antiPatternHandler);
           allDetectedPatterns.addAll(handlerDetectedPattern);
        }
        return allDetectedPatterns;
    }

    public static void analyseDisplayer(List<DetectedAntiPattern> antiPatterns){
        for(DetectedAntiPattern antiPattern : antiPatterns){
            System.out.println(antiPattern.toString() );
        }
    }

}
