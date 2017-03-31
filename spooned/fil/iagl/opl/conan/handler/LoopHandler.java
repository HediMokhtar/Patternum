

package fil.iagl.opl.conan.handler;


public class LoopHandler implements fil.iagl.opl.conan.handler.ElementHandler {
    @java.lang.Override
    public void handle(spoon.reflect.declaration.CtMethod method, spoon.Launcher launcher) {
        for (java.lang.Object obj : method.getElements(new spoon.reflect.visitor.filter.TypeFilter<>(spoon.reflect.code.CtLoop.class))) {
            spoon.reflect.code.CtLoop loop = ((spoon.reflect.code.CtLoop) (obj));
            java.lang.String addIteration = ("fil.iagl.opl.conan.debug.DebugAssistant.iterate(" + (loop.getPosition().getLine())) + ")";
            final spoon.reflect.code.CtCodeSnippetStatement addIterationSnippet = launcher.getFactory().Code().createCodeSnippetStatement(addIteration);
            loop.getBody().insertBefore(addIterationSnippet);
            java.lang.String endIteration = "fil.iagl.opl.conan.debug.DebugAssistant.resetIteration()";
            final spoon.reflect.code.CtCodeSnippetStatement endIterationSnippet = launcher.getFactory().Code().createCodeSnippetStatement(endIteration);
            loop.insertAfter(endIterationSnippet);
        }
    }
}

