package fil.iagl.opl.conan.debug;

import java.util.ArrayList;
import java.util.HashMap;

public class VariableState {

    public int line;
    public Object previousValue = null;
    public Object nextValue = null;
    public String binaryOperator;
    public String iteration = "";
    public boolean reached = false;
    public Object completeState;

    public VariableState(int line, Object nextValue, String iteration){
        this.line = line;
        if(nextValue instanceof ArrayList){
            this.nextValue = new ArrayList<>((ArrayList) nextValue);
        } else if (nextValue instanceof HashMap) {
            this.nextValue = new HashMap((HashMap) nextValue);
        }else{
            this.nextValue = nextValue;
        }
        this.iteration = iteration;
    }

    public VariableState(int line, Object previousValue, Object nextValue, String iteration){
        this.line = line;
        this.previousValue = previousValue;
        if(nextValue instanceof ArrayList){
            this.nextValue = new ArrayList<>((ArrayList) nextValue);
        } else if (nextValue instanceof HashMap) {
            this.nextValue = new HashMap((HashMap) nextValue);
        }else{
            this.nextValue = nextValue;
        }
        this.iteration = iteration;
    }

    public VariableState(int line, Object previousValue, Object nextValue, String binaryOperator, String iteration){
        this.line = line;
        this.previousValue = previousValue;
        if(nextValue instanceof ArrayList){
            this.nextValue = new ArrayList<>((ArrayList) nextValue);
        } else if (nextValue instanceof HashMap) {
            this.nextValue = new HashMap((HashMap) nextValue);
        }else{
            this.nextValue = nextValue;
        }
        this.binaryOperator = binaryOperator;
        this.iteration = iteration;
    }

}
