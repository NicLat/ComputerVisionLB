package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.Utils;
import filtering.filters.KirschFilter;
import filtering.filters.ThreeOnNineFilter;

public class KirschTest {
	
	public static void main(String[] args) {
		
		String temp = "img-gray/inverno.jpg";
		IFilter filter;
		Img newImg;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		filter = new KirschFilter();
		newImg = filter.filter(image);
		Utils.printImage(newImg.getBufferedImage(), "Kirsch Filtered");
	}

}
