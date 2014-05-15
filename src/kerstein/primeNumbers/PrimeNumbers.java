package kerstein.primeNumbers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PrimeNumbers extends JFrame implements ActionListener, Runnable {

	private JButton start;
	private JTextArea area;
	private JScrollPane scroll;

	public PrimeNumbers() {
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		start = new JButton("Start");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		this.add(start, BorderLayout.SOUTH);
		this.add(scroll, BorderLayout.CENTER);

		start.addActionListener(this);
	}

	public boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10000000; i++) {
			if (isPrime(i)) {
				area.append(String.valueOf(i));
				area.append("\n");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Thread t = new Thread(this);
		t.start();

	}

	public static void main(String[] args) {
		PrimeNumbers primes = new PrimeNumbers();
		primes.setVisible(true);

	}

}
