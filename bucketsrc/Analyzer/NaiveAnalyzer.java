package Analyzer;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import Model.Bucket;
import Model.Buckets;
import Model.Stacktrace;
import Model.SubStackTrace;

public class NaiveAnalyzer extends Analyzer{

	private HashMap<Stacktrace,Buckets> potentialStackTraceBuckets;
	private HashMap<Stacktrace,Bucket> stackTraceWhichBelongToOneBucket;
	private HashMap<Stacktrace,Buckets> stackTraceWhichBelongToFewBuckets;
	
	public NaiveAnalyzer(Buckets buckets) {
		super(buckets);
		this.potentialStackTraceBuckets = new HashMap<Stacktrace,Buckets>();
		this.stackTraceWhichBelongToOneBucket = new HashMap<Stacktrace,Bucket>();
		stackTraceWhichBelongToFewBuckets = new HashMap<Stacktrace,Buckets>();;

	}

	public Bucket searchBucket(Stacktrace stackTrace){

		Bucket bucketToReturn = new Bucket("0");

		for(Bucket bucket : this.buckets){
			if(stackTraceMatch(stackTrace, bucket)){
				return bucketToReturn = bucket;
			}
		}
		return bucketToReturn;
	}
	
	private void searchPotentialBuckets(Stacktrace stackTrace){

		Buckets potentialBuckets = new Buckets();

		for(Bucket bucket : this.buckets){
			if(stackTraceMatch(stackTrace, bucket)){
				potentialBuckets.add(bucket);
			}
		}
		this.potentialStackTraceBuckets.put(stackTrace, potentialBuckets);
	}
		
	private Buckets getPotentialBuckets(Stacktrace stackTrace){
		return this.potentialStackTraceBuckets.get(stackTrace);
	}
	
	private String printPotentialBuckets(Stacktrace stackTrace){
		return getPotentialBuckets(stackTrace).toStringBuckets();
	}
	
	public String searchAndGetPotentialBuckets(Stacktrace stackTrace){
		this.searchPotentialBuckets(stackTrace);
		return this.printPotentialBuckets(stackTrace);
	}
	
	private Bucket getValidateBuckets(Stacktrace stackTrace){
		return this.stackTraceWhichBelongToOneBucket.get(stackTrace);
	}
	
	private String printValidateBuckets(Stacktrace stackTrace){
		if(getValidateBuckets(stackTrace) == null){
			return "";
		}
		return stackTrace.getStackTraceNumber() + " validate bucket : " + getValidateBuckets(stackTrace).toString() + "\n";
	}
	
	public String searchAndGetValidateBuckets(Stacktrace stackTrace){
		this.searchPotentialBuckets(stackTrace);
		this.catchValidateBuckets();
		return this.printValidateBuckets(stackTrace);
	}
	
	private Buckets getAlmostValidateBuckets(Stacktrace stackTrace){
		return this.stackTraceWhichBelongToFewBuckets.get(stackTrace);
	}
	
	private String printAlmostValidateBuckets(Stacktrace stackTrace){
		if(getAlmostValidateBuckets(stackTrace) == null){
			return "";
		}
		return stackTrace.getStackTraceNumber() + " almost validate buckets :  \n " + getAlmostValidateBuckets(stackTrace).toStringBuckets() + "\n";
	}
	
	public String searchAndGetAlmostValidateBuckets(Stacktrace stackTrace){
		this.catchAlmostValidateBuckets();
		return this.printAlmostValidateBuckets(stackTrace);
	}
	
	private void catchValidateBuckets(){
		Buckets target;
		for(Stacktrace key : potentialStackTraceBuckets.keySet()){
			target = potentialStackTraceBuckets.get(key);
			if(target.size() == 1){
				this.stackTraceWhichBelongToOneBucket.put(key,target.get(0));
			}
		}
	}
	
	private void catchAlmostValidateBuckets(){
		Buckets target;
		for(Stacktrace key : potentialStackTraceBuckets.keySet()){
			target = potentialStackTraceBuckets.get(key);
			if(target.size() < 10 && target.size() > 1){
				this.stackTraceWhichBelongToFewBuckets.put(key,target);
			}
		}
	}
	
	private HashMap<Stacktrace, Bucket> getValidateBucket(Stacktrace stackTrace){
		this.searchPotentialBuckets(stackTrace);
		this.catchValidateBuckets();
		return this.stackTraceWhichBelongToOneBucket;
	}
	
	public String monperrusEvalPrinter(Stacktrace stacktrace){
		HashMap<Stacktrace, Bucket> result = getValidateBucket(stacktrace);
		return this.monperrusEvalPrinter(stacktrace, result.get(stacktrace));
	}	
	
	public int searchNumberOfMatchingBuckets(Stacktrace stackTrace){
		int numbersOfMatch = 0; 
		
		for(Bucket bucket : this.buckets){
			if(stackTraceMatch(stackTrace, bucket)){
				numbersOfMatch++;
			}
		}
		return numbersOfMatch;
	}
	
	public String monperrusEvalPrinter(File stackTraceFile, Stacktrace stackTrace){
		String result = "";
		result += Integer.parseInt(stackTraceFile.getName().substring(0, stackTraceFile.getName().length()-4));
		result +=  "  ->  ";
		result +=  this.searchBucket(stackTrace).getBucketNumber() + "\n";
		result += this.searchNumberOfMatchingBuckets(stackTrace) + "\n";
		return result;
	}
	
	
	private static boolean stackTraceMatch(Stacktrace stackTrace, Bucket bucket){
    	for(SubStackTrace subStackTrace : stackTrace){
    		if(isPartOfSubStackTraceInTheBucket(subStackTrace, bucket)){
    			return true;
    		}
    	}
    	return false;
    }
    
    private static boolean isPartOfSubStackTraceInTheBucket(SubStackTrace subStackTrace, Bucket bucket){
    	if(bucket.containFunctionName(subStackTrace.getFunctionName()) && bucket.containFileName(subStackTrace.getFileName())){
    		return true;
    	}
    	if(bucket.containFunctionName(subStackTrace.getFunctionName()) && bucket.containLibraryName(subStackTrace.getLibraryName())){
    		return true;
    	}
    	return false;
    }
}
	
	

