package filtering;

import java.awt.Color;
import java.util.Random;

//bisognerebbe considerare anche il kernel!
public class NoiseAdder implements IFilter {

	double variance;
	
	public NoiseAdder(double variance) {
		super();
		this.variance = variance;
	}

	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth(), original.getHeight());
		Random rand = new Random();
		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				int greyPixel = new Color(original.getPixel(i, j)).getRed();
				greyPixel += rand.nextGaussian()*Math.sqrt(variance);
				if(greyPixel > 255) greyPixel = 255;
				if(greyPixel < 0 )greyPixel = 0;
				Color c = new Color(greyPixel, greyPixel, greyPixel);
				newImg.setPixel(i, j, c.getRGB());
			}

		}
		return newImg;
	}
	
	

}
