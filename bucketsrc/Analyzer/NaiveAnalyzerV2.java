package Analyzer;

import java.io.File;

import Model.Bucket;
import Model.Buckets;
import Model.Stacktrace;
import Model.SubStackTrace;

public class NaiveAnalyzerV2 extends Analyzer{


	public NaiveAnalyzerV2(Buckets buckets) {
		super(buckets);
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
	
	public Buckets searchPotentialBuckets(Stacktrace stackTrace){

		Buckets bucketsToReturn = new Buckets();

		for(Bucket bucket : this.buckets){
			if(stackTraceMatch(stackTrace, bucket)){
				bucketsToReturn.add(bucket);
			}
		}
		return bucketsToReturn;
	}
	
	public int searchNumberOfPotentialBuckets(Stacktrace stackTrace){

		int result = 0;

		for(Bucket bucket : this.buckets){
			if(stackTraceMatch(stackTrace, bucket)){
				result++;
			}
		}
		return result;
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
    	
    			if(bucket.matchFunctionAndFileMap(subStackTrace.getFunctionName(),subStackTrace.getFileName())){
    			return true;
    	
    			}
    		
    			if(bucket.matchFunctionAndLibraryMap(subStackTrace.getFunctionName(),subStackTrace.getLibraryName())){
    				return true;
    			
    			}
    	return false;
    }
}
	
	

