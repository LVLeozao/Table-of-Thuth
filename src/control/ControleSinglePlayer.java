package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Destroy;
import model.Itens;
import model.Protagonista;
import view.SinglePlayer;
import view.TelaInventario;
import view.TelaPausa;
import view.TelaTransicao;

public class ControleSinglePlayer extends Thread implements ActionListener{

	private SinglePlayer single;
	private TelaInventario telaInventario;
	private TelaPausa telaPausa;
	private TelaTransicao telaTrancisao;
	private Protagonista protagonista;
	private int numeroFase;
	private ControleFase controleFase;
	private ThreadTransicao threadTransicao;
	
	
	
	
	public ControleSinglePlayer(SinglePlayer single, Protagonista protagonista){
		
		this.single = single;
		this.telaInventario = this.single.getTelaInventario();
		this.telaPausa = this.single.getTelaPausa();
		this.protagonista = protagonista;
		this.telaTrancisao = this.single.getTelaTransicao();
		this.numeroFase = 1;
		
		threadTransicao = new ThreadTransicao(single);
		threadTransicao.start();
		
		
		ativar();
		setarFase();
		
	}
	
	public void verificarFaseAtiva(){
		if(this.controleFase.getAtiva() == false){
			
			this.matarControleFase();
			
			this.protagonista.setQntBausAbertos(0);
			
			this.motrarResultado();
			
		}
		
	}
	
	public void motrarResultado(){
		this.single.getCardResultados().show(this.single.getPanelResultados(), "1");

		this.single.getPanelInventario().setVisible(false);
		this.single.getPanelJogavel().setVisible(false);
		this.single.getPanelResultados().setVisible(true);
		

		this.single.getTelaTransicao().getSomVitoria().play();
		
		if(this.numeroFase<3){
			this.single.getTelaTransicao().setResultadoAtivo(true);
			this.single.getTelaTransicao().getBtnConfirmar().setVisible(true);
			this.single.getTelaTransicao().getBtnSair().setVisible(false);
		}
		else if(this.numeroFase == 3){
			this.single.getTelaTransicao().setResultadoFinalAtivo(true);
			this.single.getTelaTransicao().getBtnConfirmar().setVisible(false);
			this.single.getTelaTransicao().getBtnSair().setVisible(true);
		}
		
		
		
		this.single.getTelaTransicao().getLbTempo().setText(this.protagonista.getTempo());
		this.single.getTelaTransicao().getLbPontuacao().setText(this.protagonista.getPontuacao()+"");
		
		
		this.single.getTelaTransicao().getLbTempo().setVisible(true);
		this.single.getTelaTransicao().getLbPontuacao().setVisible(true);
	
		this.single.getTelaTransicao().repaint();
		
		this.numeroFase+=1;
		
		this.telaTrancisao.setFocusable(false);
		this.telaTrancisao.requestFocus(false);
		
		this.protagonista.getTempos().add(this.protagonista.getTempo());
		
		
		
	}
	
	
	public void matarControleFase(){
		this.controleFase.stop();
		this.controleFase.getTelaJogo().setFocusable(false);
		this.controleFase = null;
		System.gc();
		
	}
	
	public void verificarVidaPersonagem(){
		if(this.protagonista.isMorto()){
		
			this.controleFase.matarControle();
			this.matarControleFase();
			
			
			this.protagonista.setMorto(false);
			
			this.single.getTelaTransicao().setResultadoAtivo(false);
			this.single.getTelaTransicao().setMorteAtiva(true);
			
			
			this.single.getPanelResultados().setVisible(true);
			this.single.getCardResultados().show(this.single.getPanelResultados(), "1");
			this.single.getPanelInventario().setVisible(false);
			this.single.getPanelJogavel().setVisible(false);
			this.single.getTelaTransicao().getSomDerrota().play();

			this.single.getTelaTransicao().getBtnConfirmar().setVisible(false);
			this.single.getTelaTransicao().getBtnSair().setVisible(true);
			
			
			
		}
	}
	
