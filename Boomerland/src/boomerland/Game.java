package boomerland;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {

	private JFrame frame;
	private Thread thread;
	private boolean running = false;
	
	private String title = "Boomerland Testing";
	private int WIDTH = 800;
	private int HEIGHT = 600;
	
	public int FRAME_RATE = 0;
	
	BufferedImage image;
	Graphics imageGraphics;
	
	int x = 0, y = 0;
	
	public Game() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		imageGraphics = image.createGraphics();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
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
		imageGraphics.setColor(Color.black);
		imageGraphics.fillRect(0, 0, 800, 600);
		imageGraphics.setColor(Color.white);
		imageGraphics.fillRect(x, y, 50, 50);
		g.drawImage(image, 0, 0, null);
	}
	
	private void update() {
		x += 1;
		y += 1;
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
