package GameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public abstract class GameState {
	
	public abstract void draw(Graphics2D g);
	public abstract void update();
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	
}