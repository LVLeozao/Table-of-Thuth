package control;

import java.io.IOException;

import model.Protagonista;
import view.Tela;
import view.TelaJogo;

public class ControleFases extends Thread {

	private Protagonista protagonista;
	private Tela tela;

	public ControleFases(Tela tela, Protagonista protagonista) {

		
		this.tela = tela;
		
		this.protagonista = protagonista;
	
		
		this.tela.getPanelGeral().setVisible(false);

		this.tela.getTelaAnd().setTelaAtiva(true);
		


	}
	
	
	public void transicao(String tela){
		;
	}
	
	
	public void run() {
		System.out.println(this.tela.getTelaAnd().getTelaAtiva());
		while(true){
			System.out.println(this.tela.getTelaAnd().getTelaAtiva());
			if(this.tela.getTelaAnd().getTelaAtiva()){
				transicao("and");
				System.out.println("TESTE");
				this.tela.getPanelInventario().setVisible(true);
				this.tela.getPanelJogavel().setVisible(true);
				this.tela.getCardInventario().show(this.tela.getPanelInventario(), "1");
				
	
				ControleFase controleFase = new ControleFase(this.tela.getTelaAnd(), this.protagonista);
				controleFase.start();
				
				this.tela.getTelaAnd().setTelaAtiva(false);
				
			}
			
			
			
			
		}

	}

}
