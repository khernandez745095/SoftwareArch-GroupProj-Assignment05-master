import java.awt.Dimension;

import javax.swing.JFrame;

import view.ConsoleWindow;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setLocation(300, 150);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(new Dimension(500, 500));
		window.setTitle("Key Word In Context");
		var consoleWindow = new ConsoleWindow(window);
		consoleWindow.init();

		window.pack();
		window.setVisible(true);
	}
}
