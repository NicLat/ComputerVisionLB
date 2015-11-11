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

	public DoGFilter(double variance1, double variance2) {
		super();
		this.variance1 = variance1;
		this.variance2 = variance2;
	}

	@Override
	public Img filter(Img original) {
		Img filteredImage = new Img(original.getWidth(), original.getHeight());

		int dim = (int) Math.ceil(variance2 * 6);
		if (dim % 2 == 0) {
			dim += 1;
		}

		double[][] gauss = new double[dim][dim];
		gauss = getGaussianKernel(variance1, dim);
		double[][] gauss2 = new double[dim][dim];
		gauss2 = getGaussianKernel(variance2, dim);

		double[][] gaussian = new double[dim][dim];
		
		for (int i = 0; i < gaussian.length; i++) {
			for (int j = 0; j < gaussian.length; j++) {
				gaussian[i][j] = gauss[i][j] - gauss2[i][j];
				//System.out.print(gaussian[i][j]+ " ");
			}
			//System.out.println();
		}
		
		for (int i = dim/2; i < original.getHeight() - dim/2; i++) {
			for (int j = dim/2; j < original.getWidth() - dim/2; j++) {

				double convolution = 0;

				for (int j2 = 0; j2 < dim; j2++) {
					for (int k = 0; k < dim; k++) {
						convolution += original.getPixel(j2 + i - dim/2, k + j - dim/2) * gaussian[j2][k];
					}
				}
				if (convolution < 0) {
					filteredImage.setPixel(i, j, (new Color(0,0,0)).getRGB());
				} else {
					filteredImage.setPixel(i, j, (new Color(255,255,255)).getRGB());
				}
			}
		}
		
		Img edgeDetectionedImage = edgeDetection(filteredImage);
		return edgeDetectionedImage;
	}
	
	
	private static double[][] getGaussianKernel(double sigma, int dim) {

		double[][] gauss = new double[dim][dim];
		double s = 2.0 * sigma * sigma;

		// generate dimXdim kernel
		for (int x = -dim / 2; x <= dim / 2; x++) {
			for (int y = -dim/2 ; y <= dim / 2; y++) {
				gauss[x + dim / 2][y + dim / 2] = (Math.exp(-(x*x+y*y) / s)) / (Math.PI * s);
			}
		}
		return gauss;
	}

	private Img edgeDetection(Img image) {

		Img newImg = new Img(image.getWidth(), image.getHeight());

		for (int i = 1; i < image.getHeight() - 1; i++) {
			for (int j = 1; j < image.getWidth() - 1; j++) {
				
				for (int j2 = -1; j2 <= 1; j2++) {
					for (int k = -1; k <= 1; k++) {
						if (image.getPixel(i, j) != image.getPixel(i + j2,j + k) ) {
							newImg.setPixel(i, j,  (new Color(0,0,0)).getRGB());
							k = 2;
							j2 = 2;
						} else {
							newImg.setPixel(i, j, (new Color(255,255,255)).getRGB());
						}
					}
				}
				
			}
		}
		return newImg;
	}
	
}
