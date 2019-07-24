package view;

import javax.swing.JPanel;

import model.Protagonista;

public class TelaOr extends TelaJogo{
	
	
	public TelaOr() {
		super("img/piso2.png", "img/parede2.png", "img/Objetos2.png", "arquivos/chaoMapa02.txt", "arquivos/paredeMapa02.txt",
				"arquivos/ObjetosMapa02.txt", "img/inimigoAnd.png", "img/Fogo.png");
		
		getInimigo1().setTexto("P1: V\nP2: V\nC = ??\n\nQual a saída para P1vP2 = C");
		getInimigo1().setResposta(0);
		
		getInimigo2().setTexto("Se a Thread não for nula ou estiver ativada o processo será realizado.\n\nP1: Thread - NullPointerException \n"
				+ "P2: false\nC: ?? \n\nQual a saída para P1vP2 = C");
		getInimigo2().setResposta(1);
		
		getInimigo3().setTexto("P1: Pi é um número racional\nP2: Raiz quadrada de 2 é um número irracional\nC: ??\n\nQual a saída para P1vP2 = C");
		getInimigo3().setResposta(0);
		
		
		getBaus().get(0).setTexto("Será verdadeira quando pelo menos uma das preposiçõesfor verdadeira.");
		getBaus().get(1).setTexto("Operação lógica(Disjunção).");
		getBaus().get(2).setTexto("Simbolo (v)");
		
	}
	
	

}
