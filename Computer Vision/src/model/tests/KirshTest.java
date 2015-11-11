package model.tests;

import model.IFilter;
import model.Img;
import model.Utils;
import model.filters.KirshFilt;

public class KirshTest {
	
	public static void main(String[] args) {
		
		String temp = "img-gray/inverno.jpg";
		IFilter filter;
		Img newImg;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		filter = new KirshFilt();
		newImg = filter.filter(image);
		Utils.printImage(newImg.getBufferedImage(), "Kirsch Filtered");
	}

}
