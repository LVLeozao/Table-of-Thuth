package model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class GerarPosicao {
	
	public static int[] gerarPosicaoXY(ArrayList<Rectangle> matzColisao, int[][] matz){
		Random random = new Random();
		int temp[] = new int[2];
		
		while(true){
			int x = random.nextInt(799);
			int y = random.nextInt(703);
			
			
			boolean naoColidiu=false;
			
			for (Rectangle rect : matzColisao) {
				
				if(!new Rectangle(x,y,32,32).getBounds().intersects(rect)
						&& !new Rectangle(x+32,y,32,32).getBounds().intersects(rect)
						&& !new Rectangle(x-32,y,32,32).getBounds().intersects(rect)
						&& !new Rectangle(x,y-32,32,32).getBounds().intersects(rect)
						&& !new Rectangle(x,y+32,32,32).getBounds().intersects(rect)
						
						&& matz[y/32][x/32] == 0 && matz[y/32][(x+32)/32] == 0
						&& matz[y/32][(x-32)/32] == 0 && matz[(y+32)/32][x/32] == 0
						&& matz[(y-32)/32][x/32] == 0
						
						){
					naoColidiu = false;
				}
				else{
					naoColidiu = true;
				}
				
			}
		
			
			if(!naoColidiu){
				temp[0]=x;
				temp[1]=y;
				return temp;
			}
			

		}
		
		
		
	}
	


}
