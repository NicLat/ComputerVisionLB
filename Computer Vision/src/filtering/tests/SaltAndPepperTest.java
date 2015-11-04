package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.SaltAndPepperNoise;
import filtering.Utils;

public class SaltAndPepperTest {
	
	public static void main(String[] args) {
		
		String name = "img-gray/inverno.jpg";
		IFilter filter;
		
		Img imageOriginal = new Img(name);
		Utils.printImage(imageOriginal.getBufferedImage(), "Original");
		
		filter = new SaltAndPepperNoise(0.1, 0.9);
		Img imageNoised = filter.filter(imageOriginal);
		Utils.printImage(imageNoised.getBufferedImage(), "Noisy Image");
	}

}
