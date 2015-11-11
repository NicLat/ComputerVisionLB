package model.filters;

import java.awt.Color;

import model.IFilter;
import model.Img;
import model.Normalizer;

public class KirshFilter implements IFilter {

	@Override
	public Img filter(Img original) {
		int[][] matrix = new int[original.getHeight() - 1][original.getWidth() - 1];
		Img newImg = new Img(original.getWidth(), original.getHeight());
		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				int sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i - 1, j))).getRed()* 5;
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed()*5;
				sum += (new Color(original.getPixel(i, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i, j + 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i +1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed()*-3;
				int max = sum;
				sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i - 1, j))).getRed()* 5;
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed()*-3;
				sum += (new Color(original.getPixel(i, j - 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i, j + 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i +1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed()*-3;
				if(sum > max) max = sum;
				sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i - 1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed()*-3;
				sum += (new Color(original.getPixel(i, j - 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i, j + 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i +1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed()*-3;
				if(sum > max) max = sum;
				sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed()*-3;
				sum += (new Color(original.getPixel(i, j - 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i, j + 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i +1, j))).getRed()* 5;
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed()*-3;
				if(sum > max) max = sum;
				sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed()*-3;
				sum += (new Color(original.getPixel(i, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i, j + 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i +1, j))).getRed()* 5;
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed()*5;
				if(sum > max) max = sum;
				sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed()*-3;
				sum += (new Color(original.getPixel(i, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i, j + 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i +1, j))).getRed()* 5;
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed()*5;
				if(sum > max) max = sum;
				sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed()*5;
				sum += (new Color(original.getPixel(i, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i, j + 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i +1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed()*5;
				if(sum > max) max = sum;
				sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i - 1, j))).getRed()* 5;
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed()*5;
				sum += (new Color(original.getPixel(i, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i, j + 1))).getRed()* 5;
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed()* -3;
				sum += (new Color(original.getPixel(i +1, j))).getRed()* -3;
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed()*-3;
				if(sum > max) max = sum;
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
