package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaSelecao extends JPanel{
	
	private JLabel lbMasculino, lbFeminino, lbBg, lbInfo;
	private JButton btnVoltar, btnConfirmar;
	private JTextField tfNome;
	private String selecionado;
	private String nome;
	
	
	public TelaSelecao(){
		setLayout(null);

		tfNome = new JTextField(10);
		tfNome.setBounds(390, 580, 200, 30);
		
		lbMasculino = new JLabel(new ImageIcon("src/img/SelecaoM.png"));
		lbMasculino.setBounds(208, 258, 184, 186);
		
		lbFeminino = new JLabel(new ImageIcon("src/img/SelecaoF.png"));
		lbFeminino.setBounds(608, 258, 184, 186);
		
		lbInfo = new JLabel("");
		lbInfo.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lbInfo.setBounds(415, 180, 500, 100);
		
		lbBg = new JLabel(new ImageIcon("src/img/TelaSelecao.png"));
		lbBg.setBounds(0, 0, 1000, 704);
		
		btnVoltar = new JButton(new ImageIcon("src/img/Cancelar.png"));
		btnVoltar.setBounds(940, 10, 50, 50);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		
		btnConfirmar = new JButton(new ImageIcon("src/img/Confirmar.png"));
		btnConfirmar.setBounds(610,570, 50, 50);
		btnConfirmar.setContentAreaFilled(false);
		btnConfirmar.setBorderPainted(false);
		
	
		
		add(btnVoltar);
		add(btnConfirmar);
		add(lbMasculino);
		add(lbFeminino);
		add(tfNome);
		add(lbInfo);
		add(lbBg);
		
		
		
		
		setVisible(true);
	}

	
	
	



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	


	public String getSelecionado() {
		return selecionado;
	}







	public void setSelecionado(String selecionado) {
		this.selecionado = selecionado;
	}







	public JLabel getLbMasculino() {
		return lbMasculino;
	}

	public JLabel getLbFeminino() {
		return lbFeminino;
	}

	public JLabel getLbInfo() {
		return lbInfo;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JTextField getTfNome() {
		return tfNome;
	}







	public void setLbInfo(JLabel lbInfo) {
		this.lbInfo = lbInfo;
	}
	
	
	
	
	
}
