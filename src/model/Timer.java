package model;

import view.TelaInventario;

public class Timer extends Thread{

	private TelaInventario inventario;
	private Protagonista protagonista;
	private int mm,ss;
	
	
	public Timer(TelaInventario inventario, Protagonista protagonista) {
		this.inventario = inventario;
		this.protagonista = protagonista;
		this.mm = 0;
		this.ss = 0;
	}
	
	public void run(){
		while(true){
			
			if(ss == 60){
				ss = 0;
				mm+=1;
			}
			
			this.protagonista.setTempo(mm+":"+ss);
			this.inventario.getTimer().setText(mm+":"+ss);
			ss+=1;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
			
		}
	}
	
	
}
