package model.tests;

import model.IFilter;
import model.Img;
import model.Utils;
import model.filters.SobelModuleFilter;
import model.filters.ThreeOnNineFilter;

public class ThreeOnNineTest {
	
	public static void main(String[] args) {
		
		String temp = "img-gray/inverno.jpg";
		IFilter filter;
		Img newImg;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		filter = new ThreeOnNineFilter(80, 0.68);
		newImg = filter.filter(image);
		//newImg.normalizeImage();
		Utils.printImage(newImg.getBufferedImage(), "3/9 Filtered");
	}

}
