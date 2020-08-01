package Main;

import javax.swing.JFrame;

public class Game {
	
	public GamePanel gp;
	
	public Game() {
		gp = new GamePanel();
		JFrame frame = new JFrame("Boomerland Testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(gp);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.addKeyListener(new KeyFunctioner(this));
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
