

package fil.iagl.opl.conan;


public class Main {
    public static void main(java.lang.String[] args) throws java.lang.Exception {
        final java.lang.String challengesFolderPath = "src/main/resources/challenges";
        final java.lang.String[] challengesClassNames = java.util.Arrays.stream(new java.io.File(challengesFolderPath).listFiles()).map(( className) -> {
            return className.getName().substring(0, ((className.getName().length()) - 5));
        }).toArray(java.lang.String[]::new);
        final spoon.Launcher launcher = new fil.iagl.opl.conan.LauncherBuilder().buildLauncher();
        final fil.iagl.opl.conan.handler.MethodHandler methodHandler = new fil.iagl.opl.conan.MethodHandlerBuilder().buildMethodHandler();
        for (final java.lang.String className : challengesClassNames) {
            fil.iagl.opl.conan.debug.DebugAssistant.resetAll();
            fil.iagl.opl.conan.debug.DDebuggerImpl.runtimeCauseEffectChain = new fil.iagl.opl.conan.debug.DebugCauseEffectChain();
            final fil.iagl.opl.conan.model.Challenge newChallenge = new fil.iagl.opl.conan.ChallengeProcessor().process(launcher, methodHandler, className);
            java.lang.System.out.println((("-------> " + className) + "\n"));
            new fil.iagl.opl.conan.debug.DDebuggerImpl().debug(newChallenge);
        }
    }
}

