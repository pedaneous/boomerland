package boomerland.GameState;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import boomerland.Game;
import boomerland.image.ImageLoader;

public class GameStateManager {

	ImageLoader imgLoader;
	public int currentState = 0;
	private Game game;
	
	private ArrayList<BufferedImage> bg = new ArrayList<BufferedImage>();
	
	public GameStateManager(Game game) {
		this.game = game;
		imgLoader = new ImageLoader();
		for(int i = 1; i <= 5; i++) {
			bg.add(imgLoader.loadImage("level/jungle/plx-"+i+".png"));
		}
	}
	
	public void render(Graphics g) {
		if(currentState == 0) {
			g.drawImage(bg.get(0), 0, 0, game.WIDTH * game.SCALE, game.HEIGHT * game.SCALE, null);
			g.drawImage(bg.get(1), 0, 0, game.WIDTH * game.SCALE, game.HEIGHT * game.SCALE, null);
			g.drawImage(bg.get(2), 0, 0, game.WIDTH * game.SCALE, game.HEIGHT * game.SCALE, null);
			g.drawImage(bg.get(3), 0, 0, game.WIDTH * game.SCALE, game.HEIGHT * game.SCALE, null);
			g.drawImage(bg.get(4), 0, 0, game.WIDTH * game.SCALE, game.HEIGHT * game.SCALE, null);
		}
	}
	
	
	
}
