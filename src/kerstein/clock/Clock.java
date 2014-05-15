package kerstein.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComponent;

public class Clock extends JComponent {
	private int centerX, centerY, seconds, minutes, hours, radius;

	public void paintComponent(Graphics g) {
		GregorianCalendar now = (GregorianCalendar) Calendar.getInstance();
		hours = now.get(Calendar.HOUR_OF_DAY);
		minutes = now.get(Calendar.MINUTE);
		seconds = now.get(Calendar.SECOND);

		this.centerX = this.getWidth() / 2;
		this.centerY = this.getHeight() / 2;

		g.setColor(Color.BLACK);
		g.drawOval(0, 0, this.getWidth(), this.getHeight());

		g.setColor(Color.BLUE);
		this.radius = 55;
		double hourAngle = Math.toRadians((hours * 30) + (minutes * .5)
				+ (seconds * .0083) - 90);
		int hourX = (int) (centerX + (radius * Math.cos(hourAngle)));
		int hourY = (int) (centerY + (radius * Math.sin(hourAngle)));
		g.drawLine(centerX, centerY, hourX, hourY);

		g.setColor(Color.RED);
		double minuteAngle = Math
				.toRadians((6 * minutes) + (seconds * .1) - 90);
		this.radius = 75;
		int minuteX = (int) (centerX + (radius * Math.cos(minuteAngle)));
		int minuteY = (int) (centerY + (radius * Math.sin(minuteAngle)));
		g.drawLine(centerX, centerY, minuteX, minuteY);

		g.setColor(Color.GREEN);
		double secondsAngle = Math.toRadians(seconds * 6 - 90);
		this.radius = 100;
		int secondX = (int) (centerX + (radius * Math.cos(secondsAngle)));
		int secondY = (int) (centerY + (radius * Math.sin(secondsAngle)));
		g.drawLine(centerX, centerY, secondX, secondY);
	}
}