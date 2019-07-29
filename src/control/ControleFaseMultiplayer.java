package control;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import model.Exercicio;
import model.GerarPosicao;
import model.Inimigo;
import model.Itens;
import model.Personagem;
import model.Protagonista;
import view.Multiplayer;
import view.ShowMessage;
import view.TelaInventario;
import view.TelaInventarioMultiplayer;
import view.TelaJogo;
import view.TelaJogoMultiplayer;

public class ControleFaseMultiplayer extends Thread{
	private TelaJogoMultiplayer telaJogo;
	private ArrayList<Personagem> personagens;
	private Protagonista player1, player2;
	private ArrayList<Rectangle> matzColisao;
	private Boolean ativa;
	private TelaInventarioMultiplayer telaInventario;
	private Itens itens;
	private ControlePersonagem controlePersonagem, controlePersonagem2;
	
	public ControleFaseMultiplayer(Multiplayer multi, TelaJogoMultiplayer telaJogo){
		this.telaJogo = telaJogo;
		this.personagens = telaJogo.getPersonagens();
		this.itens = telaJogo.getItens();
		this.matzColisao = telaJogo.getMatzColisao();
		this.itens.setAtivo(true);
		this.telaJogo.setTelaAtiva(true);
		
		this.player1 = this.telaJogo.getPlayer1();
	
		this.player2 = this.telaJogo.getPlayer2();

		
		this.controlePersonagem = new ControlePersonagem(this.player1, this.matzColisao, this.personagens);
		this.controlePersonagem2 = new ControlePersonagem(this.player2, this.matzColisao, this.personagens);
		this.telaJogo.addKeyListener(new ControleKeyMulti(this.player1, this.player2));
		
		this.controlePersonagem.start();
		this.controlePersonagem2.start();
		
		
		this.telaInventario = multi.getTelaInventarioMultiplayer();
		this.telaInventario.getLbNomePlayer1().setText(multi.getTelaFloresta().getPlayer1().getNome());
		this.telaInventario.getLbNomePlayer2().setText(multi.getTelaFloresta().getPlayer2().getNome());
	
		this.telaInventario.getTextArea().setText(
				"Player 1:\nDano: "+ this.player1.getPoder().getDano() + 
				"\nVelocidade: "+ this.controlePersonagem.getTempoThreadMovimento() +
				
				"\n\nPlayer 2:\nDano: "+ this.player2.getPoder().getDano() + 
				"\nVelocidade: "+ this.controlePersonagem2.getTempoThreadMovimento());	
		
		this.telaInventario.repaint();
	
		
		
	}
	
	public void intersectItem(){
		
		if(this.player1.getBounds().intersects(this.itens.getBounds())){
			action(this.player1, this.controlePersonagem);
		}
		
		else if(this.player2.getBounds().intersects(this.itens.getBounds())){
			action(this.player2, this.controlePersonagem2);
		}
		
		
	}
	public void responderQuestionario(Protagonista protagonista){
		
		this.player1.setAction(-1);
		this.player2.setAction(-1);
	
		Random random = new Random();
		
		int x = random.nextInt(5);
		
		Exercicio temp = this.telaJogo.getExercicios().get(x);
		
		
		int resposta = ShowMessage.activeInputDialog(temp.getText());
		
		
		
		if(resposta == 0  && temp.getResposta().equalsIgnoreCase("true")){
			protagonista.setPontuacao(protagonista.getPontuacao()+250);
			
		}
		else if(resposta == 1  && temp.getResposta().equalsIgnoreCase("false")){
			protagonista.setPontuacao(protagonista.getPontuacao()-150);
		}
		
		ativar();
		
	}
	
	public void desativar(){
			
		this.telaJogo.setFocusable(false);
		this.telaJogo.requestFocus(false);

	}

	public void ativar(){
		
		this.telaJogo.setFocusable(true);
		this.telaJogo.requestFocus(true);

	}
	
	
	public void action(Protagonista protagonista, ControlePersonagem control){
		this.player1.setAction(-1);
		this.player2.setAction(-1);
		this.desativar();
		switch (this.itens.getAparencia()) {
		
			case 0:	
				
				if(control.getTempoThreadMovimento()>10)
					control.setTempoThreadMovimento(control.getTempoThreadMovimento()-3);
				
				break;
	
			case 1:
				protagonista.setQntVida(protagonista.getQntVida()+1000);
				break;
			
			case 2:
				if(this.player1.getBounds().intersects(this.itens.getBounds())){
					controlePersonagem2.setTempoThreadMovimento(controlePersonagem2.getTempoThreadMovimento()+3);
				}
				else if(this.player2.getBounds().intersects(this.itens.getBounds())){
					controlePersonagem.setTempoThreadMovimento(controlePersonagem.getTempoThreadMovimento()+3);
				}
				break;
			case 3:
				protagonista.getPoder().setDano(protagonista.getPoder().getDano()+500);
				break;
			case 4:
				this.telaJogo.setFocusable(false);
				
				this.responderQuestionario(protagonista);
				
				break;
				
			
				
			
			
		}
		this.telaInventario.getTextArea().setText(
				"Player 1:\nDano: "+ this.player1.getPoder().getDano() + 
				"\nVelocidade: "+ this.controlePersonagem.getTempoThreadMovimento() +
				
				"\n\nPlayer 2:\nDano: "+ this.player2.getPoder().getDano() + 
				"\nVelocidade: "+ this.controlePersonagem2.getTempoThreadMovimento());			
			
		int [] a =  GerarPosicao.gerarPosicaoXY(this.telaJogo.getMatzColisao(), this.telaJogo.getCamada2().mapa);
		
		
		this.itens.setPosX(a[0]);
		this.itens.setPosY(a[1]);
			
		this.itens.setAparencia(new Random().nextInt(4));	
		
		ativar();
	
	}
	
	public void verificarVidaPersonagens(){

		for (Personagem personagem : this.personagens) {
			if(personagem.isCondicaoExistencia() == true){
				if(personagem.getQntVida() <=0){
			
					if(this.player1.getQntVida() <=0){
						this.player1.setMorto(true);
					}
					else if(this.player2.getQntVida() <=0){
						this.player2.setMorto(true);
					}
					
					
				}
				
				else{
					this.telaInventario.getBarPlayer1().setValue(this.player1.getQntVida());
					this.telaInventario.getBarPlayer2().setValue(this.player2.getQntVida());
					this.telaInventario.getBarPlayer1().setToolTipText(this.player1.getQntVida()+"/"+this.telaInventario.getBarPlayer1().getMaximum());
					this.telaInventario.getBarPlayer2().setToolTipText(this.player2.getQntVida()+"/"+this.telaInventario.getBarPlayer2().getMaximum());
					this.telaInventario.getLbPontuacaoPlayer1().setText(this.player1.getPontuacao()+"");
					this.telaInventario.getLbPontuacaoPlayer2().setText(this.player2.getPontuacao()+"");
				
				}
				
				this.telaInventario.repaint();
			}
			
			}
		
	}
	
	public void matarControle(){
		desativar();
		this.controlePersonagem.stop();	
		this.controlePersonagem2.stop();
		
		this.controlePersonagem = null;
		this.controlePersonagem2 = null;
		this.telaJogo.setTelaAtiva(false);
		this.ativa = false;
		System.gc();
	}
	
	public void run(){
		while(true){
			if(telaJogo.getTelaAtiva()){
				verificarVidaPersonagens();
				telaJogo.repaint();
				this.intersectItem();
			}
			else{
				break;
			}
		}
	}

	public TelaJogoMultiplayer getTelaJogo() {
		return telaJogo;
	}
	
	
	
	
}
