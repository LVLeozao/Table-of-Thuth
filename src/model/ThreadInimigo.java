package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import control.ControleInimigo;


public class ThreadInimigo extends Thread{
	
	private Inimigo inimigo;
	private ArrayList<Rectangle> matzColisao;
	private Random random;
	private ThreadPoder threadPoder;
	private ArrayList<Personagem> personagens;
	private ControleInimigo controleInimigo;
	
	
	public ThreadInimigo(Personagem inimigo, ArrayList<Personagem> personagens, ArrayList<Rectangle> matzColisao) {
		
		Inimigo temp = (Inimigo) inimigo;
		// Arrumar o and !!! tem que passar tudo !!!!
		this.inimigo = temp;
		this.matzColisao = matzColisao;
		this.personagens = personagens;
		
		
		this.controleInimigo = new ControleInimigo(this.inimigo,this.matzColisao, this.threadPoder, this.personagens);
		
	}
	

	public void run(){
		random = new Random();
		
		while(inimigo.isCondicaoExistencia()){
			
			try {
				int direcao = random.nextInt(5);
				
				controleInimigo.action(direcao);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

}
