package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.MedianFilter;
import filtering.NoiseAdder;
import filtering.Utils;


public class Test04 {

	public static void main(String[] args) {

		String temp = "img-gray/inverno.jpg";
		IFilter filter;
		Img newImg;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		image = new Img(temp);
		filter = new NoiseAdder(100);
		newImg = filter.filter(image);
		Utils.printImage(newImg.getBufferedImage(), "Noisy Image");

	}

}
