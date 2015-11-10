package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.Utils;
import filtering.filters.SobelFilter;
import filtering.filters.ThreeOnNineFilter;

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
