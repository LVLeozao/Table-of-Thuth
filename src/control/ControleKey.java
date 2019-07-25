package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Personagem;
import model.Protagonista;

public class ControleKey implements KeyListener{
	private Protagonista p1;
	private Protagonista p2;
	
	
	public ControleKey(Protagonista p1, Protagonista p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == p1.getDirecoes()[0]){
			p1.setSentido(0);
		}
		else if(e.getKeyCode() == p1.getDirecoes()[1]){
			p1.setSentido(1);
		}
		else if(e.getKeyCode() == p1.getDirecoes()[2]){
			p1.setSentido(2);
		}
		else if(e.getKeyCode() == p1.getDirecoes()[3]){
			p1.setSentido(3);
		}
		
		else if(e.getKeyCode() == p2.getDirecoes()[0]){
			p2.setSentido(0);
		}
		else if(e.getKeyCode() == p2.getDirecoes()[1]){
			p2.setSentido(1);
		}
		else if(e.getKeyCode() == p2.getDirecoes()[2]){
			p2.setSentido(2);
		}
		else if(e.getKeyCode() == p2.getDirecoes()[3]){
			p2.setSentido(3);
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		for (int i = 0; i <= 3; i++) {
			if(e.getKeyCode() == p1.getDirecoes()[i] && i == p1.getSentido()){
				p1.setSentido(-1);
			}
			
			if(e.getKeyCode() == p2.getDirecoes()[i] &&  i == p2.getSentido()){
				p2.setSentido(-1);
			}
		}

		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
