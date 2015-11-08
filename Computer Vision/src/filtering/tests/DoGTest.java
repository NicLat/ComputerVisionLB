package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.Utils;
import filtering.filters.DoGFilter;

public class DoGTest {

	public static void main(String[] args) {

		//il risultato migliore aumentando la dimensione del kernel e aumentando la differenza
		//tra prima varianza e seconda
		
		String temp = "img-gray/Pavia1.jpg";
		IFilter filter;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		filter = new DoGFilter(9, 0.5, 7);
		Img newImage = filter.filter(image);
		Utils.printImage(newImage.getBufferedImage(), " DoG filtered");
		

	}
}
