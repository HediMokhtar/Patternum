

package fil.iagl.opl.conan.debug;


public class DebugAssistant {
    public static java.util.LinkedHashMap<java.lang.String, fil.iagl.opl.conan.debug.CatchedVariable> capturedVariables = new java.util.LinkedHashMap<>();

    public static java.util.LinkedHashMap<java.lang.String, fil.iagl.opl.conan.debug.CatchedVariable> capturedVariablesToReplaceValues = new java.util.LinkedHashMap<>();

    public static boolean waitForNewValue = false;

    public static java.util.LinkedHashMap<java.lang.Integer, java.lang.Integer> iterations = new java.util.LinkedHashMap<>();

    public static boolean compareTwoState(fil.iagl.opl.conan.debug.VariableState state1, fil.iagl.opl.conan.debug.VariableState state2) {
        if ((state1.line) != (state2.line))
            return false;
        
        if (!(state1.iteration.equals(state2.iteration)))
            return false;
        
        return true;
    }

    public static void resetAll() {
        fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables = new java.util.LinkedHashMap<>();
        fil.iagl.opl.conan.debug.DebugAssistant.capturedVariablesToReplaceValues = new java.util.LinkedHashMap<>();
        fil.iagl.opl.conan.debug.DebugAssistant.waitForNewValue = false;
        fil.iagl.opl.conan.debug.DebugAssistant.iterations = new java.util.LinkedHashMap<>();
    }

    public static <T> T capture(T inputVal, int line, java.lang.String inputName) {
        if (fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.containsKey(inputName)) {
            fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.get(inputName).addState(line, inputVal, fil.iagl.opl.conan.debug.DebugAssistant.buildIterationString());
        }else {
            fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.put(inputName, new fil.iagl.opl.conan.debug.CatchedVariable(line, inputVal, inputName, fil.iagl.opl.conan.debug.DebugAssistant.buildIterationString()));
        }
        return fil.iagl.opl.conan.debug.DebugAssistant.replaceValueIfExist(inputVal, fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.get(inputName), false);
    }

    public static <T> T capture(T inputVal, int line, java.lang.String inputName, java.lang.String binaryOperator) {
        if (!(binaryOperator.equals("="))) {
            fil.iagl.opl.conan.debug.DebugAssistant.waitForNewValue = true;
        }
        if (fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.containsKey(inputName)) {
            fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.get(inputName).addState(line, inputVal, binaryOperator, fil.iagl.opl.conan.debug.DebugAssistant.buildIterationString());
        }else {
            fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.put(inputName, new fil.iagl.opl.conan.debug.CatchedVariable(line, inputVal, inputName, fil.iagl.opl.conan.debug.DebugAssistant.buildIterationString()));
        }
        return fil.iagl.opl.conan.debug.DebugAssistant.replaceValueIfExist(inputVal, fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.get(inputName), false);
    }

    public static <T> T captureArg(T argVal, int line, java.lang.String argName, java.lang.String methodName, java.lang.String variableCalledName) {
        if (fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.containsKey(variableCalledName)) {
            fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.get(variableCalledName).addState(line, argVal, fil.iagl.opl.conan.debug.DebugAssistant.buildIterationString());
        }else {
            fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.put(variableCalledName, new fil.iagl.opl.conan.debug.CatchedVariable(line, argVal, variableCalledName, fil.iagl.opl.conan.debug.DebugAssistant.buildIterationString()));
        }
        java.lang.String description = (((((" has run the method : " + methodName) + " --> args : (name = ") + argName) + " || value = ") + argVal) + ")";
        fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.get(variableCalledName).updateLastDescription(description);
        return fil.iagl.opl.conan.debug.DebugAssistant.replaceValueIfExist(argVal, fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.get(variableCalledName), false);
    }

    public static void captureNewVal(java.lang.Object inputVal, java.lang.String inputName) {
        fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables.get(inputName).updateLastCompleteStateValue(inputVal);
        fil.iagl.opl.conan.debug.DebugAssistant.waitForNewValue = false;
    }

