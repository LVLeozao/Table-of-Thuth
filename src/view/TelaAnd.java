package view;

import model.GerarPosicao;
import model.Inimigo;
import model.Personagem;

public class TelaAnd extends TelaJogo {

	public TelaAnd() {
		super("img/tileset.png", "img/Parede.png", "img/Objetos.png", "arquivos/chaoMapa01.txt", "arquivos/paredeMapa01.txt",
				"arquivos/objetosMapa01.txt", "img/inimigoAnd.png", "img/Fogo.png");
		
		
		
		
		getBaus().get(0).setTexto("Ser� Verdadeira somente quando todas as proposi��es forem verdadeiras.");
		getBaus().get(1).setTexto("Opera��o l�gica(Conjun��o)");
		getBaus().get(2).setTexto("Simbolo (^)");
		
		
		
		
		
	}

}
