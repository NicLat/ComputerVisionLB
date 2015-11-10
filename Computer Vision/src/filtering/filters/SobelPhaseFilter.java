package filtering.filters;

import java.awt.Color;

import filtering.IFilter;
import filtering.Img;

public class SobelPhaseFilter implements IFilter {

	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth(), original.getHeight());
		double[][] matrix = new double[original.getHeight()][original.getWidth()];
		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				int x = 0;
				x += (new Color(original.getPixel(i - 1, j - 1))).getRed() * -1;
				x += (new Color(original.getPixel(i - 1, j + 1))).getRed();
				x += (new Color(original.getPixel(i, j - 1))).getRed() * -2;
				x += (new Color(original.getPixel(i, j + 1))).getRed() * 2;
				x += (new Color(original.getPixel(i + 1, j - 1))).getRed() * -1;
				x += (new Color(original.getPixel(i + 1, j + 1))).getRed();

				int y = 0;
				y += (new Color(original.getPixel(i - 1, j - 1))).getRed();
				y += (new Color(original.getPixel(i - 1, j + 1))).getRed();
				y += (new Color(original.getPixel(i - 1, j))).getRed() * 2;
				y += (new Color(original.getPixel(i + 1, j))).getRed() * -2;
				y += (new Color(original.getPixel(i + 1, j - 1))).getRed() * -1;
				y += (new Color(original.getPixel(i + 1, j + 1))).getRed() * -1;

				matrix[i][j] = Math.atan(y/(double)x);

			}

		}

		double min = matrix[0][0];
		double max = matrix[0][0];
		for (int k = 0; k < matrix.length; k++) {
			for (int k2 = 0; k2 < matrix[k].length; k2++) {
				if (matrix[k][k2] < min)
					min = matrix[k][k2];
				if (matrix[k][k2] > max)
					max = matrix[k][k2];
			}
		}
		int[][] newMatrix = new int[matrix.length][matrix[0].length];

		for (int k = 0; k < matrix.length; k++) {
			for (int k2 = 0; k2 < matrix[k].length; k2++) {
				double grayPixel = matrix[k][k2];
				double newGrayPixel = 0;
				if (grayPixel <= min) {
					newGrayPixel = 0;
				} else if (grayPixel >= max) {
					newGrayPixel = 255;
				} else {
					newGrayPixel = 255 * (grayPixel - min) / (max - min);
				}
				newMatrix[k][k2] = (int) newGrayPixel;
				//System.out.println(newGrayPixel);
			}
		}
		for (int i = 1; i < newMatrix.length - 1; i++) {
			for (int j = 1; j < newMatrix[i].length - 1; j++) {
				Color c = new Color(newMatrix[i][j], newMatrix[i][j], newMatrix[i][j]);
				newImg.setPixel(i, j, c.getRGB());
			}
		}
		return newImg;

	}

}
