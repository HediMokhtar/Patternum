

package fil.iagl.opl.conan.handler;


public class UnaryOperatorHandler implements fil.iagl.opl.conan.handler.ElementHandler {
    @java.lang.Override
    public void handle(spoon.reflect.declaration.CtMethod method, spoon.Launcher launcher) {
        for (spoon.reflect.code.CtUnaryOperator unaryOp : method.getElements(new spoon.reflect.visitor.filter.TypeFilter<>(spoon.reflect.code.CtUnaryOperator.class))) {
            if ((unaryOp.getKind()) == (spoon.reflect.code.UnaryOperatorKind.NOT))
                continue;
            
            final java.lang.String addedCall = ((((("fil.iagl.opl.conan.debug.DebugAssistant.capture(" + (unaryOp.toString())) + ", ") + (unaryOp.getPosition().getLine())) + ", \"") + (unaryOp.getOperand())) + "\")";
            final spoon.reflect.code.CtCodeSnippetStatement statementMethod = launcher.getFactory().Code().createCodeSnippetStatement(addedCall);
            unaryOp.replace(statementMethod);
        }
    }
}

