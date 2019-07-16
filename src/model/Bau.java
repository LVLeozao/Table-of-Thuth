package model;

import java.awt.Rectangle;

import javax.swing.JOptionPane;



public class Bau {
	private Rectangle rectangle;
	private String texto;
	private String respostaCerta;
	private Boolean wasActivated;
	
	
	
	public Bau(String texto, Rectangle rectangle, String resposta) {
		this.rectangle = rectangle;
		this.texto = texto;
		this.respostaCerta = resposta;
		this.wasActivated = false;
		
	}
	
	public String getRespostaCerta() {
		return respostaCerta;
	}




	public Rectangle getRectangle() {
		return rectangle;
	}

	public Boolean getWasActivated() {
		return wasActivated;
	}

	public void setWasActivated(Boolean wasActivated) {
		this.wasActivated = wasActivated;
	}
	
	
	
}
