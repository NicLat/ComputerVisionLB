package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.Utils;
import filtering.filters.RankFilter;
import filtering.noises.SaltAndPepperNoise;

public class SaltAndPepperTest {
	
	public static void main(String[] args) {
		
		String name = "img-gray/inverno.jpg";
		IFilter filter;
		
		Img imageOriginal = new Img(name);
		Utils.printImage(imageOriginal.getBufferedImage(), "Original");
		
		filter = new SaltAndPepperNoise(0.1, 0.9);
		Img imageNoised = filter.filter(imageOriginal);
		Utils.printImage(imageNoised.getBufferedImage(), "Noisy Image");
		
		Img imageDenoised = new Img(name);
		filter = new RankFilter(1);
		imageDenoised = filter.filter(imageNoised);
		Utils.printImage(imageDenoised.getBufferedImage(), "Image Denoised with Median Filter");
	}

}
