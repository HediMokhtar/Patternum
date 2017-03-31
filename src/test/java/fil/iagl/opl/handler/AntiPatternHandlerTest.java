package fil.iagl.opl.handler;
import fil.iagl.opl.spoon.ClassProcessor;
import fil.iagl.opl.utils.LauncherBuilder;
import org.junit.Test;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Test of all the handlers
 * A project to test were created to simulate the handler behaviour, the test project is located in "testsrc"
 */
public class AntiPatternHandlerTest {

    public final Launcher testLauncherBuilder() throws IOException {
        final String repositoryPath = "testsrc";
        final Launcher launcher = LauncherBuilder.createLauncher(repositoryPath);
        return launcher;
    }

    @Test
    public final void blobAverageSizeMethod() throws IOException {
        final Launcher launcher = testLauncherBuilder();
        List<CtClass<?>> controlledSizedCtClass = new LinkedList<CtClass<?>>();
        launcher.run();
        List<CtClass<?>> allCtClasses = ClassProcessor.getCtClassList().getCtClasses();

        for(CtClass ctClass : allCtClasses){
            if(ctClass.getSimpleName().startsWith("SizeTest")){
                controlledSizedCtClass.add(ctClass);
            }
        }

        int averageSize = Blob.getAverageSize(controlledSizedCtClass);

        assertTrue("Test of blob average size method ", averageSize == 41);
    }

    /**
     * The class BlobClass in the test project is especially big to test the blog method
     * @throws IOException
     */
    @Test
    public final void blobHandler() throws IOException {
        final Launcher launcher = testLauncherBuilder();
        final Blob blob = new Blob();

        launcher.run();
        List<DetectedAntiPattern> blobOccurences = ClassProcessor.analyzeOn(blob);
        boolean isBlobClassABlob = false;

        for(DetectedAntiPattern antipattern : blobOccurences){
            isBlobClassABlob = isBlobClassABlob || antipattern.getAntiPatternClass().getSimpleName().equals("BlobTest");
        }
        assertTrue("Test of Blob Handler ", isBlobClassABlob);
    }

    @Test
    public final void booleanParameterHandler() throws IOException {
        final Launcher launcher = testLauncherBuilder();
        final BooleanParameter booleanParameter = new BooleanParameter();

        launcher.run();
        List<DetectedAntiPattern> booleanParameterOccurences = ClassProcessor.analyzeOn(booleanParameter);
        boolean isBooleanParameterTestDetected = false;

        for(DetectedAntiPattern antipattern : booleanParameterOccurences){
            isBooleanParameterTestDetected = isBooleanParameterTestDetected || antipattern.getAntiPatternClass().getSimpleName().equals("BooleanParameterTest");
        }
        assertTrue("Test of Boolean Parameter Method ", isBooleanParameterTestDetected);
    }

    @Test
    public final void tooManyParametersHandler() throws IOException {
        final Launcher launcher = testLauncherBuilder();
        final TooManyParameters tooManyParameters = new TooManyParameters();

        launcher.run();
        List<DetectedAntiPattern> tooManyParametersOccurences = ClassProcessor.analyzeOn(tooManyParameters);
        boolean isTooManyParametersTestDetected = false;

        for(DetectedAntiPattern antipattern : tooManyParametersOccurences){
            isTooManyParametersTestDetected = isTooManyParametersTestDetected || antipattern.getAntiPatternClass().getSimpleName().equals("TooManyParametersTest");
        }
        assertTrue("Test of too many parameters Method ", isTooManyParametersTestDetected);
    }

    @Test
    public final void spaghettiCodeHandler() throws IOException {
        final Launcher launcher = testLauncherBuilder();
        final SpaghettiCode spaghettiCode = new SpaghettiCode();

        launcher.run();
        List<DetectedAntiPattern> spaghettiCodeOccurences = ClassProcessor.analyzeOn(spaghettiCode);
        boolean isSpaghettiCodeDetected = false;

        for(DetectedAntiPattern antipattern : spaghettiCodeOccurences){
            isSpaghettiCodeDetected = isSpaghettiCodeDetected || antipattern.getAntiPatternClass().getSimpleName().equals("Spaghetti2");
        }
        assertTrue("Test of Spaghetti Code Method ", isSpaghettiCodeDetected);
    }
}
