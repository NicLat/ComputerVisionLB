package filtering.filters;

import java.awt.Color;
import java.util.ArrayList;

import filtering.IFilter;
import filtering.Img;

public class KirschFilter implements IFilter {

	@Override
	public Img filter(Img original) {
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
				
				if (max > 255)
					max = 255;
				else if (max < 0)
					max= 0;
				
				Color c = new Color(max, max, max);
				newImg.setPixel(i, j, c.getRGB());
			}
		}
		return newImg;
	}

}
