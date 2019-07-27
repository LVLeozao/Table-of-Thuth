package control;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import model.Protagonista;
import view.SinglePlayer;
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
	private ControleSinglePlayer controleSingle;
	private Protagonista protagonista;
	private SinglePlayer singlePlayer;
	
	public Controle(Tela tela){
		this.tela = tela;
		this.telaAbertura = tela.getTelaAbertura();
		this.telaInformacoes = tela.getTelaInformacoes();
		this.telaSelecao = tela.getTelaSelecao();
		this.singlePlayer = new SinglePlayer(this.tela);
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
		
		this.singlePlayer.getTelaPausa().getBtnSair().addActionListener(this);
		this.singlePlayer.getTelaTransicao().getBtnSair().addActionListener(this);
		
	
	}
	
	public void matarControleSingle(){
		this.tela.remove(this.singlePlayer.getTelaAnd());
		this.tela.remove(this.singlePlayer.getTelaOr());
		this.tela.remove(this.singlePlayer.getTelaNot());
		
		
		this.singlePlayer.getPanelResultados().setVisible(false);
		this.singlePlayer.getPanelInventario().setVisible(false);
		this.singlePlayer.getPanelJogavel().setVisible(false);
		this.singlePlayer = null;
		this.controleSingle.getThreadTransicao().stop();
		this.controleSingle.setThreadTransicao(null);
		this.controleSingle.stop();
		this.controleSingle = null;
		
		System.gc();
		
		this.singlePlayer = new SinglePlayer(this.tela);
		this.protagonista = null;
		
		this.tela.getPanelGeral().setVisible(true);
		this.tela.getCardGeral().show(this.tela.getPanelGeral(), "1");
		ativar();
	}
	
	public void actionPerformed(ActionEvent e) {
		
	
		if(e.getSource() == this.tela.getTelaAbertura().getBtnConfig()){
			this.tela.getCardGeral().show(this.tela.getPanelGeral(), "2");
		}
		
		else if(e.getSource()== this.tela.getTelaConfig().getBtnVoltar()){
			this.tela.getTelaConfig().setVisible(false);
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
					
					
					this.tela.getPanelGeral().setVisible(false);
					
					 
					
					this.controleSingle = new ControleSinglePlayer(singlePlayer, this.protagonista);
					
					this.controleSingle.start();
				
					this.telaSelecao.setSelecionado("");
					this.telaSelecao.getLbInfo().setText("");
					this.telaSelecao.getTfNome().setText("");
					
				}
				
			}
		}
		
		else if(e.getSource() == this.singlePlayer.getTelaPausa().getBtnSair()){
			this.matarControleSingle();
		}
		
		else if(e.getSource() == this.singlePlayer.getTelaTransicao().getBtnSair()){
			this.tela.getXml().salvar(this.protagonista);
			this.matarControleSingle();
			
			
			
			
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
