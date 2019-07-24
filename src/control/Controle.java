package control;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import model.Protagonista;
import view.Tela;
import view.TelaAbertura;
import view.TelaAnd;
import view.TelaInformacoes;
import view.TelaInventario;
import view.TelaNot;
import view.TelaOr;
import view.TelaPausa;
import view.TelaSelecao;

public class Controle implements ActionListener, MouseListener {

	private Tela tela;
	private TelaAbertura telaAbertura;
	private TelaInformacoes telaInformacoes;
	private TelaInventario telaInventario;
	private TelaPausa telaPausa;
	private TelaSelecao telaSelecao;
	private ControleFases controleFases;
	private Protagonista protagonista;
	
	public Controle(Tela tela){
		this.tela = tela;
		this.telaAbertura = tela.getTelaAbertura();
		this.telaInformacoes = tela.getTelaInformacoes();
		this.telaSelecao = tela.getTelaSelecao();
		this.telaInventario = tela.getTelaInventario();
		this.telaPausa = tela.getTelaPausa();
		ativar();
	
	}
	
	public void ativar(){
		this.telaAbertura.getBtnConfig().addActionListener(this);
		this.telaAbertura.getBtnExit().addActionListener(this);
		this.telaAbertura.getBtnSingle().addActionListener(this);
		this.telaAbertura.getBtnMultiplayer().addActionListener(this);
		this.telaInformacoes.getBtnControle().addActionListener(this);
		this.telaInformacoes.getBtnCreditos().addActionListener(this);
		this.telaInformacoes.getBtnSobre().addActionListener(this);
		this.telaInformacoes.getBtnResultados().addActionListener(this);
		this.telaInformacoes.getBtnVoltar().addActionListener(this);
		this.telaSelecao.getBtnConfirmar().addActionListener(this);
		this.telaSelecao.getBtnVoltar().addActionListener(this);
		this.telaSelecao.getLbFeminino().addMouseListener(this);
		this.telaSelecao.getLbMasculino().addMouseListener(this);
		
		this.telaInventario.getBtnPausar().addActionListener(this);
		
	
		this.telaPausa.getBtnVoltar().addActionListener(this);
		this.telaPausa.getBtnSair().addActionListener(this);
		this.telaPausa.getBtnConfiguracao().addActionListener(this);
		this.tela.getTelaResultado().getBtnConfirmar().addActionListener(this);
		this.tela.getTelaResultado().getBtnComecar().addActionListener(this);
		this.tela.getTelaResultado().getBtnSair().addActionListener(this);
		
		this.tela.getTelaConfig().getBtnVoltar().addActionListener(this);
		
		//this.tela.getTelaInventarioMultiplayer().getBtnPausar().addActionListener(this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.tela.getTelaAbertura().getBtnConfig()){
			this.tela.getCardGeral().show(this.tela.getPanelGeral(), "2");
		}
		
		else if(e.getSource()== this.tela.getTelaConfig().getBtnVoltar()){
			this.tela.getTelaConfig().setVisible(false);
		}
		
		else if(e.getSource() == this.tela.getTelaInventarioMultiplayer().getBtnPausar()){
			this.tela.getCardInventario().show(this.tela.getPanelInventario(), "2");
			this.tela.getMultiplayer().setFocusable(false);
		}
		
		else if(e.getSource() == this.tela.getTelaAbertura().getBtnMultiplayer()){
			this.tela.getPanelGeral().setVisible(false);
			this.tela.getPanelInventario().setVisible(true);
			this.tela.getPanelJogavel().setVisible(true);
		
			this.tela.getCardJogavel().show(this.tela.getPanelJogavel(),"5");
			this.tela.getCardInventario().show(this.tela.getPanelInventario(), "3");
			ControleMultiplayer  controlMulti = new ControleMultiplayer(this.tela.getTelaInventarioMultiplayer(), this.tela.getMultiplayer(), tela);
			controlMulti.start();
			

			this.tela.getMultiplayer().setFocusable(true);
			this.tela.getMultiplayer().requestFocus(true);
			
			
		}
		else if(e.getSource() == this.tela.getTelaInformacoes().getBtnControle()){
			this.telaInformacoes.getLbControle().setVisible(true);
			this.telaInformacoes.getLbSobre().setVisible(false);
			this.telaInformacoes.getLbCredito().setVisible(false);
		}
		
