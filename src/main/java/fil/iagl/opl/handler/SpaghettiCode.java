package fil.iagl.opl.handler;

import fil.iagl.opl.spoon.Method;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpaghettiCode implements AntiPatternHandler{
    public List<DetectedAntiPattern> handle(List<CtClass<?>> ctClassList, List<Method> methodList) {

        Map<String,LinkedList<Method>> methodCallsMap = new HashMap<String, LinkedList<Method>>();
        LinkedList<DetectedAntiPattern> antiPatternFound = new LinkedList<DetectedAntiPattern>();

        //First we store each method in a hashmap which link the method to the method calls
        for(Method method: methodList){
            final String methodName = method.getCtClass().getSimpleName();

            methodCallsMap.put(methodName + " " + method.getCtMethod().getSimpleName(), new LinkedList<Method>());

        }

        for(Method method: methodList){
            final String methodName = method.getCtMethod().getSimpleName();
            for(Method methodMemo: methodList){
                try {
                    final List<CtStatement> methodBody = methodMemo.getCtMethod().getBody().getStatements();
                    for (CtStatement statement : methodBody) {
                        if (statement.toString().contains(methodName)) {
                           LinkedList<Method> methodCurrentList = methodCallsMap.get(methodMemo.getCtClass().getSimpleName() + " " + methodMemo.getCtMethod().getSimpleName());
                            if (!methodCurrentList.contains(methodMemo)) {
                                methodCurrentList.add(method);
                            }
                            methodCallsMap.put(methodMemo.getCtClass().getSimpleName() + " " + methodMemo.getCtMethod().getSimpleName(), methodCurrentList);
                        }
                    }
                }
                catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

        }

        for(Map.Entry<String,LinkedList<Method>> e : methodCallsMap.entrySet()){
            if(e.getValue().size() > 6){
                String[] splittedKey = e.getKey().split(" ");
                String className = splittedKey[0];
                String methodName = splittedKey[1];
                for(Method method: methodList){
                    if(method.getCtMethod().getSimpleName().equals(methodName) && method.getCtClass().getSimpleName().equals(className)){
                        antiPatternFound.add(new DetectedAntiPattern(method.getCtClass(),method.getCtMethod(),new SpaghettiCode()));
                    }
                }

            }
        }


        return antiPatternFound;
    }

    public void helper() {
        System.out.println("Go and check this out to learn how to counter a SpaghettiCode : " + "SpaghettiToPenne.html");
    }

    public String toString(){
        return "SpaghettiCode";
    }
}
