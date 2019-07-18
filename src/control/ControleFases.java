package control;

import java.awt.CardLayout;
import java.io.IOException;

import model.Protagonista;
import view.Tela;
import view.TelaAnd;
import view.TelaJogo;
import view.TelaNot;
import view.TelaOr;

public class ControleFases extends Thread {

	private Protagonista protagonista;
	private Tela tela;
	private static int numeroFase;
	private ControleFase controleFase;
	
	private TelaAnd telaAnd;
	private TelaOr telaOr;
	private TelaNot telaNot;
	


	public ControleFases(Tela tela, Protagonista protagonista) {
		this.tela = tela;
		this.protagonista = protagonista;
		this.tela.getPanelGeral().setVisible(false);
		
		
		//Setar vida, setar tempo
		
		tela.setTelaAnd(new TelaAnd());
		tela.setTelaNot(new TelaNot());
		tela.setTelaOr(new TelaOr());
		
		this.tela.setCardJogavel(new CardLayout());
		this.tela.getPanelJogavel().setLayout(this.tela.getCardJogavel());
		tela.getCardJogavel().addLayoutComponent(this.tela.getTelaAnd(), "1");
		tela.getCardJogavel().addLayoutComponent(this.tela.getTelaOr(), "2");
		tela.getCardJogavel().addLayoutComponent(this.tela.getTelaNot(), "3");
		
		this.tela.getPanelJogavel().add(this.tela.getTelaAnd());
		this.tela.getPanelJogavel().add(this.tela.getTelaOr());
		this.tela.getPanelJogavel().add(this.tela.getTelaNot());
		
		this.tela.add(this.tela.getPanelJogavel());
	
		
		
		this.tela.getPanelInventario().setVisible(true);
		this.tela.getPanelJogavel().setVisible(true);
		
		this.numeroFase = 1;
		this.trocarFase();
		
	}

	
	public void transicao(String tela){
		;
	}
	
	public static void mudarNumeroFase(){
		numeroFase+=1;
	}
	
	public void trocarFase(){
		switch (numeroFase) {
			case 1:
				
				transicao("and");
				this.tela.getCardInventario().show(this.tela.getPanelInventario(), "1");
				this.controleFase = new ControleFase(this.tela.getTelaAnd(), this.protagonista, this.tela.getTelaInventario());
				this.controleFase.start();
				
				this.tela.getTelaInventario().getLbNomeFase().setText("AND");
				this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"1");
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			}
	}
	
	
			
			
			
			
		

	


	public ControleFase getControleFase() {
		return controleFase;
	}
	
	

}
