package kerstein.smiley;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SmileyFrame extends JFrame {

	public SmileyFrame() {
		this.setTitle("SMILE!");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		SmileyFace smileyFace = new SmileyFace();
		this.add(smileyFace, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		SmileyFrame smileyFrame = new SmileyFrame();
		smileyFrame.setVisible(true);
	}
}