    public static void iterate(int line) {
        if (fil.iagl.opl.conan.debug.DebugAssistant.iterations.containsKey(line)) {
            fil.iagl.opl.conan.debug.DebugAssistant.iterations.replace(line, ((fil.iagl.opl.conan.debug.DebugAssistant.iterations.get(line)) + 1));
        }else {
            fil.iagl.opl.conan.debug.DebugAssistant.iterations.put(line, 1);
        }
    }

    public static void resetIteration() {
        int last = (fil.iagl.opl.conan.debug.DebugAssistant.iterations.size()) - 1;
        int i = 0;
        java.lang.Integer toRemove = null;
        for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry : fil.iagl.opl.conan.debug.DebugAssistant.iterations.entrySet()) {
            if (i == last)
                toRemove = entry.getKey();
            
            i++;
        }
        fil.iagl.opl.conan.debug.DebugAssistant.iterations.remove(toRemove);
    }

    public static java.lang.String buildIterationString() {
        java.lang.String iteration = "iteration n° ";
        for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry : fil.iagl.opl.conan.debug.DebugAssistant.iterations.entrySet()) {
            java.lang.Integer value = entry.getValue();
            iteration += value.toString();
        }
        if (fil.iagl.opl.conan.debug.DebugAssistant.iterations.isEmpty()) {
            iteration += "1";
        }
        iteration += "";
        return iteration;
    }

    public static <T> T replaceValueIfExist(T input, fil.iagl.opl.conan.debug.CatchedVariable inputCatchedVariable, boolean isReading) {
        if (!(fil.iagl.opl.conan.debug.DebugAssistant.capturedVariablesToReplaceValues.containsKey(inputCatchedVariable.name)))
            return input;
        
        fil.iagl.opl.conan.debug.CatchedVariable replacementVar = fil.iagl.opl.conan.debug.DebugAssistant.capturedVariablesToReplaceValues.get(inputCatchedVariable.name);
        fil.iagl.opl.conan.debug.VariableState lastState = inputCatchedVariable.states.get(((inputCatchedVariable.states.size()) - 1));
        java.lang.String it1 = lastState.iteration;
        for (fil.iagl.opl.conan.debug.VariableState replacementState : replacementVar.states) {
            if (fil.iagl.opl.conan.debug.DebugAssistant.compareTwoState(lastState, replacementState)) {
                replacementState.reached = true;
                return ((T) (replacementState.nextValue));
            }else {
                java.lang.String it2 = replacementState.iteration;
                if ((fil.iagl.opl.conan.debug.DebugAssistant.iterationIsBigger(it1, it2)) && ((replacementState.reached) == false)) {
                    if (isReading == false)
                        replacementState.reached = true;
                    
                    return ((T) (replacementState.nextValue));
                }
            }
        }
        return input;
    }

    public static <T> T readVar(T inputVal, int line, java.lang.String inputName) {
        fil.iagl.opl.conan.debug.CatchedVariable c = new fil.iagl.opl.conan.debug.CatchedVariable(line, inputVal, inputName, inputVal.getClass(), fil.iagl.opl.conan.debug.DebugAssistant.buildIterationString(), true);
        return fil.iagl.opl.conan.debug.DebugAssistant.replaceValueIfExist(inputVal, c, true);
    }

    public static java.lang.Boolean iterationIsBigger(java.lang.String it1, java.lang.String it2) {
        it1 = it1.substring(11, ((it1.length()) - 2));
        it2 = it2.substring(11, ((it2.length()) - 2));
        java.lang.String[] it1A = it1.split("\\s");
        java.lang.String[] it2A = it2.split("\\s");
        for (int i = 0; i < (it1A.length); i++) {
            int it1I = java.lang.Integer.valueOf(it1A[i]);
            int it2I = java.lang.Integer.valueOf(it2A[i]);
            if (it1I > it2I) {
                return true;
            }else
                if (it1I < it2I) {
                    return false;
                }
            
        }
        return false;
    }
}

