package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import filtering.Utils;
import filtering.noises.SaltAndPepperNoise;
import filtering.noises.SaltAndPepperWithLinearNoise;
import filtering.noises.UniformNoise;
import model.Editor;
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

	}

}
