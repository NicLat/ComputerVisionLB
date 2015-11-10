package model.noises;

import java.awt.Color;
import java.util.Random;

import model.IFilter;
import model.Img;

public class SaltAndPepperNoise implements IFilter {

	double a;
	double b;

	public SaltAndPepperNoise(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public Img filter(Img original) {

		Img newImg = new Img(original.getWidth(), original.getHeight());
		Random rand = new Random();
		for (int i = 0; i < original.getHeight(); i++) {
			for (int j = 0; j < original.getWidth(); j++) {
				double greyPixel = new Color(original.getPixel(i, j)).getRed();
				if (rand.nextDouble() < a)
					greyPixel = 0;
				else if (rand.nextDouble() > b)
					greyPixel = 255;
				else
					greyPixel = new Color(original.getPixel(i, j)).getRed();
				Color color = new Color((int) greyPixel, (int) greyPixel,
						(int) greyPixel);
				newImg.setPixel(i, j, color.getRGB());
			}

		}
		return newImg;
	}

}
