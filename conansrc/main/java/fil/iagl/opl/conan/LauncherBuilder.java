package fil.iagl.opl.conan;

import spoon.Launcher;

public class LauncherBuilder {

    public Launcher buildLauncher() {
        final Launcher launcher = new Launcher();
        launcher.setArgs(new String[] {"--source-classpath","target/classes"});
        launcher.addInputResource("src/main/resources");
        launcher.buildModel();
        return launcher;
    }

}
