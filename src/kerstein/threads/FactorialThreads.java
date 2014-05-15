package kerstein.threads;

public class FactorialThreads {

	public static void main(String[] args) {
		Thread t1 = new Factorial(1000);
		Thread t2 = new Factorial(3);
		t1.start();// telling JVM to run the thread
		t2.start();
	}

}
