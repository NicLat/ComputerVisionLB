package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.Utils;
import filtering.filters.BoxFilter;
import filtering.filters.SharpeningFilter;
import filtering.filters.SobelFilter;


public class SobelTest {

	public static void main(String[] args) {

		String temp = "img-gray/inverno.jpg";
		IFilter filter;
		Img newImg;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		/*filter = new BoxFilter();
		newImg = filter.filter(image);
		Utils.printImage(newImg.getBufferedImage(), "Box Filtered");
		
		image = new Img(temp);
		filter = new SharpeningFilter();
		newImg = filter.filter(image);
		Utils.printImage(newImg.getBufferedImage(), "Sharpening Filtered");*/
		
		image = new Img(temp);
		filter = new SobelFilter();
		newImg = filter.filter(image);
		Utils.printImage(newImg.getBufferedImage(), "Sobel Filtered");

	}

}
