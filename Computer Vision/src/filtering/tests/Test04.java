package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.MedianFilter;
import filtering.NoiseAdder;
import filtering.Utils;


public class Test04 {

	public static void main(String[] args) {

		String name = "img-gray/inverno.jpg";
		IFilter filter;
		
		Img imageOriginal = new Img(name);
		Utils.printImage(imageOriginal.getBufferedImage(), "Original");
		
		filter = new NoiseAdder(20);
		Img imageNoised = filter.filter(imageOriginal);
		Utils.printImage(imageNoised.getBufferedImage(), "Noisy Image");
		
		Img imageDenoised = new Img(name);
		filter = new MedianFilter(1);
		imageDenoised = filter.filter(imageNoised);
		Utils.printImage(imageDenoised.getBufferedImage(), "Image Denoised with Median Filter");

	}

}
