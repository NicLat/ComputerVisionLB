package model.filters;

import java.awt.Color;

import model.IFilter;
import model.Img;

public class BoxFilter implements IFilter {

	@Override
	public Img filter(Img original) {
		
		Img newImg = new Img(original.getWidth()-2, original.getHeight()-2);

		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {

				int sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed();
				sum += (new Color(original.getPixel(i - 1, j))).getRed();
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed();
				sum += (new Color(original.getPixel(i, j - 1))).getRed();
				sum += (new Color(original.getPixel(i, j))).getRed();
				sum += (new Color(original.getPixel(i, j + 1))).getRed();
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed();
				sum += (new Color(original.getPixel(i + 1, j))).getRed();
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed();
				sum /= 9;

				Color c = new Color(sum, sum, sum);
				newImg.setPixel(i, j, c.getRGB());
			}

		}

		return newImg;
	}
}
