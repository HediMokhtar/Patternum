package fil.iagl.opl.handler;

import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

/**
 * Object to store an anti-pattern detected, to show it later to the user
 */
public class DetectedAntiPattern {

    private CtClass classLocation;
    private CtMethod methodLocation;
    private AntiPatternHandler antiPattern;

    public DetectedAntiPattern(CtClass classLocation, AntiPatternHandler antiPattern){
        this.classLocation = classLocation;
        this.methodLocation = null;
        this.antiPattern = antiPattern;
    }

    public DetectedAntiPattern(CtClass classLocation, CtMethod methodLocation, AntiPatternHandler antiPattern){
        this.classLocation = classLocation;
        this.methodLocation = methodLocation;
        this.antiPattern = antiPattern;
    }

    public CtClass getAntiPatternClass(){
        return this.classLocation;
    }

    public CtMethod getAntiPatternMethod(){
        return this.methodLocation;
    }

    public AntiPatternHandler getAntiPattern(){ return this.antiPattern; }

    public String toString(){
        if(this.getAntiPatternMethod() == null){
            return "AntiPattern " + this.getAntiPattern().toString() + " in the class " + this.getAntiPatternClass().getSimpleName();
        }
        else{
            return "AntiPattern " + this.getAntiPattern().toString() + " in the class " + this.getAntiPatternClass().getSimpleName() + " for the method " + this.getAntiPatternMethod().getSimpleName();
        }
    }
}
