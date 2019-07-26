package control;

import java.util.Random;

import model.Exercicio;
import model.GerarPosicao;
import model.Inimigo;
import model.Itens;
import model.Personagem;
import model.Protagonista;
import model.Timer;
import view.Multiplayer;
import view.ShowMessage;
import view.Tela;
import view.TelaInventarioMultiplayer;


public class ControleMultiplayer extends Thread{
	
	private Multiplayer multiplayer;
	private TelaInventarioMultiplayer telaInventario;
	private Itens itens;
	private Tela tela;
	private Boolean telaAtiva;
	
	
	public ControleMultiplayer(TelaInventarioMultiplayer telaInventario, Multiplayer multiplayer, Tela tela){
		
		this.tela = tela;
		this.multiplayer = multiplayer;
		this.telaInventario = telaInventario;
		this.telaAtiva = true;
		this.multiplayer.setControlePlayer1(new ControlePersonagem(this.multiplayer.getPlayer1(), this.multiplayer.getMatzColisao(), this.multiplayer.getPersonagens()));
		this.multiplayer.setControlePlayer2(new ControlePersonagem(this.multiplayer.getPlayer2(), this.multiplayer.getMatzColisao(), this.multiplayer.getPersonagens()));
		this.itens = this.multiplayer.getItens();
		
		
		
		
		this.multiplayer.addKeyListener(new ControleKeyMulti(this.multiplayer.getPlayer1(), this.multiplayer.getPlayer2()));
	
		this.multiplayer.getControlePlayer1().start();
		this.multiplayer.getControlePlayer2().start();
		
		
	}
	
	public void responderQuestionario(Protagonista protagonista){
		
		
		this.multiplayer.getControlePlayer1().setDirecao(-1);
		this.multiplayer.getControlePlayer1().setDirecao(-1);
		
		Random random = new Random();
		
		int x = random.nextInt(5);
		
		Exercicio temp = this.multiplayer.getExercicios().get(x);
		
		
		int resposta = ShowMessage.activeInputDialog(temp.getText());
		
		
		if(resposta == temp.getResposta()){
			protagonista.setPontuacao(protagonista.getPontuacao()+250);
		}
		else{
			protagonista.setPontuacao(protagonista.getPontuacao()-150);
		}
		
		this.multiplayer.setFocusable(true);
		
	}
	
	
	public void action(Protagonista protagonista, ControlePersonagem control){
		System.out.println(this.itens.getAparencia());
		switch (this.itens.getAparencia()) {
		
			case 0:	
				
				control.setTempoThreadMovimento(control.getTempoThreadMovimento()-3);
				
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
			case 4:
				this.multiplayer.setFocusable(true);
				
				this.responderQuestionario(protagonista);
				
				break;
		}
		
		
		int [] a =  GerarPosicao.gerarPosicaoXY(this.multiplayer.getMatzColisao(), this.multiplayer.getCamada2().mapa);
		
		this.multiplayer.getItens().setPosX(a[0]);
		this.multiplayer.getItens().setPosY(a[1]);
		
		this.multiplayer.getItens().setAparencia(new Random().nextInt(5));
		
	}
	
	
	public void intersectItem(){
		
		for (Personagem personagem : this.multiplayer.getPersonagens()) {
			Protagonista temp = (Protagonista) personagem;
			if(personagem.getBounds().intersects(this.multiplayer.getItens().getBounds())){
				
				if (temp.getNome().equalsIgnoreCase("Niklaus")){
					
					this.action(temp, this.multiplayer.getControlePlayer1());
					
					
				}
				else{
					this.action(temp, this.multiplayer.getControlePlayer2());
				}
				
				
			}
			
		}
	}
	
	public void finalizar(Protagonista protagonista){
		
		for (Personagem personagem : this.multiplayer.getPersonagens()) {
			if(personagem.getQntVida() >0){
				this.tela.getTelaResultado().setResultadoMultiplayer(true);
				this.tela.getTelaResultado().getBtnSair().setVisible(true);
			}
		}
		
		
	}
	
	public void verificarVidaPersonagens(){

		for (Personagem personagem : this.multiplayer.getPersonagens()) {
			Protagonista temp = (Protagonista) personagem;
			
			if(personagem.isCondicaoExistencia() == true){
				
				
				
				if(personagem.getQntVida() ==0){
					personagem.setCondicaoExistencia(false);
					
					personagem.setBounds(0, 0);
					
					
					if(personagem instanceof Protagonista){
						temp.setMorto(true);
					}
					
					if (temp.getNome().equalsIgnoreCase("Niklaus")){
						this.telaInventario.getBarPlayer1().setVisible(false);	
						
						
						
					}
					else{
						this.telaInventario.getBarPlayer2().setVisible(false);
						
					}
					
					
					
				}
					
				
				
				else{
					
					
						if (temp.getNome().equalsIgnoreCase("Niklaus")){
							this.telaInventario.getBarPlayer1().setValue(temp.getQntVida());	
							this.telaInventario.getLbPontuacaoPlayer1().setText(temp.getPontuacao()+"");
							this.telaInventario.getBarPlayer1().setToolTipText(temp.getQntVida()+"/"+this.telaInventario.getBarPlayer1().getMaximum());
							
							
						}
						else{
							this.telaInventario.getBarPlayer2().setValue(temp.getQntVida());
							this.telaInventario.getBarPlayer2().setToolTipText(temp.getQntVida()+"/"+this.telaInventario.getBarPlayer2().getMaximum());
							this.telaInventario.getLbPontuacaoPlayer2().setText(temp.getPontuacao()+"");
						}
						
						
				}
				
		
					
			}
				
			
			
			
			}
	}
	
	
	
	public Boolean getTelaAtiva() {
		return telaAtiva;
	}

	public void setTelaAtiva(Boolean telaAtiva) {
		this.telaAtiva = telaAtiva;
	}

	public void run(){
		while(true){
			this.verificarVidaPersonagens();
			this.intersectItem();
			this.multiplayer.repaint();
		}
	}
	
	
}
	


