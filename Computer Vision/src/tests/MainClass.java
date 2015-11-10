package tests;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import control.MenuController;
import filtering.Utils;
import model.Editor;
import view.Board;
import view.MenuBar;

public class MainClass {
	
	public static void main(String[] args) {
		
		Editor editor = new Editor();
		
		JFrame frame = Utils.createFrame("Image Filtrator");
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
