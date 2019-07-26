package view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class SinglePlayer{
	private JPanel  panelJogavel, panelInventario, panelResultados;
	
	private TelaAnd telaAnd; 
	private TelaOr telaOr;	
	private TelaNot telaNot;
	
	private TelaPausa telaPausa;
	private TelaInventario telaInventario;
	private TelaTransicao telaTransicao;
	private CardLayout cardJogavel, cardInventario, cardResultados;
	
	
	public SinglePlayer(Tela tela){
		
		this.cardJogavel = new CardLayout();
		this.cardInventario = new CardLayout();
		this.cardResultados = new CardLayout();
		
		panelJogavel = new JPanel();
		panelJogavel.setLayout(cardJogavel);
		panelJogavel.setVisible(false);
		panelJogavel.setBounds(0,0,800,704);
		
		panelResultados = new JPanel();
		panelResultados.setLayout(cardResultados);
		panelResultados.setVisible(false);
		panelResultados.setBounds(0,0,1000,704);
		panelResultados.setVisible(false);
		
		panelInventario = new JPanel();
		panelInventario.setLayout(cardInventario);
		panelInventario.setVisible(false);
		panelInventario.setBounds(800, 0, 200, 704);
		
		this.telaAnd = new TelaAnd();
		this.telaOr = new TelaOr();
		this.telaNot = new TelaNot();
		
		this.telaInventario = new TelaInventario();
		this.telaPausa = new TelaPausa();
		this.telaTransicao = new TelaTransicao();
		
		cardJogavel.addLayoutComponent(telaAnd, "1");
		cardJogavel.addLayoutComponent(telaOr, "2");
		cardJogavel.addLayoutComponent(telaNot, "3");
		
		cardInventario.addLayoutComponent(this.telaInventario, "1");
		cardInventario.addLayoutComponent(this.telaPausa, "2");
		
		
		cardResultados.addLayoutComponent(telaTransicao, "1");
		
		panelJogavel.add(telaAnd);
		panelJogavel.add(telaOr);
		panelJogavel.add(telaNot);
		panelJogavel.add(telaTransicao);

		panelInventario.add(telaInventario);
		panelInventario.add(telaPausa);
		
		panelResultados.add(telaTransicao);
		
		tela.add(panelJogavel);
		tela.add(panelInventario);
		tela.add(panelResultados);
		
		
		
	}

	

	public JPanel getPanelResultados() {
		return panelResultados;
	}



	public CardLayout getCardResultados() {
		return cardResultados;
	}



	public JPanel getPanelJogavel() {
		return panelJogavel;
	}



	public JPanel getPanelInventario() {
		return panelInventario;
	}



	public TelaAnd getTelaAnd() {
		return telaAnd;
	}



	public TelaOr getTelaOr() {
		return telaOr;
	}



	public TelaNot getTelaNot() {
		return telaNot;
	}



	public TelaPausa getTelaPausa() {
		return telaPausa;
	}



	public TelaInventario getTelaInventario() {
		return telaInventario;
	}



	public TelaTransicao getTelaTransicao() {
		return telaTransicao;
	}



	public CardLayout getCardJogavel() {
		return cardJogavel;
	}



	public CardLayout getCardInventario() {
		return cardInventario;
	}
	
	

}
