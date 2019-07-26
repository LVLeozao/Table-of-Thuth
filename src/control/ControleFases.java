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
	
	private Boolean telaAtiva;

	public ControleFases(Tela tela, Protagonista protagonista) {
		this.tela = tela;
		this.protagonista = protagonista;
		this.tela.getPanelGeral().setVisible(false);
		
	
		this.tela.getPanelInventario().setVisible(true);
		this.tela.getPanelJogavel().setVisible(true);
		this.tela.getCardInventario().show(this.tela.getPanelInventario(), "1");
		this.numeroFase = 1;
		this.transicao();
		
		this.telaAtiva = true;
		
	}

	
	public void transicao(){
		this.tela.getTelaResultado().setResultadoAtivo(false);
		this.tela.getTelaResultado().getBtnComecar().setVisible(true);
		this.tela.getTelaResultado().getBtnConfirmar().setVisible(false);
		this.tela.getTelaResultado().getLbPontuacao().setVisible(false);
		this.tela.getTelaResultado().getLbPntBau().setVisible(false);
		this.tela.getTelaResultado().getLbTempo().setVisible(false);

		switch (numeroFase) {
		
			case 1:
				
				
				this.tela.getTelaResultado().setFaseAtiva1(true);
				this.tela.getTelaResultado().setFaseAtiva2(false);
				this.tela.getTelaResultado().setFaseAtiva3(false);
				
				this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"4");
				
				
				this.tela.getTelaResultado().setResultadoMultiplayer(false);
				
				this.tela.getTelaResultado().setResultadoFinalAtivo(false);
				
				
				this.tela.getTelaResultado().repaint();
				

				
				break;
		
			case 2:
				
				
				this.tela.getTelaResultado().setFaseAtiva1(false);
				this.tela.getTelaResultado().setFaseAtiva2(true);
				this.tela.getTelaResultado().setFaseAtiva3(false);
				
				this.tela.getTelaResultado().setResultadoMultiplayer(false);
				
				this.tela.getTelaResultado().setResultadoFinalAtivo(false);
				
				
				this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"4");
				
				this.tela.getTelaResultado().repaint();

				break;
		
			case 3:
				
				
				this.tela.getTelaResultado().setFaseAtiva1(false);
				this.tela.getTelaResultado().setFaseAtiva2(false);
				this.tela.getTelaResultado().setFaseAtiva3(true);
				
				this.tela.getTelaResultado().setResultadoMultiplayer(false);
				
				this.tela.getTelaResultado().setResultadoFinalAtivo(false);
				
				
				this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"4");
				
				this.tela.getTelaResultado().repaint();
				break;
	
		
			case 4:
				
				this.tela.getTelaResultado().getBtnComecar().setVisible(false);
				this.tela.getTelaResultado().getBtnSair().setVisible(true);
				
				this.tela.getTelaResultado().setFaseAtiva1(false);
				this.tela.getTelaResultado().setFaseAtiva2(false);
				this.tela.getTelaResultado().setFaseAtiva3(false);
				this.tela.getTelaResultado().setResultadoFinalAtivo(true);
				this.tela.getTelaResultado().setResultadoMultiplayer(false);
				this.tela.getTelaResultado().getLbPontuacao().setVisible(true);
				this.tela.getTelaResultado().getLbNome().setText(this.protagonista.getNome());
				this.tela.getTelaResultado().getLbNome().setVisible(true);
				this.tela.getTelaResultado().getLbPontuacao().setBounds(580, 250, 400, 400);
				
				
				this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"4");
				
				this.tela.getTelaResultado().repaint();
				
				
				
				this.tela.getXml().salvar(this.protagonista);
				
				break;
		
				
		
			
		
		
		}
	}
	
	
	
	public Boolean getTelaAtiva() {
		return telaAtiva;
	}


	public void setTelaAtiva(Boolean telaAtiva) {
		this.telaAtiva = telaAtiva;
	}


	public void mostrarResultado(){
		
		this.controleFase.setQntInimigosMortos(0);
		this.tela.getTelaResultado().getSomVitoria().play();
		this.tela.getTelaResultado().getBtnConfirmar().setVisible(true);
		this.tela.getTelaResultado().getBtnComecar().setVisible(false);
		this.tela.getTelaResultado().getBtnSair().setVisible(false);
		
		
		this.tela.getTelaResultado().setFaseAtiva1(false);
		this.tela.getTelaResultado().setFaseAtiva2(false);
		this.tela.getTelaResultado().setFaseAtiva3(false);
		this.tela.getTelaResultado().getLbPontuacao().setVisible(true);
		this.tela.getTelaResultado().getLbPntBau().setVisible(true);
		this.tela.getTelaResultado().getLbTempo().setVisible(true);
		
		this.tela.getTelaResultado().setResultadoAtivo(true);
		
		this.tela.getTelaResultado().repaint();
		
		
		this.tela.getTelaResultado().getLbTempo().setText(this.protagonista.getTempo());
		this.tela.getTelaResultado().getLbPntBau().setText(this.protagonista.getQntBausAbertos() * (-10)+"");
		this.tela.getTelaResultado().getLbPontuacao().setText(this.protagonista.getPontuacao()+this.protagonista.getQntBausAbertos() * (-10) +"");

		this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"4");
		
		this.protagonista.getTempoFases().add(this.protagonista.getTempo());
	}
	
		
	
	
	
	
	public void verificarFase(){
		
		if(this.controleFase.getQntInimigosMortos() == 3){
			this.controleFase.desativarThread();
			this.controleFase.getTimer().stop();
			this.controleFase.stop();
			
			this.controleFase.getControlePersonagem().stop();
			
			
			
			mostrarResultado();
			
			
			
		}
		else if(this.protagonista.isMorto()){
			this.tela.getTelaResultado().getSomDerrota().play();
			
			this.getControleFase().getTimer().setPausa(true);
			this.tela.getTelaResultado().getBtnConfirmar().setVisible(false);
			this.tela.getTelaResultado().getBtnComecar().setVisible(false);
			this.tela.getTelaResultado().getBtnSair().setVisible(true);
			
			this.tela.getTelaResultado().setFaseAtiva1(false);
			this.tela.getTelaResultado().setFaseAtiva2(false);
			this.tela.getTelaResultado().setFaseAtiva3(false);	
			this.tela.getTelaResultado().setResultadoAtivo(false);
			this.tela.getTelaResultado().setMorteAtiva(true);
			
			
			this.tela.getTelaResultado().repaint();

			this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"4");
			
			this.controleFase.desativarThread();
			this.protagonista.setMorto(false);
		
		}
		
	}
	
			
	public void run(){
		while(true && this.isAlive()){
			if(this.controleFase != null && this.controleFase.isAlive()){
				verificarFase();
				
			
			}
		}
	}

	public static int getNumeroFase() {
		return numeroFase;
	}


	public static void setNumeroFase(int numeroFase) {
		ControleFases.numeroFase = numeroFase;
	}


	public ControleFase getControleFase() {
		return controleFase;
	}


	public void setControleFase(ControleFase controleFase) {
		this.controleFase = controleFase;
	}
	
	

}
