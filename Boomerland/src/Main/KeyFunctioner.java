package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyFunctioner extends KeyAdapter {

	private Game g;
	private boolean debounce = false;
	
	public KeyFunctioner(Game g) {
		this.g = g;
	}
	
	public void keyPressed(KeyEvent e) {
		g.gp.keyPressed(e);
	}
	
}
