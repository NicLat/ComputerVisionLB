package model.filters;

import java.awt.Color;

import model.IFilter;
import model.Img;

public class PrewittFilter implements IFilter {

	int[][] horizontalMask = {{-1, 0, 1}, {-1, 0, 1}, {-1, 0, 1}};
	int[][] verticalMask = {{1, 1, 1}, {0, 0, 0}, {-1, -1, -1}};
	
	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth(), original.getHeight());
		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				int x = 0;
				for (int k = 0; k < horizontalMask.length; k++) {
					for (int k2 = 0; k2 < horizontalMask.length; k2++) {
						x += (new Color(original.getPixel(i - 1 + k, j - 1 + k2))).getRed()*horizontalMask[k][k2];
					}
				}
				
				int y = 0;
				for (int k = 0; k < verticalMask.length; k++) {
					for (int k2 = 0; k2 < verticalMask.length; k2++) {
						y += (new Color(original.getPixel(i - 1 + k, j - 1 + k2))).getRed()*verticalMask[k][k2];
					}
				}
				
				int sum = (int) Math.sqrt(x*x + y*y);
				
				if (sum > 255)
					sum = 255;
				else if (sum < 0)
					sum= 0;
				
				Color c = new Color(sum, sum, sum);
				newImg.setPixel(i, j, c.getRGB());
			}

		}

		return newImg;

	}

}
