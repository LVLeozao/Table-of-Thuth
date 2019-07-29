package view;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import control.ControlePersonagem;
import model.Camada;
import model.Exercicio;
import model.GerarPosicao;
import model.Inimigo;
import model.Itens;
import model.Personagem;
import model.Protagonista;

public class Multiplayer{

	private JPanel  panelJogavel, panelInventario;
	private TelaPausa telaPausa;
	private TelaInventarioMultiplayer telaInventarioMultiplayer;
	private TelaResultadoMultiplayer telaResultado;
	private CardLayout cardJogavel, cardInventario;
	private Tela tela;
	private TelaFloresta telaFloresta;
	
	
	public Multiplayer(Tela tela){

		this.cardJogavel = new CardLayout();
		this.cardInventario = new CardLayout();
		this.telaResultado = new TelaResultadoMultiplayer();
		
		panelJogavel = new JPanel();
		panelJogavel.setLayout(cardJogavel);
		panelJogavel.setVisible(false);
		panelJogavel.setBounds(0,0,800,704);
	
		panelInventario = new JPanel();
		panelInventario.setLayout(cardInventario);
		panelInventario.setVisible(false);
		panelInventario.setBounds(800, 0, 200, 704);
		
		this.telaInventarioMultiplayer = new TelaInventarioMultiplayer();
		this.telaPausa = new TelaPausa();
	
		this.telaFloresta = new TelaFloresta("", "");
		
		cardJogavel.addLayoutComponent(this.telaFloresta, "1");
		
		cardInventario.addLayoutComponent(this.telaInventarioMultiplayer, "1");
		cardInventario.addLayoutComponent(this.telaPausa, "2");
		
	
		
		panelJogavel.add(this.telaFloresta);
		
		panelInventario.add(telaInventarioMultiplayer);
		panelInventario.add(telaPausa);

		
		
		
		
		tela.add(panelJogavel);
		tela.add(panelInventario);
	;
		

	}

	public JPanel getPanelJogavel() {
		return panelJogavel;
	}

	public JPanel getPanelInventario() {
		return panelInventario;
	}

	

	public TelaPausa getTelaPausa() {
		return telaPausa;
	}

	public TelaInventarioMultiplayer getTelaInventarioMultiplayer() {
		return telaInventarioMultiplayer;
	}



	public CardLayout getCardJogavel() {
		return cardJogavel;
	}

	public CardLayout getCardInventario() {
		return cardInventario;
	}

	

	public TelaFloresta getTelaFloresta() {
		return telaFloresta;
	}

	public TelaResultadoMultiplayer getTelaResultado() {
		return telaResultado;
	}
	
	
	


	
	
	
	
	
	
	
	
	
}
