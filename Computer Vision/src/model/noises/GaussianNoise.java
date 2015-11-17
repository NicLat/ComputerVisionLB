package model.noises;

import java.awt.Color;

import model.IFilter;
import model.Img;
import model.Normalizer;

public class GaussianNoise implements IFilter {

	private double sigma;

	public GaussianNoise(double sigma) {
		super();
		this.sigma = sigma;
	}

	@Override
	public Img filter(Img original) {
		
		Img filteredImage = new Img(original.getWidth(), original.getHeight());
		
		int dim = (int) Math.ceil(sigma * 6);
		if (dim % 2 == 0) {
			dim += 1;
		}

		double matrix[][] = new double[original.getHeight() - 1][original.getWidth() - 1];

		double[][] gauss = new double[dim][dim];
		gauss = getGaussian(sigma, dim);

		for (int i = dim / 2; i < original.getHeight() - dim / 2; i++) {
			for (int j = dim / 2; j < original.getWidth() - dim / 2; j++) {

				double convolution = 0;

				for (int j2 = 0; j2 < dim; j2++) {
					for (int k = 0; k < dim; k++) {
						int currentPixel = original.getPixel(j2 + i - dim /2, k + j - dim / 2);
						convolution += currentPixel* gauss[j2][k];
					}
				}
				
				matrix[i - dim/2][j - dim/2] = (int) Math.ceil(convolution);		
				
			}
			
		}
		
		int[][] newMatrix = Normalizer.normalizeImage(matrix);

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				Color c = new Color(newMatrix[i][j], newMatrix[i][j],
						newMatrix[i][j]);
				filteredImage.setPixel(i, j, c.getRGB());
			}
		}

		return filteredImage;
		
	}

	public static double[][] getGaussian(double sigma, int dim) {

		double[][] gauss = new double[dim][dim];
		double s = 2.0 * sigma * sigma;

		// generate dimXdim kernel
		for (int x = -dim / 2; x <= dim / 2; x++) {
			for (int y = -dim / 2; y <= dim / 2; y++) {
				gauss[x + dim / 2][y + dim / 2] = (Math.exp(-(x * x + y * y)
						/ s))
						/ (Math.PI * s);
			}
		}

		return gauss;

	}

}
