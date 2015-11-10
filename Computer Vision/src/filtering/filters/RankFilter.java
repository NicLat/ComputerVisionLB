package filtering.filters;

import java.awt.Color;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.Collections;

import filtering.IFilter;
import filtering.Img;

public class RankFilter implements IFilter {

	int intervalLength;

	public RankFilter(int intervalLength) {
		super();
		this.intervalLength = intervalLength;
	}

	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth()-2, original.getHeight()-2);

		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				ArrayList<Integer> array = new ArrayList<>();
				array.add((new Color(original.getPixel(i - 1, j - 1))).getRed());
				array.add((new Color(original.getPixel(i - 1, j))).getRed());
				array.add((new Color(original.getPixel(i - 1, j + 1))).getRed());
				array.add((new Color(original.getPixel(i, j - 1))).getRed());
				array.add((new Color(original.getPixel(i, j))).getRed());
				array.add((new Color(original.getPixel(i, j + 1))).getRed());
				array.add((new Color(original.getPixel(i + 1, j - 1))).getRed());
				array.add((new Color(original.getPixel(i + 1, j))).getRed());
				array.add((new Color(original.getPixel(i + 1, j + 1))).getRed());
				Collections.sort(array);

				int fin = 0;
				switch (intervalLength) {
				case 1:
					fin = array.get(4);
					break;
				case 3:
					fin = array.get(3) + array.get(4) + array.get(5);
					fin /= 3;
					break;
				case 5:
					fin = array.get(2) + array.get(3) + array.get(4)
							+ array.get(5) + array.get(6);
					fin /= 5;
					break;
				case 7:
					fin = array.get(1) + array.get(2) + array.get(3)
							+ array.get(4) + array.get(5) + array.get(6)
							+ array.get(7);
					fin /= 7;
					break;
				case 9:
					fin = array.get(0) + array.get(1) + array.get(2)
							+ array.get(3) + array.get(4) + array.get(5)
							+ array.get(6) + array.get(7) + array.get(8);
					fin /= 9;
					break;
				default:
					System.err.println("Interval Lenght Not Valid");
					break;

				}

				Color c = new Color(fin, fin, fin);
				newImg.setPixel(i-1, j-1, c.getRGB());
			}

		}

		return newImg;
	}

}
