package GameState;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Background;

public class Level1State extends GameState {
	
	private GameStateManager gsm;
	
	private Background bg;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		try {
			bg = new Background(ImageIO.read(getClass().getResource("/sky1.png")));
			bg.setVector(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
	}

	@Override
	public void update() {
		bg.update();
	}

	@Override
	public void keyPressed(int key) {
		
	}

	@Override
	public void keyReleased(int key) {
		
	}
	
}
