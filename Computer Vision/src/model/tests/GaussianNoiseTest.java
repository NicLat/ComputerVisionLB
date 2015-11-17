package model.tests;

import model.IFilter;
import model.Img;
import model.Utils;
import model.noises.GaussianNoise;

public class GaussianNoiseTest {
	
	public static void main(String[] args) {
		
		String name = "img-gray/inverno.jpg";
		IFilter filter;
		
		Img imageOriginal = new Img(name);
		Utils.printImage(imageOriginal.getBufferedImage(), "Original");
		
		filter = new GaussianNoise(5);
		Img imageNoised = filter.filter(imageOriginal);
		Utils.printImage(imageNoised.getBufferedImage(), "Noisy Image");
	}

}
