package fil.iagl.opl.conan.debug;


import fil.iagl.opl.conan.model.ChainElement;

public class DebugChainElement implements ChainElement {

    public Integer line;
    public String variableName;
    public String description;
    public Object value;
    public Object completeState;
    public String iteration;

    public DebugChainElement(int line, String variableName, Object value, String description, String iteration) {
        this.line = line;
        this.variableName = variableName;
        this.value = value;
        this.description = description;
        this.iteration = iteration;
    }

    @Override
    public String getLine() {
        return String.valueOf(this.line) + " " + iteration;
    }

    @Override
    public String getVariable() {
        return this.variableName;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean equals(Object o) {
		if(o instanceof DebugChainElement) {
			DebugChainElement elem = (DebugChainElement)o;
            Boolean valueIsNull = false;
            if(this.value == null || elem.value == null){
                valueIsNull = true;
            }
			if(this.variableName.equals(elem.variableName) && this.getLine().equals(elem.getLine())){
                if (!valueIsNull){
                    if (this.value.equals(elem.value)) return true;
                } else {
                    if(this.value == null && elem.value == null) return true;
                }

			}
		}
    	return false;
    }

	public String getIteration() {
		return iteration;
	}

}
