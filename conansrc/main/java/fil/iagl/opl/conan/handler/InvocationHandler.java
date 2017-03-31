package fil.iagl.opl.conan.handler;

import spoon.Launcher;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.ArrayList;
import java.util.List;

public class InvocationHandler implements ElementHandler {

    @Override
    public void handle(CtMethod method, Launcher launcher) {
        for (CtInvocation invocation : method.getElements(new TypeFilter<>(CtInvocation.class))) {
            final List<CtExpression> argsToReplace = new ArrayList<>();
            final String name = invocation.getExecutable().getSimpleName();
            if (!invocation.getArguments().isEmpty()) {
                for (Object arg : invocation.getArguments()) {
                    if (arg instanceof CtExpression) {
                        String addedCall = null;
                        final String targetName = invocation.getTarget().toString();
                        if (arg.toString().contains("\"")) {
                            addedCall = "fil.iagl.opl.conan.debug.DebugAssistant.captureArg(" + arg + ", "
                                    + invocation.getPosition().getLine() + "," + arg.toString() + ", \"" + name + "\", \"" + targetName + "\")";
                        } else {
                            addedCall = "fil.iagl.opl.conan.debug.DebugAssistant.captureArg(" + arg + ", "
                                    + invocation.getPosition().getLine() + ", \"" + arg + "\", \"" + name + "\", \"" + targetName + "\")";
                        }
                        // Apply it
                        final CtCodeSnippetExpression statementMethod = launcher.getFactory().Code().createCodeSnippetExpression(addedCall);
                        argsToReplace.add(statementMethod);
                    }
                }
                invocation.setArguments(argsToReplace);
            }
        }
    }
}
