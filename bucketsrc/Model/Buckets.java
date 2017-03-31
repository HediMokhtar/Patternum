package Model;

import Main.Tools;

import java.io.File;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Buckets extends ArrayList<Bucket>{

	private float totalSubstacktrace = 0;
    private float totalOkSubstacktrace = 0;
    private float totalStackTrace = 0;
    private float totalOkStackTrace = 0;


	/**
	 * Objet de buckets recopiant les buckets du dossier qu'il prend en parametre
	 * @param directoryBucketPath
	 */
	public Buckets(String directoryBucketPath){
		super();


		for(File directory : new File(directoryBucketPath).listFiles()) {
            Bucket bucket = new Bucket(this);
            System.out.println("BUCKET : " + directory.getName());
            bucket.fill(directory.listFiles(), directory.getName());
            this.add(bucket);
        }
	}

	public Buckets(){
	}


	public float getTotalSubstacktrace() {
		return totalSubstacktrace;
	}
	public void incrementTotalSubstacktrace() {
		this.totalSubstacktrace++;
	}


	public float getTotalOkSubstacktrace() {
		return totalOkSubstacktrace;
	}
	public void incrementTotalOkSubstacktrace() {
		this.totalOkSubstacktrace++;
	}
	public void decrementTotalOkSubstacktrace() {
		this.totalOkSubstacktrace--;
	}


	public float getTotalStackTrace() {
		return totalStackTrace;
	}
	public void incrementTotalStackTrace() {
		this.totalStackTrace++;
	}


	public float getTotalOkStackTrace() {
		return totalOkStackTrace;
	}
	public void incrementTotalOkStackTrace() {
		this.totalOkStackTrace++;
	}
	public void decrementTotalOkStackTrace() {
		this.totalOkStackTrace--;
	}

	public String toString(){
		String result = "";
		result += "SubStacktrace OK : " + Tools.round((getTotalOkSubstacktrace()/getTotalSubstacktrace()) * 100, 2) + "%" + "\n";
		result += "Stacktrace OK : " + Tools.round((getTotalOkStackTrace()/getTotalStackTrace()) * 100, 2) + "%" + "\n";
		result += "Stacktrace OK : " + Tools.round(getTotalOkStackTrace(), 0) + "\n";
		result += "Stacktrace : " + Tools.round(getTotalStackTrace(), 0) + "\n";
		result += "Stacktrace NOT OK : " + Tools.round(getTotalStackTrace()-getTotalOkStackTrace(), 0) + "\n";
		return result;
	}

	public String toStringBuckets(){
		String s = "";
		for(Bucket b : this){
			s += b.toString() + "\n";
		}
		return s;
	}
	

	/*
	public Buckets(String directoryBucketPath){
		super();
		bucketsThis = this;

		File[] buckets = new File(directoryBucketPath).listFiles();
		final CountDownLatch latch = new CountDownLatch(buckets.length);


		for(File directory : buckets) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					Bucket bucket = new Bucket(bucketsThis);
					bucket.fill(directory.listFiles(), directory.getName());
					bucketsThis.add(bucket);
					latch.countDown();;
				}
			});
			thread.start();
		}

		try{
			latch.await();
			System.out.println("All analyze of each bucket is done");
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	*/

}
