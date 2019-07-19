package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaResultado extends JPanel {
	private JButton btnConfirmar;
	private JLabel lbPontuacao, lbPntBau, lbTempo;
	
	public TelaResultado(){
		setLayout(null);
		setSize(800, 704);
		int font = 50;
		this.btnConfirmar = new JButton(new ImageIcon("src/img/Confirmar.png"));
		this.btnConfirmar.setContentAreaFilled(false);
		this.btnConfirmar.setBorderPainted(false);
		this.btnConfirmar.setBounds(380, 635, 50, 50);
		this.btnConfirmar.setToolTipText("Confirmar");
		
		this.lbPontuacao = new JLabel("1000");
		this.lbPontuacao.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbPontuacao.setForeground(new Color(255,255,255));
		this.lbPontuacao.setBounds(450, 85, 400, 400);
		
		this.lbPntBau = new JLabel("-30");
		this.lbPntBau.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbPntBau.setForeground(new Color(255,255,255));
		this.lbPntBau.setBounds(450, 200, 400, 400);
		
		this.lbTempo = new JLabel("00:00");
		this.lbTempo.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbTempo.setForeground(new Color(255,255,255));
		this.lbTempo.setBounds(450, 312, 400, 400);
		
		
		add(btnConfirmar);
		add(this.lbTempo);
		add(this.lbPntBau);
		add(this.lbPontuacao);
	
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("src/img/TelaCompleta.png").getImage(), 0, 0, this);
	}


	public JLabel getLbPontuacao() {
		return lbPontuacao;
	}


	public void setLbPontuacao(JLabel lbPontuacao) {
		this.lbPontuacao = lbPontuacao;
	}


	public JLabel getLbPntBau() {
		return lbPntBau;
	}


	public void setLbPntBau(JLabel lbPntBau) {
		this.lbPntBau = lbPntBau;
	}


	public JLabel getLbTempo() {
		return lbTempo;
	}


	public void setLbTempo(JLabel lbTempo) {
		this.lbTempo = lbTempo;
	}


	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	

}
