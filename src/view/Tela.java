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

public class Tela extends JFrame implements Cloneable{
	private JPanel panelGeral, panelJogavel, panelInventario;
	private TelaAnd telaAnd; 
	private TelaOr telaOr;	
	private TelaNot telaNot;
	private CardLayout cardGeral, cardJogavel, cardInventario;

	private TelaPausa telaPausa;
	private TelaAbertura telaAbertura;
	private TelaInformacoes telaInformacoes;
	private TelaSelecao telaSelecao;
	private TelaInventario telaInventario;
	
	
	public Tela(){
		setSize(1000,704);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setLayout(null);
		
		this.cardGeral = new CardLayout();
		//this.cardJogavel = new CardLayout();
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
		
		/*this.telaAnd = new TelaAnd();
		this.telaOr = new TelaOr();
		this.telaNot = new TelaNot();*/
		
		this.telaAbertura = new TelaAbertura();
		this.telaInformacoes = new TelaInformacoes();
		this.telaSelecao = new TelaSelecao();
		this.telaInventario = new TelaInventario();
		this.telaPausa = new TelaPausa();
	
		/*cardJogavel.addLayoutComponent(telaAnd, "1");
		cardJogavel.addLayoutComponent(telaOr, "2");
		cardJogavel.addLayoutComponent(telaNot, "3");*/
		
		/*panelJogavel.add(telaAnd);
		panelJogavel.add(telaOr);
		panelJogavel.add(telaNot);*/
		
		
		cardGeral.addLayoutComponent(this.telaAbertura, "1");
		cardGeral.addLayoutComponent(this.telaInformacoes, "2");
		cardGeral.addLayoutComponent(this.telaSelecao, "3");
		
		panelGeral.add(telaAbertura);
		panelGeral.add(telaInformacoes);
		panelGeral.add(telaSelecao);
		
		
		cardInventario.addLayoutComponent(this.telaInventario, "1");
		cardInventario.addLayoutComponent(this.telaPausa, "2");
		panelInventario.add(telaInventario);
		panelInventario.add(telaPausa);
	
		
		
		
		
		add(panelGeral);
		add(panelInventario);
		//add(panelJogavel);
		
		cardGeral.show(panelGeral, "1");
		
		
		setVisible(true);
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
	
	
	
	
}
