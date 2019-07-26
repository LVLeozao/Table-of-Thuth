package control;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Bau;

import model.Inimigo;
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
	
	private ControlePersonagem controlePersonagem;
	
	
	public ControleFase(TelaJogo telaJogo, Protagonista protagonista, TelaInventario telaInventario, String nome){
		
		
		this.telaJogo = telaJogo;
		this.protagonista = protagonista;
		this.telaJogo.getPersonagens().add(protagonista);
		this.personagens = telaJogo.getPersonagens();
		this.protagonista.setTempo("0");
		this.baus = telaJogo.getBaus();
		
		this.matzColisao = telaJogo.getMatzColisao();
		
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
		int resposta = ShowMessage.activeInputDialog(temp.getTexto());
		
		Protagonista temp2  = (Protagonista) this.personagens.get(3);
		
		if(resposta == temp.getResposta()){
			this.protagonista.setPontuacao(this.protagonista.getPontuacao()+250);
			this.telaInventario.getLbPontuacao().setText(this.protagonista.getPontuacao()+"");
			this.protagonista.getLifeBar().setValue(this.protagonista.getQntVida()+100);
		}
		else{
			this.protagonista.setQntVida(this.protagonista.getQntVida()-100);
		}
		
		ativarThread();
	}
	
	public void ativarBau(){
		for (Bau bau : baus){
		
			if(this.protagonista.getBounds().intersects(bau.getRectangle().getBounds()) && bau.getWasActivated()== false){	
					bau.getSomBau().play();
					bau.mostrarInforma��o();
					bau.setWasActivated(true);
					this.protagonista.setQntBausAbertos(this.protagonista.getQntBausAbertos()+1);
					this.telaInventario.setQntBaus(this.protagonista.getQntBausAbertos());
					
					
			}
			else if(this.protagonista.getBounds().intersects(bau.getRectangle().getBounds()) && bau.getWasActivated()== true){
				ShowMessage.showText("B�u j� foi ativado!");
			}	
		}
		this.protagonista.setIntersectBau(false);
		this.protagonista.setAction(-1);
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
	
	public void faseAtiva(){
		
		if(this.qntInimigosMortos == 3){
		
			
			desativarThread();
		
			this.controlePersonagem.stop();			
			this.timer.stop();			
			this.timer = null;
			this.controlePersonagem = null;
			System.gc();
			
			
			this.protagonista.setAction(-1);
			this.qntInimigosMortos = 0;
			this.telaJogo.setTelaAtiva(false);
			this.ativa = false;
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
