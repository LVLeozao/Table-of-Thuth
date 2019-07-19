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
	
	public void mostrarResultado(){
		
		this.tela.getTelaResultado().getLbTempo().setText(this.protagonista.getTempo());
		this.tela.getTelaResultado().getLbPntBau().setText(this.protagonista.getQntBausAbertos() * (-10)+"");
		this.tela.getTelaResultado().getLbPontuacao().setText(this.protagonista.getPontuacao()+"");
		System.out.println("DEPOIS");
		this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"4");
		System.out.println("PASSOU2");
		
	}
	
		
	public void trocarFase(){
		switch (numeroFase) {
			case 1:
				
				transicao("and");
				this.controleFase = new ControleFase(this.tela.getTelaAnd(), this.protagonista, this.tela.getTelaInventario(), this);
				this.controleFase.start();
				
				this.tela.getTelaInventario().getLbNomeFase().setText("AND");
				this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"1");
				this.tela.getCardInventario().show(this.tela.getPanelInventario(), "1");
				break;
			case 2:
				this.protagonista.setPosX(352);
				this.protagonista.setPosY(576);
				
				transicao("or");
				this.tela.getCardInventario().show(this.tela.getPanelInventario(), "1");
				this.controleFase = new ControleFase(this.tela.getTelaOr(), this.protagonista, this.tela.getTelaInventario(), this);
				this.controleFase.start();
				
				this.tela.getTelaInventario().getLbNomeFase().setText("OR");
				this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"2");
				break;
				
			case 3:
				
				break;
			}
	}
	
	public void verificarFase(){
		
		if(this.controleFase.getQntInimigosMortos() == 3){
			this.controleFase.desativarThread();
			this.controleFase.getTimer().stop();
			this.controleFase.stop();
			mostrarResultado();
			
			
			
		}
		
	}
	
			
	public void run(){
		while(true && this.isAlive()){
			if(this.controleFase != null && this.controleFase.isAlive()){
				verificarFase();
			}
		}
	}
			
			
			
		

	


	public ControleFase getControleFase() {
		return controleFase;
	}


	public void setControleFase(ControleFase controleFase) {
		this.controleFase = controleFase;
	}
	
	

}
