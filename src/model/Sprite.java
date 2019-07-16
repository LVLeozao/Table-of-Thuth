package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;

public class Sprite extends JProgressBar{
	private BufferedImage personagem;
	private int largura, altura;
	private int linhas, colunas;
	private BufferedImage[] sprites;
	private int aparencia;

	
	
	public Sprite(String fileImage, int largura, int altura, int linhas, int colunas, int aparencia) throws IOException {
		this.personagem = ImageIO.read(getClass().getClassLoader().getResource(fileImage));
		this.largura = largura;
		this.altura = altura;
		this.linhas = linhas;
		this.colunas = colunas;
		this.aparencia = aparencia;
		sprites = new BufferedImage[colunas*linhas];
		for(int i = 0; i < colunas; i++) {
			for(int j = 0; j < linhas; j++) {
				sprites[(i * linhas) + j] = personagem.getSubimage(i * largura, j * altura, largura, altura);
			}
		}
		
	}


	public BufferedImage getPersonagem() {
		return personagem;
	}


	public int getLargura() {
		return largura;
	}


	public int getAltura() {
		return altura;
	}


	public int getLinhas() {
		return linhas;
	}


	public int getColunas() {
		return colunas;
	}


	public BufferedImage[] getSprites() {
		return sprites;
	}


	public int getAparencia() {
		return aparencia;
	}


	public void setAparencia(int aparencia) {
		this.aparencia = aparencia;
	}
	
	
	
	
	
	
	

}
