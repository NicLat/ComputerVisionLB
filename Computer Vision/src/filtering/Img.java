package filtering;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Img {

	private int[] pixels;
	private int height, width;
	private int min;
	private int max;

	public Img(int width, int height) {
		super();
		pixels = new int[width * height];
		this.width = width;
		this.height = height;
	}
	public Img(String file) {
		super();

		loadFile(file);
	}

	public int getPixel(int i, int j) {
		// index / img.getWidth() == riga
		// index % img.getWidth() == colonna
		return pixels[j + i * (width)];
	}
	public void setPixel(int i, int j, int rgb) {
		pixels[j + i * (width)] = rgb;
	}

	public void loadFile(String file) {

		try {

			BufferedImage img = null;
			img = ImageIO.read(new File(file));

			// Transformation in vector
			pixels = new int[img.getWidth() * img.getHeight()];
			min = (new Color(img.getRGB(0, 0)).getRed());
			min = (new Color(img.getRGB(0, 0)).getRed());
			for (int i = 0; i < img.getHeight(); i++)
				for (int j = 0; j < img.getWidth(); j++) {
					pixels[j + i * (img.getWidth())] = img.getRGB(j, i);
					int grayPixel = (new Color(img.getRGB(j, i)).getRed());
					if(grayPixel < min) min = grayPixel;
					if(grayPixel > max) max = grayPixel;
				}
			width = img.getWidth();
			height = img.getHeight();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	public void transformInGray() {
		for (int i = 0; i < pixels.length; i++) {
			Color oldColor = new Color(pixels[i]);

			int red = (int) (oldColor.getRed() * 0.299);
			int green = (int) (oldColor.getGreen() * 0.587);
			int blue = (int) (oldColor.getBlue() * 0.114);
			Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);

			pixels[i] = newColor.getRGB();
		}
	}

	public BufferedImage getBufferedImage() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, width, height, pixels, 0, width);

		// WritableRaster raster = (WritableRaster) image.getData();
		// raster.setPixels(0, 0, width, height, pixels);
		return image;
	}
	
	//non mi normalizza
	public BufferedImage getBufferedNormalizedImage(){
		int[] newPixels = new int[pixels.length];
		for (int i = 0; i < pixels.length; i++) {
			if(pixels[i] <= min) newPixels[i] = min;
			else if(pixels[i] >= max )newPixels[i] = max;
			else newPixels[i] = 255*(pixels[i] - min)/(max - min);
			
		}
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, width, height, newPixels, 0, width);
		return image;
	}

	public int[] getPixels() {
		return pixels;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
