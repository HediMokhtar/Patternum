

package fil.iagl.opl.conan.handler;


public class AssignmentHandler implements fil.iagl.opl.conan.handler.ElementHandler {
    @java.lang.Override
    public void handle(spoon.reflect.declaration.CtMethod method, spoon.Launcher launcher) {
        for (java.lang.Object obj : method.getElements(new spoon.reflect.visitor.filter.TypeFilter<>(spoon.reflect.code.CtAssignment.class))) {
            spoon.reflect.code.CtAssignment assignment = ((spoon.reflect.code.CtAssignment) (obj));
            java.lang.String surrounded = ((((((("fil.iagl.opl.conan.debug.DebugAssistant.capture(" + (assignment.getAssignment())) + ", ") + (assignment.getPosition().getLine())) + ", \"") + (assignment.getAssigned().toString())) + "\", \"") + (getOperator(assignment))) + "\")";
            final spoon.reflect.code.CtCodeSnippetExpression statementMethod = launcher.getFactory().Code().createCodeSnippetExpression(surrounded);
            assignment.setAssignment(statementMethod);
            java.lang.String captureNewValue = ((("fil.iagl.opl.conan.debug.DebugAssistant.captureNewVal(" + (assignment.getAssigned())) + ", \"") + (assignment.getAssigned())) + "\")";
            final spoon.reflect.code.CtCodeSnippetStatement captureNewValSnippet = launcher.getFactory().Code().createCodeSnippetStatement(captureNewValue);
            assignment.insertAfter(captureNewValSnippet);
        }
    }

    private java.lang.String getOperator(spoon.reflect.code.CtAssignment assignment) {
        java.lang.String equalsOperator = "=";
        if (assignment instanceof spoon.reflect.code.CtOperatorAssignment<?, ?>) {
            spoon.reflect.code.CtOperatorAssignment ctp = ((spoon.reflect.code.CtOperatorAssignment) (assignment));
            return (binaryOperatorToString(ctp.getKind())) + equalsOperator;
        }
        return equalsOperator;
    }

    public java.lang.String binaryOperatorToString(spoon.reflect.code.BinaryOperatorKind operator) {
        switch (operator) {
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

