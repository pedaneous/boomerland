package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameState.GameStateManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {

	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	private Thread thread;
	private boolean running;
	
	public int FRAME_RATE = 0;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private GameStateManager gsm;
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		gsm = new GameStateManager(this);
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
			running = true;
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
				draw();
				drawToScreen();
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
		gsm.update(g);
	}
	
	public void draw() {
		gsm.draw(g);
		g.setColor(Color.green);
		g.setFont(new Font("Arial", 10, 10));
		g.drawString(FRAME_RATE + " fps", 0, HEIGHT-2);
	}
	
	public void drawToScreen() {
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
	}

	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}
	
}
