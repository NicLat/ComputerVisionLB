package model.filters;

import java.awt.Color;
import java.util.ArrayList;

import model.IFilter;
import model.Img;
import model.Normalizer;

public class KirshFilter implements IFilter {

	ArrayList<int[][]> masks = new ArrayList<>(8);
	int[][] mask1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
	int[][] mask2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
	int[][] mask3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
	int[][] mask4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
	int[][] mask5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
	int[][] mask6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
	int[][] mask7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
	int[][] mask8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
	
	@Override
	public Img filter(Img original) {
		masks.add(mask1);
		masks.add(mask2);
		masks.add(mask3);
		masks.add(mask4);
		masks.add(mask5);
		masks.add(mask6);
		masks.add(mask7);
		masks.add(mask8);
		double[][] matrix = new double[original.getHeight() - 1][original.getWidth() - 1];
		Img newImg = new Img(original.getWidth(), original.getHeight());
		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				int max = Integer.MIN_VALUE;
				for (int j2 = 0; j2 < masks.size(); j2++) {
					int[][] currentMask = masks.get(j2);
					int sum = 0;
					for (int k = 0; k < currentMask.length; k++) {
						for (int k2 = 0; k2 < currentMask.length; k2++) {
							sum += (new Color(original.getPixel(i - 1 + k, j - 1 + k2))).getRed()*currentMask[k][k2];
						}
					}
					if(sum > max) max = sum;
				}
				matrix[i][j] = max;
			}
		}
		
		int[][] newMatrix = Normalizer.normalizeImage(matrix);
		
		for (int i = 1; i < newMatrix.length; i++) {
			for (int j = 1; j < newMatrix[i].length; j++) {
				Color c = new Color(newMatrix[i][j], newMatrix[i][j], newMatrix[i][j]);
				newImg.setPixel(i, j, c.getRGB());
			}
		}
		return newImg;
	}

}
