package model.filters;

import java.awt.Color;

import model.IFilter;
import model.Img;
import model.Normalizer;

public class SobelPhaseFilter implements IFilter {

	int[][] horizontalMask = { { -1, 0, 1 }, { -2, 0, 2 }, { -1, 0, 1 } };
	int[][] verticalMask = { { 1, 2, 1 }, { 0, 0, 0 }, { -1, -2, -1 } };

	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth(), original.getHeight());
		double[][] matrix = new double[original.getHeight() - 1][original
				.getWidth() - 1];
		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				int x = 0;
				for (int k = 0; k < horizontalMask.length; k++) {
					for (int k2 = 0; k2 < horizontalMask.length; k2++) {
						x += (new Color(
								original.getPixel(i - 1 + k, j - 1 + k2)))
								.getRed()
								* horizontalMask[k][k2];
					}
				}

				int y = 0;
				for (int k = 0; k < verticalMask.length; k++) {
					for (int k2 = 0; k2 < verticalMask.length; k2++) {
						y += (new Color(
								original.getPixel(i - 1 + k, j - 1 + k2)))
								.getRed()
								* verticalMask[k][k2];
					}
				}

				if (x == 0)
					matrix[i][j] = 0;
				else
					matrix[i][j] = Math.atan(y / (double) x);

			}

		}

		int[][] newMatrix = Normalizer.normalizeImage(matrix);

		for (int i = 1; i < newMatrix.length; i++) {
			for (int j = 1; j < newMatrix[i].length; j++) {
				Color c = new Color(newMatrix[i][j], newMatrix[i][j],
						newMatrix[i][j]);
				newImg.setPixel(i, j, c.getRGB());
			}
		}
		return newImg;

	}

}
