

package fil.iagl.opl.conan.handler;


public class InvocationHandler implements fil.iagl.opl.conan.handler.ElementHandler {
    @java.lang.Override
    public void handle(spoon.reflect.declaration.CtMethod method, spoon.Launcher launcher) {
        for (spoon.reflect.code.CtInvocation invocation : method.getElements(new spoon.reflect.visitor.filter.TypeFilter<>(spoon.reflect.code.CtInvocation.class))) {
            final java.util.List<spoon.reflect.code.CtExpression> argsToReplace = new java.util.ArrayList<>();
            final java.lang.String name = invocation.getExecutable().getSimpleName();
            if (!(invocation.getArguments().isEmpty())) {
                for (java.lang.Object arg : invocation.getArguments()) {
                    if (arg instanceof spoon.reflect.code.CtExpression) {
                        java.lang.String addedCall = null;
                        final java.lang.String targetName = invocation.getTarget().toString();
                        if (arg.toString().contains("\"")) {
                            addedCall = ((((((((("fil.iagl.opl.conan.debug.DebugAssistant.captureArg(" + arg) + ", ") + (invocation.getPosition().getLine())) + ",") + (arg.toString())) + ", \"") + name) + "\", \"") + targetName) + "\")";
                        }else {
                            addedCall = ((((((((("fil.iagl.opl.conan.debug.DebugAssistant.captureArg(" + arg) + ", ") + (invocation.getPosition().getLine())) + ", \"") + arg) + "\", \"") + name) + "\", \"") + targetName) + "\")";
                        }
                        final spoon.reflect.code.CtCodeSnippetExpression statementMethod = launcher.getFactory().Code().createCodeSnippetExpression(addedCall);
                        argsToReplace.add(statementMethod);
                    }
                }
                invocation.setArguments(argsToReplace);
            }
        }
    }
}

