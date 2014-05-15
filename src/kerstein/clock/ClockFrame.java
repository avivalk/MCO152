package kerstein.clock;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ClockFrame extends JFrame {
	private Clock clock;
	private Thread animation;

	public ClockFrame() {
		this.setTitle("My Clock");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		clock = new Clock();
		this.add(clock, BorderLayout.CENTER);
		animation = new AnimationThread(clock);
		animation.start();
	}

	public static void main(String[] args) {
		ClockFrame clock = new ClockFrame();
		clock.setVisible(true);

	}

}
