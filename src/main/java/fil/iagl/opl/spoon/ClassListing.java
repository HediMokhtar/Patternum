
package fil.iagl.opl.spoon;

        import java.util.*;

        import spoon.reflect.declaration.CtClass;
        import spoon.reflect.declaration.CtMethod;

/**
 * Structure to keep the most information as possible from the first spoon invocation on the project
 * Only the class and methods are saved but we could imagine a deeper granularity
 */
public class ClassListing{

    private List<CtClass<?>> classList;
    private List<Method> allMethods;


    public ClassListing() {
        classList = new LinkedList<CtClass<?>>();
        allMethods = new LinkedList<Method>();
    }

    public List<CtClass<?>> getCtClasses(){
        return this.classList;
    }

    public List<Method> getAllMethods(){
        return this.allMethods;
    }

    public void addClass(CtClass<?> ctClass) {
        classList.add(ctClass);
        addMethods(ctClass);
    }

    private void addMethods(CtClass<?> ctClass){
        Set<CtMethod<?>> methods;

        methods = ctClass.getMethods();
        for (CtMethod<?> ctMethod : methods) {
            Method method = new Method(ctMethod, ctClass);
            this.allMethods.add(method);
        }
    }

}
