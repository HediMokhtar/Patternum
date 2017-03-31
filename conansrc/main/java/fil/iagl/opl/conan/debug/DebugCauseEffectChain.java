package fil.iagl.opl.conan.debug;


import fil.iagl.opl.conan.model.CauseEffectChain;
import fil.iagl.opl.conan.model.ChainElement;

import java.util.ArrayList;
import java.util.List;

public class DebugCauseEffectChain implements CauseEffectChain {

    public List<DebugChainElement> ourCauseEffectChain = new ArrayList<DebugChainElement>();

    public List<ChainElement> getChain() {

        List<ChainElement> chainElementList = new ArrayList<ChainElement>();
        chainElementList.addAll(ourCauseEffectChain);

        return chainElementList;
    }

    public void updateLastDescription(String description){
        ourCauseEffectChain.get(ourCauseEffectChain.size() - 1).description = description;
    }

    public void add(DebugChainElement chainElement){
        ourCauseEffectChain.add(chainElement);
    }

    public void updateLastCompleteStateValue(Object value, String description){
        ourCauseEffectChain.get(ourCauseEffectChain.size() - 1).completeState = value;
        ourCauseEffectChain.get(ourCauseEffectChain.size() - 1).description = description;
    }

    public List<DebugChainElement> getDebugChain(){
        return ourCauseEffectChain;
    }

    public void addChainList(List<DebugChainElement> chainElementList){
        ourCauseEffectChain.addAll(chainElementList);
    }
}
