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
	private int up, down, left, right, direcaoPoder;
	private ArrayList<Rectangle> matzColisao;
	private ThreadPoder threadPoder;
	private ArrayList<Personagem> personagens;
	private int direcao = -1;
	private int passos = 4;
	private int tempoThreadMovimento = 25;


	public ControlePersonagem(Protagonista protagonista, ArrayList<Rectangle> matzColisao, ArrayList<Personagem> personagens) {
		this.protagonista = protagonista;
		this.matzColisao = matzColisao;
		this.personagens = personagens;
	
		
	}

	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == this.protagonista.getDirecoes()[4]){
			this.direcao = 0;
		}
			
		
		if (e.getKeyCode() == this.protagonista.getDirecoes()[0]) {
			this.direcao = 1;
		}

		else if (e.getKeyCode() == this.protagonista.getDirecoes()[1]) {
			
			this.direcao = 2;

		}

		else if (e.getKeyCode() == this.protagonista.getDirecoes()[3]) {
			this.direcao = 3;

		}

		else if (e.getKeyCode() == this.protagonista.getDirecoes()[2]) {
			
			this.direcao = 4;
		}
		
		else if(e.getKeyCode() == this.protagonista.getDirecoes()[5]){
			this.direcao = 5;
			
		}
		
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.direcao = -1;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	
	public void run(){
		while(true){
			switch (direcao) {
				case 0:
					
					if (threadPoder == null || threadPoder.isAlive() == false) {
						
						protagonista.getPoder().setPosX(protagonista.getPosX());
						protagonista.getPoder().setPosY(protagonista.getPosY());
						
						if (protagonista.getAparencia() == 0 || protagonista.getAparencia() == 4
								|| protagonista.getAparencia() == 8) {
							this.direcaoPoder = 0;
						}

						else if (protagonista.getAparencia() == 1 || protagonista.getAparencia() == 5
								|| protagonista.getAparencia() == 9) {
							this.direcaoPoder = 1;
						}

						if (protagonista.getAparencia() == 2 || protagonista.getAparencia() == 6
								|| protagonista.getAparencia() == 10) {
							this.direcaoPoder = 2;
						}
						if (protagonista.getAparencia() == 3 || protagonista.getAparencia() == 7
								|| protagonista.getAparencia() == 11) {
							this.direcaoPoder = 3;
						}
						
						
						threadPoder = new ThreadPoder(protagonista, this.direcaoPoder, matzColisao, personagens);
						threadPoder.start();	
						
					}
					break;
				case 1:
					
					if(VerificarColisao.verificarColisao(protagonista.getPosX(), protagonista.getPosY() + passos, matzColisao, protagonista) &&
				VerificarColisao.verificarColisaoPersonagens(protagonista, personagens)){
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

					protagonista.setPosY(protagonista.getPosY() + passos);
					if (down == 2) {
						down = 0;
					} 
					else {
						down += 1;
					}
					
					}
					
					break;
				
				case 2:
					if(VerificarColisao.verificarColisao(protagonista.getPosX(),
							protagonista.getPosY() - passos, matzColisao, protagonista) &&
							VerificarColisao.verificarColisaoPersonagens(protagonista, personagens)){
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
					
					
					break;
				case 3:
					if(VerificarColisao.verificarColisao(protagonista.getPosX() - passos, protagonista.getPosY(), matzColisao, protagonista) &&
							VerificarColisao.verificarColisaoPersonagens(protagonista, personagens)){
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
					
					
					break;
				
				case 4:
					
					if(VerificarColisao
							.verificarColisao(protagonista.getPosX() + passos, protagonista.getPosY(), matzColisao, protagonista) &&
							VerificarColisao.verificarColisaoPersonagens(protagonista, personagens)){
						

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
					
					break;
				
				case 5:
					this.protagonista.setIntersectBau(true);
					break;
		}
			
			try {
				Thread.sleep(this.tempoThreadMovimento);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getTempoThreadMovimento() {
		return tempoThreadMovimento;
	}

	public void setTempoThreadMovimento(int tempoThreadMovimento) {
		this.tempoThreadMovimento = tempoThreadMovimento;
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

}
