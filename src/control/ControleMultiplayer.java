package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import view.TelaPausa;
import view.TelaTransicao;


public class ControleMultiplayer extends Thread implements ActionListener{
	
	private Multiplayer multiplayer;
	private TelaInventarioMultiplayer telaInventario;
	private TelaPausa telaPausa;
	private Protagonista ganhador;
	
	private Itens itens;
	private Boolean telaAtiva;
	private ControleFaseMultiplayer controleFase;
	
	
	public ControleMultiplayer(Multiplayer multi, String nome1, String nome2){
		
		this.multiplayer = multi;
		this.telaInventario = this.multiplayer.getTelaInventarioMultiplayer();
		this.telaPausa = this.multiplayer.getTelaPausa();
	
		this.ganhador = null;
		this.multiplayer.getTelaFloresta().getPlayer1().setNome(nome1);
		this.multiplayer.getTelaFloresta().getPlayer2().setNome(nome2);
		this.telaAtiva = true;
	
		setarFaser();
		ativar();
		
	}
	
	public void setarFaser(){
		this.multiplayer.getPanelInventario().setVisible(true);
		this.multiplayer.getPanelJogavel().setVisible(true);
		this.multiplayer.getCardInventario().show(this.multiplayer.getPanelInventario(), "1");
	
		this.controleFase = new ControleFaseMultiplayer(this.multiplayer, this.multiplayer.getTelaFloresta());
		this.controleFase.start();
		
		this.multiplayer.getTelaFloresta().setFocusable(true);
		this.multiplayer.getTelaFloresta().requestFocus();
	}

	public void ativar(){
		this.telaInventario.getBtnPausar().addActionListener(this);
		this.telaPausa.getBtnConfiguracao().addActionListener(this);
		this.telaPausa.getBtnVoltar().addActionListener(this);
		this.telaPausa.getTelaConfiguracoes().getBtnVoltar().addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.telaInventario.getBtnPausar()){
			
			this.controleFase.desativar();
			this.multiplayer.getCardInventario().show(this.multiplayer.getPanelInventario(), "2");
			
		}
		
		else if(e.getSource() == this.telaPausa.getBtnVoltar()){
			this.controleFase.ativar();
			this.multiplayer.getCardInventario().show(this.multiplayer.getPanelInventario(), "1");
			
		}
		
		else if(e.getSource() == this.telaPausa.getBtnConfiguracao()){
			this.telaPausa.getTelaConfiguracoes().setVisible(true);
		}
		
		else if(e.getSource() == this.telaPausa.getTelaConfiguracoes().getBtnVoltar()){
			this.telaPausa.getTelaConfiguracoes().setVisible(false);
		}
		
	}
	
	public void setarTransicao(Protagonista player){
		

		this.multiplayer.getTelaResultado().getLbGanhador().setText("Ganhador: "+player.getNome());
		this.multiplayer.getTelaResultado().getLbPontucao().setText("Pontuação: "+player.getPontuacao());
		
		this.multiplayer.getTelaResultado().setVisible(true);
		
		
		this.ganhador = player;
	}
	
	public void verificarVidaPersonagem(){
		if(this.multiplayer.getTelaFloresta().getPlayer1().isMorto()) {
			matarControleFase();
			setarTransicao(this.multiplayer.getTelaFloresta().getPlayer2());
			
		}
		
		else if(this.multiplayer.getTelaFloresta().getPlayer2().isMorto()) {
			matarControleFase();
			setarTransicao(this.multiplayer.getTelaFloresta().getPlayer1());
		}
		
	}
	
	public void matarControleFase(){
		this.controleFase.matarControle();
		this.controleFase.getTelaJogo().setFocusable(false);
		this.controleFase = null;
		System.gc();
		
	}
	
	public void run(){
		while(true){
			try{
				if(this.controleFase.isAlive()){
					
					this.verificarVidaPersonagem();
				}
				
				else{
					break;
				}
			}catch(java.lang.NullPointerException e){
				;
			}
			
		}
	}

	public ControleFaseMultiplayer getControleFase() {
		return controleFase;
	}

	public Protagonista getGanhador() {
		return ganhador;
	}
	
	
	
}
	


