package model.noises;

import java.awt.Color;
import java.util.Random;

import model.IFilter;
import model.Img;

public class UniformNoise implements IFilter {

	int k;
	
	public UniformNoise(int k) {
		super();
		this.k = k;
	}

	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth(), original.getHeight());
		Random rand = new Random();
		for (int i = 0; i < original.getHeight(); i++) {
			for (int j = 0; j < original.getWidth(); j++) {
				
				double greyPixel = new Color(original.getPixel(i, j)).getRed();
				double c = (rand.nextDouble() - 0.5)*2*k;
				greyPixel += c;
				if(greyPixel > 255) greyPixel = 255;
				if(greyPixel < 0 )greyPixel = 0;
				Color color = new Color((int)greyPixel, (int)greyPixel, (int)greyPixel);
				newImg.setPixel(i, j, color.getRGB());
			}

		}
		return newImg;
	}
	
	

}
