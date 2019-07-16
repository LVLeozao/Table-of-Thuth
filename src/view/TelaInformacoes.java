package view;

import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TelaInformacoes extends JPanel{

	private JButton btnVoltar, btnSobre, btnCreditos, btnControle;
	private ImageIcon iiVoltar, iiCreditos, iiSobre, iiControle;
	private JLabel lbCredito, lbSobre, lbControle, lbBg;
	
	public TelaInformacoes(){
		setLayout(null);
		btnControle = new JButton("Controles");
		btnControle.setBounds(310, 60, 100, 30);
		btnSobre = new JButton("Sobre");
		btnSobre.setBounds(435, 60, 100, 30);
		btnCreditos = new JButton("Creditos");
		btnCreditos.setBounds(560, 60, 100, 30);
		
		btnVoltar = new JButton(new ImageIcon("src/img/Cancelar.png"));
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setBounds(945, 10, 50, 50);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		
		lbBg = new JLabel(new ImageIcon("src/img/Informacoes.png"));
		lbBg.setBounds(0, 0, 1000, 704);
		
		
		lbSobre = new JLabel(new ImageIcon("src/img/Sobre.png"));
		lbSobre.setBounds(0, 0, 1000, 704);
		
		lbControle = new JLabel(new ImageIcon("src/img/Controles.png"));
		lbControle.setBounds(235, 100, 500, 500);
		lbControle.setVisible(false);
		
		lbCredito = new JLabel(new ImageIcon("src/img/Creditos.png"));
		lbCredito.setBounds(235, 100, 500, 500);
		lbCredito.setVisible(false);
		
		add(btnControle);
		add(btnSobre);
		add(btnCreditos);
		
		add(btnVoltar);

		
		add(lbCredito);
		add(lbSobre);
		add(lbControle);
		add(lbBg);
		
		
	}
	
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	public JButton getBtnSobre() {
		return btnSobre;
	}
	public JButton getBtnCreditos() {
		return btnCreditos;
	}
	public JButton getBtnControle() {
		return btnControle;
	}
	public JLabel getLbCredito() {
		return lbCredito;
	}
	public JLabel getLbSobre() {
		return lbSobre;
	}
	public JLabel getLbControle() {
		return lbControle;
	}
	
	

	
}
