package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaInventarioMultiplayer extends JPanel{
	
	private JLabel lbNomePlayer1, lbNomePlayer2, lbPontuacaoPlayer1, lbPontuacaoPlayer2;
	private JButton btnPausar;
	private JProgressBar barPlayer1, barPlayer2;
	private JTextArea textArea;
	private JScrollPane barra;
	
	public TelaInventarioMultiplayer() {
		setLayout(null);
		setSize(200,704);
		
		lbNomePlayer1 = new JLabel("");
		lbNomePlayer1.setFont(new Font("Heliabe", Font.BOLD, 12));
		lbNomePlayer1.setForeground(new Color(0,0,0));
		lbNomePlayer1.setBounds(58, 90, 74, 15);
		
		lbNomePlayer2 = new JLabel("");
		lbNomePlayer2.setFont(new Font("Heliabe", Font.BOLD, 12));
		lbNomePlayer2.setForeground(new Color(0,0,0));
		lbNomePlayer2.setBounds(58, 164, 74, 15);
		
		lbPontuacaoPlayer1 = new JLabel("0");
		lbPontuacaoPlayer1.setFont(new Font("Heliabe", Font.BOLD, 12));
		lbPontuacaoPlayer1.setForeground(new Color(0,0,0));
		lbPontuacaoPlayer1.setBounds(135, 90, 74, 15);
		
		lbPontuacaoPlayer2 = new JLabel("0");
		lbPontuacaoPlayer2.setFont(new Font("Heliabe", Font.BOLD, 12));
		lbPontuacaoPlayer2.setForeground(new Color(0,0,0));
		lbPontuacaoPlayer2.setBounds(135, 164, 74, 15);

		textArea = new JTextArea();
		barra = new JScrollPane(textArea);
		barra.setBounds(0,250,200,300);
		textArea.setFont(new Font("Heliabe", Font.PLAIN, 18));
		textArea.setEditable(false);
		textArea.setText("Player 1:\nDano:000\nVelocidade:0\n\nPlayer 2:\nDano:000\nVelocidade:0");
		
		this.barPlayer1 = new JProgressBar();
		this.barPlayer1.setMaximum(10000);
		this.barPlayer1.setValue(10000);
		this.barPlayer1.setBackground(new Color(0, 0, 0));
		this.barPlayer1.setForeground(new Color(219, 37, 37));
		this.barPlayer1.setBorderPainted(false);
		this.barPlayer1.setToolTipText(this.barPlayer1.getValue()+"/"+this.barPlayer1.getMaximum());
		this.barPlayer1.setBounds(56,107,142,31);
		
		this.barPlayer2 = new JProgressBar();
		this.barPlayer2.setMaximum(10000);
		this.barPlayer2.setValue(10000);
		this.barPlayer2.setBackground(new Color(0, 0, 0));
		this.barPlayer2.setForeground(new Color(219, 37, 37));
		this.barPlayer2.setBorderPainted(false);
		this.barPlayer2.setToolTipText(this.barPlayer2.getValue()+"/"+this.barPlayer2.getMaximum());
		this.barPlayer2.setBounds(56,181,142,31);
		
		this.btnPausar = new JButton(new ImageIcon("src/img/Pausar.png"));
		btnPausar.setBounds(70, 594, 66, 66);
		btnPausar.setContentAreaFilled(false);
		btnPausar.setBorderPainted(false);
		btnPausar.setFocusPainted(false);
		btnPausar.setToolTipText("Pausar");
		
		add(lbNomePlayer1);
		add(lbPontuacaoPlayer1);
		add(lbNomePlayer2);
		add(lbPontuacaoPlayer2);
		add(btnPausar);
		add(barra);
;
		add(this.barPlayer1);
		add(this.barPlayer2);
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("src/img/InventarioMultiplayer.png").getImage(), 0, 0, this);
		
	}
	

	public JLabel getLbPontuacaoPlayer1() {
		return lbPontuacaoPlayer1;
	}

	public JLabel getLbPontuacaoPlayer2() {
		return lbPontuacaoPlayer2;
	}

	public JButton getBtnPausar() {
		return btnPausar;
	}

	public JProgressBar getBarPlayer1() {
		return barPlayer1;
	}

	public JProgressBar getBarPlayer2() {
		return barPlayer2;
	}

	public JLabel getLbNomePlayer1() {
		return lbNomePlayer1;
	}

	public JLabel getLbNomePlayer2() {
		return lbNomePlayer2;
	}

	public JTextArea getTextArea() {
		return textArea;
	}
	
	
	
}
