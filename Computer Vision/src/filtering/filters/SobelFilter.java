package filtering.filters;

import java.awt.Color;

import filtering.IFilter;
import filtering.Img;

public class SobelFilter implements IFilter {

	
	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth(), original.getHeight());
		
		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				int x = 0;
				x += (new Color(original.getPixel(i - 1, j - 1))).getRed()* -1;
				x += (new Color(original.getPixel(i - 1, j + 1))).getRed();
				x += (new Color(original.getPixel(i, j - 1))).getRed()* -Math.sqrt(2);
				x += (new Color(original.getPixel(i, j + 1))).getRed()* Math.sqrt(2);
				x += (new Color(original.getPixel(i + 1, j - 1))).getRed()* -1;
				x += (new Color(original.getPixel(i + 1, j + 1))).getRed();
				
				int y = 0;
				y += (new Color(original.getPixel(i - 1, j - 1))).getRed();
				y += (new Color(original.getPixel(i - 1, j + 1))).getRed();
				y += (new Color(original.getPixel(i - 1 , j))).getRed()* Math.sqrt(2);
				y += (new Color(original.getPixel(i + 1 , j))).getRed()* -Math.sqrt(2);
				y += (new Color(original.getPixel(i + 1, j - 1))).getRed()* -1;
				y += (new Color(original.getPixel(i + 1, j + 1))).getRed()* -1;
				
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
