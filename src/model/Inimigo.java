package model;

import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

public class Inimigo extends Personagem{
	private String texto;
	private int resposta;
	
	//private Exercicio exercicio;

	public Inimigo(String fileImage, int largura, int altura, int linhas, int colunas, int aparencia, int qntVida,
			int posX, int posY, boolean condicaoExistencia, String poderImage,
			int colunasPoder, int larguraPoder, int dano, String texto, int resposta) throws IOException {
		super(fileImage, largura, altura, linhas, colunas, aparencia, qntVida, posX, posY, condicaoExistencia, poderImage, colunasPoder, larguraPoder, dano);
	
		this.texto = texto;
		this.resposta = resposta;
		
		getLifeBar().setBounds(posX+8, posY-12, 25, 8);
		
	}

	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getResposta() {
		return resposta;
	}

	public void setResposta(int resposta) {
		this.resposta = resposta;
	}
	
	
	
}
