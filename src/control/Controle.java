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
		this.telaInformacoes.getBtnControle().addActionListener(this);
		this.telaInformacoes.getBtnCreditos().addActionListener(this);
		this.telaInformacoes.getBtnSobre().addActionListener(this);
		this.telaInformacoes.getBtnVoltar().addActionListener(this);
		this.telaSelecao.getBtnConfirmar().addActionListener(this);
		this.telaSelecao.getBtnVoltar().addActionListener(this);
		this.telaSelecao.getLbFeminino().addMouseListener(this);
		this.telaSelecao.getLbMasculino().addMouseListener(this);
		
		this.telaInventario.getBtnPausar().addActionListener(this);
		this.telaPausa.getBtnVoltar().addActionListener(this);
		this.telaPausa.getBtnSair().addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.tela.getTelaAbertura().getBtnConfig()){
			this.tela.getCardGeral().show(this.tela.getPanelGeral(), "2");
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
						if (this.telaSelecao.getNome().equalsIgnoreCase("Rebekah")) {

							this.protagonista = new Protagonista("img/Rebekah.png", 32, 32, 4, 3, 0, 2000, 32, 96, this.tela.getTelaSelecao().getTfNome().getText(), true,
									"img/Raio.png", 4, 128, 500, "src/img/F.png");
						}
						else if (this.telaSelecao.getNome().equalsIgnoreCase("Niklaus")) {
							this.protagonista = new Protagonista("img/Niklaus.png", 32, 32, 4, 3, 0, 2000, 32, 96, this.tela.getTelaSelecao().getTfNome().getText(), true,
									"img/Raio.png", 4, 128, 500, "src/img/M.png");
						}

					} 
					
					catch (IOException arg) {
						arg.printStackTrace();
					}
					
					
					this.controleFases = new ControleFases(tela, this.protagonista);
			
					
				}
				
			}
		}
		
		else if(e.getSource() == this.tela.getTelaInventario().getBtnPausar()){
		
			this.controleFases.getControleFase().desativarThread();
			this.tela.getCardInventario().show(this.tela.getPanelInventario(), "2");
		}
		else if(e.getSource() == this.tela.getTelaPausa().getBtnSair()){
			Runtime rt = Runtime.getRuntime();
			System.out.println("Memória total da JVM: " + rt.totalMemory());
			System.out.println("Memória antes da criação dos objetos: " + rt.freeMemory());
		  
		  
			
			//Parando
			this.tela.getPanelInventario().setVisible(false);
			this.tela.getPanelJogavel().setVisible(false);
			this.tela.getPanelGeral().setVisible(true);
			this.controleFases.getControleFase().desativarThread();
			this.controleFases.getControleFase().getTimer().stop();
			//setar para null
			this.controleFases.getControleFase().stop();
			this.tela.getCardGeral().show(this.tela.getPanelGeral(), "1");
		
			this.controleFases = null;
			System.gc();
			
			
			this.tela.getPanelJogavel().remove(0);
			this.tela.getPanelJogavel().remove(1);
		
			
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
		
			
			System.gc();
			System.out.println("Memória depois executar o gc: " + rt.freeMemory());
			
			
			//Setando novamente
			
		
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
			
			
			
			
		}
		
		else if(e.getSource() == this.telaPausa.getBtnVoltar()){
			this.controleFases.getControleFase().ativarThread();
			this.tela.getCardInventario().show(this.tela.getPanelInventario(), "1");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.telaSelecao.getLbFeminino()){
			this.telaSelecao.getLbInfo().setText("Rebekah Selecionada");
			this.telaSelecao.getLbInfo().setForeground(new Color(113,177,169));
			this.telaSelecao.setSelecionado("Rebekah");
			this.telaSelecao.setNome("Rebekah");
			
			
		}
		
		else if (e.getSource() == this.telaSelecao.getLbMasculino()){
			this.telaSelecao.getLbInfo().setText("Niklaus Selecionado");
			this.telaSelecao.getLbInfo().setForeground(new Color(255, 171,15));
			this.telaSelecao.setSelecionado("Niklaus");
			this.telaSelecao.setNome("Niklaus");
		}
		
		
		
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
