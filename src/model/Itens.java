package model;

import java.awt.Rectangle;
import java.io.IOException;

public class Itens  extends Sprite{
	private boolean ativo;
	private int posX, posY;
	
	public Itens(String fileImage, int largura, int altura, int linhas, int colunas, int aparencia, int posX, int posY) throws IOException {
		super(fileImage, largura, altura, linhas, colunas, aparencia);
		this.ativo = true;
		this.posX = posX;
		this.posY = posY;
		
	
	}
	
	
	
	public Rectangle getBounds() {
		return new Rectangle(this.posX, this.posY, 32, 32).getBounds();
	}
	
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
