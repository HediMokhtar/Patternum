package fil.iagl.opl.main;

import fil.iagl.opl.handler.DetectedAntiPattern;
import fil.iagl.opl.helper.HelperManager;
import fil.iagl.opl.spoon.ClassProcessor;
import fil.iagl.opl.utils.LauncherBuilder;
import spoon.Launcher;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        long debut = System.currentTimeMillis();

        //Step 1 : get the project location from the user and parse it with Spoon
        final String repositoryPath = "apachesrc";
        final Launcher launcher = LauncherBuilder.createLauncher(repositoryPath);
        launcher.run();

        //Step 2 : Analyze the Java class with all the anti-pattern analyzers
        List<DetectedAntiPattern> antiPatterns = ClassProcessor.analyse();

        //Step 3 : Show the result to the user

        //Display accurately where your antiPatterns are
        ClassProcessor.analyseDisplayer(antiPatterns);

        HelperManager helperManager = new HelperManager();
        //If activated display all the path to get tips to solve your AntiPattern
        helperManager.helperGenerator(antiPatterns);

        System.out.println(System.currentTimeMillis()-debut);

    }
}
