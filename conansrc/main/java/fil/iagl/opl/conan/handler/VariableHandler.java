package fil.iagl.opl.conan.handler;

import spoon.Launcher;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtForEach;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

public class VariableHandler implements ElementHandler {

    @Override
    public void handle(CtMethod method, Launcher launcher) {
        for (Object obj : method.getElements(new TypeFilter<>(CtLocalVariable.class))) {
            final CtLocalVariable variable = (CtLocalVariable) obj;
            if (!(variable.getParent() instanceof CtForEach)) {
                final String addedCall = "fil.iagl.opl.conan.debug.DebugAssistant.capture(" + variable.getAssignment() + ", "
                        + variable.getPosition().getLine() + ", \"" + variable.getSimpleName() + "\")";
                final CtCodeSnippetExpression statementMethod = launcher.getFactory().Code().createCodeSnippetExpression(addedCall);
                variable.setAssignment(statementMethod);
            } else {
                final String addedCapture = variable.getSimpleName() + " = fil.iagl.opl.conan.debug.DebugAssistant.capture(" + variable.getSimpleName() + ", "
                        + variable.getPosition().getLine() + ", \"" + variable.getSimpleName() + "\")";
                final CtCodeSnippetStatement statementMethod = launcher.getFactory().Code().createCodeSnippetStatement(addedCapture);
                variable.insertBefore(statementMethod);
            }
        }
    }
}
