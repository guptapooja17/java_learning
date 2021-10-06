package multithreading;

import java.util.concurrent.TimeUnit;

public class RunnableClass {

	public static void main(String[] args) {

		Runnable runnable = () -> System.out.println("Inside runnable method");

		Thread thread = new Thread(runnable);
		thread.start();
		
		new Thread( () -> System.out.println("Can work like this ")).start();

		Runnable runnable2 = () -> {
			try {
				String name = Thread.currentThread().getName();
				System.out.println("Foo" + name);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Foo 123" + name);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		};
		
		new Thread(runnable2).start();
	}
}
