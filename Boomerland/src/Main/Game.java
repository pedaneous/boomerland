package Main;

import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Boomerland Testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new GamePanel());
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
