package fil.iagl.opl.handler;

import fil.iagl.opl.spoon.Method;
import spoon.reflect.declaration.CtClass;

import java.util.List;

public class TooManyParameters implements AntiPatternHandler{

    public List<DetectedAntiPattern> handle(List<CtClass<?>> ctClassList, List<Method> methodList) {

            for(Method method: methodList){
                if(method.getCtMethod().getParameters().size() > 3){
                    antiPatterns.add(new DetectedAntiPattern(method.getCtClass(),method.getCtMethod(), new TooManyParameters()));
                }
            }
            return antiPatterns;
    }

    public void helper() {
        System.out.println("Go and check this out to learn how to counter TooManyParameters : " + "SplitYourParameters.html");
    }

    public String toString(){
        return "TooManyParameters";
    }
}
