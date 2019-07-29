package view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.BancoExercicios;
import model.Camada;
import model.Exercicio;
import model.Itens;
import model.Personagem;
import model.Protagonista;
import model.XmlExercicio;

public class TelaJogoMultiplayer extends JPanel{
	private ArrayList<Rectangle> matzColisao;
	private ArrayList<Personagem> personagens;
	private Boolean telaAtiva;
	private String camadaTile1, camadaTile2;
	private Camada camada1, camada2;
	private Itens itens;
	private Protagonista player1, player2;
	
	private ArrayList<Exercicio> exercicios;
	
	
	public TelaJogoMultiplayer(String nome1, String nome2){
		setSize(800, 704);
		setLayout(null);
		
		BancoExercicios.carregarXml(new XmlExercicio());
		exercicios = BancoExercicios.getArray();
		camada1 = new Camada("img/pisoMulti.png", "arquivos/paredeMulti.txt", 25, 22, 32, 32);
		camada1.montarMapa(800, 704);

		camada2 = new Camada("img/paredeMultiplayer.png", "arquivos/paredeMulti.txt", 25, 22, 32, 32);
		camada2.montarMapa(800, 704);
		matzColisao = camada2.montarColisao();
		
		this.telaAtiva = true;
		
		try {
			itens = new Itens("img/itens.png", 64, 64, 1, 5, 4, 50, 50);
			this.personagens = new ArrayList<Personagem>();
			
			this.player2 = new Protagonista("img/Rebekah.png", 32, 32, 4, 3, 0, 10000, 32, 96, nome1, true,
					"img/Raio.png", 4, 128, 500, "src/img/F.png", 1, "Multi");
			
			this.player1 = new Protagonista("img/Niklaus.png", 32, 32, 4, 3, 0, 10000, 128, 96, nome2, true,
					"img/Raio.png", 4, 128, 500, "src/img/M.png", 2, "Multi");
			
			
			this.personagens.add(this.player1);
			this.personagens.add(this.player2);
			
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
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


	public Boolean getTelaAtiva() {
		return telaAtiva;
	}


	public void setTelaAtiva(Boolean telaAtiva) {
		this.telaAtiva = telaAtiva;
	}


	public ArrayList<Rectangle> getMatzColisao() {
		return matzColisao;
	}


	public ArrayList<Personagem> getPersonagens() {
		return personagens;
	}


	public Camada getCamada1() {
		return camada1;
	}


	public Camada getCamada2() {
		return camada2;
	}


	public Itens getItens() {
		return itens;
	}


	public Protagonista getPlayer1() {
		return player1;
	}


	public Protagonista getPlayer2() {
		return player2;
	}


	public ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}
	
	
	
}
