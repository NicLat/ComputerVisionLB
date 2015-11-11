package model.filters;

import java.awt.Color;

import model.IFilter;
import model.Img;

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
				/*if (max > 255)
					max = 255;
				else if (max < 0)
					max= 0;
				
				Color c = new Color(max, max, max);
				newImg.setPixel(i, j, c.getRGB());*/
			}
		}
		
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
				//System.out.println(newGrayPixel);
			}
		}
		for (int i = 1; i < newMatrix.length; i++) {
			for (int j = 1; j < newMatrix[i].length; j++) {
				Color c = new Color(newMatrix[i][j], newMatrix[i][j], newMatrix[i][j]);
				newImg.setPixel(i, j, c.getRGB());
			}
		}
		return newImg;
	}

}