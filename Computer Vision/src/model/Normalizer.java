package model;

public class Normalizer {
	
	public static int[][] normalizeImage(int[][] matrix){
		
		double min = matrix[0][0];
		double max = matrix[0][0];
		for (int k = 0; k < matrix.length; k++) {
			for (int k2 = 0; k2 < matrix[0].length; k2++) {
				if (matrix[k][k2] < min)
					min = matrix[k][k2];
				if (matrix[k][k2] > max)
					max = matrix[k][k2];
			}
		}
		int[][] newMatrix = new int[matrix.length][matrix[0].length];

		for (int k = 0; k < matrix.length; k++) {
			for (int k2 = 0; k2 < matrix[0].length; k2++) {
				int grayPixel = matrix[k][k2];
				int newGrayPixel = 0;
				
				newGrayPixel = (int) (255 * (grayPixel - min) / (max - min));
				
				newMatrix[k][k2] = newGrayPixel;
			}
		}
		
		return newMatrix;
	}

}
