package kerstein.forecast;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Graph extends JComponent {

	private ArrayList<Double> temps;

	public Graph() {
		this.temps = new ArrayList<Double>();
	}

	public void setTemps(ArrayList<Double> temps) {
		this.temps = temps;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		double xScale = (this.getWidth() - 40) / (temps.size() + 1);
		double yScale = (this.getHeight() - 40) / 100;
		for (int i = 0; i < temps.size(); i++) {
			int x = 20 + (int) (xScale * (i + 1));
			int y = (this.getHeight() - 20) - (int) (yScale * temps.get(i));
			g.drawOval(x, y, 4, 4);
			g.fillOval(x, y, 4, 4);
		}

	}
}
