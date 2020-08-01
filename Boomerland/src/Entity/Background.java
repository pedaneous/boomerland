package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.GamePanel;

public class Background {

	private int x = 0;
	private int dx = 0;
	private BufferedImage image;
	
	public Background(BufferedImage image) {
		this.image = image;
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, x, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		if(x < 0) {
			g.drawImage(image, x + GamePanel.WIDTH, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		}
		if(x > 0) {
			g.drawImage(image, x - GamePanel.WIDTH, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		}
	}
	
	public void update() {
		x += dx;
		if(x < -GamePanel.WIDTH) {
			x = 0;
		}
	}
	
	public void setVector(int x) {dx = x;}
	
}
