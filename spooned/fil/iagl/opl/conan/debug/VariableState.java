

package fil.iagl.opl.conan.debug;


public class VariableState {
    public int line;

    public java.lang.Object previousValue = null;

    public java.lang.Object nextValue = null;

    public java.lang.String binaryOperator;

    public java.lang.String iteration = "";

    public boolean reached = false;

    public java.lang.Object completeState;

    public VariableState(int line, java.lang.Object nextValue, java.lang.String iteration) {
        fil.iagl.opl.conan.debug.VariableState.this.line = line;
        if (nextValue instanceof java.util.ArrayList) {
            fil.iagl.opl.conan.debug.VariableState.this.nextValue = new java.util.ArrayList(((java.util.ArrayList) (nextValue)));
        }else
            if (nextValue instanceof java.util.HashMap) {
                fil.iagl.opl.conan.debug.VariableState.this.nextValue = new java.util.HashMap(((java.util.HashMap) (nextValue)));
            }else {
                fil.iagl.opl.conan.debug.VariableState.this.nextValue = nextValue;
            }
        
        fil.iagl.opl.conan.debug.VariableState.this.iteration = iteration;
    }

    public VariableState(int line, java.lang.Object previousValue, java.lang.Object nextValue, java.lang.String iteration) {
        fil.iagl.opl.conan.debug.VariableState.this.line = line;
        fil.iagl.opl.conan.debug.VariableState.this.previousValue = previousValue;
        if (nextValue instanceof java.util.ArrayList) {
            fil.iagl.opl.conan.debug.VariableState.this.nextValue = new java.util.ArrayList(((java.util.ArrayList) (nextValue)));
        }else
            if (nextValue instanceof java.util.HashMap) {
                fil.iagl.opl.conan.debug.VariableState.this.nextValue = new java.util.HashMap(((java.util.HashMap) (nextValue)));
            }else {
                fil.iagl.opl.conan.debug.VariableState.this.nextValue = nextValue;
            }
        
        fil.iagl.opl.conan.debug.VariableState.this.iteration = iteration;
    }

    public VariableState(int line, java.lang.Object previousValue, java.lang.Object nextValue, java.lang.String binaryOperator, java.lang.String iteration) {
        fil.iagl.opl.conan.debug.VariableState.this.line = line;
        fil.iagl.opl.conan.debug.VariableState.this.previousValue = previousValue;
        if (nextValue instanceof java.util.ArrayList) {
            fil.iagl.opl.conan.debug.VariableState.this.nextValue = new java.util.ArrayList(((java.util.ArrayList) (nextValue)));
        }else
            if (nextValue instanceof java.util.HashMap) {
                fil.iagl.opl.conan.debug.VariableState.this.nextValue = new java.util.HashMap(((java.util.HashMap) (nextValue)));
            }else {
                fil.iagl.opl.conan.debug.VariableState.this.nextValue = nextValue;
            }
        
        fil.iagl.opl.conan.debug.VariableState.this.binaryOperator = binaryOperator;
        fil.iagl.opl.conan.debug.VariableState.this.iteration = iteration;
    }
}

