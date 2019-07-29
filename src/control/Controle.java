package control;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.BancoExercicios;
import model.Exercicio;
import model.Protagonista;
import model.XmlExercicio;
import view.Multiplayer;
import view.ShowMessage;
import view.SinglePlayer;
import view.Tela;
import view.TelaAbertura;
import view.TelaAnd;
import view.TelaCadastro;
import view.TelaInformacoes;
import view.TelaInventario;
import view.TelaNot;
import view.TelaOr;
import view.TelaPausa;
import view.TelaSelecao;
import view.TelaSelectMultiplayer;

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
	private TelaCadastro telaCadastro;
	private XmlExercicio xmlExercicio;
	private ControleMultiplayer controleMultiplayer;
	private Multiplayer multiplayer;
	private TelaSelectMultiplayer telaSelecMultiplayer;
	
	public Controle(Tela tela){
		this.tela = tela;
		this.telaAbertura = tela.getTelaAbertura();
		this.telaInformacoes = tela.getTelaInformacoes();
		this.telaSelecao = tela.getTelaSelecao();
		this.singlePlayer = new SinglePlayer(this.tela);
		this.multiplayer = new Multiplayer(this.tela);
		this.xmlExercicio = new XmlExercicio();
		BancoExercicios.carregarXml(xmlExercicio);
		
		this.telaSelecMultiplayer = new TelaSelectMultiplayer();
	
	
		this.telaCadastro = new TelaCadastro();
		
		ativar();
		
	}
	
	public void ativar(){
		this.telaAbertura.getBtnConfig().addActionListener(this);
		this.telaAbertura.getBtnExit().addActionListener(this);
		this.telaAbertura.getBtnSingle().addActionListener(this);
		this.telaAbertura.getBtnMultiplayer().addActionListener(this);
		this.telaAbertura.getBtnAdd().addActionListener(this);
		
		this.telaInformacoes.getBtnControle().addActionListener(this);
		this.telaInformacoes.getBtnCreditos().addActionListener(this);
		this.telaInformacoes.getBtnSobre().addActionListener(this);
		this.telaInformacoes.getBtnResultados().addActionListener(this);
		this.telaInformacoes.getBtnVoltar().addActionListener(this);
		this.telaInformacoes.getRbSingle().addActionListener(this);
		this.telaInformacoes.getRbMulti().addActionListener(this);
		this.telaSelecao.getBtnConfirmar().addActionListener(this);
		this.telaSelecao.getBtnVoltar().addActionListener(this);
		this.telaSelecao.getLbFeminino().addMouseListener(this);
		this.telaSelecao.getLbMasculino().addMouseListener(this);
		
		this.singlePlayer.getTelaPausa().getBtnSair().addActionListener(this);
		this.singlePlayer.getTelaTransicao().getBtnSair().addActionListener(this);
		
		this.multiplayer.getTelaPausa().getBtnSair().addActionListener(this);
		this.multiplayer.getTelaResultado().getBtnSair().addActionListener(this);
		
		
		this.telaCadastro.getBtnCadastrar().addActionListener(this);
		this.telaCadastro.getBtnRemover().addActionListener(this);
		this.telaCadastro.getRbCadastrar().addActionListener(this);
		this.telaCadastro.getRbRemover().addActionListener(this);
		
		
		this.telaSelecMultiplayer.getBtnComecar().addActionListener(this);
		this.multiplayer.getTelaResultado().getBtnSair().addActionListener(this);
		this.multiplayer.getTelaPausa().getBtnSair().addActionListener(this);
	
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
		
		else if(e.getSource() == this.telaAbertura.getBtnMultiplayer() ){
			this.telaSelecMultiplayer.setVisible(true);
		}
		
		else if(e.getSource() == this.multiplayer.getTelaPausa().getBtnSair()){
			this.multiplayer.getPanelInventario().setVisible(false);
			this.multiplayer.getPanelJogavel().setVisible(false);
			this.multiplayer.getTelaResultado().setVisible(false);
			this.tela.getPanelGeral().setVisible(true);
			this.tela.getCardGeral().show(this.tela.getPanelGeral(), "1");
			this.controleMultiplayer.stop();
			this.controleMultiplayer = null;
			this.multiplayer = null;
			System.gc();
			
			this.multiplayer = new Multiplayer(this.tela);
			
			ativar();
			
			
			
		}
		
		else if(e.getSource() == this.multiplayer.getTelaResultado().getBtnSair()){
			
			this.tela.getXml().salvar(this.controleMultiplayer.getGanhador());
			
			
			this.tela.remove(this.multiplayer.getPanelInventario());
			this.tela.remove(this.multiplayer.getPanelJogavel());
			
			this.multiplayer.getPanelInventario().setVisible(false);
			this.multiplayer.getPanelJogavel().setVisible(false);
			this.multiplayer.getTelaResultado().setVisible(false);
			this.tela.getPanelGeral().setVisible(true);
			this.tela.getCardGeral().show(this.tela.getPanelGeral(), "1");
			this.controleMultiplayer.stop();
			this.controleMultiplayer = null;
			this.multiplayer = null;
			System.gc();
			
			this.multiplayer = new Multiplayer(this.tela);
		
			ativar();
			
		}
		else if(e.getSource() == this.telaSelecMultiplayer.getBtnComecar()){
			
			
			if(!this.telaSelecMultiplayer.getTfPlayer1().getText().equals("") 
					&&
				!this.telaSelecMultiplayer.getTfPlayer2().getText().equals("")){
				
				this.tela.getPanelGeral().setVisible(false);
				
				this.controleMultiplayer = new ControleMultiplayer(multiplayer, this.telaSelecMultiplayer.getTfPlayer1().getText(),
						this.telaSelecMultiplayer.getTfPlayer2().getText());
				
				this.controleMultiplayer.start();
				
				
				this.telaSelecMultiplayer.getTfPlayer1().setText("");
				this.telaSelecMultiplayer.getTfPlayer2().setText("");
				this.telaSelecMultiplayer.setVisible(false);
				
				
			}
		}
		
		else if(e.getSource() == this.telaAbertura.getBtnAdd()){
			this.telaCadastro.setVisible(true);
		}
		
		else if(e.getSource()== this.tela.getTelaConfig().getBtnVoltar()){
			this.tela.getTelaConfig().setVisible(false);
		}
		
		else if(e.getSource() == this.tela.getTelaInformacoes().getBtnControle()){
			this.telaInformacoes.getLbControle().setVisible(true);
			this.telaInformacoes.getLbSobre().setVisible(false);
			this.telaInformacoes.getLbCredito().setVisible(false);
			this.telaInformacoes.getBarra().setVisible(false);
			this.telaInformacoes.getRbMulti().setVisible(false);
			this.telaInformacoes.getRbSingle().setVisible(false);
		}
		
		else if(e.getSource() == this.telaInformacoes.getBtnCreditos()){
			this.telaInformacoes.getLbControle().setVisible(false);
			this.telaInformacoes.getLbSobre().setVisible(false);
			this.telaInformacoes.getLbCredito().setVisible(true);
			this.telaInformacoes.getBarra().setVisible(false);
			this.telaInformacoes.getRbMulti().setVisible(false);
			this.telaInformacoes.getRbSingle().setVisible(false);
		}
		
		else if(e.getSource() == this.tela.getTelaInformacoes().getBtnSobre()){
			this.telaInformacoes.getLbControle().setVisible(false);
			this.telaInformacoes.getLbSobre().setVisible(true);
			this.telaInformacoes.getLbCredito().setVisible(false);
			this.telaInformacoes.getBarra().setVisible(false);
			this.telaInformacoes.getRbMulti().setVisible(false);
			this.telaInformacoes.getRbSingle().setVisible(false);
		}
		
		else if(e.getSource() == this.telaInformacoes.getBtnVoltar() || e.getSource() == this.telaSelecao.getBtnVoltar()){
			this.tela.getCardGeral().show(this.tela.getPanelGeral(), "1");
			this.telaInformacoes.getLbControle().setVisible(false);
			this.telaInformacoes.getLbSobre().setVisible(true);
			this.telaInformacoes.getLbCredito().setVisible(false);
			this.telaInformacoes.getBarra().setVisible(false);
			this.telaInformacoes.getRbMulti().setVisible(false);
			this.telaInformacoes.getRbSingle().setVisible(false);
			
			
			
			this.telaSelecao.getLbInfo().setText("");
			this.telaSelecao.getTfNome().setText("");
			this.telaSelecao.setSelecionado("");
			
		}
		
		else if(e.getSource() == this.telaInformacoes.getRbMulti()){
			String temp = "= = = = RANKING MULTIPLAYER = = = =\n";
			
			this.tela.setResultados((ArrayList<Protagonista>) this.tela.getXml().ler());
			
			Collections.sort(this.tela.getResultados());
			
			
			for (Protagonista x : this.tela.getResultados()) {

				
				if(x.getModoFase().equalsIgnoreCase("Multi")){
					temp+= "Nome: " + x.getNome() + "\n";
					temp+= "Pontuação: "+x.getPontuacao()+"\n";
				}
				
			}
			
			this.telaInformacoes.getTextArea().setText(temp);
			
		}
		
		else if(e.getSource() == this.telaInformacoes.getRbSingle()){
			String temp = "= = = = RANKING SINGLEPLAYER = = = =\n";
			
			this.tela.setResultados((ArrayList<Protagonista>) this.tela.getXml().ler());
			
			Collections.sort(this.tela.getResultados());
			
			for (Protagonista x : this.tela.getResultados()) {

				
				if(x.getModoFase().equalsIgnoreCase("single")){
					temp+= "Nome: " + x.getNome() + "\n";
					temp+= "Pontuação: "+x.getPontuacao()+"\n";
					temp+= "Tempo: \n";
					temp+= "   Fase 1: " + x.getTempos().get(0) + "\n";
					temp+= "   Fase 2: " + x.getTempos().get(1) + "\n";
					temp+= "   Fase 3: " + x.getTempos().get(2) + "\n\n";
				}
				
			}
			
			this.telaInformacoes.getTextArea().setText(temp);
			
			
		}
		
		else if(e.getSource() == this.telaInformacoes.getBtnResultados()){
			this.telaInformacoes.getLbControle().setVisible(false);
			this.telaInformacoes.getLbSobre().setVisible(false);
			this.telaInformacoes.getLbCredito().setVisible(false);
			this.telaInformacoes.getBarra().setVisible(true);
			this.telaInformacoes.getRbMulti().setVisible(true);
			this.telaInformacoes.getRbSingle().setVisible(true);
			
			
			
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
									"img/Raio.png", 4, 128, 500, "src/img/F.png", 1, "Single");
						}
						else if (this.telaSelecao.getSelecionado().equalsIgnoreCase("Niklaus")) {
							this.protagonista = new Protagonista("img/Niklaus.png", 32, 32, 4, 3, 0, 2000, 32, 96, this.tela.getTelaSelecao().getTfNome().getText(), true,
									"img/Raio.png", 4, 128, 500, "src/img/M.png", 1, "Single");
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
		
		else if(e.getSource() == this.telaCadastro.getRbCadastrar()){
			this.telaCadastro.getPanelRemove().setVisible(false);
			this.telaCadastro.getPanelAdd().setVisible(true);
			
		}
		
		else if(e.getSource() == this.telaCadastro.getRbRemover()){
			this.telaCadastro.getPanelRemove().setVisible(true);
			this.telaCadastro.getPanelAdd().setVisible(false);
			
		}
		
		else if(e.getSource() == this.telaCadastro.getBtnRemover()){
			if(!this.telaCadastro.getTfIdentificador().getText().equals("")){
				
				BancoExercicios.removerExercicio(Integer.parseInt(this.telaCadastro.getTfIdentificador().getText()), xmlExercicio);
			
				
				
				
				
			}
			BancoExercicios.carregarXml(xmlExercicio);
			this.telaCadastro.getTextArea().setText(BancoExercicios.gerarTexto());
		}
		
		else if(e.getSource() == this.telaCadastro.getBtnCadastrar()){
			

			if(!this.telaCadastro.getTfEnunciado().getText().equals("")
					&& !this.telaCadastro.getTfResposta().getText().equals("")
					&& !this.telaCadastro.getTfTag().getText().equals("")){
				
				
				while (true){
					int id = new Random().nextInt(1000);
					if(BancoExercicios.buscar(id) == null){
						BancoExercicios.addExercicio(new Exercicio(
								this.telaCadastro.getTfEnunciado().getText(), 
								this.telaCadastro.getTfResposta().getText(),
								this.telaCadastro.getTfTag().getText(), 
								id), xmlExercicio);
						break;
					}
					
				}
				
				BancoExercicios.carregarXml(xmlExercicio);
				
				this.telaCadastro.getTextArea().setText(BancoExercicios.gerarTexto());
				
				
			}
			
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
