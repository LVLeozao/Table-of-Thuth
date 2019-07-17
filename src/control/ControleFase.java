package control;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Bau;
import model.Inimigo;
import model.Personagem;
import model.Protagonista;
import model.ThreadInimigo;
import view.ShowMessage;
import view.TelaInventario;
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
	private TelaInventario telaInventario;
	
	public ControleFase(TelaJogo telaJogo, Protagonista protagonista, TelaInventario telaInventario){
		
		this.telaInventario = telaInventario;
		
		this.telaJogo = telaJogo;
		
		this.protagonista = protagonista;
		this.telaJogo.getPersonagens().add(protagonista);
		this.personagens = telaJogo.getPersonagens();
		
		this.pausa = false;
		this.baus = telaJogo.getBaus();
		this.matzColisao = telaJogo.getMatzColisao();
		ativarThread();
		this.telaJogo.setTelaAtiva(true);
		this.telaJogo.addKeyListener(new ControlePersonagem(this.protagonista, this.matzColisao, this.personagens));

		this.telaInventario.add(this.protagonista.getLifeBar());
		this.telaInventario.getLbNome().setText(this.protagonista.getNome());
		this.telaInventario.getLbPontuacao().setText(this.protagonista.getPontuacao()+"");
		this.telaInventario.setIiThumb(new ImageIcon(this.protagonista.getCaminhoTumb()));
		this.telaInventario.repaint();
		
		System.out.println("CLone: "+ this.personagens.size());
		
	}
	
	
	
	public void ativarThread(){
		
		this.telaJogo.setFocusable(true);
		this.telaJogo.requestFocus();
		
		thread1 = new ThreadInimigo(this.personagens.get(0), this.personagens, this.matzColisao);
		thread1.start();
		thread2 = new ThreadInimigo(this.personagens.get(1), this.personagens, this.matzColisao);
		thread2.start();
		thread3 = new ThreadInimigo(this.personagens.get(2), this.personagens, this.matzColisao);
		thread3.start();
		
	}
	
	public void desativarThread(){
		this.telaJogo.setFocusable(false);
		thread1.stop();
		thread2.stop();
		thread3.stop();
		
	}
	
	
	public void responderQuestionario(Inimigo temp){
		int resposta = ShowMessage.activeInputDialog(temp.getTexto());
		
		Protagonista temp2  = (Protagonista) this.personagens.get(3);
		
		if(resposta == temp.getResposta()){
			this.protagonista.setPontuacao(this.protagonista.getPontuacao()+250);
			this.telaInventario.getLbPontuacao().setText(this.protagonista.getPontuacao()+"");
			this.protagonista.getLifeBar().setValue(this.protagonista.getQntVida()+100);
		}
		else{
			
			this.protagonista.getLifeBar().setValue(this.protagonista.getQntVida()-200);
		}
		
		ativarThread();
	}
	
	public void ativarBau(){
		for (Bau bau : baus){
			if(this.protagonista.getBounds().intersects(bau.getRectangle().getBounds()) && bau.getWasActivated()== false){	
					bau.mostrarInformação();
					bau.setWasActivated(true);
			}
			else if(this.protagonista.getBounds().intersects(bau.getRectangle().getBounds()) && bau.getWasActivated()== true){
				ShowMessage.showText("Báu já foi ativado!");
			}	
		}
		this.protagonista.setIntersectBau(false);
	}
	
	public void verificarVidaPersonagens(){

		for (Personagem personagem : this.personagens) {
			if(personagem.isCondicaoExistencia() == true){
				if(personagem.getQntVida() <=0){
					personagem.setCondicaoExistencia(false);
					personagem.getLifeBar().setVisible(false);
					personagem.setBounds(0, 0);
					
					if(personagem instanceof Inimigo){
						
						Inimigo temp = (Inimigo) personagem;
						desativarThread();
						responderQuestionario(temp);
						
					}
					
					
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
					
					if(this.protagonista.getIntersectBau()){
						ativarBau();
					}
					
					
				}
						
			}
		}
		
		
	}

}
