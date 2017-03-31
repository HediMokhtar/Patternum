package fil.iagl.opl.conan.handler;

import spoon.Launcher;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

public class AssignmentHandler implements ElementHandler {

    @Override
    public void handle(CtMethod method, Launcher launcher) {
        for (Object obj : method.getElements(new TypeFilter<>(CtAssignment.class))) {

            CtAssignment assignment = (CtAssignment) obj;
            String surrounded = "fil.iagl.opl.conan.debug.DebugAssistant.capture(" + assignment.getAssignment() + ", "
                    + assignment.getPosition().getLine() + ", \"" + assignment.getAssigned().toString() + "\", \"" + getOperator(assignment) + "\")";
            final CtCodeSnippetExpression statementMethod = launcher.getFactory().Code().createCodeSnippetExpression(surrounded);
            assignment.setAssignment(statementMethod);

            String captureNewValue = "fil.iagl.opl.conan.debug.DebugAssistant.captureNewVal(" + assignment.getAssigned() + ", \"" + assignment.getAssigned() + "\")";
            final CtCodeSnippetStatement captureNewValSnippet = launcher.getFactory().Code().createCodeSnippetStatement(captureNewValue);
            assignment.insertAfter(captureNewValSnippet);
        }

    }

    private String getOperator(CtAssignment assignment) {
        String equalsOperator = "=";
        if (assignment instanceof CtOperatorAssignment<?, ?>){
            CtOperatorAssignment ctp = (CtOperatorAssignment) assignment;
            return binaryOperatorToString(ctp.getKind()) + equalsOperator;
        }
        return equalsOperator;
    }

    public String binaryOperatorToString(BinaryOperatorKind operator) {
        switch(operator) {
            case PLUS :
                return "+";
            case MINUS :
                return "-";
            case DIV :
                return "/";
            case MUL :
                return "*";
            default :
                return operator.name();
        }
    }

}
