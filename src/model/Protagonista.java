package model;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.beans.Transient;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Protagonista extends Personagem implements Comparable<Protagonista>{
	private String nome;
	private int pontuacao;
	transient private Boolean intersectBau;
	transient private String caminhoTumb;
	transient private int qntBausAbertos;
	transient private String tempo;
	transient private boolean morto = false;
	
	private ArrayList<Exercicio> exercicios;

	transient private int direcoes[];
	
	transient private int action=-1;
	
	private String modoFase;
	
	
	public Protagonista(String fileImage, int largura, int altura, int linhas, int colunas, int aparencia, int qntVida,
			int posX, int posY,String nome, boolean condicaoExistenci, String poderImage,
			int colunasPoder, int larguraPoder, int dano, String caminhoThumb, int modoTeclado, String modoFase) throws IOException {
		super(fileImage, largura, altura, linhas, colunas, aparencia, qntVida, posX, posY
				, condicaoExistenci, poderImage, colunasPoder, larguraPoder, dano);
		
		this.modoFase = modoFase;
		this.nome = nome;
		this.intersectBau = false;
		this.caminhoTumb = caminhoThumb;
		getLifeBar().setBounds(25, 371, 153, 15);
		this.qntBausAbertos = 0;
		
		this.exercicios = new ArrayList<Exercicio>();
		
		
		this.direcoes = new int[6];
		
		if(modoTeclado == 1){
			this.direcoes[0] = KeyEvent.VK_DOWN;
			this.direcoes[1] = KeyEvent.VK_UP;
			this.direcoes[2] = KeyEvent.VK_RIGHT;
			this.direcoes[3] = KeyEvent.VK_LEFT; // esquerda
			this.direcoes[4] = KeyEvent.VK_N; // Soltar poder
			this.direcoes[5] = KeyEvent.VK_M; // ativar ba�
			

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
	
	
	
	
	
	public ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}





	public String getModoFase() {
		return modoFase;
	}





	public void setModoFase(String modoFase) {
		this.modoFase = modoFase;
	}





	public int getAction() {
		return action;
	}





	public void setAction(int action) {
		this.action = action;
	}





	public int[] getDirecoes() {
		return direcoes;
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





	@Override
	public int compareTo(Protagonista o) {
		 if (this.pontuacao > o.getPontuacao()) {
	          return -1;
	     }
	     if (this.pontuacao < o.getPontuacao()) {
	          return 1;
	     }
	     return 0;
	}
	
}
