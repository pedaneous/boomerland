package GameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.GamePanel;

public class GameStateManager {

	ArrayList<GameState> gameStates = new ArrayList<GameState>();
	private int currentState = 0;
	
	public final static int MENU_STATE = 0;
	
	public GameStateManager(GamePanel gp) {
		gameStates.add(new TitleMenu());
	}
	
	public void draw(Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}
	
	public void update(Graphics2D g) {
		gameStates.get(currentState).update();
	}
	
	public void setState(int i) {currentState = i;}
	
	public void keyPressed(int key) {
		gameStates.get(currentState).keyPressed(key);
	}
	
	public void keyReleased(int key) {
		gameStates.get(currentState).keyReleased(key);
	}
	
}
