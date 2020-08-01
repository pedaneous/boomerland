package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Background;

public class TitleMenu extends GameState {

	private Color titleColor = new Color(201, 0, 0);
	private Font titleFont = new Font("Century Gothic", Font.PLAIN, 28);
	private Font font = new Font("Arial", Font.PLAIN, 18);
	private Color selectionColor = new Color(255, 0, 0);
	private Color optionColor = new Color(255, 255, 255);
	
	private int selection = 0;
	private String[] options = {
		"Start",
		"Help",
		"Exit"
	};
	
	private Background background;
	
	private GameStateManager gsm;
	
	public TitleMenu(GameStateManager gsm) {
		this.gsm = gsm;
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
		g.setFont(titleFont);
		g.setColor(titleColor);
		g.drawString("Boomerland", 83, 70);
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == selection) {
				g.setColor(selectionColor);
			} else {
				g.setColor(optionColor);
			}
			g.drawString(options[i], 135, i * 5 * 4 + 120);
		}
	}
	
	@Override
	public void update() {
		background.update();
	}

	public void select() {
		if(selection == 0) {
			//start
			gsm.setState(gsm.LEVEL1_STATE);
		}
		if(selection == 1) {
			//help
		}
		if(selection == 2) {
			//quit
			System.exit(0);
		}
	}
	
	@Override
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_UP) {
			selection--;
			if(selection < 0) {
				selection = options.length - 1;
			}
		}
		if(key == KeyEvent.VK_DOWN) {
			selection++;
			if(selection > options.length - 1) {
				selection = 0;
			}
		}
		if(key == KeyEvent.VK_ENTER) {
			select();
		}
	}

	@Override
	public void keyReleased(int key) {
		
	}

}
