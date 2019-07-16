package model;

import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

public class Inimigo extends Personagem{
	

	public Inimigo(String fileImage, int largura, int altura, int linhas, int colunas, int aparencia, int qntVida,
			int posX, int posY,boolean condicaoExistencia, String poderImage,
			int colunasPoder, int larguraPoder, int dano) throws IOException {
		super(fileImage, largura, altura, linhas, colunas, aparencia, qntVida, posX, posY, condicaoExistencia, poderImage, colunasPoder, larguraPoder, dano);
	
		
		
		getLifeBar().setBounds(posX+8, posY-12, 25, 8);
		
	}

	//Add questionarios;

	
	
	
}
