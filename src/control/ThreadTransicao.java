package control;

import javax.swing.ImageIcon;

import view.SinglePlayer;
import view.TelaJogo;

public class ThreadTransicao extends Thread{
	private SinglePlayer teste;
	
	
	
	public ThreadTransicao(SinglePlayer teste) {
		super();
		this.teste = teste;
	}

	public void sleep(){
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void run(){
		while(true){
			if(this.teste.getTelaAnd().getFaseAtiva1()){
				sleep();
				this.teste.getTelaAnd().setFaseAtiva1(false);
			}
			else if(this.teste.getTelaOr().getFaseAtiva2()){
				sleep();
				this.teste.getTelaOr().setFaseAtiva2(false);
			}
			else if(this.teste.getTelaNot().getFaseAtiva3()){
				sleep();
				this.teste.getTelaNot().setFaseAtiva3(false);
				break;
			}
		}
	}
}