		else if(e.getSource() == this.telaInformacoes.getBtnCreditos()){
			this.telaInformacoes.getLbControle().setVisible(false);
			this.telaInformacoes.getLbSobre().setVisible(false);
			this.telaInformacoes.getLbCredito().setVisible(true);
		}
		
		else if(e.getSource() == this.tela.getTelaInformacoes().getBtnSobre()){
			this.telaInformacoes.getLbControle().setVisible(false);
			this.telaInformacoes.getLbSobre().setVisible(true);
			this.telaInformacoes.getLbCredito().setVisible(false);
		}
		
		else if(e.getSource() == this.telaInformacoes.getBtnVoltar() || e.getSource() == this.telaSelecao.getBtnVoltar()){
			this.tela.getCardGeral().show(this.tela.getPanelGeral(), "1");
			
			this.telaSelecao.getLbInfo().setText("");
			this.telaSelecao.getTfNome().setText("");
			this.telaSelecao.setSelecionado("");
			
		}
		

		else if(e.getSource() == this.telaInformacoes.getBtnResultados()){
			this.telaInformacoes.getLbControle().setVisible(false);
			this.telaInformacoes.getLbSobre().setVisible(false);
			this.telaInformacoes.getLbCredito().setVisible(false);
			this.telaInformacoes.getTextArea().setVisible(true);
		}
		
		
		
		
		
		else if(e.getSource() == this.telaAbertura.getBtnExit()){
			System.exit(0);
		}
		
		else if(e.getSource() == this.telaAbertura.getBtnSingle()){
			this.tela.getCardGeral().show(this.tela.getPanelGeral(), "3");
		}
		
		else if(e.getSource() == this.telaSelecao.getBtnConfirmar()){
			
			if(this.telaSelecao.getSelecionado().equalsIgnoreCase("Rebekah") ||this.telaSelecao.getSelecionado().equalsIgnoreCase("Niklaus")){
				
				if(!this.telaSelecao.getTfNome().getText().equals("")){
					
					try {
						if (this.telaSelecao.getSelecionado().equalsIgnoreCase("Rebekah")) {

							this.protagonista = new Protagonista("img/Rebekah.png", 32, 32, 4, 3, 0, 2000, 32, 96, this.tela.getTelaSelecao().getTfNome().getText(), true,
									"img/Raio.png", 4, 128, 500, "src/img/F.png", 1);
						}
						else if (this.telaSelecao.getSelecionado().equalsIgnoreCase("Niklaus")) {
							this.protagonista = new Protagonista("img/Niklaus.png", 32, 32, 4, 3, 0, 2000, 32, 96, this.tela.getTelaSelecao().getTfNome().getText(), true,
									"img/Raio.png", 4, 128, 500, "src/img/M.png", 1);
						}

					} 
					
					catch (IOException arg) {
						arg.printStackTrace();
					}
					
					
					this.controleFases = new ControleFases(tela, this.protagonista);
					this.controleFases.start();
					
					this.telaSelecao.setSelecionado("");
					this.telaSelecao.getLbInfo().setText("");
					this.telaSelecao.getTfNome().setText("");
					
				}
				
			}
		}
		
		else if(e.getSource() == this.tela.getTelaPausa().getBtnSair()){
				
			this.parar();
			
			this.tela.getMultiplayer().setFocusable(false);
		
		}
		
		else if(e.getSource() == this.tela.getTelaResultado().getBtnComecar()){
			this.tela.getTelaResultado().setFocusable(false);
			this.controleFases.trocarFase();
			
		}
		
		else if(e.getSource() == this.tela.getTelaResultado().getBtnConfirmar()){
			this.controleFases.setNumeroFase(this.controleFases.getNumeroFase()+1);
			this.tela.getTelaResultado().setFocusable(false);
			this.controleFases.transicao();
			
		}
		
