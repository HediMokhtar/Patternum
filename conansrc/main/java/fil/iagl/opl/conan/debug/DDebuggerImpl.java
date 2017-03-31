package fil.iagl.opl.conan.debug;


import fil.iagl.opl.conan.model.Challenge;
import fil.iagl.opl.conan.model.DDebugger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class DDebuggerImpl implements DDebugger<String> {

    public static DebugCauseEffectChain runtimeCauseEffectChain = new DebugCauseEffectChain();

    public Object workingInput;
    public DebugCauseEffectChain workingChain = new DebugCauseEffectChain();
    public DebugCauseEffectChain failureChain = new DebugCauseEffectChain();

    public DebugCauseEffectChain debug(Challenge modifiedChallenge) {
        final List<Map<String, CatchedVariable>> listMapCapturedVar = new ArrayList<>();
        for (Object input: modifiedChallenge.getInputs()){
            System.out.print("Input : " + input + " : ");
            try{
                modifiedChallenge.challenge(input);
                System.out.println("--> PASS");
                listMapCapturedVar.add(DebugAssistant.capturedVariables);
                workingInput = input;

                workingChain.ourCauseEffectChain = new ArrayList<>(runtimeCauseEffectChain.ourCauseEffectChain);

            } catch (AssertionError| Exception e){
                System.out.println("--> FAIL");
                listMapCapturedVar.add(DebugAssistant.capturedVariables);

                failureChain.ourCauseEffectChain = new ArrayList<>(runtimeCauseEffectChain.ourCauseEffectChain);

            }
            DebugAssistant.capturedVariables = new LinkedHashMap<>();
            runtimeCauseEffectChain.ourCauseEffectChain = new ArrayList<>();

        }

        Ddmin ddmin = new Ddmin(workingInput, modifiedChallenge);
        List<DebugChainElement> diffs = ddmin.getDiffs(workingChain.getDebugChain(), failureChain.getDebugChain());
        System.out.println("\n-------> CAUSE EFFECT CHAIN");
        List<DebugChainElement> causeEffectChain =  ddmin.process(diffs);
        for(DebugChainElement chainElement : causeEffectChain){
            System.out.println("## Line " + chainElement.getLine() + " for variable from " + chainElement.getVariable() + " which" + chainElement.getDescription().replaceAll("\n", "\\\\n"));
        }
        System.out.println("Then the program failed.");

        return null;
    }

}
