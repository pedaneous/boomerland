package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Background;

public class TitleMenu extends GameState {

	private Color titleColor = new Color(128, 0, 0);
	private Font titleFont = new Font("Century Gothic", Font.PLAIN, 28);
	private Font font = new Font("Arial", Font.PLAIN, 12);
	
	private Background background;
	
	public TitleMenu() {
		try {
			background = new Background(ImageIO.read(getClass().getResourceAsStream("/background.png")));
			background.setVector(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		background.draw(g);
	}

	@Override
	public void update() {
		background.update();
	}

	@Override
	public void keyPressed(int key) {
		
	}

	@Override
	public void keyReleased(int key) {
		
	}

}
