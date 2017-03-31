

package fil.iagl.opl.conan.handler;


public class VariableReadHandler implements fil.iagl.opl.conan.handler.ElementHandler {
    @java.lang.Override
    public void handle(spoon.reflect.declaration.CtMethod method, spoon.Launcher launcher) {
        for (final java.lang.Object o : method.getElements(new spoon.reflect.visitor.filter.TypeFilter<>(spoon.reflect.code.CtVariableRead.class))) {
            final spoon.reflect.code.CtVariableRead variableRead = ((spoon.reflect.code.CtVariableRead) (o));
            final java.lang.String addedCall = ((((("fil.iagl.opl.conan.debug.DebugAssistant.readVar(" + variableRead) + ", ") + (variableRead.getPosition().getLine())) + ", \"") + (variableRead.toString())) + "\")";
            final spoon.reflect.code.CtCodeSnippetExpression statementMethod = launcher.getFactory().Code().createCodeSnippetExpression(addedCall);
            variableRead.replace(statementMethod);
        }
    }
}

