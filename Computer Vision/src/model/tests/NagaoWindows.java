package model.tests;

public class NagaoWindows {

	public static void main(String[] args) {

		int kernelSize = 5;

		int[][] matrix = new int[kernelSize][kernelSize];
		int[] counts = new int[9];

		int limInf = 0;
		int limMid = kernelSize / 2;
		int limSup = kernelSize - 1;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = 0;

				if (i != limInf && i != limSup && j != limInf && j != limSup) {
					counts[0]++;
//					matrix[i][j] = 1;
				}
				if (i <= j && i + j < kernelSize && !((i == limInf && j == limInf) || (i == limInf && j == limSup))) {
					counts[1]++;
//					matrix[i][j] = 1;
				}

				if (i <= j && i + j >= limSup && !((i == limInf && j == limSup) || (i == limSup && j == limSup))) {
					counts[2]++;
//					matrix[i][j] = 1;
				}

				if (i >= j && i + j >= limSup && !((i == limSup && j == limSup) || (i == limSup && j == limInf))) {
					counts[3]++;
//					matrix[i][j] = 1;
				}

				if (i >= j && i + j < kernelSize && !((i == limSup && j == limInf) || (i == limInf && j == limInf))) {
					counts[4]++;
//					matrix[i][j] = 1;
				}

				if (i <= limMid && j <= limMid && !((i == limInf && j == limMid) || (i == limMid && j == limInf))) {
					counts[5]++;
//					matrix[i][j] = 1;
				}

				if (i <= limMid && j >= limMid && !((i == limInf && j == limMid) || (i == limMid && j == limSup))) {
					counts[6]++;
//					matrix[i][j] = 1;
				}

				if (i >= limMid && j >= limMid && !((i == limSup && j == limMid) || (i == limMid && j == limSup))) {
					counts[7]++;
//					matrix[i][j] = 1;
				}

				if (i >= limMid && j <= limMid && !((i == limSup && j == limMid) || (i == limMid && j == limInf))) {
					counts[8]++;
					matrix[i][j] = 1;
				}

			}
		}

		System.out.println();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
