package boomerland.GameState;

import java.awt.Graphics;

import boomerland.Game;

public class GameStateManager {

	int currentState = 0;
	private Game game;
	
	public GameStateManager(Game game) {
		
	}
	
	public void render(Graphics g) {
		if(currentState == 0) {
			
		}
	}
	
	public void nextState() {
		currentState++;
	}
	
	public void backState() {
		currentState--;
	}
	
}
