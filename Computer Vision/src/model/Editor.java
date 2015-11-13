package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.imageio.ImageIO;

public class Editor extends Observable {
	public static final int INITIAL_SIZE = 1;
	public static final int INITIAL_COLOR = 255;

	private Img image;
	private IFilter filter;
	ArrayList<Img> list = new ArrayList<>();

	private void update() {
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
		try {
			list.add((Img) image.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		update();
	}

	public void openImage(String fileName) {
		Img newImage = new Img(fileName);

		try {
			list.add((Img) newImage.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		this.image = newImage;
		update();
	}

	public void saveImage(String filename) {
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
		Img newImage = filter.filter(image);

		try {
			list.add((Img) newImage.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		this.image = newImage;
		update();
	}

	public Img getImage() {
		return image;
	}

	public void undo() {
		if (list.size() > 1) {
			list.remove(list.size() - 1);
			try {
				image = (Img) list.get(list.size() - 1).clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		update();
	}

	public boolean undoable(){
		if(list.size() > 0)
			return true;
		return false;
	}
}
