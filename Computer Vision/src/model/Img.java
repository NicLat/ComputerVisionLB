package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Img{
	
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Img n = new Img(width,height);
		n.setPixels(pixels);
		return n;
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
			max = (new Color(img.getRGB(0, 0)).getRed());
			
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
	
	public void normalizeImage(){
		
		int[] newPixels = new int[pixels.length];
		
		for (int i = 0; i < pixels.length; i++) {
			
			int grayPixel = new Color(pixels[i]).getRed();
			int newGrayPixel = 0;
			if(grayPixel <= min){
				newGrayPixel = 0;
			}
			else if(grayPixel >= max ){
				newGrayPixel = 255;
			}
			else{
				newGrayPixel = 255*(grayPixel - min)/(max - min);
			}
			Color c = new Color(newGrayPixel, newGrayPixel, newGrayPixel);
			newPixels[i] = c.getRGB();
			
		}
		pixels = newPixels;
	}

	public BufferedImage getBufferedImage() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, width, height, pixels, 0, width);

		// WritableRaster raster = (WritableRaster) image.getData();
		// raster.setPixels(0, 0, width, height, pixels);
		return image;
	}
	

	public int[] getPixels() {
		return pixels;
	}
	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

}
