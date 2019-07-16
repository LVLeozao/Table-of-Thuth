package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TelaInventario extends JPanel{
	
	private ImageIcon iiPausar;
	private JLabel lbNome, lbPontuacao, lbBg;
	private JProgressBar barraVida;
	private JButton btnPausar;
	private String nomePersonagem, camingoImagemBackground, pontuacao;
	
	
	
	public TelaInventario(){
	
		setLayout(null);
		
		this.lbBg = new JLabel(new ImageIcon("src/img/BarraLateralOr.png"));
		lbBg.setBounds(0,0,200,704);
		
		this.iiPausar = new ImageIcon("src/img/Pausar.png");
	
		this.lbNome = new JLabel(this.nomePersonagem);
		lbNome.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbNome.setForeground(new Color(255,255,255));
		lbNome.setBounds(25, 380, 161, 20);
		
		this.lbPontuacao = new JLabel(this.pontuacao);
		lbPontuacao.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbPontuacao.setForeground(new Color(255,255,255));
		lbPontuacao.setBounds(25, 455, 161, 20);
		
		this.btnPausar = new JButton(iiPausar);
		btnPausar.setBounds(70, 560, 66, 66);
		btnPausar.setContentAreaFilled(false);
		btnPausar.setBorderPainted(false);
		btnPausar.setFocusPainted(false);
		btnPausar.setToolTipText("Pausar");
		
		add(lbNome);
		add(lbPontuacao);
		add(btnPausar);
		add(lbBg);
		
		requestFocus();
		

		
	}
	
	
	public JLabel getLbPontuacao() {
		return lbPontuacao;
	}
	public void setLbPontuacao(JLabel lbPontuacao) {
		this.lbPontuacao = lbPontuacao;
	}
	public JButton getBtnPausar() {
		return btnPausar;
	}
	
	
}
