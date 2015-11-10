package model.filters;

import java.awt.Color;

import model.IFilter;
import model.Img;

/**
 * Il DoG filter si ottiene dalla differenza tra due Gaussian Filter con varianze differenti.
 * In questo modo, si salvano solo i contorni delle immagini. 
 * @author alessandro
 *
 */
public class DoGFilter implements IFilter {

	double variance1;
	double variance2;
	int kernelSize;

	public DoGFilter(double variance1, double variance2, int kernelSize) {
		super();
		this.variance1 = variance1;
		this.variance2 = variance2;
		this.kernelSize = kernelSize;
	}

	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth(), original.getHeight());

		int[][] gaussianMask1 = new int[kernelSize][kernelSize];
		int normalizationConstant1 = 0;
		double constant1 = 1 / Math.exp(-Math.pow((kernelSize / 2), 2)
				/ (variance1));
		System.out.println(constant1);
		//creo le due maschere 
		for (int i = 0; i < gaussianMask1.length; i++) {
			for (int j = 0; j < gaussianMask1.length; j++) {
				gaussianMask1[i][j] = (int) Math.round((constant1 * Math
						.exp(-(Math.pow((kernelSize / 2 - i), 2) + (Math.pow(
								(kernelSize / 2 - j), 2))) / (2 * variance1))));
				normalizationConstant1 += gaussianMask1[i][j];
			}
		}
		
		int[][] gaussianMask2 = new int[kernelSize][kernelSize];
		int normalizationConstant2 = 0;
		double constant2 = 1 / Math.exp(-Math.pow((kernelSize / 2), 2)
				/ (variance1));
		for (int i = 0; i < gaussianMask2.length; i++) {
			for (int j = 0; j < gaussianMask2.length; j++) {
				gaussianMask2[i][j] = (int) Math.round((constant2 * Math
						.exp(-(Math.pow((kernelSize / 2 - i), 2) + (Math.pow(
								(kernelSize / 2 - j), 2))) / (2 * variance2))));
				normalizationConstant2 += gaussianMask2[i][j];
			}
			
		}
		for (int i = kernelSize / 2; i < original.getHeight() - kernelSize / 2; i++) {
			for (int j = kernelSize / 2; j < original.getWidth() - kernelSize
					/ 2; j++) {
				int fin1 = 0;
				int fin2 = 0;

				for (int l = 0, k1 = i; l < kernelSize; l++, k1++) {
					for (int l2 = 0, k2 = j; l2 < kernelSize; l2++, k2++) {
						fin1 += (new Color(original.getPixel(k1 - kernelSize
								/ 2, k2 - kernelSize / 2))).getRed()
								* gaussianMask1[l][l2];
						fin2 += (new Color(original.getPixel(k1 - kernelSize
								/ 2, k2 - kernelSize / 2))).getRed()
								* gaussianMask2[l][l2];

					}
				}

				fin1 /= normalizationConstant1;
				fin2 /= normalizationConstant2;
				
				int fin = fin1 - fin2;
				if (fin > 255)
					fin = 255;
				if (fin < 0)
					fin = 0;

				Color c = new Color(fin, fin, fin);
				newImg.setPixel(i, j, c.getRGB());
			}

		}

		return newImg;
	}

}
