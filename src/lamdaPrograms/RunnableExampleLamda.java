package lamdaPrograms;

public class RunnableExampleLamda {

	public static void main(String[] args) {

		System.out.println("Main Thread Name : " + Thread.currentThread().getName());

		//Runnable implementation using anonymous class
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Anonymous Thread Implementation : " + Thread.currentThread().getName());
			}
		};	
		Thread thread1 = new Thread(runnable);
		thread1.start();



		//Pass the runnable into thread creation using anonymous implementation  
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Provide Runnable into Thread : " + Thread.currentThread().getName());		
			}
		});

		thread2.start();


		//Using Lamda
		new Thread( () -> System.out.println("Lamda Runnable Implementation " + Thread.currentThread().getName())).start();


		//Local Variable in Lamda

		int limit = 10;
		new Thread( () ->  {
				// int limit = 5;			you can't redeclare local variables inside Lamda again
				for (int i=0; i<limit ; i++)
					System.out.println(i);
				}
		);

	}

}
