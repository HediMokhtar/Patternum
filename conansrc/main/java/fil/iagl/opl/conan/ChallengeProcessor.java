package fil.iagl.opl.conan;

import fil.iagl.opl.conan.handler.MethodHandler;
import fil.iagl.opl.conan.model.Challenge;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.NameFilter;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.Optional;

public class ChallengeProcessor {

    public Challenge process(Launcher launcher, MethodHandler methodHandler, String challengeName) throws Exception {
        System.out.println(launcher.getFactory().Package().getRootPackage().getQualifiedName());
        CtClass challenge = (CtClass) launcher.getFactory().Package().getRootPackage().getElements(new NameFilter(challengeName)).get(0);

        Class<?> challengeClass = null;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        final Optional maybeChallengeMethod = challenge.getElements(new TypeFilter(CtMethod.class)).stream().filter(
                object -> "challenge".equals(((CtMethod) object).getSimpleName())
        ).findFirst();

        final CtMethod challengeMethod = (CtMethod) maybeChallengeMethod.get();

        methodHandler.handleMethod(challengeMethod, launcher);

        return (Challenge) challengeClass.newInstance();
    }
}
