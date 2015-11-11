package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Editor;
import model.Utils;
import model.filters.BoxFilter;
import model.filters.DoGFilter;
import model.filters.KirshFilter;
import model.filters.NagaoFilter;
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

	public MenuController(Editor editor, MenuBar bar) {
		super();
		this.editor = editor;
		this.bar = bar;
	}

	public void setListeners() {

		bar.getOpen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String file = Utils.selectOpenFile(bar.getBar());
				if (!file.equals(""))
					editor.openImage(file);
			}
		});

		bar.getSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String file = Utils.selectSaveFile(bar.getBar());
				if (!file.equals(""))
					editor.saveImage(file);
			}
		});

		bar.getItemsNoise()[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "k";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p, "Insert the k value");
				String[] res = in.getResults();
				editor.setFilter(new UniformNoise(Integer.parseInt((res[0]))));
				editor.filter();
			}
		});

		bar.getItemsNoise()[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[2];
				p[0] = "a";
				p[1] = "b";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p, "Insert the bounds of the noise");
				String[] res = in.getResults();
				editor.setFilter(new SaltAndPepperNoise(Double.parseDouble((res[0])), Double.parseDouble((res[1]))));
				editor.filter();
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
				editor.setFilter(new SaltAndPepperWithLinearNoise(Double.parseDouble((res[0])),
						Double.parseDouble((res[1])), Integer.parseInt((res[2]))));
				editor.filter();
			}
		});

		bar.getItemsFilter()[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new BoxFilter());
				editor.filter();
			}
		});

		bar.getItemsFilter()[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new SharpeningFilter());
				editor.filter();
			}
		});

		bar.getItemsFilter()[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "w";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p, "Insert the window width");
				String[] res = in.getResults();
				editor.setFilter(new RankFilter(Integer.parseInt((res[0]))));
				editor.filter();
			}
		});

		bar.getItemsFilter()[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new SobelModuleFilter());
				editor.filter();
			}
		});

		bar.getItemsFilter()[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new SobelPhaseFilter());
				editor.filter();
			}
		});

		bar.getItemsFilter()[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new KirshFilter());
				editor.filter();
			}
		});

		bar.getItemsFilter()[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[3];
				p[0] = "v1";
				p[1] = "v2";
				p[2] = "size";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the two variances and the kernel size");
				String[] res = in.getResults();
				editor.setFilter(new DoGFilter(Double.parseDouble((res[0])), Double.parseDouble((res[1])),
						Integer.parseInt((res[2]))));
				editor.filter();
			}
		});

		bar.getItemsFilter()[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[2];
				p[0] = "p";
				p[1] = "tau";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p, "Insert p and tau");
				String[] res = in.getResults();
				editor.setFilter(new ThreeOnNineFilter(Double.parseDouble((res[0])), Double.parseDouble((res[1]))));
				editor.filter();
			}
		});
		
		bar.getItemsFilter()[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "s";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p, "Insert the size of the nagao kernel (odd number)");
				String[] res = in.getResults();
				editor.setFilter(new NagaoFilter(Integer.parseInt((res[0]))));
				editor.filter();
			}
		});
	}

}
