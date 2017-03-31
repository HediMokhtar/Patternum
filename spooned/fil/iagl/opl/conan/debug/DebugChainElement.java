

package fil.iagl.opl.conan.debug;


public class DebugChainElement implements fil.iagl.opl.conan.model.ChainElement {
    public java.lang.Integer line;

    public java.lang.String variableName;

    public java.lang.String description;

    public java.lang.Object value;

    public java.lang.Object completeState;

    public java.lang.String iteration;

    public DebugChainElement(int line, java.lang.String variableName, java.lang.Object value, java.lang.String description, java.lang.String iteration) {
        fil.iagl.opl.conan.debug.DebugChainElement.this.line = line;
        fil.iagl.opl.conan.debug.DebugChainElement.this.variableName = variableName;
        fil.iagl.opl.conan.debug.DebugChainElement.this.value = value;
        fil.iagl.opl.conan.debug.DebugChainElement.this.description = description;
        fil.iagl.opl.conan.debug.DebugChainElement.this.iteration = iteration;
    }

    @java.lang.Override
    public java.lang.String getLine() {
        return ((java.lang.String.valueOf(fil.iagl.opl.conan.debug.DebugChainElement.this.line)) + " ") + (iteration);
    }

    @java.lang.Override
    public java.lang.String getVariable() {
        return fil.iagl.opl.conan.debug.DebugChainElement.this.variableName;
    }

    @java.lang.Override
    public java.lang.String getDescription() {
        return fil.iagl.opl.conan.debug.DebugChainElement.this.description;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (o instanceof fil.iagl.opl.conan.debug.DebugChainElement) {
            fil.iagl.opl.conan.debug.DebugChainElement elem = ((fil.iagl.opl.conan.debug.DebugChainElement) (o));
            java.lang.Boolean valueIsNull = false;
            if (((fil.iagl.opl.conan.debug.DebugChainElement.this.value) == null) || ((elem.value) == null)) {
                valueIsNull = true;
            }
            if ((fil.iagl.opl.conan.debug.DebugChainElement.this.variableName.equals(elem.variableName)) && (fil.iagl.opl.conan.debug.DebugChainElement.this.getLine().equals(elem.getLine()))) {
                if (!valueIsNull) {
                    if (fil.iagl.opl.conan.debug.DebugChainElement.this.value.equals(elem.value))
                        return true;
                    
                }else {
                    if (((fil.iagl.opl.conan.debug.DebugChainElement.this.value) == null) && ((elem.value) == null))
                        return true;
                    
                }
            }
        }
        return false;
    }

    public java.lang.String getIteration() {
        return iteration;
    }
}

