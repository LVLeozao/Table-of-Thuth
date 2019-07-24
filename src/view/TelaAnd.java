package view;

import model.GerarPosicao;
import model.Inimigo;
import model.Personagem;

public class TelaAnd extends TelaJogo {

	public TelaAnd() {
		super("img/tileset.png", "img/Parede.png", "img/Objetos.png", "arquivos/chaoMapa01.txt", "arquivos/paredeMapa01.txt",
				"arquivos/objetosMapa01.txt", "img/inimigoAnd.png", "img/Fogo.png");
		
		getInimigo1().setTexto("P1: V\nP2: V\nC = ??\n\nQual a saída para P1^P2 = C");
		getInimigo1().setResposta(0);
		
		getInimigo2().setTexto("É possível entrar na festa se possuir identidade e for maior de idade.\n\nP1:Tem 19 anos\n"
				+ "P2:Não tem identidade\nC: ?? \n\nQual a saída para P1^P2 = C");
		getInimigo2().setResposta(1);
		
		getInimigo3().setTexto("P1: Pi é um número racional\nP2: Raiz quadrada de 2 é um número irracional\nC: ??\n\nQual a saída para P1^P2 = C");
		getInimigo3().setResposta(1);
		
		
		getBaus().get(0).setTexto("Será Verdadeira somente quando todas as proposições forem verdadeiras.");
		getBaus().get(1).setTexto("Operação lógica(Conjunção)");
		getBaus().get(2).setTexto("Simbolo (^)");
		
		
		
		
		
	}

}
