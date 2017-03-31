

package fil.iagl.opl.conan.debug;


public class CatchedVariable {
    public java.lang.String name;

    public java.lang.Object previousValue;

    public java.lang.Boolean transformChainElement = false;

    public java.util.List<fil.iagl.opl.conan.debug.VariableState> states = new java.util.ArrayList<>();

    public CatchedVariable(int line, java.lang.Object val, java.lang.String name, java.lang.String iteration) {
        fil.iagl.opl.conan.debug.CatchedVariable.this.name = name;
        fil.iagl.opl.conan.debug.CatchedVariable.this.previousValue = val;
        fil.iagl.opl.conan.debug.VariableState variableState = new fil.iagl.opl.conan.debug.VariableState(line, val, iteration);
        addState(variableState);
    }

    public CatchedVariable(int line, java.lang.Object val, java.lang.String name, java.lang.Class varClass, java.lang.String iteration, java.lang.Boolean transformChainElement) {
        fil.iagl.opl.conan.debug.CatchedVariable.this.name = name;
        fil.iagl.opl.conan.debug.CatchedVariable.this.previousValue = val;
        fil.iagl.opl.conan.debug.VariableState variableState = new fil.iagl.opl.conan.debug.VariableState(line, val, iteration);
        fil.iagl.opl.conan.debug.CatchedVariable.this.transformChainElement = transformChainElement;
        addState(variableState);
    }

    public void addState(int line, java.lang.Object newVal, java.lang.String iteration) {
        fil.iagl.opl.conan.debug.VariableState variableState = new fil.iagl.opl.conan.debug.VariableState(line, fil.iagl.opl.conan.debug.CatchedVariable.this.previousValue, newVal, iteration);
        addState(variableState);
    }

    public void addState(int line, java.lang.Object newVal, java.lang.String binaryOperator, java.lang.String iteration) {
        fil.iagl.opl.conan.debug.VariableState variableState = new fil.iagl.opl.conan.debug.VariableState(line, fil.iagl.opl.conan.debug.CatchedVariable.this.previousValue, newVal, binaryOperator, iteration);
        addState(variableState);
    }

    private void addState(fil.iagl.opl.conan.debug.VariableState variableState) {
        states.add(variableState);
        if (!(transformChainElement)) {
            fil.iagl.opl.conan.debug.DebugChainElement debugChainElement = buildChainElement(variableState);
            fil.iagl.opl.conan.debug.DDebuggerImpl.runtimeCauseEffectChain.add(debugChainElement);
        }
    }

    protected fil.iagl.opl.conan.debug.DebugChainElement buildChainElement(fil.iagl.opl.conan.debug.VariableState state) {
        int line = state.line;
        java.lang.String description = "";
        java.lang.Object stateNewVal = state.nextValue;
        java.lang.String stateNewValStr = "";
        if (stateNewVal instanceof java.lang.String[]) {
            stateNewValStr = java.util.Arrays.toString(((java.lang.String[]) (stateNewVal)));
        }else {
            stateNewValStr = stateNewVal.toString();
        }
        if ((state.nextValue) == null) {
            stateNewVal = new java.lang.String("null");
        }
        if ((state.previousValue) == null) {
            description += " was initialized to " + stateNewValStr;
        }else {
            description += " values " + stateNewValStr;
        }
        return new fil.iagl.opl.conan.debug.DebugChainElement(line, name, state.nextValue, description, state.iteration);
    }

    public void updateLastCompleteStateValue(java.lang.Object completeState) {
        states.get(((states.size()) - 1)).completeState = completeState;
        java.lang.String stateNewValStr = "";
        if (completeState instanceof java.lang.String[]) {
            stateNewValStr = java.util.Arrays.toString(((java.lang.String[]) (completeState)));
        }else {
            stateNewValStr = completeState.toString();
        }
        java.lang.String description = " values " + stateNewValStr;
        fil.iagl.opl.conan.debug.DDebuggerImpl.runtimeCauseEffectChain.updateLastCompleteStateValue(completeState, description);
    }

    public void updateLastDescription(java.lang.String description) {
        fil.iagl.opl.conan.debug.DDebuggerImpl.runtimeCauseEffectChain.updateLastDescription(description);
    }

    @java.lang.Override
    public int hashCode() {
        return name.hashCode();
    }

    @java.lang.Override
    public boolean equals(java.lang.Object other) {
        if (other instanceof fil.iagl.opl.conan.debug.CatchedVariable) {
            return fil.iagl.opl.conan.debug.CatchedVariable.this.name.equals(((fil.iagl.opl.conan.debug.CatchedVariable) (other)).name);
        }else {
            return false;
        }
    }
}

