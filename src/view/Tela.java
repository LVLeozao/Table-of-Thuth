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
	private JPanel panelGeral;
	
	private CardLayout cardGeral;
	private TelaConfiguracoes telaConfig;
	private TelaAbertura telaAbertura;
	private TelaInformacoes telaInformacoes;
	private TelaSelecao telaSelecao;
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
		
		
		panelGeral = new JPanel();
		panelGeral.setLayout(cardGeral);
		panelGeral.setBounds(0, 0, 1000, 704);
		
		
		this.multiplayer = new Multiplayer();
		
		
		this.telaAbertura = new TelaAbertura();
		this.telaInformacoes = new TelaInformacoes();
		this.telaSelecao = new TelaSelecao();
		this.telaInventarioMultiplayer = new TelaInventarioMultiplayer();
		
		
		
		
		cardGeral.addLayoutComponent(this.telaAbertura, "1");
		cardGeral.addLayoutComponent(this.telaInformacoes, "2");
		cardGeral.addLayoutComponent(this.telaSelecao, "3");
		
		panelGeral.add(telaAbertura);
		panelGeral.add(telaInformacoes);
		panelGeral.add(telaSelecao);
		
		
		
		//cardInventario.addLayoutComponent(this.telaInventarioMultiplayer, "3");
		
		//panelInventario.add(telaInventarioMultiplayer);
		
		xml = new XmlUsuario();
		
		this.telaConfig = new TelaConfiguracoes();
		
		add(panelGeral);
		
		cardGeral.show(panelGeral, "1");
		
		
		setVisible(true);
	}
	
	


	public XmlUsuario getXml() {
		return xml;
	}






	public TelaSelecao getTelaSelecao() {
		return telaSelecao;
	}


	public JPanel getPanelGeral() {
		return panelGeral;
	}




	public CardLayout getCardGeral() {
		return cardGeral;
	}



	public TelaAbertura getTelaAbertura() {
		return telaAbertura;
	}

	public TelaInformacoes getTelaInformacoes() {
		return telaInformacoes;
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
