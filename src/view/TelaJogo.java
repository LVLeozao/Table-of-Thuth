package view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Bau;
import model.Camada;
import model.GerarPosicao;
import model.Inimigo;
import model.Personagem;
import model.Protagonista;

public abstract class TelaJogo extends JPanel {

	private Camada camada1, camada2, camada3;

	private ArrayList<Rectangle> matzColisao;
	private ArrayList<Rectangle> matzColisaoBaus;
	private ArrayList<Bau> baus = new ArrayList<Bau>();
	private ArrayList<Personagem> personagens;

	private Inimigo inimigo1, inimigo2, inimigo3;
	private Protagonista protagonista;

	private Boolean telaAtiva;

	private String camadaTile1, camadaTile2, camadaTile3;
	private String arquivoCamada1, arquivoCamada2, arquivoCamada3;

	private String imgInimigo, poderImagemInimigo;

	public TelaJogo(String camadaTile1, String camadaTile2, String camadaTile3, String arquivoCamada1,
			String arquivoCamada2, String arquivoCamada3, String imgInimigo, String poderImagemInimigo) {

		this.camadaTile1 = camadaTile1;
		this.camadaTile2 = camadaTile2;
		this.camadaTile3 = camadaTile3;

		this.arquivoCamada1 = arquivoCamada1;
		this.arquivoCamada2 = arquivoCamada2;
		this.arquivoCamada3 = arquivoCamada3;

		this.imgInimigo = imgInimigo;
		this.poderImagemInimigo = poderImagemInimigo;

		setSize(800, 704);
		setLayout(null);

		camada1 = new Camada(this.camadaTile1, this.arquivoCamada1, 25, 22, 32, 32);
		camada1.montarMapa(800, 704);

		camada2 = new Camada(this.camadaTile2, this.arquivoCamada2, 25, 22, 32, 32);
		camada2.montarMapa(800, 704);
		matzColisao = camada2.montarColisao();
		matzColisaoBaus = camada2.getBausColisao();

		camada3 = new Camada(this.camadaTile3, this.arquivoCamada3, 25, 22, 32, 32);
		camada3.montarMapa(800, 704);
		
		baus.add(new Bau("", matzColisaoBaus.get(0)));
		baus.add(new Bau("", matzColisaoBaus.get(1)));
		baus.add(new Bau("", matzColisaoBaus.get(2)));
		
		try {

			personagens = new ArrayList<Personagem>();

			inimigo1 = new Inimigo(imgInimigo, 32, 32, 4, 3, 3, 2000, 0, 0, true, poderImagemInimigo, 4, 128, 500, "", 0);
			inimigo2 = new Inimigo(imgInimigo, 32, 32, 4, 3, 3, 2000, 0, 0, true, poderImagemInimigo, 4, 128, 500, "", 0);
			inimigo3 = new Inimigo(imgInimigo, 32, 32, 4, 3, 3, 2000, 0, 0, true, poderImagemInimigo, 4, 128, 500, "", 0);

			personagens.add(inimigo1);
			personagens.add(inimigo2);
			personagens.add(inimigo3);

		}

		catch (IOException e) {
			e.printStackTrace();
		}

		int[] gerar; 
		
		
		for (Personagem personagem : getPersonagens()) {
			if(personagem instanceof Inimigo){
				gerar = GerarPosicao.gerarPosicaoXY(this.matzColisao, this.camada2.mapa); 
				
				personagem.setPosX(gerar[0]);
				personagem.setPosY(gerar[1]);
				
			}
			
		}
		
		
		for (Personagem teste : this.personagens) {
			add(teste.getLifeBar());
		}
		
		
		
		
	}
	


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(camada1.camada, 0, 0, this);
		g.drawImage(camada2.camada, 0, 0, this);
		g.drawImage(camada3.camada, 0, 0, this);

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

	}

	public void setImgInimigo(String imgInimigo) {
		this.imgInimigo = imgInimigo;
	}

	public void setPoderImagemInimigo(String poderImagemInimigo) {
		this.poderImagemInimigo = poderImagemInimigo;
	}

	public String getCamadaTile1() {
		return camadaTile1;
	}

	public void setCamadaTile1(String camadaTile1) {
		this.camadaTile1 = camadaTile1;
	}

	public String getCamadaTile2() {
		return camadaTile2;
	}

	public void setCamadaTile2(String camadaTile2) {
		this.camadaTile2 = camadaTile2;
	}

	public String getCamadaTile3() {
		return camadaTile3;
	}

	public void setCamadaTile3(String camadaTile3) {
		this.camadaTile3 = camadaTile3;
	}

	public String getArquivoCamada1() {
		return arquivoCamada1;
	}

	public void setArquivoCamada1(String arquivoCamada1) {
		this.arquivoCamada1 = arquivoCamada1;
	}

	public String getArquivoCamada2() {
		return arquivoCamada2;
	}

	public void setArquivoCamada2(String arquivoCamada2) {
		this.arquivoCamada2 = arquivoCamada2;
	}

	public String getArquivoCamada3() {
		return arquivoCamada3;
	}

	public void setArquivoCamada3(String arquivoCamada3) {
		this.arquivoCamada3 = arquivoCamada3;
	}

	public Camada getCamada1() {
		return camada1;
	}

	public void setCamada1(Camada camada1) {
		this.camada1 = camada1;
	}

	public Camada getCamada2() {
		return camada2;
	}

	public void setCamada2(Camada camada2) {
		this.camada2 = camada2;
	}

	public Camada getCamada3() {
		return camada3;
	}

	public void setCamada3(Camada camada3) {
		this.camada3 = camada3;
	}

	public Protagonista getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(Protagonista protagonista) {
		this.protagonista = protagonista;
	}

	public Boolean getTelaAtiva() {
		return telaAtiva;
	}

	public void setTelaAtiva(Boolean telaAtiva) {
		this.telaAtiva = telaAtiva;
	}

	public ArrayList<Personagem> getPersonagens() {
		return personagens;
	}

	public ArrayList<Rectangle> getMatzColisao() {
		return matzColisao;
	}

	public ArrayList<Rectangle> getMatzColisaoBaus() {
		return matzColisaoBaus;
	}

	public ArrayList<Bau> getBaus() {
		return baus;
	}

	public Inimigo getInimigo1() {
		return inimigo1;
	}

	public Inimigo getInimigo2() {
		return inimigo2;
	}

	public Inimigo getInimigo3() {
		return inimigo3;
	}

	public String getImgInimigo() {
		return imgInimigo;
	}

	public String getPoderImagemInimigo() {
		return poderImagemInimigo;
	}

}
