package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TelaInventario extends JPanel{
	
	private ImageIcon iiPausar;
	private JLabel lbNome, lbPontuacao, lbNomeFase;
	private JProgressBar barraVida;
	private JButton btnPausar;
	private String nomePersonagem, camingoImagemBackground, pontuacao;
	private int qntBaus;
	
	private ImageIcon iiBg, iiThumb;
	
	public JLabel timer;
	
	public TelaInventario(){
	
		setLayout(null);
		
		lbNomeFase = new JLabel("");
		lbNomeFase.setFont(new Font("Heliabe", Font.BOLD, 40));
		lbNomeFase.setForeground(new Color(255,255,255));
		lbNomeFase.setBounds(55, 20, 161, 50);
		
		this.iiBg = new ImageIcon("src/img/BarraLateral.png");
		this.iiThumb  = new ImageIcon("");
		
		this.iiPausar = new ImageIcon("src/img/Pausar.png");
	
		this.lbNome = new JLabel(this.nomePersonagem);
		lbNome.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbNome.setForeground(new Color(255,255,255));
		lbNome.setBounds(25, 330, 161, 20);
		
		this.timer = new JLabel("0:00");
		this.timer.setFont(new Font("Heliabe", Font.BOLD, 30));
		this.timer.setForeground(new Color(255,255,255));
		this.timer.setBounds(73, 480, 161, 50);
		
		this.lbPontuacao = new JLabel(this.pontuacao);
		lbPontuacao.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbPontuacao.setForeground(new Color(255,255,255));
		lbPontuacao.setBounds(25, 405, 161, 20);
		
		this.btnPausar = new JButton(iiPausar);
		btnPausar.setBounds(70, 575, 66, 66);
		btnPausar.setContentAreaFilled(false);
		btnPausar.setBorderPainted(false);
		btnPausar.setFocusPainted(false);
		btnPausar.setToolTipText("Pausar");
		
	
		
		this.qntBaus = 0;
		
		add(lbNome);
		add(lbPontuacao);
		add(btnPausar);
		add(lbNomeFase);
		add(timer);
	
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(iiBg.getImage(), 0, 0, this);
		g.drawImage(iiThumb.getImage(), 58, 190, this);
		
		
		int posX = 22;
		int posY = 450;
		
		for (int i = 0; i < this.qntBaus; i++) {
			g.drawImage(new ImageIcon("src/img/bauAberto.png").getImage(), posX, posY, this);
			System.out.println(this.qntBaus);
			posX = posX + 62;
		}
	
	}
	
	public int getQntBaus() {
		return qntBaus;
	}


	public void setQntBaus(int qntBaus) {
		this.qntBaus = qntBaus;
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

	public String getNomePersonagem() {
		return nomePersonagem;
	}

	public void setNomePersonagem(String nomePersonagem) {
		this.nomePersonagem = nomePersonagem;
	}


	public JLabel getLbNome() {
		return lbNome;
	}


	public ImageIcon getIiPausar() {
		return iiPausar;
	}


	public ImageIcon getIiThumb() {
		return iiThumb;
	}


	public void setIiThumb(ImageIcon iiThumb) {
		this.iiThumb = iiThumb;
	}


	public JLabel getLbNomeFase() {
		return lbNomeFase;
	}


	public JLabel getTimer() {
		return timer;
	}


	
	
	
	
	
}
