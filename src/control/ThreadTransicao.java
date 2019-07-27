package control;

import javax.swing.ImageIcon;

import view.SinglePlayer;
import view.TelaAnd;
import view.TelaJogo;
import view.TelaNot;
import view.TelaOr;

public class ThreadTransicao extends Thread{
	private TelaAnd telaAnd;
	private TelaOr telaOr;
	private TelaNot telaNot;
	private SinglePlayer single;
	
	public ThreadTransicao(SinglePlayer single) {
		super();
		this.single = single;
		this.telaAnd = single.getTelaAnd();
		this.telaOr = single.getTelaOr();
		this.telaNot = single.getTelaNot();
		
	}

	public void sleep(int tempo){
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void run(){
		while(true){
			
		
	
			if(this.telaAnd.getFaseAtiva1()){
				sleep(2500);
				this.telaAnd.setFaseAtiva1(false);
			}
			if(this.telaOr.getFaseAtiva2()){
				sleep(2500);
				this.telaOr.setFaseAtiva2(false);
			}
			if(this.telaNot.getFaseAtiva3()){
				sleep(2500);
				this.telaNot.setFaseAtiva3(false);
				break;
			}
			
			sleep(1);
			
		}
	}
}
