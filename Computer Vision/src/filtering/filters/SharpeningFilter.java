package filtering.filters;

import java.awt.Color;

import filtering.IFilter;
import filtering.Img;

public class SharpeningFilter implements IFilter {

	@Override
	public Img filter(Img original) {
		
		Img newImg = new Img(original.getWidth(), original.getHeight());

		// box filter, i do the avarage only on the red level (being a gray
		// scale rgb are all the same)
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

				int a = 2 * (new Color(original.getPixel(i, j))).getRed();
				int value = a - sum;
				if (value > 255)
					value = 255;
				else if(value < 0)
					value = 0;

				Color c = new Color(value, value, value);
				newImg.setPixel(i, j, c.getRGB());
			}

		}

		return newImg;
	}
}
