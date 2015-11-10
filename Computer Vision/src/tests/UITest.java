package tests;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import control.MenuController;
import model.Editor;
import model.Utils;
import view.Board;
import view.MenuBar;

public class UITest {
	
	public static void main(String[] args) {
		
		Editor editor = new Editor();
		
		JFrame frame = Utils.createFrame("Image Filtrator",700,1200);
		frame.setLayout(new BorderLayout());
		
		Board board = new Board(editor);
		frame.add(board, BorderLayout.CENTER);
		
		MenuBar bar = new MenuBar();
		frame.setJMenuBar(bar.getBar());
		
		MenuController menuContr = new MenuController(editor, bar);
		menuContr.setListeners();
		
		frame.getContentPane().add(board);	
		frame.setVisible(true);
	}

}
