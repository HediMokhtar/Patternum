package fil.iagl.opl.conan.handler;

import spoon.Launcher;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

public class VariableReadHandler implements ElementHandler {

    @Override
    public void handle(CtMethod method, Launcher launcher) {
        for (final Object o : method.getElements(new TypeFilter<>(CtVariableRead.class))) {
            final CtVariableRead variableRead = (CtVariableRead) o;
            final String addedCall = "fil.iagl.opl.conan.debug.DebugAssistant.readVar(" + variableRead + ", "
                    + variableRead.getPosition().getLine() + ", \"" + variableRead.toString() + "\")";
            final CtCodeSnippetExpression statementMethod = launcher.getFactory().Code().createCodeSnippetExpression(addedCall);
            variableRead.replace(statementMethod);
        }
    }

}
