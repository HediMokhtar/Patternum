

package fil.iagl.opl.conan.handler;


public class VariableHandler implements fil.iagl.opl.conan.handler.ElementHandler {
    @java.lang.Override
    public void handle(spoon.reflect.declaration.CtMethod method, spoon.Launcher launcher) {
        for (java.lang.Object obj : method.getElements(new spoon.reflect.visitor.filter.TypeFilter<>(spoon.reflect.code.CtLocalVariable.class))) {
            final spoon.reflect.code.CtLocalVariable variable = ((spoon.reflect.code.CtLocalVariable) (obj));
            if (!((variable.getParent()) instanceof spoon.reflect.code.CtForEach)) {
                final java.lang.String addedCall = ((((("fil.iagl.opl.conan.debug.DebugAssistant.capture(" + (variable.getAssignment())) + ", ") + (variable.getPosition().getLine())) + ", \"") + (variable.getSimpleName())) + "\")";
                final spoon.reflect.code.CtCodeSnippetExpression statementMethod = launcher.getFactory().Code().createCodeSnippetExpression(addedCall);
                variable.setAssignment(statementMethod);
            }else {
                final java.lang.String addedCapture = (((((((variable.getSimpleName()) + " = fil.iagl.opl.conan.debug.DebugAssistant.capture(") + (variable.getSimpleName())) + ", ") + (variable.getPosition().getLine())) + ", \"") + (variable.getSimpleName())) + "\")";
                final spoon.reflect.code.CtCodeSnippetStatement statementMethod = launcher.getFactory().Code().createCodeSnippetStatement(addedCapture);
                variable.insertBefore(statementMethod);
            }
        }
    }
}

