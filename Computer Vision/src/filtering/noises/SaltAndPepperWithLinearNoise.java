package filtering.noises;

import java.awt.Color;
import java.util.Random;

import filtering.IFilter;
import filtering.Img;

public class SaltAndPepperWithLinearNoise implements IFilter {

	double a;
	double b;
	int k;

	public SaltAndPepperWithLinearNoise(double a, double b, int k) {
		super();
		this.a = a;
		this.b = b;
		this.k = k;
	}

	@Override
	public Img filter(Img original) {

		Img newImg = new Img(original.getWidth(), original.getHeight());
		Random rand = new Random();
		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				double greyPixel = new Color(original.getPixel(i, j)).getRed();
				if (rand.nextDouble() < a)
					greyPixel = 0;
				else if (rand.nextDouble() > b)
					greyPixel = 255;
				else{
					greyPixel = new Color(original.getPixel(i, j)).getRed();
					double c = 2*((k - b)/(b - a))*(rand.nextDouble() - 0.5);
					greyPixel += c;
					if(greyPixel > 255) greyPixel = 255;
					if(greyPixel < 0 )greyPixel = 0;
				}
				
				Color color = new Color((int) greyPixel, (int) greyPixel,
						(int) greyPixel);
				newImg.setPixel(i, j, color.getRGB());
			}

		}
		return newImg;
	}
}
