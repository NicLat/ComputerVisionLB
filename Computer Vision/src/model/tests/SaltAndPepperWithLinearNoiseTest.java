package model.tests;

import model.IFilter;
import model.Img;
import model.Utils;
import model.filters.RankFilter;
import model.noises.SaltAndPepperWithLinearNoise;

public class SaltAndPepperWithLinearNoiseTest {
	
public static void main(String[] args) {
		
		String name = "img-gray/inverno.jpg";
		IFilter filter;
		
		Img imageOriginal = new Img(name);
		Utils.printImage(imageOriginal.getBufferedImage(), "Original");
		
		filter = new SaltAndPepperWithLinearNoise(0.1, 0.7, 20);
		Img imageNoised = filter.filter(imageOriginal);
		Utils.printImage(imageNoised.getBufferedImage(), "Noisy Image");
		
		Img imageDenoised = new Img(name);
		filter = new RankFilter(1);
		imageDenoised = filter.filter(imageNoised);
		Utils.printImage(imageDenoised.getBufferedImage(), "Image Denoised with Median Filter");
	}

}
