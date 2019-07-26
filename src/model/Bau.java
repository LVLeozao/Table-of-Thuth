package model;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

import view.ShowMessage;

public class Bau {
	private Rectangle rectangle;
	private String texto;
	private Boolean wasActivated;
	private Som somBau;
	
	
	
	public Bau(String texto, Rectangle rectangle) {
		this.rectangle = rectangle;
		this.texto = texto;
		this.wasActivated = false;
		this.somBau = new Som("sons/somBau.wav");
		
	}

	
	public Som getSomBau() {
		return somBau;
	}


	public void mostrarInformação(){
		ShowMessage.showText(this.texto);
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
	
}
