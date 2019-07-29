package control;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Bau;
import model.Destroy;
import model.GerarPosicao;
import model.Inimigo;
import model.Itens;
import model.Personagem;
import model.Protagonista;
import model.Som;
import model.ThreadInimigo;
import model.Timer;
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
	private Boolean ativa;
	private TelaInventario telaInventario;

	private Timer timer;
	private int qntInimigosMortos;
	private Itens itens;
	private ControlePersonagem controlePersonagem;
	
	
	public ControleFase(TelaJogo telaJogo, Protagonista protagonista, TelaInventario telaInventario, String nome){
		
		
		this.telaJogo = telaJogo;
		this.protagonista = protagonista;
		this.telaJogo.getPersonagens().add(protagonista);
		this.personagens = telaJogo.getPersonagens();
		this.protagonista.setTempo("0");
		this.baus = telaJogo.getBaus();
		this.itens = telaJogo.getItens();
		this.matzColisao = telaJogo.getMatzColisao();
		
		
		this.itens.setAtivo(true);
	
		timer = new Timer(this.telaInventario, this.protagonista);
		timer.start();

		ativarThread();
		
		this.telaJogo.setTelaAtiva(true);
		this.controlePersonagem = new ControlePersonagem(this.protagonista, this.matzColisao, this.personagens);
		this.telaJogo.addKeyListener(new ControleKeySingle(this.protagonista));
		this.controlePersonagem.start();
		
		
		
		this.telaInventario = telaInventario;
		this.telaInventario.add(this.protagonista.getLifeBar());
		this.telaInventario.getLbNome().setText(this.protagonista.getNome());
		this.telaInventario.getLbPontuacao().setText(this.protagonista.getPontuacao()+"");
		this.telaInventario.setIiThumb(new ImageIcon(this.protagonista.getCaminhoTumb()));
		this.telaInventario.setQntBaus(0);
		this.telaInventario.getLbNomeFase().setText(nome);
		
		this.telaInventario.getTimer().setText("00:00");
		
		this.qntInimigosMortos = 0;
		
		
		

		
	}
	
	public void intersectItem(){
		
		if(this.protagonista.getBounds().intersects(this.itens.getBounds())){
			action(this.protagonista, this.controlePersonagem);
		}
	}
	
	
	public void action(Protagonista protagonista, ControlePersonagem control){


		switch (this.itens.getAparencia()) {
		
			case 0:	
				
				this.thread1.setSpeed(600);
				this.thread2.setSpeed(600);
				this.thread3.setSpeed(600);
				break;
	
			case 1:
				protagonista.setQntVida(protagonista.getQntVida()+1000);
				break;
			
			case 2:
				control.setTempoThreadMovimento(control.getTempoThreadMovimento()+3);
				break;
			case 3:
				protagonista.getPoder().setDano(protagonista.getPoder().getDano()+500);
				break;
			
		}
		
		int [] a =  GerarPosicao.gerarPosicaoXY(this.telaJogo.getMatzColisao(), this.telaJogo.getCamada2().mapa);
		
		this.itens.setPosX(a[0]);
		this.itens.setPosY(a[1]);
		
		this.itens.setAparencia(new Random().nextInt(4));
		
		
	}
	
	
	
	public void ativarThread(){
		
		this.telaJogo.setFocusable(true);
		this.telaJogo.requestFocus(true);
		
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
		
		this.telaJogo.setFocusable(false);
		this.telaJogo.requestFocus(false);
		
	}
	
	
	public void responderQuestionario(Inimigo temp){
		this.protagonista.setAction(-1);
		int resposta = ShowMessage.activeInputDialog(temp.getExercicio().getText());
		
		Protagonista temp2  = (Protagonista) this.personagens.get(3);
		
		if(resposta == 0 && temp.getExercicio().getResposta().equalsIgnoreCase("true")){
			this.protagonista.setPontuacao(this.protagonista.getPontuacao()+250);
			this.telaInventario.getLbPontuacao().setText(this.protagonista.getPontuacao()+"");
			this.protagonista.getLifeBar().setValue(this.protagonista.getQntVida()+100);
			this.protagonista.getExercicios().add(temp.getExercicio());
			
			
		}
		else{
			this.protagonista.setQntVida(this.protagonista.getQntVida()-100);
		}
		
		ativarThread();
	}
	
	public void ativarBau(){
		
		for (Bau bau : baus){
		
			if(this.protagonista.getBounds().intersects(bau.getRectangle().getBounds()) && bau.getWasActivated()== false){	
					
					desativarThread();
					this.protagonista.setAction(-1);
					bau.getSomBau().play();
					bau.mostrarInformação();
					bau.setWasActivated(true);
					this.protagonista.setQntBausAbertos(this.protagonista.getQntBausAbertos()+1);
					this.telaInventario.setQntBaus(this.telaInventario.getQntBaus()+1);
					this.protagonista.setPontuacao(this.protagonista.getPontuacao()-10);
					this.telaInventario.getLbPontuacao().setText(this.protagonista.getPontuacao()+"");
					
					ativarThread();
					
					
			}
			else if(this.protagonista.getBounds().intersects(bau.getRectangle().getBounds()) && bau.getWasActivated()== true){
				desativarThread();
				this.protagonista.setAction(-1);
				ShowMessage.showText("Báu já foi ativado!");
				ativarThread();
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
						this.qntInimigosMortos+=1;
						
					}
					
					else if(personagem instanceof Protagonista){
						
						this.protagonista.setMorto(true);
					}
					
					
					
				}
				
				else{
					personagem.getLifeBar().setValue(personagem.getQntVida());
				}
				
				this.telaInventario.repaint();
			}
			
			}
		
	}
	
	public void matarControle(){
		desativarThread();
		this.controlePersonagem.stop();			
		this.timer.stop();
		this.timer = null;
		this.controlePersonagem = null;
		this.telaJogo.setTelaAtiva(false);
		this.ativa = false;
		System.gc();
	}
	
	public void faseAtiva(){
		
		if(this.qntInimigosMortos == 3){
		
		
			this.protagonista.setAction(-1);
			this.qntInimigosMortos = 0;
			this.telaJogo.setTelaAtiva(false);
			
			matarControle();
		}
	}
	
	public void setarTimer(){
		
		this.telaInventario.getTimer().setText(protagonista.getTempo());
		
	}
	
	public void run(){
			
		while(true){
			if(telaJogo.getTelaAtiva()){
				verificarVidaPersonagens();
				telaJogo.repaint();
				this.faseAtiva();
				this.setarTimer();
				this.intersectItem();
				if(this.protagonista.getIntersectBau()){
					ativarBau();
				}
			}
			else{
				break;
			}
		}
		
		
	}


	public int getQntInimigosMortos() {
		return qntInimigosMortos;
	}





	public Boolean getAtiva() {
		return ativa;
	}





	public ControlePersonagem getControlePersonagem() {
		return controlePersonagem;
	}





	public void setQntInimigosMortos(int qntInimigosMortos) {
		this.qntInimigosMortos = qntInimigosMortos;
	}





	public TelaJogo getTelaJogo() {
		return telaJogo;
	}





	public Timer getTimer() {
		return timer;
	}

}
