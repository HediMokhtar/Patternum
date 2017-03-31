package fil.iagl.opl.spoon;

import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

/**
 * Spoon's method structure with the simpler information possible
 */
public class Method {

    private CtMethod<?> method;
    private CtClass<?> ctClass;

    public Method(CtMethod<?> ctMethod, CtClass<?> ctClass) {
        this.ctClass = ctClass;
        this.method = ctMethod;
    }

    public String toString(){
        return "The method named " + method.getSimpleName() + " in the class " + ctClass.getSimpleName();
    }

    public CtMethod<?> getCtMethod(){
        return this.method;
    }

    public CtClass<?> getCtClass() {return this.ctClass;}
}
