package filtering.filters;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import filtering.IFilter;
import filtering.Img;

//Non si capisce un cazzo di quello che c'è scritto sulle slide!!!
//l'immagine filtrata è sbagliata
public class ThreeOnNineFilter implements IFilter {

	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth(), original.getHeight());

		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				ArrayList<Integer> pCoefficients = new ArrayList<>(8);
				pCoefficients.add((new Color(original.getPixel(i - 1, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i - 1, j))).getRed()
						+ (new Color(original.getPixel(i - 1, j + 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i - 1, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i, j - 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j))).getRed());
				pCoefficients.add((new Color(original.getPixel(i - 1, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i, j - 1))).getRed()
						+ (new Color(original.getPixel(i + 1, j - 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i + 1, j - 1))).getRed()
						+ (new Color(original.getPixel(i + 1, j))).getRed());
				pCoefficients.add((new Color(original.getPixel(i + 1, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i + 1, j))).getRed()
						+ (new Color(original.getPixel(i + 1, j + 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i + 1, j)))
						.getRed()
						+ (new Color(original.getPixel(i + 1, j + 1))).getRed()
						+ (new Color(original.getPixel(i, j + 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i + 1, j + 1)))
						.getRed()
						+ (new Color(original.getPixel(i, j + 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j + 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i, j + 1)))
						.getRed()
						+ (new Color(original.getPixel(i - 1, j + 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j))).getRed());
				
				int maxCoefficient = Collections.max(pCoefficients);
				double sum = 0;
				sum += (new Color(original.getPixel(i - 1, j - 1))).getRed();
				sum += (new Color(original.getPixel(i - 1, j))).getRed();
				sum += (new Color(original.getPixel(i - 1, j + 1))).getRed();
				sum += (new Color(original.getPixel(i, j - 1))).getRed();
				sum += (new Color(original.getPixel(i, j))).getRed();
				sum += (new Color(original.getPixel(i, j + 1))).getRed();
				sum += (new Color(original.getPixel(i + 1, j - 1))).getRed();
				sum += (new Color(original.getPixel(i + 1, j))).getRed();
				sum += (new Color(original.getPixel(i + 1, j + 1))).getRed();
				sum /= 9;
		
				int fin;			
				fin = (int) (1.5*((maxCoefficient*9/sum) - 0.333));
				if (fin > 255)
					fin = 255;
				else if (fin < 0)
					fin = 0;

				Color c = new Color(fin, fin, fin);
				newImg.setPixel(i, j, c.getRGB());
			}

		}

		return newImg;
	}
}
