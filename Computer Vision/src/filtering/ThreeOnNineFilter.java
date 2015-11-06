package filtering;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

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
				int threshold = 255;
				int sum = 0;
				for (Integer integer : pCoefficients) {
					if((new Color(original.getPixel(i, j))).getRed() < integer){
						int tau = (new Color(original.getPixel(i, j))).getRed()/integer;
						int currentTreshold = (1 - tau)/(2*tau + 1);
						if(currentTreshold < threshold) threshold = currentTreshold;
					}
					sum +=integer;
				}
				System.out.println(threshold);
				int fin;
				if(sum > threshold) sum = threshold;
				fin = (int) (1.5*((maxCoefficient/sum) - 0.333));
				
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
