

package fil.iagl.opl.conan.debug;


public class DDebuggerImpl implements fil.iagl.opl.conan.model.DDebugger<java.lang.String> {
    public static fil.iagl.opl.conan.debug.DebugCauseEffectChain runtimeCauseEffectChain = new fil.iagl.opl.conan.debug.DebugCauseEffectChain();

    public java.lang.Object workingInput;

    public fil.iagl.opl.conan.debug.DebugCauseEffectChain workingChain = new fil.iagl.opl.conan.debug.DebugCauseEffectChain();

    public fil.iagl.opl.conan.debug.DebugCauseEffectChain failureChain = new fil.iagl.opl.conan.debug.DebugCauseEffectChain();

    public fil.iagl.opl.conan.debug.DebugCauseEffectChain debug(fil.iagl.opl.conan.model.Challenge modifiedChallenge) {
        final java.util.List<java.util.Map<java.lang.String, fil.iagl.opl.conan.debug.CatchedVariable>> listMapCapturedVar = new java.util.ArrayList<>();
        for (java.lang.Object input : modifiedChallenge.getInputs()) {
            java.lang.System.out.print((("Input : " + input) + " : "));
            try {
                modifiedChallenge.challenge(input);
                java.lang.System.out.println("--> PASS");
                listMapCapturedVar.add(fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables);
                workingInput = input;
                workingChain.ourCauseEffectChain = new java.util.ArrayList<>(fil.iagl.opl.conan.debug.DDebuggerImpl.runtimeCauseEffectChain.ourCauseEffectChain);
            } catch (java.lang.AssertionError | java.lang.Exception e) {
                java.lang.System.out.println("--> FAIL");
                listMapCapturedVar.add(fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables);
                failureChain.ourCauseEffectChain = new java.util.ArrayList<>(fil.iagl.opl.conan.debug.DDebuggerImpl.runtimeCauseEffectChain.ourCauseEffectChain);
            }
            fil.iagl.opl.conan.debug.DebugAssistant.capturedVariables = new java.util.LinkedHashMap<>();
            fil.iagl.opl.conan.debug.DDebuggerImpl.runtimeCauseEffectChain.ourCauseEffectChain = new java.util.ArrayList<>();
        }
        fil.iagl.opl.conan.debug.Ddmin ddmin = new fil.iagl.opl.conan.debug.Ddmin(workingInput, modifiedChallenge);
        java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffs = ddmin.getDiffs(workingChain.getDebugChain(), failureChain.getDebugChain());
        java.lang.System.out.println("\n-------> CAUSE EFFECT CHAIN");
        java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> causeEffectChain = ddmin.process(diffs);
        for (fil.iagl.opl.conan.debug.DebugChainElement chainElement : causeEffectChain) {
            java.lang.System.out.println(((((("## Line " + (chainElement.getLine())) + " for variable from ") + (chainElement.getVariable())) + " which") + (chainElement.getDescription().replaceAll("\n", "\\\\n"))));
        }
        java.lang.System.out.println("Then the program failed.");
        return null;
    }
}

