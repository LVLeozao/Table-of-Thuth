package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaConfiguracoes extends JFrame {
	
	private JButton btnVoltar;
	private JLabel lbControle;
	
	
	public TelaConfiguracoes(){
		
		setSize(500,500);
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		btnVoltar = new JButton(new ImageIcon("src/img/Cancelar.png"));
		btnVoltar.setBounds(440, 10, 50, 50);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setToolTipText("Fechar");
			
		lbControle = new JLabel(new ImageIcon("src/img/ControleS.png"));
		lbControle.setBounds(0, 0, 500, 500);
		
		
		
		
		add(btnVoltar);
		add(lbControle);
		
		
		
		
		setVisible(false);

		
		
	}


	public JButton getBtnVoltar() {
		return btnVoltar;
	}


	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}


	
	
	
	
	

}
