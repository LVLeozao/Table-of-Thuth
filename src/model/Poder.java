package model;

import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

public class Poder extends Sprite{

	private int dano;
	private int distancia;
	private int custo = 200;
	private int aparencia;
	private int posX, posY;
	private boolean ativo = false;
	
	
	private Rectangle rectangle;
	
	public Poder(String fileImage, int largura, int altura, int linhas, int colunas, int aparencia, int dano,
			int distancia, int posX, int posY) throws IOException {
		super(fileImage, 32, 32, linhas, colunas, aparencia);
		this.dano = dano;
		this.distancia = 4;

		this.posX = posX;
		this.posY = posY;
		
		
	}
	
	public Rectangle pegarRectangleTemp(int posTempX, int posTempY){
		this.rectangle = new Rectangle(posTempX, posTempY, 32, 32);
		
		return rectangle;
	}
	
	public Rectangle getBound(){
		return rectangle;
	}
	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public int getAparencia() {
		return aparencia;
	}


	public void setAparencia(int aparencia) {
		this.aparencia = aparencia;
	}


	public int getDano() {
		return dano;
	}

	public int getDistancia() {
		return distancia;
	}

	public int getCusto() {
		return custo;
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
	
	
	
	

}