	public void setarFase(){
		this.single.getPanelInventario().setVisible(true);
		this.single.getPanelJogavel().setVisible(true);

		this.single.getPanelResultados().setVisible(false);
		

		this.single.getCardInventario().show(this.single.getPanelInventario(), "1");
		
		switch (this.numeroFase) {
		
			case 1:
				
				
				this.controleFase = new ControleFase(this.single.getTelaAnd(), this.protagonista, this.telaInventario, "AND");
				this.controleFase.start();
				
				this.single.getCardJogavel().show(this.single.getPanelJogavel(),"1");
				
				this.single.getTelaAnd().setFaseAtiva1(true);
				
				

				this.single.getTelaAnd().setFocusable(true);
				this.single.getTelaAnd().requestFocus();
				
				break;
				
			case 2:
				this.protagonista.setPosX(352);
				this.protagonista.setPosY(576);
				
				this.controleFase = new ControleFase(this.single.getTelaOr(), this.protagonista, this.telaInventario, "OR");
				this.controleFase.start();
				
				this.single.getCardJogavel().show(this.single.getPanelJogavel(),"2");
				
				
			
				this.single.getTelaOr().setFaseAtiva2(true);
				
				this.single.getTelaOr().repaint();
				
				this.single.getTelaOr().setFocusable(true);
				this.single.getTelaOr().requestFocus();
				
				
				break;
				
				
			case 3:
				this.protagonista.setPosX(256);
				this.protagonista.setPosY(608);
				
				this.controleFase = new ControleFase(this.single.getTelaNot(), this.protagonista, this.telaInventario, "NOT");
				this.controleFase.start();
				
				this.single.getCardJogavel().show(this.single.getPanelJogavel(),"3");
				
				this.single.getTelaNot().setFaseAtiva3(true);
				
				this.single.getTelaNot().setFocusable(true);
				this.single.getTelaNot().requestFocus();
				
				break;

		}
		
	}
	
	
	public void ativar(){
		this.telaTrancisao.getBtnConfirmar().addActionListener(this);
		this.telaInventario.getBtnPausar().addActionListener(this);
		this.telaPausa.getBtnConfiguracao().addActionListener(this);
		this.telaPausa.getBtnVoltar().addActionListener(this);
		this.telaPausa.getTelaConfiguracoes().getBtnVoltar().addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.telaTrancisao.getBtnConfirmar()){
			this.single.getTelaTransicao().getLbTempo().setVisible(false);
			this.single.getTelaTransicao().getLbPontuacao().setVisible(false);
			
			this.setarFase();
		}
		
		else if(e.getSource() == this.telaInventario.getBtnPausar()){
			
			this.controleFase.desativarThread();
			this.controleFase.getTimer().setPausa(true);
			this.single.getCardInventario().show(this.single.getPanelInventario(), "2");
			
		}
		
		else if(e.getSource() == this.telaPausa.getBtnVoltar()){
			
			this.controleFase.ativarThread();
			this.controleFase.getTimer().setPausa(false);
			this.single.getCardInventario().show(this.single.getPanelInventario(), "1");
			
		}
		
		else if(e.getSource() == this.telaPausa.getBtnConfiguracao()){
			this.telaPausa.getTelaConfiguracoes().setVisible(true);
		}
		
		else if(e.getSource() == this.telaPausa.getTelaConfiguracoes().getBtnVoltar()){
			this.telaPausa.getTelaConfiguracoes().setVisible(false);
		}
		
	}
	
	public void run(){
		while(true){
			try{
				if(this.controleFase.isAlive()){
					this.verificarVidaPersonagem();
					this.verificarFaseAtiva();
				}
			}catch(java.lang.NullPointerException e){
				;
			}
			
		}
	}

	public ThreadTransicao getThreadTransicao() {
		return threadTransicao;
	}

	public void setThreadTransicao(ThreadTransicao threadTransicao) {
		this.threadTransicao = threadTransicao;
	}

	public ControleFase getControleFase() {
		return controleFase;
	}
	
	
	
}
