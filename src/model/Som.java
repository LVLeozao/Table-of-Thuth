package model;
import java.applet.Applet;
import java.applet.AudioClip;

public class Som{

	
	private AudioClip abertura;
	
	public Som(String nomeSom){
		abertura = Applet.newAudioClip(this.getClass().getClassLoader().getResource(nomeSom));
	}
	

	public void play(){
		abertura.play();
	}
	
	public void stop(){
		abertura.stop();
	}
	
	public void loop(){
		abertura.loop();
	}

}