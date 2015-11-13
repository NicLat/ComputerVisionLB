package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

import model.Editor;
import model.Utils;
import model.filters.BoxFilter;
import model.filters.CompassFilter;
import model.filters.DoGFilter;
import model.filters.KirshFilter;
import model.filters.NagaoFilter;
import model.filters.PrewittFilter;
import model.filters.RankFilter;
import model.filters.SharpeningFilter;
import model.filters.SobelModuleFilter;
import model.filters.SobelPhaseFilter;
import model.filters.ThreeOnNineFilter;
import model.noises.SaltAndPepperNoise;
import model.noises.SaltAndPepperWithLinearNoise;
import model.noises.UniformNoise;
import view.MenuBar;

public class MenuController {

	private Editor editor;
	private MenuBar bar;
	private JTextArea history;

	public MenuController(Editor editor, MenuBar bar, JTextArea history) {
		super();
		this.editor = editor;
		this.bar = bar;
		this.history = history;
	}

	public void setListeners() {

		bar.getOpen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String file = Utils.selectOpenFile(bar.getBar());
				if (!file.equals("")) {

					editor.openImage(file);
					history.setText("");
					history.append("Opened image " + file + "\n");

				}
			}
		});

		bar.getSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String file = Utils.selectSaveFile(bar.getBar());
				if (!file.equals("")) {

					editor.saveImage(file);
					history.append("Saved image " + file + "\n");

					StringTokenizer tok = new StringTokenizer(file, ".");
					PrintWriter writer;
					try {

						writer = new PrintWriter(tok.nextToken()
								+ "-history.txt", "UTF-8");
						writer.println(history.getText());
						writer.close();

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		bar.getItemsNoise()[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "k";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the k value");
				String[] res = in.getResults();
				editor.setFilter(new UniformNoise(Integer.parseInt((res[0]))));
				editor.filter();
				history.append("Applied Uniform Noise with k = " + res[0]
						+ "\n");
			}
		});

		bar.getItemsNoise()[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[2];
				p[0] = "a";
				p[1] = "b";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the bounds of the noise");
				String[] res = in.getResults();
				editor.setFilter(new SaltAndPepperNoise(Double
						.parseDouble((res[0])), Double.parseDouble((res[1]))));
				editor.filter();
				history.append("Applied Salt&Pepper Noise with a = " + res[0]
						+ " and b = " + res[1] + "\n");
			}
		});

		bar.getItemsNoise()[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[3];
				p[0] = "a";
				p[1] = "b";
				p[2] = "k";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the bounds of the noise and the constant k");
				String[] res = in.getResults();
				editor.setFilter(new SaltAndPepperWithLinearNoise(Double
						.parseDouble((res[0])), Double.parseDouble((res[1])),
						Integer.parseInt((res[2]))));
				editor.filter();
				history.append("Applied Mixed Noise with a = " + res[0]
						+ ", b = " + res[1] + " and k = " + res[2] + "\n");
			}
		});

		bar.getItemsFilter()[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new BoxFilter());
				editor.filter();
				history.append("Applied Box Filter\n");

			}
		});

		bar.getItemsFilter()[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new SharpeningFilter());
				editor.filter();
				history.append("Applied Sharpening Filter\n");
			}
		});

		bar.getItemsFilter()[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "w";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the window width");
				String[] res = in.getResults();
				editor.setFilter(new RankFilter(Integer.parseInt((res[0]))));
				editor.filter();
				history.append("Applied Rank Filter with w = " + res[0] + "\n");
			}
		});

		bar.getItemsFilter()[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new SobelModuleFilter());
				editor.filter();
				history.append("Applied Sobel Module Filter\n");
			}
		});

		bar.getItemsFilter()[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new SobelPhaseFilter());
				editor.filter();
				history.append("Applied Sobel Phase Filter\n");
			}
		});

		bar.getItemsFilter()[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new KirshFilter());
				editor.filter();
				history.append("Applied Kirsh Filter\n");
			}
		});

		bar.getItemsFilter()[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[2];
				p[0] = "v1";
				p[1] = "v2";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the two variances");
				String[] res = in.getResults();
				editor.setFilter(new DoGFilter(Double.parseDouble((res[0])),
						Double.parseDouble((res[1]))));
				editor.filter();
				history.append("Applied DoG Filter with v1 = " + res[0]
						+ " and v2 = " + res[1] + "\n");
			}
		});

		bar.getItemsFilter()[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[2];
				p[0] = "p";
				p[1] = "tau";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert p and tau");
				String[] res = in.getResults();
				editor.setFilter(new ThreeOnNineFilter(Double
						.parseDouble((res[0])), Double.parseDouble((res[1]))));
				editor.filter();
				history.append("Applied Three on Nine Filter with p = "
						+ res[0] + " and tau = " + res[1] + "\n");
			}
		});

		bar.getItemsFilter()[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "s";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the size of the nagao kernel (odd number)");
				String[] res = in.getResults();
				editor.setFilter(new NagaoFilter(Integer.parseInt((res[0]))));
				editor.filter();
				history.append("Applied Nagao Filter with kernel size = "
						+ res[0] + "\n");
			}
		});

		bar.getItemsFilter()[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new CompassFilter());
				editor.filter();
				history.append("Applied Compass Filter\n");

			}
		});

		bar.getItemsFilter()[10].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new PrewittFilter());
				editor.filter();
				history.append("Applied Prewitt Filter\n");

			}
		});
	}

}
