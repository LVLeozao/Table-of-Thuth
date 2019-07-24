package model;

public class Exercicio{
	private String text;
	private int resposta;
	
	public Exercicio(String text, int resposta) {
		super();
		this.text = text;
		this.resposta = resposta;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getResposta() {
		return resposta;
	}
	public void setResposta(int resposta) {
		this.resposta = resposta;
	}
	
	
	
}
