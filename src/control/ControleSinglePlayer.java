package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
	
	public ControleSinglePlayer(SinglePlayer single, Protagonista protagonista){
		
		this.single = single;
		this.telaInventario = this.single.getTelaInventario();
		this.telaPausa = this.single.getTelaPausa();
		this.protagonista = protagonista;
		this.telaTrancisao = this.single.getTelaTransicao();
		this.numeroFase = 1;
		
		ThreadTransicao teste = new ThreadTransicao(single);
		teste.start();
		
		
		ativar();
		setarFase();
	}
	
	public void verificarFaseAtiva(){
		if(this.controleFase.getAtiva() == false){
			this.controleFase.stop();
			this.controleFase.getTelaJogo().setFocusable(false);
			
			this.controleFase = null;
			System.gc();
			
			this.motrarResultado();
		}
		
	}
	public void transicao(){
		//add transicao tela(nomes)
	}
	
	public void motrarResultado(){
		this.single.getCardResultados().show(this.single.getPanelResultados(), "1");

		this.single.getPanelInventario().setVisible(false);
		this.single.getPanelJogavel().setVisible(false);
		this.single.getPanelResultados().setVisible(true);
		

		this.single.getTelaTransicao().getSomVitoria().play();
		
		if(this.numeroFase<=3){
			this.single.getTelaTransicao().getBtnConfirmar().setVisible(true);
			this.single.getTelaTransicao().getBtnSair().setVisible(false);
		}
		else if(this.numeroFase == 4){
			this.single.getTelaTransicao().getBtnConfirmar().setVisible(false);
			this.single.getTelaTransicao().getBtnSair().setVisible(true);
		}
		
		this.single.getTelaTransicao().setResultadoAtivo(true);
		
		
		this.single.getTelaTransicao().getLbTempo().setText(this.protagonista.getTempo());
		this.single.getTelaTransicao().getLbPontuacao().setText(this.protagonista.getPontuacao()+(this.protagonista.getQntBausAbertos() * (-10)) +"");
		
		
		this.single.getTelaTransicao().getLbTempo().setVisible(true);
		this.single.getTelaTransicao().getLbPontuacao().setVisible(true);
		//add transicao tela(nomes)
		this.single.getTelaTransicao().repaint();
		
		this.numeroFase+=1;
		
		this.telaTrancisao.setFocusable(false);
		this.telaTrancisao.requestFocus(false);
		
		
		
		
	}
	
	
	public void setarFase(){
		this.single.getPanelInventario().setVisible(true);
		this.single.getPanelJogavel().setVisible(true);

		this.single.getPanelResultados().setVisible(false);
		

		this.single.getCardInventario().show(this.single.getPanelInventario(), "1");
		System.out.println(this.numeroFase);
		switch (this.numeroFase) {
		
			case 1:
				
				this.controleFase = new ControleFase(this.single.getTelaAnd(), this.protagonista, this.telaInventario, "And");
				this.controleFase.start();
				
				this.single.getCardJogavel().show(this.single.getPanelJogavel(),"1");
				
				this.single.getTelaAnd().setFaseAtiva1(true);
				
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
			case 4:
				//chamar telaZerou
				break;
			

		
		}
		
	}
	

	public void ativar(){
		this.telaTrancisao.getBtnConfirmar().addActionListener(this);
		this.telaInventario.getBtnPausar().addActionListener(this);
		this.telaPausa.getBtnConfiguracao().addActionListener(this);
		this.telaPausa.getBtnVoltar().addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.telaTrancisao.getBtnConfirmar()){
			this.single.getTelaTransicao().getLbTempo().setVisible(false);
			this.single.getTelaTransicao().getLbPontuacao().setVisible(false);
			this.setarFase();
		}
		
	}
	
	public void run(){
		while(true){
			try{
				if(this.controleFase.isAlive()){
					
					this.verificarFaseAtiva();
				}
			}catch(java.lang.NullPointerException e){
				;
			}
			
		}
	}

}
