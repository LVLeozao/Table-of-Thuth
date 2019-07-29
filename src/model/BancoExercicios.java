package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

import view.ShowMessage;

public class BancoExercicios {
	private static ArrayList<Exercicio> exercicios;
	private int identificador;
	
	
	
	public static void addExercicio(Exercicio exercicio, XmlExercicio xml){
		if(!buscar(exercicio)){
			xml.salvar(exercicio);
			ShowMessage.showText("Exercicio adicionado com sucesso.");
		}
		else{
			
			ShowMessage.showText("Exercicio já existe no Banco de Dados.");
			
		}
	}
	
	public static void removerExercicio(int id, XmlExercicio xml){
		Exercicio temp = buscar(id);
		
		if(temp != null){
			xml.remover(temp);
			carregarXml(xml);
		}
		else{
			ShowMessage.showText("Identificador não existe no banco de dados.");
		}
	}
	
	public static boolean buscar(Exercicio exercicio){
		for (Exercicio ex : exercicios) {
			if(ex.getText() == exercicio.getText()){
				return true;
			}
		}
		return false;
	}
	
	public static Exercicio buscar(int id){
		for (Exercicio ex : exercicios) {
			if(ex.getId() == id){
				return ex;
			}
		}
		return null;
	}
	
	
	public static String gerarTexto(){
		if(exercicios != null){
			String temp = "Exercícios Cadastrados\n\n";
			for (Exercicio exercicio : exercicios) {
				temp += "Enunciado: " + exercicio.getText()+"\n";
				temp += "Respota: " + exercicio.getResposta()+"\n";
				temp += "Tag: " + exercicio.getTag()+"\n";
				temp += "Id: " + exercicio.getId()+"\n\n";
				
			}
			return temp;
		}
		
		return null;
	}
	
	public static void carregarXml(XmlExercicio xml){
		exercicios = (ArrayList<Exercicio>) xml.ler();
	}
	public static int size(){
		return exercicios.size();
	}
	
	public static ArrayList<Exercicio> getArray(){
		return exercicios;
	}
	
}
