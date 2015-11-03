package filtering.tests;

import java.awt.Color;
import java.awt.image.BufferedImage;

import filtering.Img;
import filtering.Utils;

public class Test01 {

	public static void main(String[] args) {

		String temp = "img-gray/inverno.jpg";
		Img image = new Img(temp);

		Utils.printImage(image.getBufferedImage(), "Original");
		
//		image.transformInGray();
		
//		Color oldColor = new Color(image.getPixel(200, 250));
//		int red = (int) (oldColor.getRed() * 0.299);
//		int green = (int) (oldColor.getGreen() * 0.587);
//		int blue = (int) (oldColor.getBlue() * 0.114);
//		Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
//		System.out.println(newColor.getRed() + " " + newColor.getGreen() + " " + newColor.getBlue() );

		
		// box filter, i do the avarage only on the red level (being a gray scale rgb are all the same)
		for (int i = 1; i < image.getHeight() - 1; i++) {
			for (int j = 1; j < image.getWidth() - 1; j++) {

				int sum = 0;
				sum += (new Color(image.getPixel(i-1, j-1))).getRed();
				sum += (new Color(image.getPixel(i-1, j))).getRed();
				sum += (new Color(image.getPixel(i-1, j+1))).getRed();
				sum += (new Color(image.getPixel(i, j-1))).getRed();
				sum += (new Color(image.getPixel(i, j))).getRed();
				sum += (new Color(image.getPixel(i, j+1))).getRed();
				sum += (new Color(image.getPixel(i+1, j-1))).getRed();
				sum += (new Color(image.getPixel(i+1, j))).getRed();
				sum += (new Color(image.getPixel(i+1, j+1))).getRed();
				sum /= 9;
				
				Color c = new Color(sum, sum, sum);
				image.setPixel(i, j, c.getRGB());			
			}

		}

		BufferedImage img2 = image.getBufferedImage();
		Utils.printImage(img2, "Box Filtered");

	}

}
