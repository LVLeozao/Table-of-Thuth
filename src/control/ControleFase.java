package control;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Bau;
import model.Inimigo;
import model.Personagem;
import model.Protagonista;
import model.ThreadInimigo;
import view.Draw;
import view.TelaJogo;
import view.TelaOr;

public class ControleFase extends Thread{
	
	private TelaJogo telaJogo;
	private ThreadInimigo thread1, thread3, thread2;
	private ArrayList<Personagem> personagens;
	private Protagonista protagonista;
	private ArrayList<Bau> baus;
	private ArrayList<Rectangle> matzColisao;
	private Boolean pausa;
	
	public ControleFase(TelaJogo telaJogo, Protagonista protagonista){
		
		this.telaJogo = telaJogo;
		this.protagonista = protagonista;
		this.telaJogo.getPersonagens().add(protagonista);
		this.personagens = telaJogo.getPersonagens();
		
		this.pausa = false;
		this.baus = telaJogo.getBaus();
		this.matzColisao = telaJogo.getMatzColisao();
		ativarThread();
		this.telaJogo.setTelaAtiva(true);
	}
	
	public void ativarThread(){
		System.out.println(this.personagens.get(3));
		thread1 = new ThreadInimigo(this.personagens.get(0), this.personagens, this.matzColisao);
		thread1.start();
		thread2 = new ThreadInimigo(this.personagens.get(1), this.personagens, this.matzColisao);
		thread2.start();
		thread3 = new ThreadInimigo(this.personagens.get(2), this.personagens, this.matzColisao);
		thread3.start();
		
	}
	
	public void desativarThread(){
		thread1.stop();
		thread2.stop();
		thread3.stop();
		
	}
	
	public void verificarVidaPersonagens(){

		for (Personagem personagem : this.personagens) {
			if(personagem.isCondicaoExistencia() == true){
				if(personagem.getQntVida() <=0){
					personagem.setCondicaoExistencia(false);
					personagem.getLifeBar().setVisible(false);
					personagem.setBounds(0, 0);
				}
				
				else{
					personagem.getLifeBar().setValue(personagem.getQntVida());
				}
			}
			
			}
		
	}
	
	public void run(){
			
		while(true){
			while(!this.pausa){
				if(telaJogo.getTelaAtiva()){
					verificarVidaPersonagens();
					telaJogo.repaint();
				}
						
			}
		}
		
		
	}

}
