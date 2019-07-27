package model;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JProgressBar;

public abstract class Personagem extends Sprite{
	private int qntVida;
	
	private int posX, posY;
	private int posLinha, posColuna;
	private boolean condicaoExistencia;
	private Poder poder;
	private JProgressBar lifeBar;
	private Rectangle rectangle;
	private ArrayList<String>tempos;

	
	
	public Personagem(String fileImage, int largura, int altura, int linhas, int colunas, int aparencia,
			int qntVida,int posX, int posY, boolean condicaoExistencia, String poderImage, int colunasPoder, 
			int larguraPoder, int dano) throws IOException {
		super(fileImage, largura, altura, linhas, colunas, aparencia);
		this.qntVida = qntVida;
		
		this.posX = posX;
		this.posY = posY;
		this.condicaoExistencia = condicaoExistencia;
		this.poder = new Poder(poderImage, larguraPoder, 32, 1, colunasPoder, 0, dano, larguraPoder, posX, posY);
		
		rectangle = new Rectangle(posX, posY, 32, 32);
		
		tempos = new ArrayList<String>();
		
		ativar();
		
		
		
	}
	
	public void ativar(){
		lifeBar = new JProgressBar();
		lifeBar.setMaximum(this.qntVida);
		lifeBar.setValue(this.qntVida);
		lifeBar.setBackground(new Color(0, 0, 0));
		lifeBar.setForeground(new Color(219, 37, 37));
		lifeBar.setBorderPainted(false);
		lifeBar.setToolTipText("Pontos de Vida");
	}
	
	
	public ArrayList<String> getTempos() {
		return tempos;
	}

	public JProgressBar getLifeBar() {
		return lifeBar;
	}

	public boolean isCondicaoExistencia() {
		return condicaoExistencia;
	}

	public void setCondicaoExistencia(boolean condicaoExistencia) {
		this.condicaoExistencia = condicaoExistencia;
	}

	public Rectangle setBounds(int posTempX, int posTempY){
		this.rectangle = new Rectangle(posTempX, posTempY, 32, 32);
		return this.rectangle;
	}
	
	public Rectangle getBounds(){
		return this.rectangle;
	}
	
	public int getQntVida() {
		return qntVida;
	}

	public void setQntVida(int qntVida) {
		this.qntVida = qntVida;
	}


	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosLinha() {
		return posLinha;
	}

	public void setPosLinha(int posLinha) {
		this.posLinha = posLinha;
	}

	public int getPosColuna() {
		return posColuna;
	}

	public void setPosColuna(int posColuna) {
		this.posColuna = posColuna;
	}

	public Poder getPoder() {
		return poder;
	}


}
