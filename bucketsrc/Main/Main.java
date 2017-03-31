package Main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import Analyzer.IAnalyzer;
import Analyzer.NaiveAnalyzer;
import Analyzer.NaiveAnalyzerV2;
import Model.Buckets;
import Model.Stacktrace;


/**
 * Created by Junior on 19-10-16.
 */
public class Main {
	
    public static final String PATH_BUCKETS_TRAINING = "./nautilus/nautilus-training";
    public static final String PATH_BUCKETS_TESTING = "./nautilus/nautilus-testing";

    public static HashMap<String, Integer> functionMap = new HashMap<String,Integer>();
    public static HashMap<String, Integer> fileMap = new HashMap<String,Integer>();
    public static HashMap<String, Integer> libraryMap = new HashMap<String,Integer>();

    public static void main (String [] arg) throws IOException{

    	//Creation de l'espace d'entrainement et affichage du resultat de l'assimilation des donnees
    	
        Buckets buckets = new Buckets(PATH_BUCKETS_TRAINING);
        System.out.println(buckets.toString());
        
        File stacktraceFile = new File(PATH_BUCKETS_TESTING);
        File[] stacktraceFiles = stacktraceFile.listFiles();

        //Analyze(new MatchAnalyzerBoolean(buckets), stacktraceFiles);
        //Analyze(new MatchAnalyzerCount(buckets), stacktraceFiles);
        
        NaiveAnalyzer naive = new NaiveAnalyzer(buckets);
//      Analyze(new NaiveAnalyzer(buckets), stacktraceFiles);
        System.out.println("=====================================================");
        System.out.println("TESTING with : " + naive.getClass().getSimpleName());
        System.out.println("=====================================================");
        Stacktrace stacktraceTesting;
        for(File stackTraceTest : stacktraceFiles) {
            stacktraceTesting = new Stacktrace();
            stacktraceTesting.fill(stackTraceTest, stackTraceTest.getName().substring(0, stackTraceTest.getName().length()-4));
            System.out.print(naive.searchAndGetValidateBuckets(stacktraceTesting));
            System.out.print(naive.searchAndGetAlmostValidateBuckets(stacktraceTesting));
            naive.createAnalyzeResultFile(stackTraceTest, stacktraceTesting);
        }
        
        
    }


    public static void Analyze (IAnalyzer analyzer, File[] stacktraceFiles) throws IOException
    {
        System.out.println("=====================================================");
        System.out.println("TESTING with : " + analyzer.getClass().getSimpleName());
        System.out.println("=====================================================");
        Stacktrace stacktraceTesting;
        for(File stackTraceTest : stacktraceFiles) {
            stacktraceTesting = new Stacktrace();
            stacktraceTesting.fill(stackTraceTest, stackTraceTest.getName().substring(0, stackTraceTest.getName().length()-4));
            System.out.print(analyzer.monperrusEvalPrinter(stackTraceTest, stacktraceTesting));
            analyzer.createAnalyzeResultFile(stackTraceTest, stacktraceTesting);
        }
    }
}