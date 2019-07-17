package control;

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

	public ControleFases(Tela tela, Protagonista protagonista) {
		this.tela = tela;
		this.protagonista = protagonista;
		this.tela.getPanelGeral().setVisible(false);
		numeroFase = 1;
		
		
		tela.setTelaAnd(new TelaAnd());
		tela.setTelaNot(new TelaNot());
		tela.setTelaOr(new TelaOr());
		
		tela.getCardJogavel().addLayoutComponent(this.tela.getTelaAnd(), "1");
		tela.getCardJogavel().addLayoutComponent(this.tela.getTelaOr(), "2");
		tela.getCardJogavel().addLayoutComponent(this.tela.getTelaNot(), "3");
		
		this.tela.getPanelJogavel().add(this.tela.getTelaAnd());
		this.tela.getPanelJogavel().add(this.tela.getTelaOr());
		this.tela.getPanelJogavel().add(this.tela.getTelaNot());
		
		this.tela.add(this.tela.getPanelJogavel());
	
		this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"1");
		
		
	}

	
	public void transicao(String tela){
		;
	}
	
	public static void mudarNumeroFase(){
		numeroFase+=1;
	}
	
	public void run() {
		this.tela.getPanelInventario().setVisible(true);
		this.tela.getPanelJogavel().setVisible(true);
		
		while(true){
			switch (numeroFase) {
				case 1:
					transicao("and");
					
		
					
					this.tela.getCardInventario().show(this.tela.getPanelInventario(), "1");
					this.controleFase = new ControleFase(this.tela.getTelaAnd(), this.protagonista, this.tela.getTelaInventario());
					this.controleFase.start();
					numeroFase = 5;
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
	
					break;
				case 5:
					;
					break;
			
			}
			
			
			
			
			
		}

	}


	public ControleFase getControleFase() {
		return controleFase;
	}
	
	

}
