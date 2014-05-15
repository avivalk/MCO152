package kerstein.smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileyFace extends JComponent {

	@Override
	public void paintComponent(Graphics g) {
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(0, getHeight(), getWidth(), 0);
		g.setColor(Color.GREEN);
		g.drawOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
		g.fillOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);

	}
}
// create custom component-smileyface extends jcomponent and overrides
// paintcomponent which recieves a graphics
// paintcomponent is only place you draw to the screen
