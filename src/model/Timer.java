package model;

import view.TelaInventario;

public class Timer extends Thread{

	private TelaInventario inventario;
	private Protagonista protagonista;
	private int mm,ss;
	private boolean pausa;
	
	
	public Timer(TelaInventario inventario, Protagonista protagonista) {
		this.inventario = inventario;
		this.protagonista = protagonista;
		this.mm = 0;
		this.ss = 0;
		this.pausa = false;
		this.protagonista.setTempo("");
		
	}
	
	public void run(){
		while (true){
			
			while(this.pausa == false){
				
				
				if(ss == 60){
					ss = 0;
					mm+=1;
				}
				
				this.protagonista.setTempo(mm+":"+ss);
				
				ss+=1;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
			
		
			
	
		
	}

	public boolean isPausa() {
		return pausa;
	}

	public void setPausa(boolean pausa) {
		
		this.pausa = pausa;
		
	}
	
	
}
