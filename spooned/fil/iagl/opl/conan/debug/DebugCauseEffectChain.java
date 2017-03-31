

package fil.iagl.opl.conan.debug;


public class DebugCauseEffectChain implements fil.iagl.opl.conan.model.CauseEffectChain {
    public java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> ourCauseEffectChain = new java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>();

    public java.util.List<fil.iagl.opl.conan.model.ChainElement> getChain() {
        java.util.List<fil.iagl.opl.conan.model.ChainElement> chainElementList = new java.util.ArrayList<fil.iagl.opl.conan.model.ChainElement>();
        chainElementList.addAll(ourCauseEffectChain);
        return chainElementList;
    }

    public void updateLastDescription(java.lang.String description) {
        ourCauseEffectChain.get(((ourCauseEffectChain.size()) - 1)).description = description;
    }

    public void add(fil.iagl.opl.conan.debug.DebugChainElement chainElement) {
        ourCauseEffectChain.add(chainElement);
    }

    public void updateLastCompleteStateValue(java.lang.Object value, java.lang.String description) {
        ourCauseEffectChain.get(((ourCauseEffectChain.size()) - 1)).completeState = value;
        ourCauseEffectChain.get(((ourCauseEffectChain.size()) - 1)).description = description;
    }

    public java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> getDebugChain() {
        return ourCauseEffectChain;
    }

    public void addChainList(java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> chainElementList) {
        ourCauseEffectChain.addAll(chainElementList);
    }
}

