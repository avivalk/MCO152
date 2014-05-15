package kerstein.homework;

public class Force2D {
	private double x;
	private double y;

	public Force2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		double magnitude = Math.sqrt((x * x) + (y * y));
		return magnitude;
	}

	public double getAngle() {
		double radians = Math.atan2(y, x);
		double angle = Math.toDegrees(radians);
		return angle;
	}

	public Force2D add(Force2D force) {
		double sumX = this.x + force.x;
		double sumY = this.y + force.y;
		return new Force2D(sumX, sumY);
	}
}
