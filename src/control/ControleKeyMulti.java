package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Personagem;
import model.Protagonista;

public class ControleKeyMulti implements KeyListener{
	private Protagonista p1;
	private Protagonista p2;
	
	
	public ControleKeyMulti(Protagonista p1, Protagonista p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

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
		
		else if(e.getKeyCode() == p2.getDirecoes()[0]){
			p2.setAction(0);
		}
		else if(e.getKeyCode() == p2.getDirecoes()[1]){
			p2.setAction(1);
		}
		else if(e.getKeyCode() == p2.getDirecoes()[2]){
			p2.setAction(2);
		}
		else if(e.getKeyCode() == p2.getDirecoes()[3]){
			p2.setAction(3);
		}
		else if(e.getKeyCode() == p2.getDirecoes()[4]){
			p2.setAction(4);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		for (int i = 0; i <= 4; i++) {
			if(e.getKeyCode() == p1.getDirecoes()[i] && i == p1.getAction()){
				p1.setAction(-1);
			}
			
			if(e.getKeyCode() == p2.getDirecoes()[i] &&  i == p2.getAction()){
				p2.setAction(-1);
			}
		}

		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
