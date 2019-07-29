package view;

public class TelaNot extends TelaJogo{

	public TelaNot() {
		super("img/pisoMapa03.png", "img/parede2.png", "img/Objetos.png", "arquivos/chaoMapa03.txt", "arquivos/paredeMapa03.txt",
				"arquivos/objetosMapa03.txt", "img/inimigoAnd.png", "img/Fogo.png");
		
		
		
		
		getBaus().get(0).setTexto("Terá valor falso quando a preposição for verdadeira e vice-versa.");
		getBaus().get(1).setTexto("Operação lógica(Negação)");
		getBaus().get(2).setTexto("Simbolo (~)");
		
	
	}

}
