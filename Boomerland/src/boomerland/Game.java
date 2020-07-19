package boomerland;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private JFrame f;
	private final String TITLE = "Boomerland";
	private final Dimension SIZE;
	
	private Thread thread;
	private boolean running = false;
	
	public int FRAME_RATE = 0;
	public int MAX_FRAME_RATE = 60;
	
	public Game() {
		SIZE = new Dimension(800, 600);
		f = new JFrame(TITLE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(SIZE);
		f.add(this);
		f.pack();
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
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
		final double ns = 1000000000D / MAX_FRAME_RATE;
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
	
	public void update() {
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, SIZE.width, SIZE.height);
		
		g.dispose();
		bs.show();
	}
	
}
