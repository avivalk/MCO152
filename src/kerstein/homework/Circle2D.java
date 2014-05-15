package kerstein.homework;

public class Circle2D {
	private double x;
	private double y;
	private double radius;

	public Circle2D() {
		x = 0;
		y = 0;
		radius = 1;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}

	public double getPerimeter() {
		return radius * Math.PI * 2;
	}

	public boolean contains(double x, double y) {
		double distance = Math.sqrt((x - this.x) * (x - this.x))
				+ ((y - this.y) * (y - this.y));
		return distance < radius;

	}

	public boolean contains(Circle2D circle) {
		double distance = Math.sqrt((circle.getX() - this.x)
				* (circle.getX() - this.x))
				+ ((circle.getY() - this.y) * (circle.getY() - this.y));
		return (distance + circle.radius) < this.radius;

	}

	public boolean overlaps(Circle2D circle) {
		double distance = Math.sqrt(((circle.x - this.x) * (circle.x - this.x))
				+ ((circle.y - this.y) * (circle.y - this.y)));
		return distance < (this.radius + circle.radius);

	}
}
