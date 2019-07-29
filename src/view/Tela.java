package view;

import java.awt.CardLayout;
import java.awt.List;
import java.awt.Rectangle;
import java.lang.reflect.Array;
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
	
	private ArrayList<Protagonista> resultados;
	
	
	
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
		
		
		
		xml = new XmlUsuario();
		
		resultados = (ArrayList<Protagonista>) xml.ler();

		
		
		this.telaAbertura = new TelaAbertura();
		this.telaInformacoes = new TelaInformacoes(resultados);
		this.telaSelecao = new TelaSelecao();
		
		
		
		
		
		cardGeral.addLayoutComponent(this.telaAbertura, "1");
		cardGeral.addLayoutComponent(this.telaInformacoes, "2");
		cardGeral.addLayoutComponent(this.telaSelecao, "3");
		
		panelGeral.add(telaAbertura);
		panelGeral.add(telaInformacoes);
		panelGeral.add(telaSelecao);
		
		
		
		//cardInventario.addLayoutComponent(this.telaInventarioMultiplayer, "3");
		
		//panelInventario.add(telaInventarioMultiplayer);
		
		this.telaConfig = new TelaConfiguracoes();
		
		add(panelGeral);
		
		cardGeral.show(panelGeral, "1");
		
		
		setVisible(true);
	}
	
	
	

	public void setResultados(ArrayList<Protagonista> resultados) {
		this.resultados = resultados;
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





	public TelaConfiguracoes getTelaConfig() {
		return telaConfig;
	}




	public ArrayList<Protagonista> getResultados() {
		return resultados;
	}
	
	
	
	
}
