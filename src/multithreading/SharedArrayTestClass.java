package multithreading;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTestClass {

	public static void main(String[] args) {

		SimpleArray sharedSimpleArray = new SimpleArray(6);

		//Create two thread to write to the sharedSimpleArray
		//First will start with 1 and second will start with 11

		ArrayWriter write1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter write2 = new ArrayWriter(11, sharedSimpleArray);

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(write1);
		executorService.execute(write2);

		executorService.shutdown();

		try {
			boolean taskend = executorService.awaitTermination(1, TimeUnit.MINUTES);
			if (taskend) {
				System.out.println("Content of Shared Array : " + sharedSimpleArray);
			} else {
				System.out.println("Timeout");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class SimpleArray {

	private static final SecureRandom SECURE_RANDOM = new SecureRandom();
	private int[] arr;
	private int writeIndex = 0;

	public SimpleArray(int size) {
		arr = new int[size];
	}

	public void add(int value) {

		int position = writeIndex;

		try {
			Thread.sleep(SECURE_RANDOM.nextInt(500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		arr[position] = value;
		System.out.println("Wrote value " + value + " at index " + position + " by thread " + Thread.currentThread().getName());
		
		writeIndex++;
		System.out.println("Next write index " + writeIndex + " for thread " + Thread.currentThread().getName() + "\n");

	}

	@Override
	public String toString() {
		return  Arrays.toString(arr);
	}

}

class ArrayWriter implements Runnable{
	
	private final SimpleArray sharedSimpleArray;
	private final int startValue;
	
	public ArrayWriter(int startValue, SimpleArray sharedSimpleArray) {
		this.sharedSimpleArray = sharedSimpleArray;
		this.startValue = startValue;
	}
	
	@Override
	public void run() {
		for (int i=startValue ; i < startValue+3; i++)		
			sharedSimpleArray.add(i);
	}

}