package model;

public class Destroy {
	public static void gC(Object obj){
		obj = null;
		System.gc();
	}
}
