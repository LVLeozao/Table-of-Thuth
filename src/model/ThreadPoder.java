package model;

import java.awt.Rectangle;
import java.util.ArrayList;

public class ThreadPoder extends Thread {

	private Personagem personagem;
	private int direcao;
	private boolean intersect;
	private ArrayList<Rectangle> matzColisao;
	private ArrayList<Personagem> personagens;
	
	
	public ThreadPoder(Personagem personagem, int direcao, ArrayList<Rectangle> matzColisao, ArrayList<Personagem> personagens) {
		this.personagem = personagem;
		this.direcao = direcao;
		this.matzColisao = matzColisao;
		
		this.personagens = personagens;
		
		
		
	
		
	}
	
	public Boolean descontarVida(){
		for (Personagem obj : personagens) {
			
	
			
			if(!personagem.getBounds().intersects(obj.getBounds())){
			
		
				if(personagem.getPoder().getBound().intersects(obj.getBounds())){
				
					obj.setQntVida(obj.getQntVida()-personagem.getPoder().getDano());
					return false;
				}
								
			}
		}
		return true;
	}
	
	public void run() {
		int x = 0;
		
		while (x < personagem.getPoder().getDistancia()) {
			personagem.getPoder().setAtivo(true);
			
			
			if (direcao == 0 &&VerificarColisao.verificarColisaoPoder(personagem.getPoder().getPosX(),
					personagem.getPoder().getPosY() + 32, matzColisao, personagem.getPoder())) {
				
				if(descontarVida()){
					personagem.getPoder().setPosY(personagem.getPoder().getPosY() + 32);	
				}
				else{
					break;
				}
			
			}

			else if (direcao == 1 && VerificarColisao.verificarColisaoPoder(personagem.getPoder().getPosX() - 32,
					personagem.getPoder().getPosY(), matzColisao, personagem.getPoder())) {
				
				
				
				if(descontarVida()){
					personagem.getPoder().setPosX(personagem.getPoder().getPosX()-32);
				}
				else{
					break;
				}
			

			} 
			
			else if (direcao == 2 && VerificarColisao.verificarColisaoPoder(personagem.getPoder().getPosX() + 32,
					personagem.getPoder().getPosY(), matzColisao, personagem.getPoder())) {
				
				if(descontarVida()){
					personagem.getPoder().setPosX(personagem.getPoder().getPosX() + 32);
				}
				else{
					break;
				}
			
				
			} 
			
			else if (direcao == 3 && VerificarColisao.verificarColisaoPoder(personagem.getPoder().getPosX(),
					personagem.getPoder().getPosY() - 32, matzColisao, personagem.getPoder())) {
				
				if(descontarVida()){
					personagem.getPoder().setPosY(personagem.getPoder().getPosY() - 32);
				}
				else{
					break;
				}
			
			}

			else{
				break;
			}
			
			personagem.getPoder().setAparencia(x);
			
			
			
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			x++;
			
			
			
			
		}
		
		personagem.getPoder().setAtivo(false);
		
		

		
	}

}
