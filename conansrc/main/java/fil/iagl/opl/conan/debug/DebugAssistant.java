package fil.iagl.opl.conan.debug;

import java.util.LinkedHashMap;
import java.util.Map;

public class DebugAssistant {

    public static LinkedHashMap<String, CatchedVariable> capturedVariables = new LinkedHashMap<>();
    public static LinkedHashMap<String, CatchedVariable> capturedVariablesToReplaceValues = new LinkedHashMap<>();
    public static boolean waitForNewValue = false;
    public static LinkedHashMap<Integer, Integer> iterations = new LinkedHashMap<>();

    public static boolean compareTwoState(VariableState state1, VariableState state2){
        if(state1.line != state2.line) return false;
        if(!(state1.iteration.equals(state2.iteration))) return false;
        return true;
    }

    public static void resetAll(){
        capturedVariables = new LinkedHashMap<>();
        capturedVariablesToReplaceValues = new LinkedHashMap<>();
        waitForNewValue = false;
        iterations = new LinkedHashMap<>();
    }

    public static <T> T capture(T inputVal, int line, String inputName){

    	if(capturedVariables.containsKey(inputName)){
            capturedVariables.get(inputName).addState(line, inputVal, buildIterationString());
        } else {
            capturedVariables.put(inputName, new CatchedVariable(line, inputVal, inputName, buildIterationString()));
        }
        return replaceValueIfExist(inputVal, capturedVariables.get(inputName), false);
    }

    public static <T> T capture(T inputVal, int line, String inputName, String binaryOperator){
        if(!binaryOperator.equals("=")){
            waitForNewValue = true;
        }
        if(capturedVariables.containsKey(inputName)){
            capturedVariables.get(inputName).addState(line, inputVal, binaryOperator, buildIterationString());
        } else {
            capturedVariables.put(inputName, new CatchedVariable(line, inputVal, inputName, buildIterationString()));
        }
        return replaceValueIfExist(inputVal, capturedVariables.get(inputName), false);
    }

    public static <T> T captureArg(T argVal, int line, String argName, String methodName, String variableCalledName){

        if(capturedVariables.containsKey(variableCalledName)){
            capturedVariables.get(variableCalledName).addState(line, argVal, buildIterationString());
        } else {
            capturedVariables.put(variableCalledName, new CatchedVariable(line, argVal, variableCalledName, buildIterationString()));
        }
        String description = " has run the method : " + methodName + " --> args : (name = " + argName + " || value = " + argVal + ")";
        capturedVariables.get(variableCalledName).updateLastDescription(description);

        return replaceValueIfExist(argVal, capturedVariables.get(variableCalledName), false);
    }


    public static void captureNewVal(Object inputVal, String inputName ){
        capturedVariables.get(inputName).updateLastCompleteStateValue(inputVal);
        waitForNewValue = false;
    }

    public static void iterate(int line){
        if(iterations.containsKey(line)){
           iterations.replace(line, iterations.get(line)+1);
        } else {
            iterations.put(line, 1);
        }
    }

    public static void resetIteration(){
        int last = iterations.size() - 1;
        int i = 0;
        Integer toRemove = null;
        for (Map.Entry<Integer, Integer> entry : iterations.entrySet()) {
            if(i == last) toRemove = entry.getKey();
            i++;
        }
        iterations.remove(toRemove);
    }

    public static String buildIterationString(){
        String iteration = "iteration n° ";
        for (Map.Entry<Integer, Integer> entry : iterations.entrySet()) {
            Integer value = entry.getValue();
            iteration += value.toString();
        }
        if(iterations.isEmpty()){
            iteration += "1";
        }
        iteration += "";
        return iteration;
    }

    public static <T> T replaceValueIfExist(T input, CatchedVariable inputCatchedVariable, boolean isReading){
        if(!capturedVariablesToReplaceValues.containsKey(inputCatchedVariable.name)) return input;

        CatchedVariable replacementVar = capturedVariablesToReplaceValues.get(inputCatchedVariable.name);
        VariableState lastState = inputCatchedVariable.states.get(inputCatchedVariable.states.size() - 1);

        String it1 = lastState.iteration;
        for(VariableState replacementState : replacementVar.states){
            if(compareTwoState(lastState, replacementState)){
                replacementState.reached = true;
                return (T)replacementState.nextValue;
            } else {
                String it2 = replacementState.iteration;
                if(iterationIsBigger(it1, it2) && replacementState.reached == false){
                    if(isReading == false) replacementState.reached = true;
                    return (T)replacementState.nextValue;
                }
            }
        }

        return input;
    }


    public static <T> T readVar(T inputVal, int line, String inputName){
        CatchedVariable c = new CatchedVariable(line, inputVal, inputName, inputVal.getClass(), buildIterationString(), true);
        return replaceValueIfExist(inputVal, c, true);
    }

    public static Boolean iterationIsBigger(String it1, String it2) {
        it1 = it1.substring(11, it1.length()-2);
        it2 = it2.substring(11, it2.length()-2);
        String[] it1A = it1.split("\\s");
        String[] it2A = it2.split("\\s");
        for (int i = 0; i < it1A.length; i++) {
            int it1I = Integer.valueOf(it1A[i]);
            int it2I = Integer.valueOf(it2A[i]);
            if (it1I > it2I) {
                return true;
            } else if (it1I < it2I) {
                return false;
            }
        }
        return false;
    }
}
