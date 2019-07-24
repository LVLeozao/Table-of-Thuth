package view;

public class TelaNot extends TelaJogo{

	public TelaNot() {
		super("img/pisoMapa03.png", "img/parede2.png", "img/Objetos.png", "arquivos/chaoMapa03.txt", "arquivos/paredeMapa03.txt",
				"arquivos/objetosMapa03.txt", "img/inimigoAnd.png", "img/Fogo.png");
		
		
		getInimigo1().setTexto("P1: ~V\nP2: V\nC = ??\n\nQual a sa�da para P1vP2 = C");
		getInimigo1().setResposta(0);
		
		getInimigo2().setTexto("� poss�vel concluir o precesso se as preposi��es forem verdadeiras.\n\nP1:Verdade\n"
				+ "P2: Falso\nC: ?? \n\nQual a sa�da para (~P1)^(~P2) = (~C)");
		getInimigo2().setResposta(1);
		
		getInimigo3().setTexto("P1: Leonardo � de Pernambuco\nP2: Maria, tamb�m\nC: ??\n\nQual a sa�da para P1^(~P2) = C");
		getInimigo3().setResposta(1);
		
		
		getBaus().get(0).setTexto("Ter� valor falso quando a preposi��o for verdadeira e vice-versa.");
		getBaus().get(1).setTexto("Opera��o l�gica(Nega��o)");
		getBaus().get(2).setTexto("Simbolo (~)");
		
	}

}
