package view;

import javax.swing.JPanel;

import model.Protagonista;

public class TelaOr extends TelaJogo{
	
	
	public TelaOr() {
		super("img/piso2.png", "img/parede2.png", "img/Objetos2.png", "arquivos/chaoMapa02.txt", "arquivos/paredeMapa02.txt",
				"arquivos/ObjetosMapa02.txt", "img/inimigoAnd.png", "img/Fogo.png");
		
		
		
		getBaus().get(0).setTexto("Ser� verdadeira quando pelo menos uma das preposi��esfor verdadeira.");
		getBaus().get(1).setTexto("Opera��o l�gica(Disjun��o).");
		getBaus().get(2).setTexto("Simbolo (v)");
		
		
		
	}
	
	

}
