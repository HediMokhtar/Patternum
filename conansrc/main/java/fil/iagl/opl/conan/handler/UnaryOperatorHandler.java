package fil.iagl.opl.conan.handler;

import spoon.Launcher;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

public class UnaryOperatorHandler implements ElementHandler {

    @Override
    public void handle(CtMethod method, Launcher launcher) {
        for (CtUnaryOperator unaryOp : method.getElements(new TypeFilter<>(CtUnaryOperator.class))) {
            if(unaryOp.getKind() == UnaryOperatorKind.NOT) continue;
            final String addedCall = "fil.iagl.opl.conan.debug.DebugAssistant.capture(" + unaryOp.toString() + ", "
                    + unaryOp.getPosition().getLine() + ", \"" + unaryOp.getOperand() + "\")";
            final CtCodeSnippetStatement statementMethod = launcher.getFactory().Code().createCodeSnippetStatement(addedCall);
            unaryOp.replace(statementMethod);
        }
    }

}
