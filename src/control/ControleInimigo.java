package control;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import model.Inimigo;
import model.Personagem;
import model.ThreadPoder;
import model.VerificarColisao;

public class ControleInimigo{
	private  int passos = 4;
	private  int up, down, left, right;
	private Inimigo inimigo;
	private ArrayList<Rectangle> matzColisao;
	private ThreadPoder threadPoder;
	private ArrayList<Personagem>personagens;
	

	



	public ControleInimigo(Inimigo inimigo, ArrayList<Rectangle> matzColisao, ThreadPoder threadPoder,
			ArrayList<Personagem> personagens) {
		this.inimigo = inimigo;
		this.matzColisao = matzColisao;
		this.threadPoder = threadPoder;
		this.personagens = personagens;
	}






	public void action(int direcao){
		
		
		
		if(direcao == 0 && VerificarColisao.verificarColisao(inimigo.getPosX(), inimigo.getPosY()+ passos, matzColisao, inimigo) &&
				VerificarColisao.verificarColisaoPersonagens(inimigo, personagens)){
			inimigo.setPosY(inimigo.getPosY()+passos);
			switch (down) {
			case 0:
				inimigo.setAparencia(0);
				break;
			case 1:
				inimigo.setAparencia(4);
				break;
			case 2:
				inimigo.setAparencia(8);
				break;
			}
			
			if(down == 2){down = 0;}
			else{down+=1;}
		}
		
		else if(direcao == 1 && VerificarColisao.verificarColisao(inimigo.getPosX(), inimigo.getPosY()-passos, matzColisao, inimigo) &&
				VerificarColisao.verificarColisaoPersonagens(inimigo, personagens)){
			switch (up) {
			case 0:
				inimigo.setAparencia(3);
				break;
			case 1:
				inimigo.setAparencia(7);
				break;
			case 2:
				inimigo.setAparencia(11);
				break;
			}
			
			if(up == 2){up = 0;}
			else{up+=1;}
			inimigo.setPosY(inimigo.getPosY()-passos);

		}
		
		else if(direcao == 2 && VerificarColisao.verificarColisao(inimigo.getPosX()-passos, inimigo.getPosY(), matzColisao, inimigo) &&
				VerificarColisao.verificarColisaoPersonagens(inimigo, personagens)){
			switch (left) {
			case 0:
				inimigo.setAparencia(1);
				break;
			case 1:
				inimigo.setAparencia(5);
				break;
			case 2:
				inimigo.setAparencia(9);
				break;
			}
			
			if(left == 2){left = 0;}
			else{left+=1;}
			inimigo.setPosX(inimigo.getPosX()-passos);

		}
		
		else if(direcao == 3 && VerificarColisao.verificarColisao(inimigo.getPosX()+passos, inimigo.getPosY(), matzColisao, inimigo) &&
				VerificarColisao.verificarColisaoPersonagens(inimigo, personagens)){
			switch (right) {
			case 0:
				inimigo.setAparencia(2);
				break;
			case 1:
				inimigo.setAparencia(6);
				break;
			case 2:
				inimigo.setAparencia(10);
				break;
			}
			
			if(right == 2){right = 0;}
			else{right+=1;}
			inimigo.setPosX(inimigo.getPosX()+passos);
		
		}
		
		else if(direcao == 4){
			int tempDic = 0;
		
			
			
			if (threadPoder == null || threadPoder.isAlive() == false) {
				
				inimigo.getPoder().setPosX(inimigo.getPosX());
				inimigo.getPoder().setPosY(inimigo.getPosY());
				
				if (inimigo.getAparencia() == 0 || inimigo.getAparencia() == 4
						|| inimigo.getAparencia() == 8) {
					tempDic = 0;
				}

				else if (inimigo.getAparencia() == 1 || inimigo.getAparencia() == 5
						|| inimigo.getAparencia() == 9) {
					tempDic = 1;
				}

				if (inimigo.getAparencia() == 2 || inimigo.getAparencia() == 6
						|| inimigo.getAparencia() == 10) {
					tempDic = 2;
				}
				if (inimigo.getAparencia() == 3 || inimigo.getAparencia() == 7
						|| inimigo.getAparencia() == 11) {
					tempDic = 3;
				}
				
				
				threadPoder = new ThreadPoder(inimigo, tempDic, matzColisao, personagens);
				threadPoder.start();
			}
			
		
			
		}
		
		inimigo.getLifeBar().setBounds(inimigo.getPosX()+8, inimigo.getPosY()-12, 25, 8);
		
		
		
	}
}
