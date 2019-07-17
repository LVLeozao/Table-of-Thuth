package app;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import view.TelaInventario;

public class Teste {
	
	public static void main(String[] args) {
		
		
		int  mm, ss;
		String temp;
		mm = 1;
		ss = 55;
		
		while(true){
			
			if(ss == 60){
				ss = 0;
				mm+=1;
			}
			
			temp =  mm+":"+ss;
			ss+=1;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(mm == 2){
				break;
			}
			
		}
		
		
		
	}
}
