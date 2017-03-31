

package fil.iagl.opl.conan;


public class LauncherBuilder {
    public spoon.Launcher buildLauncher() {
        final spoon.Launcher launcher = new spoon.Launcher();
        launcher.setArgs(new java.lang.String[]{ "--source-classpath" , "target/classes" });
        launcher.addInputResource("src/main/resources");
        launcher.buildModel();
        return launcher;
    }
}

