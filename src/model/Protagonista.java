package model;

import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;

public class Protagonista extends Personagem {
	private String nome;
	private int pontuacao;
	private Boolean intersectBau;
	private String caminhoTumb;
	private int qntBausAbertos;
	private String tempo;
	
	
	public Protagonista(String fileImage, int largura, int altura, int linhas, int colunas, int aparencia, int qntVida,
			int posX, int posY,String nome, boolean condicaoExistenci, String poderImage,
			int colunasPoder, int larguraPoder, int dano, String caminhoThumb) throws IOException {
		super(fileImage, largura, altura, linhas, colunas, aparencia, qntVida, posX, posY
				, condicaoExistenci, poderImage, colunasPoder, larguraPoder, dano);
		
		this.nome = nome;
		this.intersectBau = false;
		this.caminhoTumb = caminhoThumb;
		getLifeBar().setBounds(25, 371, 153, 15);
		this.qntBausAbertos = 0;
		
		
	}
	
	
	
	
	
	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public int getQntBausAbertos() {
		return qntBausAbertos;
	}


	public void setQntBausAbertos(int qntBausAbertos) {
		this.qntBausAbertos = qntBausAbertos;
	}


	public String getCaminhoTumb() {
		return caminhoTumb;
	}

	public Boolean getIntersectBau() {
		return intersectBau;
	}

	public void setIntersectBau(Boolean intersectBau) {
		this.intersectBau = intersectBau;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
