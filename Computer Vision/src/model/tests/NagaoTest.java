package model.tests;

import model.IFilter;
import model.Img;
import model.Utils;
import model.filters.NagaoFilter;
import model.noises.SaltAndPepperNoise;


public class NagaoTest {

	public static void main(String[] args) {

		String temp = "img-gray/inverno.jpg";
		IFilter filter;
		Img imageNagao,imageNoised,imageDenoised;
		
		Img imageOriginal = new Img(temp);
		Utils.printImage(imageOriginal.getBufferedImage(), "Original");
		
		filter = new NagaoFilter(5);
		imageNagao = filter.filter(imageOriginal);
		Utils.printImage(imageNagao.getBufferedImage(), "Nagao Filtered");
		
		filter = new SaltAndPepperNoise(0.01, 0.99);
		imageNoised = filter.filter(imageOriginal);
		Utils.printImage(imageNoised.getBufferedImage(), "Noisy Image");
		
		filter = new NagaoFilter(5);
		imageDenoised = filter.filter(imageNoised);
		Utils.printImage(imageDenoised.getBufferedImage(), "Image Denoised With Nagao Filtered");
	}

}
