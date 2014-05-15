package kerstein.homework;



public class Triangle {
	private int height;
	private int rows;
	private int columns;

	public Triangle(int height) {
		this.height = height;
		rows = height;
		columns = height * 2 - 1;

	}

	public String toString() {
		StringBuilder tri = new StringBuilder();
		for (int i = 1; i < height; i++) {
			int numBlanks = height - i;
			int printedBlanks = 0;
			while (printedBlanks < numBlanks) {
				tri.append(" ");
				printedBlanks++;

			}
			int numStars = i * 2 - 1;

			for (int j = 0; j < numStars; j++) {
				if (j == 0 || j == numStars - 1) {
					tri.append("*");
				} else {
					tri.append(" ");
				}
			}
			tri.append("\n");
		}
		for (int i = 0; i < columns; i++) {
			tri.append("*");
		}
		return tri.toString();
	}

	public static void main(String[] args) {
		Triangle tri = new Triangle(3);
		System.out.println(tri);
	}
}
