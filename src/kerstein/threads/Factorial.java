package kerstein.threads;

import java.math.BigInteger;

public class Factorial extends Thread {// each thread is a new class
	private long number;

	public Factorial(long number) {
		this.number = number;
	}

	public BigInteger factorial() {
		BigInteger total = BigInteger.valueOf(number);
		for (long i = number - 1; i > 0; i--) {
			total = total.multiply(BigInteger.valueOf(i));
		}
		return total;
	}

	@Override
	public void run() {// everything u want thread to do is run method and has
		// to be override
		super.run();
		System.out.println(factorial());
	}

}
