package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.Personagem;

public class Draw extends JPanel{
	private TelaJogo telaJogo;
	
	public Draw(TelaJogo telaJogo){
		this.telaJogo = telaJogo;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(telaJogo.getCamada1().camada, 0, 0, telaJogo);
		g.drawImage(telaJogo.getCamada2().camada, 0, 0, telaJogo);
		g.drawImage(telaJogo.getCamada3().camada, 0, 0, telaJogo);
		
		
		for (Personagem personagem : telaJogo.getPersonagens()) {
			
			if(personagem != null)
				if(personagem.isCondicaoExistencia()){
					g.drawImage(personagem.getSprites()[personagem.getAparencia()], personagem.getPosX(),
							personagem.getPosY(), telaJogo);	
				
				}
				
		}
		
		
	}
	
}
