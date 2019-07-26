package model;

import java.awt.Rectangle;
import java.util.ArrayList;

public class VerificarColisao {

	
	public static boolean verificarColisaoPersonagens(Personagem personagem, ArrayList<Personagem> personagens){
		for (Personagem obj : personagens) {
			
			if(obj != personagem){
				if(personagem.getBounds().intersects(obj.getBounds())){
					return false;
				}
				
			}
		}
		return true;
	}
	
	
	public static boolean verificarColisao(int posTempX, int posTempY, ArrayList<Rectangle> matzColisao, Personagem personagem) {
		
		for (Rectangle rectangle : matzColisao) {
			
			if(rectangle.getBounds().intersects(personagem.setBounds(posTempX, posTempY))) {
			
				return false;
		
			}
		}
		
		return true;
		
	}

	/*
	public static boolean verificarColisao(int posTempX, int posTempY, ArrayList<Rectangle> matzColisao, Inimigo inimigo) {
		for (Rectangle rectangle : matzColisao) {
			if(rectangle.getBounds().intersects(inimigo.setBounds(posTempX, posTempY))) {
				return false;
			}
		}
		
		return true;
	}
	*/
	
	public static boolean verificarColisaoPoder(int posTempX, int posTempY, ArrayList<Rectangle> matzColisao,
			Poder poder) {

		for (Rectangle rectangle : matzColisao) {

			if (rectangle.getBounds().intersects(poder.pegarRectangleTemp(posTempX, posTempY))) {

				return false;
			}
		}

		return true;
	}

}
