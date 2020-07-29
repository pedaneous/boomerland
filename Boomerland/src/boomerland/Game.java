package boomerland;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import boomerland.GameState.GameStateManager;

public class Game extends JPanel implements Runnable {

	private JFrame frame;
	private Thread thread;
	private boolean running = false;
	
	private String title = "Boomerland Testing";
	public int WIDTH = 320, HEIGHT = 240, SCALE = 2;
	
	public int FRAME_RATE = 0;
	
	BufferedImage image;
	Graphics imageGraphics;
	
	private GameStateManager gsm;
	
	public Game() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		imageGraphics = image.createGraphics();
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		gsm = new GameStateManager(this);
		start();
	}
	
	public synchronized void start() {
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long last = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000D / 60;
		double delta = 0;
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - last) / ns;
			last = now;
			while(delta >= 1) {
				update();
				delta--;
				render();
				frames++;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				FRAME_RATE = frames;
				frames = 0;
			}
		}
		stop();
	}
	
	private void render() {
		Graphics g = this.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		gsm.render(g);
	}
	
	private void update() {
		
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
