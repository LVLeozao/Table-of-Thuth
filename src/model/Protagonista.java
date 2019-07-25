package model;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Protagonista extends Personagem {
	private String nome;
	private int pontuacao;
	private Boolean intersectBau;
	private String caminhoTumb;
	private int qntBausAbertos;
	private String tempo;
	private boolean morto = false;
	private ArrayList<String> tempoFases;
	private int direcoes[];
	private int sentido=-1;
	
	
	
	public Protagonista(String fileImage, int largura, int altura, int linhas, int colunas, int aparencia, int qntVida,
			int posX, int posY,String nome, boolean condicaoExistenci, String poderImage,
			int colunasPoder, int larguraPoder, int dano, String caminhoThumb, int modoTeclado) throws IOException {
		super(fileImage, largura, altura, linhas, colunas, aparencia, qntVida, posX, posY
				, condicaoExistenci, poderImage, colunasPoder, larguraPoder, dano);
		
		this.nome = nome;
		this.intersectBau = false;
		this.caminhoTumb = caminhoThumb;
		getLifeBar().setBounds(25, 371, 153, 15);
		this.qntBausAbertos = 0;
		
		this.tempoFases = new ArrayList<String>();
		this.direcoes = new int[6];
		
		if(modoTeclado == 1){
			this.direcoes[0] = KeyEvent.VK_DOWN;
			this.direcoes[1] = KeyEvent.VK_UP;
			this.direcoes[2] = KeyEvent.VK_RIGHT;
			this.direcoes[3] = KeyEvent.VK_LEFT;
			this.direcoes[4] = KeyEvent.VK_N; // Soltar poder
			this.direcoes[5] = KeyEvent.VK_M; // ativar baú
			

		}
		else if(modoTeclado ==2){
			this.direcoes[0] = KeyEvent.VK_S;
			this.direcoes[1] = KeyEvent.VK_W;
			this.direcoes[2] = KeyEvent.VK_D;
			this.direcoes[3] = KeyEvent.VK_A;
			this.direcoes[4] = KeyEvent.VK_G; // Soltar poder
			this.direcoes[5] = KeyEvent.VK_H;
			
		}
		
		
		
		
	}
	
	
	
	
	
	public int[] getDirecoes() {
		return direcoes;
	}





	public ArrayList<String> getTempoFases() {
		return tempoFases;
	}





	public boolean isMorto() {
		return morto;
	}





	public void setMorto(boolean morto) {
		this.morto = morto;
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
