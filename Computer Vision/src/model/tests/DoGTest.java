package model.tests;

import model.IFilter;
import model.Img;
import model.Utils;
import model.filters.DoGFilter;

public class DoGTest {

	public static void main(String[] args) {

		//il risultato migliore aumentando la dimensione del kernel e aumentando la differenza
		//tra prima varianza e seconda
		
		String temp = "img-gray/Pavia1.jpg";
		IFilter filter;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		filter = new DoGFilter(2, 0.5, 7);
		Img newImage = filter.filter(image);
		Utils.printImage(newImage.getBufferedImage(), " DoG filtered");
		

	}
}
