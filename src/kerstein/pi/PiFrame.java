package kerstein.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PiFrame extends JFrame implements ActionListener, Runnable {
	private JButton start;
	private JTextArea area;

	public PiFrame() {
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		start = new JButton("Start");
		area = new JTextArea();
		this.add(start, BorderLayout.SOUTH);
		this.add(area, BorderLayout.CENTER);

		start.addActionListener(this);
	}

	@Override
	public void run() {
		double total = 0;
		for (int i = 1; i < 1000000; i++) {
			total += 4 * (Math.pow(-1, i + 1)) / (2 * i - 1);
			area.setText(String.valueOf(total));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();

	}

	public static void main(String[] args) {
		PiFrame frame = new PiFrame();
		frame.setVisible(true);
	}

}
