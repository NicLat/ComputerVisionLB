package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.SobelFilter;
import filtering.ThreeOnNineFilter;
import filtering.Utils;

public class ThreeOnNineTest {
	
	public static void main(String[] args) {
		
		String temp = "img-gray/inverno.jpg";
		IFilter filter;
		Img newImg;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		filter = new ThreeOnNineFilter();
		newImg = filter.filter(image);
		Utils.printImage(newImg.getBufferedImage(), "3/9 Filtered");
	}

}
