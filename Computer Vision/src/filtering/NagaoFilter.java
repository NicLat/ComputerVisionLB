package filtering;

import java.awt.Color;

/**
 * Il filtro di Nagao si ottiene calcolando media e varianza di 9 sottofinestre (a petali) circostanti il pixel corrente.
 * Di queste sottofinestre si seleziona quella con varianza minore. La media di quest'ultima diventa il valore del pixel corrente.
 * @author nicola
 */
public class NagaoFilter implements IFilter {

	int kernelSize;
	int limInf;
	int limMid;
	int limSup;

	public NagaoFilter(int kernelSize) {
		super();

		if (kernelSize % 2 == 0)
			kernelSize = kernelSize - 1;

		this.kernelSize = kernelSize;

		limInf = 0;
		limMid = kernelSize / 2;
		limSup = kernelSize - 1;
	}

	@Override
	public Img filter(Img original) {
		Img newImg = new Img(original.getWidth(), original.getHeight());

		for (int a = kernelSize / 2; a < original.getHeight() - kernelSize / 2; a++) {
			for (int b = kernelSize / 2; b < original.getWidth() - kernelSize / 2; b++) {

				
				// i get the sum of each nagao window and count the elements
				int[] sums = new int[9];
				for (int i = 0; i < sums.length; i++) {
					sums[i] = 0;
				}
				int[] counts = new int[9];
				for (int i = 0; i < counts.length; i++) {
					counts[i] = 0;
				}

				for (int i = 0; i < kernelSize; i++) {
					for (int j = 0; j < kernelSize; j++) {
						
						int pix = (new Color(original.getPixel( a - kernelSize/2 + i , b - kernelSize/2 + j))).getRed();  

						if (i != limInf && i != limSup && j != limInf && j != limSup) {
							sums[0] += pix;
							counts[0]++;
						}
						if (i <= j && i + j < kernelSize
								&& !((i == limInf && j == limInf) || (i == limInf && j == limSup))) {
							sums[1] += pix;
							counts[1]++;
						}

						if (i <= j && i + j >= limSup
								&& !((i == limInf && j == limSup) || (i == limSup && j == limSup))) {
							sums[2] += pix;
							counts[2]++;
						}

						if (i >= j && i + j >= limSup
								&& !((i == limSup && j == limSup) || (i == limSup && j == limInf))) {
							sums[3] += pix;
							counts[3]++;
						}

						if (i >= j && i + j < kernelSize
								&& !((i == limSup && j == limInf) || (i == limInf && j == limInf))) {
							sums[4] += pix;
							counts[4]++;
						}

						if (i <= limMid && j <= limMid
								&& !((i == limInf && j == limMid) || (i == limMid && j == limInf))) {
							sums[5] += pix;
							counts[5]++;
						}

						if (i <= limMid && j >= limMid
								&& !((i == limInf && j == limMid) || (i == limMid && j == limSup))) {
							sums[6] += pix;
							counts[6]++;
						}

						if (i >= limMid && j >= limMid
								&& !((i == limSup && j == limMid) || (i == limMid && j == limSup))) {
							sums[7] += pix;
							counts[7]++;
						}

						if (i >= limMid && j <= limMid
								&& !((i == limSup && j == limMid) || (i == limMid && j == limInf))) {
							sums[8] += pix;
							counts[8]++;
						}

					}
				}
				
				// i compute the avarages
				int[] avarages = new int[9];
				for (int i = 0; i < avarages.length; i++) {
					avarages[i] = sums[i] / counts[i];
				}
				
				// i calculate the variances of each nagao window
				int[] diff = new int[9];
				for (int i = 0; i < diff.length; i++) {
					diff[i] = 0;
				}
				for (int i = 0; i < kernelSize; i++) {
					for (int j = 0; j < kernelSize; j++) {
						
						int pix = (new Color(original.getPixel( a - kernelSize/2 + i , b - kernelSize/2 + j))).getRed();  

						if (i != limInf && i != limSup && j != limInf && j != limSup) {
							diff[0] += Math.pow(avarages[0] - pix, 2);
						}
						if (i <= j && i + j < kernelSize
								&& !((i == limInf && j == limInf) || (i == limInf && j == limSup))) {
							diff[1] += Math.pow(avarages[1] - pix, 2);
						}

						if (i <= j && i + j >= limSup
								&& !((i == limInf && j == limSup) || (i == limSup && j == limSup))) {
							diff[2] += Math.pow(avarages[2] - pix, 2);
						}

						if (i >= j && i + j >= limSup
								&& !((i == limSup && j == limSup) || (i == limSup && j == limInf))) {
							diff[3] += Math.pow(avarages[3] - pix, 2);
						}

						if (i >= j && i + j < kernelSize
								&& !((i == limSup && j == limInf) || (i == limInf && j == limInf))) {
							diff[4] += Math.pow(avarages[4] - pix, 2);
						}

						if (i <= limMid && j <= limMid
								&& !((i == limInf && j == limMid) || (i == limMid && j == limInf))) {
							diff[5] += Math.pow(avarages[5] - pix, 2);
						}

						if (i <= limMid && j >= limMid
								&& !((i == limInf && j == limMid) || (i == limMid && j == limSup))) {
							diff[6] += Math.pow(avarages[6] - pix, 2);
						}

						if (i >= limMid && j >= limMid
								&& !((i == limSup && j == limMid) || (i == limMid && j == limSup))) {
							diff[7] += Math.pow(avarages[7] - pix, 2);
						}

						if (i >= limMid && j <= limMid
								&& !((i == limSup && j == limMid) || (i == limMid && j == limInf))) {
							diff[8] += Math.pow(avarages[8] - pix, 2);
						}

					}
				}
				int[] variances = new int[9];
				for (int i = 0; i < diff.length; i++) {
					variances[i] = diff[i] / counts[i];
				}
				
				// i find the minimum variance
				int min = 1000000000;
				int indexMin = 0;
				for (int i = 0; i < variances.length; i++) {
					if(variances[i] < min){
						min = variances[i];
						indexMin = i;
					}
				}
				
				// i assign to the pixel the value of the avarage of the window with the minimum variance
				Color c = new Color(avarages[indexMin],avarages[indexMin],avarages[indexMin]);
				newImg.setPixel(a, b, c.getRGB());
			}
		}

		return newImg;
	}

}