		else if(e.getSource() == this.tela.getTelaInventario().getBtnPausar()){
			this.controleFases.getControleFase().getTimer().setPausa(true);
			this.controleFases.getControleFase().desativarThread();
			this.tela.getCardInventario().show(this.tela.getPanelInventario(), "2");
		}
		else if(e.getSource() == this.tela.getTelaPausa().getBtnVoltar()){
			this.controleFases.getControleFase().ativarThread();
			this.controleFases.getControleFase().getTimer().setPausa(false);
			this.tela.getCardInventario().show(this.tela.getPanelInventario(), "1");
		}
		
		else if(e.getSource() == this.tela.getTelaPausa().getBtnConfiguracao()){
			this.tela.getTelaConfig().setVisible(true);
		}
		
		
		else if(e.getSource() == this.tela.getTelaResultado().getBtnSair()){
			this.parar();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.telaSelecao.getLbFeminino()){
			this.telaSelecao.getLbInfo().setText("Rebekah Selecionada");
			this.telaSelecao.getLbInfo().setForeground(new Color(113,177,169));
			this.telaSelecao.setSelecionado("Rebekah");
			
			
			
		}
		
		else if (e.getSource() == this.telaSelecao.getLbMasculino()){
			this.telaSelecao.getLbInfo().setText("Niklaus Selecionado");
			this.telaSelecao.getLbInfo().setForeground(new Color(255, 171,15));
			this.telaSelecao.setSelecionado("Niklaus");
			
		}
		
		
		
	}
	
	public void parar(){
		//Parando
		this.tela.getPanelInventario().setVisible(false);
		this.tela.getPanelJogavel().setVisible(false);
		this.tela.getPanelGeral().setVisible(true);
		this.controleFases.getControleFase().desativarThread();
		this.controleFases.getControleFase().getTimer().stop();
		this.controleFases.getControleFase().stop();
		this.tela.getTelaResultado().getBtnComecar().setVisible(false);
		this.tela.getTelaResultado().getBtnConfirmar().setVisible(false);
		this.tela.getCardGeral().show(this.tela.getPanelGeral(), "1");
	
		this.controleFases = null;
		System.gc();
		
		
		this.tela.getPanelJogavel().remove(this.tela.getTelaAnd());
		this.tela.getPanelJogavel().remove(this.tela.getTelaOr());
		this.tela.getPanelJogavel().remove(this.tela.getTelaNot());
		this.tela.getPanelJogavel().remove(this.tela.getTelaResultado());
		
		
		this.tela.setTelaAnd(null);
		System.gc();
		this.tela.setTelaNot(null);
		System.gc();
		this.tela.setTelaOr(null);
		System.gc();
		
		this.tela.setCardJogavel(null);
		System.gc();
		this.tela.getPanelJogavel().setLayout(null);
		System.gc();
		this.tela.remove(this.tela.getPanelJogavel());
		this.protagonista = null;
		
		System.gc();
		
		
		
		//Setando novamente
		
	
		tela.setTelaAnd(new TelaAnd());
		tela.setTelaNot(new TelaNot());
		tela.setTelaOr(new TelaOr());

		
		this.tela.setCardJogavel(new CardLayout());
		this.tela.getPanelJogavel().setLayout(this.tela.getCardJogavel());
		this.tela.getCardJogavel().addLayoutComponent(this.tela.getTelaAnd(), "1");
		this.tela.getCardJogavel().addLayoutComponent(this.tela.getTelaOr(), "2");
		this.tela.getCardJogavel().addLayoutComponent(this.tela.getTelaNot(), "3");
		this.tela.getCardJogavel().addLayoutComponent(this.tela.getTelaResultado(), "4");
		
		
		this.tela.getPanelJogavel().add(this.tela.getTelaAnd());
		this.tela.getPanelJogavel().add(this.tela.getTelaOr());
		this.tela.getPanelJogavel().add(this.tela.getTelaNot());
		this.tela.getPanelJogavel().add(this.tela.getTelaResultado());
		
		this.tela.add(this.tela.getPanelJogavel());
		
		
		
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
