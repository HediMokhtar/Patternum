package fil.iagl.opl.utils;

import fil.iagl.opl.spoon.ClassProcessor;
import spoon.Launcher;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LauncherBuilder {

    public static final Launcher createLauncher(String path) throws IOException {
        final Launcher launcher = new Launcher();
        final String repositoryPath = Pwd.getRepositoryPath(path);

        final List<String> arguments = new LinkedList<String>();
        arguments.add("-i");
        arguments.add(repositoryPath);
        arguments.add("-p");
        arguments.add(ClassProcessor.class.getName());
        arguments.add("-x");

        launcher.addInputResource(repositoryPath);

        launcher.addProcessor(new ClassProcessor());
        return launcher;
    }

}
