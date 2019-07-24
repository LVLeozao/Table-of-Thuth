package view;

import java.awt.CardLayout;
import java.awt.Rectangle;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Bau;
import model.Camada;
import model.Inimigo;
import model.Personagem;
import model.Protagonista;
import model.XmlUsuario;

public class Tela extends JFrame{
	private JPanel panelGeral, panelJogavel, panelInventario;
	private TelaAnd telaAnd; 
	private TelaOr telaOr;	
	private TelaNot telaNot;
	private CardLayout cardGeral, cardJogavel, cardInventario;
	private TelaConfiguracoes telaConfig;

	private TelaPausa telaPausa;
	private TelaAbertura telaAbertura;
	private TelaInformacoes telaInformacoes;
	private TelaSelecao telaSelecao;
	private TelaInventario telaInventario;
	private TelaTransicao telaTransicao;
	private XmlUsuario xml;
	private TelaInventarioMultiplayer telaInventarioMultiplayer;
	private Multiplayer multiplayer;
	
	public Tela(){
		setSize(1000,704);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.cardGeral = new CardLayout();
		this.cardJogavel = new CardLayout();
		this.cardInventario = new CardLayout();
		
		panelGeral = new JPanel();
		panelGeral.setLayout(cardGeral);
		panelGeral.setBounds(0, 0, 1000, 704);
		
		panelJogavel = new JPanel();
		panelJogavel.setLayout(cardJogavel);
		panelJogavel.setVisible(false);
		panelJogavel.setBounds(0,0,800,704);
		
		panelInventario = new JPanel();
		panelInventario.setLayout(cardInventario);
		panelInventario.setVisible(false);
		panelInventario.setBounds(800, 0, 200, 704);
		
		this.telaAnd = new TelaAnd();
		this.telaOr = new TelaOr();
		this.telaNot = new TelaNot();
		this.multiplayer = new Multiplayer();
		
		
		this.telaAbertura = new TelaAbertura();
		this.telaInformacoes = new TelaInformacoes();
		this.telaSelecao = new TelaSelecao();
		this.telaInventario = new TelaInventario();
		this.telaInventarioMultiplayer = new TelaInventarioMultiplayer();
		this.telaPausa = new TelaPausa();
		this.telaTransicao = new TelaTransicao();
		
		cardJogavel.addLayoutComponent(telaAnd, "1");
		cardJogavel.addLayoutComponent(telaOr, "2");
		cardJogavel.addLayoutComponent(telaNot, "3");
		cardJogavel.addLayoutComponent(telaTransicao, "4");
		cardJogavel.addLayoutComponent(multiplayer, "5");
		
		
		panelJogavel.add(telaAnd);
		panelJogavel.add(telaOr);
		panelJogavel.add(telaNot);
		panelJogavel.add(telaTransicao);
		panelJogavel.add(multiplayer);
		
		
		cardGeral.addLayoutComponent(this.telaAbertura, "1");
		cardGeral.addLayoutComponent(this.telaInformacoes, "2");
		cardGeral.addLayoutComponent(this.telaSelecao, "3");
		
		panelGeral.add(telaAbertura);
		panelGeral.add(telaInformacoes);
		panelGeral.add(telaSelecao);
		
		
		cardInventario.addLayoutComponent(this.telaInventario, "1");
		cardInventario.addLayoutComponent(this.telaPausa, "2");
		cardInventario.addLayoutComponent(this.telaInventarioMultiplayer, "3");
		panelInventario.add(telaInventario);
		panelInventario.add(telaPausa);
		panelInventario.add(telaInventarioMultiplayer);
		
		xml = new XmlUsuario();
		
		this.telaConfig = new TelaConfiguracoes();
		
		add(panelGeral);
		add(panelInventario);
		add(panelJogavel);
		
		cardGeral.show(panelGeral, "1");
		
		
		setVisible(true);
	}
	
	


	public XmlUsuario getXml() {
		return xml;
	}




	public TelaPausa getTelaPausa() {
		return telaPausa;
	}



	public TelaInventario getTelaInventario() {
		return telaInventario;
	}



	public TelaAnd getTelaAnd() {
		return telaAnd;
	}



	public TelaNot getTelaNot() {
		return telaNot;
	}



	public TelaSelecao getTelaSelecao() {
		return telaSelecao;
	}


	public JPanel getPanelGeral() {
		return panelGeral;
	}



	public JPanel getPanelJogavel() {
		return panelJogavel;
	}



	public JPanel getPanelInventario() {
		return panelInventario;
	}



	public TelaOr getTelaOr() {
		return telaOr;
	}



	public CardLayout getCardGeral() {
		return cardGeral;
	}



	public CardLayout getCardJogavel() {
		return cardJogavel;
	}



	public CardLayout getCardInventario() {
		return cardInventario;
	}



	public TelaAbertura getTelaAbertura() {
		return telaAbertura;
	}



	public TelaInformacoes getTelaInformacoes() {
		return telaInformacoes;
	}




	public void setTelaAnd(TelaAnd telaAnd) {
		this.telaAnd = telaAnd;
	}




	public void setTelaOr(TelaOr telaOr) {
		this.telaOr = telaOr;
	}




	public void setTelaNot(TelaNot telaNot) {
		this.telaNot = telaNot;
	}




	public void setCardJogavel(CardLayout cardJogavel) {
		this.cardJogavel = cardJogavel;
	}




	public void setCardInventario(CardLayout cardInventario) {
		this.cardInventario = cardInventario;
	}




	public void setTelaInventario(TelaInventario telaInventario) {
		this.telaInventario = telaInventario;
	}




	public TelaTransicao getTelaResultado() {
		return telaTransicao;
	}




	public TelaInventarioMultiplayer getTelaInventarioMultiplayer() {
		return telaInventarioMultiplayer;
	}




	public Multiplayer getMultiplayer() {
		return multiplayer;
	}




	public TelaConfiguracoes getTelaConfig() {
		return telaConfig;
	}
	
	
	
	
}
