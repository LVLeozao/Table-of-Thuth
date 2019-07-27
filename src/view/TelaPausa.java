package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPausa extends JPanel{
	
	private JButton btnVoltar;
	private JButton btnConfiguracao;
	private JButton btnSair;
	private ImageIcon iiVoltar, iiSair, iiConfig, iiBackground;
	private JLabel lbBg;
	private TelaConfiguracoes telaConfiguracoes;
	
	public TelaPausa(){

		setLayout(null);
		
		iiVoltar = new ImageIcon("src/img/Despausar.png");
		iiSair = new ImageIcon("src/img/Exit.png");
		iiConfig = new ImageIcon("src/img/Config.png");
		
		lbBg = new JLabel(new ImageIcon("src/img/PauseBackground.png"));
		lbBg.setBounds(0, 0, 200, 704);
	
		this.telaConfiguracoes = new TelaConfiguracoes();
		
		btnVoltar = new JButton(iiVoltar);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBounds(70, 246, 60, 60);
		btnVoltar.setToolTipText("Voltar");
		
		btnConfiguracao = new JButton(iiConfig);
		btnConfiguracao.setContentAreaFilled(false);
		btnConfiguracao.setBorderPainted(false);
		btnConfiguracao.setBounds(70,322,60,60);
		btnConfiguracao.setToolTipText("Configurações");
		
		btnSair = new JButton(iiSair);
		btnSair.setContentAreaFilled(false);
		btnSair.setBorderPainted(false);
		btnSair.setBounds(70, 398, 60, 60);
		btnSair.setToolTipText("Sair para o menu");
		
		
		add(btnConfiguracao);
		add(btnVoltar);
		add(btnSair);
		add(lbBg);
	



	}
	


	public JButton getBtnVoltar() {
		return btnVoltar;
	}


	public JButton getBtnConfiguracao() {
		return btnConfiguracao;
	}


	public JButton getBtnSair() {
		return btnSair;
	}



	public TelaConfiguracoes getTelaConfiguracoes() {
		return telaConfiguracoes;
	}
	
	
	
	
}
