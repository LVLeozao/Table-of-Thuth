package model;

public class Exercicio{
	private String text;
	private String resposta;
	private String tag;
	private int id;
	
	public Exercicio(String text, String resposta, String tag, int id) {
		super();
		this.text = text;
		this.resposta = resposta;
		this.tag = tag;
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
