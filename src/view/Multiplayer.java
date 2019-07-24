package view;

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

public class Multiplayer extends JPanel{
	
	private ArrayList<Rectangle> matzColisao;
	private ArrayList<Personagem> personagens;
	private ArrayList<Exercicio> exercicios;
	
	private Protagonista player1;
	private Protagonista player2;
	
	private Boolean telaAtiva;
	
	private String camadaTile1, camadaTile2;
	private Camada camada1, camada2;
	private Itens itens;
	
	private ControlePersonagem controlePlayer1, controlePlayer2;
	
	
	public Multiplayer(){
		
		setSize(800, 704);
		setLayout(null);
		
		camada1 = new Camada("img/pisoMulti.png", "arquivos/paredeMulti.txt", 25, 22, 32, 32);
		camada1.montarMapa(800, 704);

		camada2 = new Camada("img/paredeMultiplayer.png", "arquivos/paredeMulti.txt", 25, 22, 32, 32);
		camada2.montarMapa(800, 704);
		matzColisao = camada2.montarColisao();
		
		
		exercicios = new ArrayList<Exercicio>();
		
		exercicios.add(new Exercicio("P1: V\nP2: V\nC = ??\n\nQual a saída para P1^P2 = C", 0));
		exercicios.add(new Exercicio("É possível entrar na festa se possuir identidade e for maior de idade.\n\nP1:Tem 19 anos\n"
				+ "P2:Não tem identidade\nC: ?? \n\nQual a saída para P1^P2 = C", 1));
		exercicios.add(new Exercicio("P1: Pi é um número racional\nP2: Raiz quadrada de 2 é um número irracional\nC: ??\n\nQual a saída para P1^P2 = C", 1));
		exercicios.add(new Exercicio("P1: V\nP2: V\nC = ??\n\nQual a saída para P1vP2 = C", 0));
		exercicios.add(new Exercicio("Se a Thread não for nula ou estiver ativada o processo será realizado.\n\nP1: Thread - NullPointerException \n"
				+ "P2: false\nC: ?? \n\nQual a saída para P1vP2 = C", 1));
		exercicios.add(new Exercicio("P1: Pi é um número racional\nP2: Raiz quadrada de 2 é um número irracional\nC: ??\n\nQual a saída para P1vP2 = C", 0));
		exercicios.add(new Exercicio("P1: ~V\nP2: V\nC = ??\n\nQual a saída para P1vP2 = C", 0));
		exercicios.add(new Exercicio("É possível concluir o precesso se as preposições forem verdadeiras.\n\nP1:Verdade\n"
				+ "P2: Falso\nC: ?? \n\nQual a saída para (~P1)^(~P2) = (~C)", 1));
		exercicios.add(new Exercicio("P1: Leonardo é de Pernambuco\nP2: Maria, também\nC: ??\n\nQual a saída para P1^(~P2) = C", 1));
		
		
		
		
		
		try {
			itens = new Itens("img/itens.png", 64, 64, 1, 5, 4, 50, 50);
			this.personagens = new ArrayList<Personagem>();
			
			this.player1 = new Protagonista("img/Rebekah.png", 32, 32, 4, 3, 0, 10000, 32, 96, "Rebekah", true,
					"img/Raio.png", 4, 128, 500, "src/img/F.png", 1);
			
			this.player2 = new Protagonista("img/Niklaus.png", 32, 32, 4, 3, 0, 10000, 128, 96, "Niklaus", true,
					"img/Raio.png", 4, 128, 500, "src/img/M.png", 2);
			
			
			this.personagens.add(this.player1);
			this.personagens.add(this.player2);
			
			
			
			
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		int[] gerar;
		for (Personagem personagem : this.personagens) {
			if(personagem instanceof Inimigo){
				gerar = GerarPosicao.gerarPosicaoXY(this.matzColisao, this.camada2.mapa); 
				
				personagem.setPosX(gerar[0]);
				personagem.setPosY(gerar[1]);
				
			}
			
		}
		

	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(camada1.camada, 0, 0, this);
		g.drawImage(camada2.camada, 0, 0, this);

		for (Personagem personagem : personagens) {
			if (personagem.isCondicaoExistencia()) {
				g.drawImage(personagem.getSprites()[personagem.getAparencia()], personagem.getPosX(),
						personagem.getPosY(), this);

			}
		
			if(personagem.getPoder().isAtivo()){
				g.drawImage(personagem.getPoder().getSprites()[personagem.getPoder().getAparencia()], 
					personagem.getPoder().getPosX(), personagem.getPoder().getPosY(), this);
			}
			
		}
		
		if(itens.isAtivo()){
			g.drawImage(itens.getSprites()[itens.getAparencia()].getScaledInstance(32, 32, 100), itens.getPosX(),
					itens.getPosY(), this);
		}

	}


	public ArrayList<Rectangle> getMatzColisao() {
		return matzColisao;
	}


	public ArrayList<Personagem> getPersonagens() {
		return personagens;
	}


	public Boolean getTelaAtiva() {
		return telaAtiva;
	}


	public Camada getCamada1() {
		return camada1;
	}


	public Camada getCamada2() {
		return camada2;
	}


	public ControlePersonagem getControlePlayer1() {
		return controlePlayer1;
	}


	public ControlePersonagem getControlePlayer2() {
		return controlePlayer2;
	}


	public void setControlePlayer1(ControlePersonagem controlePlayer1) {
		this.controlePlayer1 = controlePlayer1;
	}


	public void setControlePlayer2(ControlePersonagem controlePlayer2) {
		this.controlePlayer2 = controlePlayer2;
	}


	public Protagonista getPlayer1() {
		return player1;
	}


	public void setPlayer1(Protagonista player1) {
		this.player1 = player1;
	}


	public Protagonista getPlayer2() {
		return player2;
	}


	public void setPlayer2(Protagonista player2) {
		this.player2 = player2;
	}


	public Itens getItens() {
		return itens;
	}


	public ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}

	
	
	
	
	
	
	
	
	
}
