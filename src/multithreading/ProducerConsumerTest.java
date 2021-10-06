package multithreading;

public class ProducerConsumerTest {
	
	public static void main(String[] args) {
		
		
	}
}

/*
 * interface Buffer {
 * 
 * void blockingPut(int value); //produce value int blockingGet(); // Consumes
 * value
 * 
 * }
 * 
 * class UnsychoronizedClass implements Buffer {
 * 
 * private int butterWrite = -1;
 * 
 * @Override public void blockingPut(int value) {
 * System.out.println(" Producer Writing " + value); butterWrite = value;
 * 
 * }
 * 
 * @Override public int blockingGet() { System.out.println(" Consumer reading "
 * + butterWrite); return butterWrite; } }
 * 
 * class Producer {
 * 
 * private static final SecureRandom SECURE_RANDOM = new SecureRandom(); private
 * final Buffer SHAREDBUFFERLOCATION_BUFFER;
 * 
 * public Producer(Buffer sharedLocation) { this.SHAREDBUFFERLOCATION_BUFFER =
 * sharedLocation; }
 * 
 * Runnable runnable = () -> {
 * 
 * int sum = 0; for (int i=1 ; i<= 10 ; i++) { try {
 * Thread.sleep(SECURE_RANDOM.nextInt(3000));
 * SHAREDBUFFERLOCATION_BUFFER.blockingPut(i); sum = sum + i;
 * System.out.println(" Sum of Produce " + sum); } catch (InterruptedException
 * e) { e.printStackTrace(); } }
 * 
 * }; }
 */