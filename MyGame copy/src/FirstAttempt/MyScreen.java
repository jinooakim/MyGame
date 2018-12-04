package FirstAttempt;

import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class MyScreen extends JFrame {
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
/**
 * 
 */
	//constructor method, this occurs when you call a previously declared method
	public MyScreen() {
		//this is current instance
		this.setSize(1200,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
			}
		
	//you need a main method to run a program
	public static void main(String[] args) {
		//calls new MyScreen from 12
		MyScreen screen = new MyScreen();
		MyCanvas canvas = new MyCanvas();
		screen.getContentPane().add(canvas);
	}
}
