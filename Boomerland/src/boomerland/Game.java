package boomerland;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {

	private JFrame frame;
	private Thread thread;
	private boolean running = false;
	
	private String title;
	private int WIDTH = 800;
	private int HEIGHT = 600;
	
	public int FRAME_RATE = 0;
	
	BufferedImage image;
	Graphics imageGraphics;
	
	public Game() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		imageGraphics = image.createGraphics();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
			running = true;
		}
	}
	
	public synchronized void stop() {
		if(running == true) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
