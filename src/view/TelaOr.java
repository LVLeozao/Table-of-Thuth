package view;

import javax.swing.JPanel;

import model.Protagonista;

public class TelaOr extends TelaJogo{
	
	
	public TelaOr() {
		super("img/piso2.png", "img/parede2.png", "img/Objetos2.png", "arquivos/chaoMapa02.txt", "arquivos/paredeMapa02.txt",
				"arquivos/ObjetosMapa02.txt", "img/inimigoAnd.png", "img/Fogo.png");
		
		getInimigo1().setTexto("P1: V\nP2: V\nC = ??\n\nQual a sa�da para P1vP2 = C");
		getInimigo1().setResposta(0);
		
		getInimigo2().setTexto("Se a Thread n�o for nula ou estiver ativada o processo ser� realizado.\n\nP1: Thread - NullPointerException \n"
				+ "P2: false\nC: ?? \n\nQual a sa�da para P1vP2 = C");
		getInimigo2().setResposta(1);
		
		getInimigo3().setTexto("P1: Pi � um n�mero racional\nP2: Raiz quadrada de 2 � um n�mero irracional\nC: ??\n\nQual a sa�da para P1vP2 = C");
		getInimigo3().setResposta(0);
		
		
		getBaus().get(0).setTexto("Ser� verdadeira quando pelo menos uma das preposi��esfor verdadeira.");
		getBaus().get(1).setTexto("Opera��o l�gica(Disjun��o).");
		getBaus().get(2).setTexto("Simbolo (v)");
		
	}
	
	

}
