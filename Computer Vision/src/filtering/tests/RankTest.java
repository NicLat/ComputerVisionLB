package filtering.tests;

import filtering.IFilter;
import filtering.Img;
import filtering.Utils;
import filtering.filters.RankFilter;


public class RankTest {

	public static void main(String[] args) {

		String temp = "img-gray/inverno.jpg";
		IFilter filter;
		Img newImg;
		
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		
		image = new Img(temp);
		filter = new RankFilter(1);
		newImg = filter.filter(image);
		Utils.printImage(newImg.getBufferedImage(), "Median Filtered");

	}

}
