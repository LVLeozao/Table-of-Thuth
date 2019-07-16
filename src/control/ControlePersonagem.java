package control;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import model.Personagem;
import model.Protagonista;
import model.ThreadPoder;
import model.VerificarColisao;


public class ControlePersonagem extends Thread implements KeyListener {

	private Protagonista protagonista;
	private int up, down, left, right, direcao;
	private ArrayList<Rectangle> matzColisao;
	private ThreadPoder threadPoder;
	private ArrayList<Personagem> personagens;

	

	public ControlePersonagem(Protagonista protagonista, ArrayList<Rectangle> matzColisao, ArrayList<Personagem> personagens) {
		this.protagonista = protagonista;
		this.matzColisao = matzColisao;
		this.personagens = personagens;

		
	}

	public void keyPressed(KeyEvent e) {
		int passos = 4;
		
		if(e.getKeyCode() == KeyEvent.VK_A){
			
			
			
			if (threadPoder == null || threadPoder.isAlive() == false) {
				
				protagonista.getPoder().setPosX(protagonista.getPosX());
				protagonista.getPoder().setPosY(protagonista.getPosY());
				
				
				
				
				if (protagonista.getAparencia() == 0 || protagonista.getAparencia() == 4
						|| protagonista.getAparencia() == 8) {
					direcao = 0;
				}

				else if (protagonista.getAparencia() == 1 || protagonista.getAparencia() == 5
						|| protagonista.getAparencia() == 9) {
					direcao = 1;
				}

				if (protagonista.getAparencia() == 2 || protagonista.getAparencia() == 6
						|| protagonista.getAparencia() == 10) {
					direcao = 2;
				}
				if (protagonista.getAparencia() == 3 || protagonista.getAparencia() == 7
						|| protagonista.getAparencia() == 11) {
					direcao = 3;
				}
				
				
				threadPoder = new ThreadPoder(protagonista, direcao, matzColisao, personagens);
				threadPoder.start();	
				
				
				
				
			}
			
		
		}
			
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN && VerificarColisao.verificarColisao(protagonista.getPosX(),
				protagonista.getPosY() + passos, matzColisao, protagonista) &&
				VerificarColisao.verificarColisaoPersonagens(protagonista, personagens)) {
			protagonista.setPosY(protagonista.getPosY() + passos);
			switch (down) {
			case 0:
				protagonista.setAparencia(0);
				break;
			case 1:
				protagonista.setAparencia(4);
				break;
			case 2:
				protagonista.setAparencia(8);
				break;
			}

			if (down == 2) {
				down = 0;
			} else {
				down += 1;
			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP && VerificarColisao.verificarColisao(protagonista.getPosX(),
				protagonista.getPosY() - passos, matzColisao, protagonista) &&
				VerificarColisao.verificarColisaoPersonagens(protagonista, personagens)) {
			switch (up) {
			case 0:
				protagonista.setAparencia(3);
				break;
			case 1:
				protagonista.setAparencia(7);
				break;
			case 2:
				protagonista.setAparencia(11);
				break;
			}

			if (up == 2) {
				up = 0;
			} else {
				up += 1;
			}
			protagonista.setPosY(protagonista.getPosY() - passos);

		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT && VerificarColisao.verificarColisao(protagonista.getPosX() - passos, protagonista.getPosY(), matzColisao, protagonista) &&
				VerificarColisao.verificarColisaoPersonagens(protagonista, personagens)) {
			switch (left) {
			case 0:
				protagonista.setAparencia(1);
				break;
			case 1:
				protagonista.setAparencia(5);
				break;
			case 2:
				protagonista.setAparencia(9);
				break;
			}

			if (left == 2) {
				left = 0;
			} else {
				left += 1;
			}
			protagonista.setPosX(protagonista.getPosX() - passos);

		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT && VerificarColisao
				.verificarColisao(protagonista.getPosX() + passos, protagonista.getPosY(), matzColisao, protagonista) &&
				VerificarColisao.verificarColisaoPersonagens(protagonista, personagens)) {
			switch (right) {
			case 0:
				protagonista.setAparencia(2);
				break;  
			case 1:
				protagonista.setAparencia(6);
				break;
			case 2:
				protagonista.setAparencia(10);
				break;
			}

			if (right == 2) {
				right = 0;
			} else {
				right += 1;
			}
			protagonista.setPosX(protagonista.getPosX() + passos);

		}
		
		else if(e.getKeyCode() == KeyEvent.VK_S){
			System.out.println("Ainda não implementado;");
		}
		
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
