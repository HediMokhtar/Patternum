package fil.iagl.opl.handler;

import fil.iagl.opl.spoon.Method;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtParameter;

import java.util.List;

public class BooleanParameter implements AntiPatternHandler{

    public List<DetectedAntiPattern> handle(List<CtClass<?>> ctClassList, List<Method> methodList) {

        List<CtParameter<?>> parameters;

        for(Method method: methodList){

            parameters = method.getCtMethod().getParameters();

            for(CtParameter<?> parameter: parameters) {
                if (parameter.getSimpleName().equals("bool")) {
                    antiPatterns.add(new DetectedAntiPattern(method.getCtClass(),method.getCtMethod(),new BooleanParameter()));
                }
            }
        }
        return antiPatterns;
    }

    public void helper() {
        System.out.println("Go and check this out to learn how to counter a BooleanParameter : " + "BooleanParameterAreNotYourFriend.html");
    }

    public String toString(){
        return "BooleanParameter";
    }
}
