package kerstein.homework;

import java.util.Scanner;

public class MaxSum {
	private int[][] grid;
	private int rows;
	private int columns;

	public MaxSum(int size, Scanner inputFile) {
		rows = size;
		columns = size;
		grid = new int[rows][columns];
		int num;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				num = inputFile.nextInt();
				grid[i][j] = num;
			}
		}
	}

	public int getMaxSum() {
		int[] array;
		int maxSum = 0;
		for (int i = 0; i < grid.length; i++) {
			array = new int[grid[0].length];
			int max = 0;
			for (int k = i; k < grid.length; k++) {
				int currentSum = 0;
				for (int j = 0; j < grid[0].length; j++) {
					array[j] += grid[k][j];
					currentSum += array[j];
					if (currentSum > max) {
						max = currentSum;
					}
					if (currentSum < 0) {
						currentSum = 0;
					}
					if (maxSum < max) {
						maxSum = max;
					}
				}
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		Scanner inputFile = new Scanner(System.in);
		int size = inputFile.nextInt();
		MaxSum sum = new MaxSum(size, inputFile);
		System.out.println("Max Sum:" + sum.getMaxSum());
	}

}
