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
	private JButton btnConfirmar, btnSair;
	private JLabel lbNome, lbPontuacao, lbTempo;
	private Som somDerrota, somVitoria;
	private JPanel panelLb;
	private Boolean resultadoAtivo, morteAtiva, resultadoFinalAtivo;
	
	public TelaTransicao(){
		setLayout(null);
		setSize(800, 704);
		int font = 60;
		
		this.panelLb = new JPanel();
		this.panelLb.setBounds(0,0,1000,704);
		this.panelLb.setLayout(null);
		this.panelLb.setVisible(false);
		
		this.resultadoAtivo = false;
		this.morteAtiva = false;
		this.resultadoFinalAtivo = false;
		
		
	
		this.btnConfirmar = new JButton(new ImageIcon("src/img/botaoConfirmar.png"));
		this.btnConfirmar.setContentAreaFilled(false);
		this.btnConfirmar.setBounds(468, 704-85, 60, 64);
		this.btnConfirmar.setToolTipText("Confirmar");
		this.btnConfirmar.setVisible(false);
		
		this.btnSair= new JButton(new ImageIcon("src/img/botaoSair.png"));
		this.btnSair.setBounds(468, 704-85, 60, 64);
		this.btnSair.setVisible(false);
		this.btnSair.setToolTipText("Confirmar");
		this.btnSair.setVisible(false);
		this.btnSair.setContentAreaFilled(false);
		
		this.lbPontuacao = new JLabel("0");
		this.lbPontuacao.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbPontuacao.setForeground(new Color(0,0,0));
		this.lbPontuacao.setBounds(537, 250, 400, 400);
		
		
		this.lbTempo = new JLabel("00:00");
		this.lbTempo.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbTempo.setForeground(new Color(0,0,0));
		this.lbTempo.setBounds(535, 140, 400, 400);
		
		
		this.lbNome= new JLabel("");
		this.lbNome.setFont(new Font("TimesRoman", Font.BOLD, font));
		this.lbNome.setForeground(new Color(0,0,0));
		this.lbNome.setBounds(380, 50, 400, 400);
		
		
		this.lbNome.setVisible(false);
		this.lbPontuacao.setVisible(false);
		this.lbTempo.setVisible(false);

		somDerrota = new Som("sons/morreu.wav");
		somVitoria = new Som("sons/vitoria.wav");
		
		add(lbPontuacao);
		add(lbTempo);
		add(lbNome);
		add(btnConfirmar);
		add(btnSair);
		
	}

	protected void paintComponent(Graphics g) {
		if(this.resultadoAtivo){
			g.drawImage(new ImageIcon("src/img/TelaResultado.png").getImage(), 0, 0, this);
		}
		
		else if(this.morteAtiva){
			g.drawImage(new ImageIcon("src/img/YouDied.png").getImage(), 0, 0, this);
		}
		
		else if(this.resultadoFinalAtivo){
			g.drawImage(new ImageIcon("src/img/TelaZerou.png").getImage(), 0, 0, this);
		}
		
		else if(this.morteAtiva){
			g.drawImage(new ImageIcon("src/img/TelaFinalMulti.png").getImage(), 0, 0, this);
		}
		

		
	}
	
	
	

	public JPanel getPanelLb() {
		return panelLb;
	}

	public Boolean getResultadoFinalAtivo() {
		return resultadoFinalAtivo;
	}

	public void setResultadoFinalAtivo(Boolean resultadoFinalAtivo) {
		this.resultadoFinalAtivo = resultadoFinalAtivo;
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
