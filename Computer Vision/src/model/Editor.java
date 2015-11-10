package model;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;

import filtering.IFilter;
import filtering.Img;

public class Editor extends Observable{
	public static final int INITIAL_SIZE = 2000;
	public static final int INITIAL_COLOR = 255;

	private Img image;
	private IFilter filter;
	
	private void update(){
		setChanged();
		notifyObservers();
	}

	public Editor() {
		super();
		image = new Img(INITIAL_SIZE, INITIAL_SIZE);
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				image.setPixel(i, j, Integer.MAX_VALUE);
			}
		}
		update();
	}

	public void openImage(String fileName) {
		image = new Img(fileName);
		update();
	}
	public void saveImage(String filename){
		 File outputfile = new File(filename);
		 try {
			ImageIO.write(image.getBufferedImage(), "jpg", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void setFilter(IFilter filter) {
		this.filter = filter;
	}
	public void filter() {
		image = filter.filter(image);
		update();
	}

	public Img getImage() {
		return image;
	}

}
