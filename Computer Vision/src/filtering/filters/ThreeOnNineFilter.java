package filtering.filters;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import filtering.IFilter;
import filtering.Img;

//Non si capisce un cazzo di quello che c'è scritto sulle slide!!!
//l'immagine filtrata è sbagliata
public class ThreeOnNineFilter implements IFilter {

	double p;
	double tau;

	public ThreeOnNineFilter(double p, double tau) {
		super();
		this.p = p;
		this.tau = tau;
	}

	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth() - 2, original.getHeight() - 2);
		double[][] matrix = new double[original.getHeight()][original.getWidth()];
		for (int i = 1; i < original.getHeight() - 1; i++) {
			for (int j = 1; j < original.getWidth() - 1; j++) {
				ArrayList<Integer> pCoefficients = new ArrayList<>(8);
				pCoefficients.add((new Color(original.getPixel(i - 1, j - 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j))).getRed()
						+ (new Color(original.getPixel(i - 1, j + 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i - 1, j - 1))).getRed()
						+ (new Color(original.getPixel(i, j - 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j))).getRed());
				pCoefficients.add((new Color(original.getPixel(i - 1, j - 1))).getRed()
						+ (new Color(original.getPixel(i, j - 1))).getRed()
						+ (new Color(original.getPixel(i + 1, j - 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i, j - 1))).getRed()
						+ (new Color(original.getPixel(i + 1, j - 1))).getRed()
						+ (new Color(original.getPixel(i + 1, j))).getRed());
				pCoefficients.add((new Color(original.getPixel(i + 1, j - 1))).getRed()
						+ (new Color(original.getPixel(i + 1, j))).getRed()
						+ (new Color(original.getPixel(i + 1, j + 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i + 1, j))).getRed()
						+ (new Color(original.getPixel(i + 1, j + 1))).getRed()
						+ (new Color(original.getPixel(i, j + 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i + 1, j + 1))).getRed()
						+ (new Color(original.getPixel(i, j + 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j + 1))).getRed());
				pCoefficients.add((new Color(original.getPixel(i, j + 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j + 1))).getRed()
						+ (new Color(original.getPixel(i - 1, j))).getRed());

				int maxCoefficient = Collections.max(pCoefficients);
				double threshold = ((1 - tau) / (2 * tau - 1));
				double fin = 0;
				if (maxCoefficient > p) {
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
					// sum /= 9;
					fin = (1.5 * ((maxCoefficient / (double) sum) - 0.333));
					// System.out.println(fin);
					if (fin < threshold) {
						matrix[i][j] = fin;
					}
				}

			}

		}
		double min = matrix[0][0];
		double max = matrix[0][0];
		for (int k = 0; k < matrix.length; k++) {
			for (int k2 = 0; k2 < matrix[k].length; k2++) {
				if (matrix[k][k2] < min)
					min = matrix[k][k2];
				if (matrix[k][k2] > max)
					max = matrix[k][k2];
			}
		}
		int[][] newMatrix = new int[matrix.length][matrix[0].length];

		for (int k = 0; k < matrix.length; k++) {
			for (int k2 = 0; k2 < matrix[k].length; k2++) {
				double grayPixel = matrix[k][k2];
				double newGrayPixel = 0;
				if (grayPixel <= min) {
					newGrayPixel = 0;
				} else if (grayPixel >= max) {
					newGrayPixel = 255;
				} else {
					newGrayPixel = 255 * (grayPixel - min) / (max - min);
				}
				newMatrix[k][k2] = (int) newGrayPixel;
				// System.out.println(newGrayPixel);
			}
		}
		for (int i = 1; i < newMatrix.length - 1; i++) {
			for (int j = 1; j < newMatrix[i].length - 1; j++) {
				Color c = new Color(newMatrix[i][j], newMatrix[i][j], newMatrix[i][j]);
				newImg.setPixel(i-1, j-1, c.getRGB());
			}
		}
		return newImg;
	}
}
