package fil.iagl.opl.conan.debug;

import java.util.*;

public class CatchedVariable {

	public String name;
	public Object previousValue;
	public Boolean transformChainElement = false;
	public List<VariableState> states = new ArrayList<>();

	public CatchedVariable(int line, Object val, String name, String iteration) {
		this.name = name;
		this.previousValue = val;
		VariableState variableState = new VariableState(line, val, iteration);
		addState(variableState);
	}

	public CatchedVariable(int line, Object val, String name, Class varClass, String iteration, Boolean transformChainElement) {
		this.name = name;
		this.previousValue = val;
		VariableState variableState = new VariableState(line, val, iteration);
		this.transformChainElement = transformChainElement;
		addState(variableState);
	}

	public void addState(int line, Object newVal, String iteration){
		VariableState variableState = new VariableState(line, this.previousValue, newVal, iteration);
		addState(variableState);
	}

	public void addState(int line, Object newVal, String binaryOperator, String iteration){
		VariableState variableState = new VariableState(line, this.previousValue, newVal, binaryOperator, iteration);
		addState(variableState);
	}

	private void addState(VariableState variableState){
		states.add(variableState);
		if(!transformChainElement) {
			DebugChainElement debugChainElement = buildChainElement(variableState);
			DDebuggerImpl.runtimeCauseEffectChain.add(debugChainElement);
		}
	}

	protected DebugChainElement buildChainElement(VariableState state){
		int line = state.line;
		String description = "";
		Object stateNewVal = state.nextValue;
		String stateNewValStr = "";
		if(stateNewVal instanceof String[]){
			stateNewValStr = Arrays.toString((String[])stateNewVal);
		} else {
			stateNewValStr = stateNewVal.toString();
		}
		if(state.nextValue == null){
			stateNewVal = new String("null");
		}
		if(state.previousValue == null){
			description += " was initialized to " + stateNewValStr;
		} else {
			description += " values " + stateNewValStr;
		}
		return new DebugChainElement(line, name, state.nextValue, description, state.iteration);
	}

	public void updateLastCompleteStateValue(Object completeState){
		states.get(states.size() - 1).completeState = completeState;
		String stateNewValStr = "";
		if(completeState instanceof String[]){
			stateNewValStr = Arrays.toString((String[])completeState);
		} else {
			stateNewValStr = completeState.toString();
		}
		String description = " values " + stateNewValStr;
		DDebuggerImpl.runtimeCauseEffectChain.updateLastCompleteStateValue(completeState, description);
	}

	public void updateLastDescription(String description){
		DDebuggerImpl.runtimeCauseEffectChain.updateLastDescription(description);
	}

	@Override
	public int hashCode(){
		return name.hashCode();
	}

	@Override
	public boolean equals(Object other){
		if(other instanceof CatchedVariable){
			return this.name.equals(((CatchedVariable) other).name);
		} else {
			return false;
		}
	}

}
