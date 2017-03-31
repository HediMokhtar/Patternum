package fil.iagl.opl.conan;

import fil.iagl.opl.conan.debug.DDebuggerImpl;
import fil.iagl.opl.conan.debug.DebugCauseEffectChain;
import fil.iagl.opl.conan.debug.DebugAssistant;
import fil.iagl.opl.conan.handler.*;
import fil.iagl.opl.conan.model.Challenge;
import spoon.Launcher;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        final String challengesFolderPath = "src/main/resources/challenges";
        final String[] challengesClassNames = Arrays.stream(new File(challengesFolderPath).listFiles()).map(className -> {
            return className.getName().substring(0, className.getName().length() - 5);
        }).toArray(String[]::new);

        final Launcher launcher = new LauncherBuilder().buildLauncher();
        final MethodHandler methodHandler = new MethodHandlerBuilder().buildMethodHandler();

        for (final String className : challengesClassNames) {
            DebugAssistant.resetAll();
            DDebuggerImpl.runtimeCauseEffectChain = new DebugCauseEffectChain();
            final Challenge newChallenge = new ChallengeProcessor().process(launcher, methodHandler, className);
            System.out.println("-------> " + className + "\n");
            new DDebuggerImpl().debug(newChallenge);
        }

    }

}
