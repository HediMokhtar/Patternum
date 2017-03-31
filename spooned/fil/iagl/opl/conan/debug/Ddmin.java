

package fil.iagl.opl.conan.debug;


public class Ddmin {
    private fil.iagl.opl.conan.model.Challenge challenge;

    private java.lang.Object input;

    public Ddmin(java.lang.Object input, fil.iagl.opl.conan.model.Challenge challenge) {
        fil.iagl.opl.conan.debug.Ddmin.this.input = input;
        fil.iagl.opl.conan.debug.Ddmin.this.challenge = challenge;
    }

    public java.util.List<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>> simplifyingDifferences(java.util.List<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>> diffsCombinations) {
        java.util.List<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>> smallestDiffs = new java.util.ArrayList<>();
        int smallestDiffsSize = java.lang.Integer.MAX_VALUE;
        java.util.Collections.sort(diffsCombinations, new java.util.Comparator<java.util.ArrayList>() {
            public int compare(java.util.ArrayList a1, java.util.ArrayList a2) {
                return (a2.size()) - (a1.size());
            }
        });
        java.util.Collections.reverse(diffsCombinations);
        for (java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement> diffs : diffsCombinations) {
            if ((diffs.size()) > smallestDiffsSize) {
                break;
            }else {
                java.lang.Boolean programFail = !(test(diffs));
                if (programFail) {
                    smallestDiffsSize = diffs.size();
                    smallestDiffs.add(diffs);
                }
            }
        }
        return smallestDiffs;
    }

    public void execDifferences(java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffs) {
        fil.iagl.opl.conan.debug.DebugAssistant.capturedVariablesToReplaceValues = new java.util.LinkedHashMap<>();
        for (fil.iagl.opl.conan.debug.DebugChainElement diff : diffs) {
            fil.iagl.opl.conan.debug.CatchedVariable diffToApply = new fil.iagl.opl.conan.debug.CatchedVariable(diff.line, diff.value, diff.variableName, diff.iteration);
            fil.iagl.opl.conan.debug.DebugAssistant.capturedVariablesToReplaceValues.put(diff.variableName, diffToApply);
        }
    }

    public java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> process(java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffs) {
        java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> causes = new java.util.ArrayList<>();
        if (diffs.isEmpty())
            return causes;
        
        java.util.List<java.util.List<fil.iagl.opl.conan.debug.DebugChainElement>> diffsByIterationList = new java.util.ArrayList<>();
        java.lang.String previousIteration = diffs.get(0).iteration;
        diffsByIterationList.add(new java.util.ArrayList<>());
        int i = 0;
        for (fil.iagl.opl.conan.debug.DebugChainElement diff : diffs) {
            java.lang.String iteration = diff.iteration;
            if (iteration.equals(previousIteration)) {
                diffsByIterationList.get(i).add(diff);
            }else {
                i++;
                previousIteration = iteration;
                java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffsForIt = new java.util.ArrayList<>();
                diffsForIt.add(diff);
                diffsByIterationList.add(diffsForIt);
            }
        }
        for (java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffsByIt : diffsByIterationList) {
            causes.addAll(subProcess(diffsByIt));
        }
        return causes;
    }

    public java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> subProcess(java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffs) {
        java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> causes = new java.util.ArrayList<>();
        java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffsToTest = new java.util.ArrayList<>(diffs);
        java.util.List<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>> powerSetOfDiffsToTest = fil.iagl.opl.conan.debug.Ddmin.powerset(diffsToTest);
        powerSetOfDiffsToTest.remove(0);
        java.util.List<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>> crashResponsibleDiffs = simplifyingDifferences(powerSetOfDiffsToTest);
        for (java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffsCrash : crashResponsibleDiffs) {
            for (fil.iagl.opl.conan.debug.DebugChainElement diff : diffsCrash) {
                if (!(causes.contains(diff))) {
                    causes.add(diff);
                }
            }
        }
        return causes;
    }

    public static java.util.List<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>> powerset(java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> list) {
        java.util.List<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>> ps = new java.util.ArrayList<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>>();
        ps.add(new java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>());
        for (fil.iagl.opl.conan.debug.DebugChainElement item : list) {
            java.util.List<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>> newPs = new java.util.ArrayList<java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>>();
            for (java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement> subset : ps) {
                newPs.add(subset);
                java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement> newSubset = new java.util.ArrayList<fil.iagl.opl.conan.debug.DebugChainElement>(subset);
                newSubset.add(item);
                newPs.add(newSubset);
            }
            ps = newPs;
        }
        return ps;
    }

    public java.lang.Boolean test(java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffs) {
        execDifferences(diffs);
        try {
            challenge.challenge(fil.iagl.opl.conan.debug.Ddmin.this.input);
            return true;
        } catch (java.lang.Exception | java.lang.AssertionError e) {
            return false;
        }
    }

    public java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> getDiffs(java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> goodChain, java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> badChain) {
        java.util.List<fil.iagl.opl.conan.debug.DebugChainElement> diffs = new java.util.ArrayList<>();
        for (fil.iagl.opl.conan.debug.DebugChainElement chainElement : badChain) {
            if (!(goodChain.contains(chainElement))) {
                diffs.add(chainElement);
            }
        }
        return diffs;
    }
}

