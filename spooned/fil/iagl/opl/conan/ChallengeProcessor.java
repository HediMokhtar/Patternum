

package fil.iagl.opl.conan;


public class ChallengeProcessor {
    public fil.iagl.opl.conan.model.Challenge process(spoon.Launcher launcher, fil.iagl.opl.conan.handler.MethodHandler methodHandler, java.lang.String challengeName) throws java.lang.Exception {
        java.lang.System.out.println(launcher.getFactory().Package().getRootPackage().getQualifiedName());
        spoon.reflect.declaration.CtClass challenge = ((spoon.reflect.declaration.CtClass) (launcher.getFactory().Package().getRootPackage().getElements(new spoon.reflect.visitor.filter.NameFilter(challengeName)).get(0)));
        java.lang.Class<?> challengeClass = null;
        try {
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        final java.util.Optional maybeChallengeMethod = challenge.getElements(new spoon.reflect.visitor.filter.TypeFilter(spoon.reflect.declaration.CtMethod.class)).stream().filter(( object) -> "challenge".equals(((spoon.reflect.declaration.CtMethod) (object)).getSimpleName())).findFirst();
        final spoon.reflect.declaration.CtMethod challengeMethod = ((spoon.reflect.declaration.CtMethod) (maybeChallengeMethod.get()));
        methodHandler.handleMethod(challengeMethod, launcher);
        return ((fil.iagl.opl.conan.model.Challenge) (challengeClass.newInstance()));
    }
}

