package lamdaPrograms;

public class LamdaWithThis {
	public static void main(String[] args) {
		
		LamdaWithThis obj = new LamdaWithThis();
		System.out.println("Main Class  = this : " + obj );
		obj.doWork();
	}

	private void doWork() {
		System.out.println("Method Class  = this : " + this);
		// Create a different class 
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Anonymous Runnable this " + this);
			}
		};
		
		new Thread(runnable).start();
		
		//Do not create extra object, manage with the created object on which the method we called
		new Thread(() -> System.out.println("Lamda Runnable  " + this)).start();
	}
}


//Main Class  = this : lamdaPrograms.LamdaWithThis@626b2d4a
//Method Class  = this : lamdaPrograms.LamdaWithThis@626b2d4a
//Anonymous Runnable this lamdaPrograms.LamdaWithThis$1@32ee961d
//Lamda Runnable  lamdaPrograms.LamdaWithThis@626b2d4a
