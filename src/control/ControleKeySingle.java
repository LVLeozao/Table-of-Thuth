package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Protagonista;

public class ControleKeySingle implements KeyListener{
	private Protagonista p1;
	
	public ControleKeySingle(Protagonista p1) {
		this.p1 = p1;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == p1.getDirecoes()[0]){
			p1.setAction(0);
		}
		else if(e.getKeyCode() == p1.getDirecoes()[1]){
			p1.setAction(1);
		}
		else if(e.getKeyCode() == p1.getDirecoes()[2]){
			p1.setAction(2);
		}
		else if(e.getKeyCode() == p1.getDirecoes()[3]){
			p1.setAction(3);
		}
		
		else if(e.getKeyCode() == p1.getDirecoes()[4]){
			p1.setAction(4);
		}
		else if(e.getKeyCode() == p1.getDirecoes()[5]){
			p1.setAction(5);
		}	
	}
	
	
	public void keyReleased(KeyEvent e) {
		p1.setAction(-1);
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
