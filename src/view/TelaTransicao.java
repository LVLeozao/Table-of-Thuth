package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Som;

public class TelaTransicao extends JPanel {
	private JButton btnComecar, btnConfirmar, btnSair;
	private JLabel lbNome, lbResultado, lbDerrota, lbPontuacao, lbPntBau, lbTempo;
	private Som somDerrota, somVitoria;
	private Boolean faseAtiva1, faseAtiva2, faseAtiva3, resultadoAtivo, morteAtiva, resultadoFinalAtivo, resultadoMultiplayer;
	
	public TelaTransicao(){
		setLayout(null);
		setSize(800, 704);
		int font = 50;
		
		
		this.faseAtiva1 = false;
		this.faseAtiva2 = false;
		this.faseAtiva3 = false;
		
		this.resultadoAtivo = false;
		this.morteAtiva = false;
		this.resultadoFinalAtivo = false;
		this.resultadoMultiplayer = false;
		
	
		this.btnConfirmar = new JButton(new ImageIcon("src/img/Confirmar.png"));
		this.btnConfirmar.setContentAreaFilled(false);
		this.btnConfirmar.setBorderPainted(false);
		this.btnConfirmar.setBounds(380, 635, 50, 50);
		this.btnConfirmar.setToolTipText("Confirmar");
		this.btnConfirmar.setVisible(false);
		
		this.btnComecar= new JButton("Começar");
		this.btnComecar.setBounds(350, 635, 150, 45);
		this.btnComecar.setVisible(false);
		
		this.btnSair= new JButton("Sair");
		this.btnSair.setBounds(350, 635, 150, 45);
		this.btnSair.setVisible(false);
		
		this.lbPontuacao = new JLabel("1000");
		this.lbPontuacao.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbPontuacao.setForeground(new Color(255,255,255));
		this.lbPontuacao.setBounds(450, 85, 400, 400);
		this.lbPontuacao.setVisible(false);
		
		this.lbPntBau = new JLabel("-30");
		this.lbPntBau.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbPntBau.setForeground(new Color(255,255,255));
		this.lbPntBau.setBounds(450, 200, 400, 400);
		this.lbPntBau.setVisible(false);
		
		this.lbTempo = new JLabel("00:00");
		this.lbTempo.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbTempo.setForeground(new Color(255,255,255));
		this.lbTempo.setBounds(450, 312, 400, 400);
		this.lbTempo.setVisible(false);
		
		this.lbNome= new JLabel("");
		this.lbNome.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbNome.setForeground(new Color(255,255,255));
		this.lbNome.setBounds(580, 160, 400, 400);
		this.lbNome.setVisible(false);
		
		
		
		this.lbDerrota = new JLabel(new ImageIcon("src/img/YouDied.png"));
		this.lbDerrota.setBounds(0,0,800,704);
		this.lbDerrota.setVisible(false);
		
		somDerrota = new Som("sons/morreu.wav");
		somVitoria = new Som("sons/vitoria.wav");
		
		add(lbPontuacao);
		add(lbPntBau);
		add(lbTempo);
		add(lbNome);
		add(btnConfirmar);
		add(btnComecar);
		add(btnSair);
	}

	protected void paintComponent(Graphics g) {
		if(this.faseAtiva1){
			g.drawImage(new ImageIcon("src/img/Fase1.png").getImage(), 0, 0, this);
		}
		else if(this.faseAtiva2){
			g.drawImage(new ImageIcon("src/img/Fase2.png").getImage(), 0, 0, this);
		}
		else if(this.faseAtiva3){
			g.drawImage(new ImageIcon("src/img/Fase3.png").getImage(), 0, 0, this);
		}
		else if(this.faseAtiva3){
			g.drawImage(new ImageIcon("src/img/Fase3.png").getImage(), 0, 0, this);
		}
		else if(this.resultadoAtivo){System.out.println("ENTROU");
			g.drawImage(new ImageIcon("src/img/TelaCompleta.png").getImage(), 0, 0, this);
		}
		
		else if(this.morteAtiva){
			g.drawImage(new ImageIcon("src/img/YouDied.png").getImage(), 0, 0, this);
		}
		
		else if(this.resultadoFinalAtivo){
			g.drawImage(new ImageIcon("src/img/TelaFinal.png").getImage(), 0, 0, this);
		}
		
		else if(this.morteAtiva){
			g.drawImage(new ImageIcon("src/img/TelaFinalMulti.png").getImage(), 0, 0, this);
		}
		
	}
	
	
	

	public Boolean getResultadoFinalAtivo() {
		return resultadoFinalAtivo;
	}

	public void setResultadoFinalAtivo(Boolean resultadoFinalAtivo) {
		this.resultadoFinalAtivo = resultadoFinalAtivo;
	}

	public Boolean getResultadoMultiplayer() {
		return resultadoMultiplayer;
	}

	public void setResultadoMultiplayer(Boolean resultadoMultiplayer) {
		this.resultadoMultiplayer = resultadoMultiplayer;
	}

	public Boolean getMorteAtiva() {
		return morteAtiva;
	}

	public void setMorteAtiva(Boolean morteAtiva) {
		this.morteAtiva = morteAtiva;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public void setResultadoAtivo(Boolean resultadoAtivo) {
		this.resultadoAtivo = resultadoAtivo;
	}
	public Boolean getResultadoAtivo() {
		return resultadoAtivo;
	}
	public void setFaseAtiva1(Boolean faseAtiva1) {
		this.faseAtiva1 = faseAtiva1;
	}
	public void setFaseAtiva2(Boolean faseAtiva2) {
		this.faseAtiva2 = faseAtiva2;
	}
	public void setFaseAtiva3(Boolean faseAtiva3) {
		this.faseAtiva3 = faseAtiva3;
	}
	public Boolean getFaseAtiva1() {
		return faseAtiva1;
	}
	public Boolean getFaseAtiva2() {
		return faseAtiva2;
	}
	public Boolean getFaseAtiva3() {
		return faseAtiva3;
	}
	
	public JButton getBtnComecar() {
		return btnComecar;
	}

	public JLabel getLbDerrota() {
		return lbDerrota;
	}

	public JLabel getLbResultado() {
		return lbResultado;
	}

	public Som getSomDerrota() {
		return somDerrota;
	}

	public Som getSomVitoria() {
		return somVitoria;
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

	public JLabel getLbNome() {
		return lbNome;
	}
	
}
