package model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class GerarPosicao {
	
	public static int[] gerarPosicaoXY(ArrayList<Rectangle> tmp){
		Random random = new Random();
		int temp[] = new int[2];
		
		while(true){
			int x = random.nextInt(799);
			int y = random.nextInt(703);
			
			for (Rectangle retangulo : tmp) {
				if(retangulo.getBounds().intersects(new Rectangle(x, y, 32, 32).getBounds()) == false){
					temp[0] = x;
					temp[1] = y;
					return temp;
				}
				
			}
		}
		
		
		
	}
	


}
