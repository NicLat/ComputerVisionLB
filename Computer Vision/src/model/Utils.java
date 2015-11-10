package model;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

public class Utils {

	public static void printImage(BufferedImage im, String title) {
		ImageIcon icon = new ImageIcon(im);
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(im.getWidth(), im.getHeight());
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	
	public static String selectOpenFile(JMenuBar menuBar){
		
		JFileChooser fileChooser = new JFileChooser();
		//fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(menuBar);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    return selectedFile.getAbsolutePath();	
		}
		return "";
	}
	
	public static String selectSaveFile(JMenuBar menuBar){

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		 
		int userSelection = fileChooser.showSaveDialog(menuBar);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		    return fileToSave.getAbsolutePath();
		}
		return "";
	}
	
	public static JFrame createFrame(String str, int height, int width) {
		JFrame frame = new JFrame();
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(str);
		return frame;
	}

}
