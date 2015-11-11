package model.tests;

import model.IFilter;
import model.Img;
import model.Utils;
import model.filters.SobelModuleFilter;
import model.filters.SobelPhaseFilter;


public class PrewittTest {

	public static void main(String[] args) {

		String temp = "img-gray/inverno.jpg";
		IFilter filter;
		Img newImg;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		image = new Img(temp);
		filter = new SobelModuleFilter();
		newImg = filter.filter(image);
		Utils.printImage(newImg.getBufferedImage(), "Prewitt Filtered");

	}

}
