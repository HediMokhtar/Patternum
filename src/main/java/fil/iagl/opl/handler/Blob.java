package fil.iagl.opl.handler;

import fil.iagl.opl.spoon.Method;
import spoon.reflect.declaration.CtClass;
import java.util.List;

/**
 * A Blob appears when a class is way too big.
 */
public class Blob implements AntiPatternHandler{

    public Blob(){}

    public List<DetectedAntiPattern> handle(List<CtClass<?>> ctClassList, List<Method> ctMethodList) {
        int classAverageSize = getAverageSize(ctClassList);

        for(CtClass<?> classElement: ctClassList)
        if (classElement.toString().length() > classAverageSize * 2) {
            antiPatterns.add(new DetectedAntiPattern(classElement, new Blob()));
        }
        return antiPatterns;
    }

    public static int getAverageSize(List<CtClass<?>> classList) {
        int sizeClassTotal = 0;
        int currentClassElementSize;
        int classNumbers = classList.size();
        int classAverageSize;

        for (CtClass<?> classElement : classList) {
            currentClassElementSize = classElement.toString().length();
            sizeClassTotal = sizeClassTotal + currentClassElementSize;
        }
        classAverageSize = sizeClassTotal / classNumbers;
        return classAverageSize;
    }

    public void helper() {
        System.out.println("Go and check this out to learn how to counter a Blob : " + "FightTheBlob.html");
    }

    public String toString(){
        return "Blob";
    }
}
