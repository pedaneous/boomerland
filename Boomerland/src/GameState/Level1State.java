package GameState;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Background;
import TileMap.Tile;
import TileMap.TileMap;

public class Level1State extends GameState {
	
	private GameStateManager gsm;
	
	private Background bg;
	
	private BufferedImage grass;
	
	private TileMap tileMap;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		try {
			bg = new Background(ImageIO.read(getClass().getResource("/sky1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		tileMap = new TileMap(30);
		tileMap.loadTiles("/grasstileset.gif");
		tileMap.loadMap("/level1-1.map");
		tileMap.setPosition(0, 0);
	}
	
	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		tileMap.draw(g);
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
