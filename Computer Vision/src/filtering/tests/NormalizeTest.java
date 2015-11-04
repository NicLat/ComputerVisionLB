package filtering.tests;

import filtering.Img;
import filtering.Utils;

public class NormalizeTest {
	
	public static void main(String[] args) {
		
		String temp = "img-gray/inverno.jpg";
		Img image = new Img(temp);
		Utils.printImage(image.getBufferedImage(), "Original");
		image.normalizeImage();
		Utils.printImage(image.getBufferedImage(), "Normalized");
	}

}
