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
				pCoefficients.add(((new Color(original.getPixel(i - 1, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i - 1, j))).getRed()
						+ (new Color(original.getPixel(i - 1, j + 1))).getRed()/3));
				pCoefficients.add(((new Color(original.getPixel(i - 1, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i, j - 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j))).getRed())/3);
				pCoefficients.add(((new Color(original.getPixel(i - 1, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i, j - 1))).getRed()
						+ (new Color(original.getPixel(i + 1, j - 1))).getRed())/3);
				pCoefficients.add(((new Color(original.getPixel(i, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i + 1, j - 1))).getRed()
						+ (new Color(original.getPixel(i + 1, j))).getRed())/3);
				pCoefficients.add(((new Color(original.getPixel(i + 1, j - 1)))
						.getRed()
						+ (new Color(original.getPixel(i + 1, j))).getRed()
						+ (new Color(original.getPixel(i + 1, j + 1))).getRed())/3);
				pCoefficients.add(((new Color(original.getPixel(i + 1, j)))
						.getRed()
						+ (new Color(original.getPixel(i + 1, j + 1))).getRed()
						+ (new Color(original.getPixel(i, j + 1))).getRed())/3);
				pCoefficients.add(((new Color(original.getPixel(i + 1, j + 1)))
						.getRed()
						+ (new Color(original.getPixel(i, j + 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j + 1))).getRed())/3);
				pCoefficients.add(((new Color(original.getPixel(i, j + 1)))
						.getRed()
						+ (new Color(original.getPixel(i - 1, j + 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j))).getRed())/3);
				int maxCoefficient = Collections.max(pCoefficients);
				int threshold = 255;
				int index = -1;
				for (int k = 0; k < pCoefficients.size(); k++) {
					if((new Color(original.getPixel(i, j))).getRed() <= pCoefficients.get(k)){
						int tau = (new Color(original.getPixel(i, j))).getRed()/pCoefficients.get(k);
						int currentTreshold = (1 - tau)/(2*tau + 1);
						if(currentTreshold < threshold){
							threshold = currentTreshold;
							index = k;
						}
					}
				}
				int fin;
				if(index == -1) fin = 0;
				else fin = (int) (1.5*((maxCoefficient/pCoefficients.get(index)) - 0.333));
				
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
