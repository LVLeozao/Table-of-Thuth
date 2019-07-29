package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Protagonista;


public class TelaInformacoes extends JPanel{

	private JButton btnVoltar, btnSobre, btnCreditos, btnControle, btnResultados;
	private ImageIcon iiVoltar, iiCreditos, iiSobre, iiControle;
	private JLabel lbCredito, lbSobre, lbControle, lbBg;
	private ButtonGroup bg;
	private JRadioButton rbSingle, rbMulti;
	private JTextArea textArea;
	private JScrollPane barra;
	private ArrayList<Protagonista> resultados;
	
	public TelaInformacoes(ArrayList<Protagonista> resultados){
		setLayout(null);
		this.resultados = resultados;
		
		bg = new ButtonGroup();
		
		rbSingle = new JRadioButton("Single Player");
		rbSingle.setBounds(500,100, 100, 40);
		rbSingle.setVisible(false);
		rbSingle.setForeground(new Color(255,255,255));
		rbSingle.setContentAreaFilled(false);
		
		rbMulti = new JRadioButton("Multiplayer");
		rbMulti.setForeground(new Color(255,255,255));
		rbMulti.setContentAreaFilled(false);
		rbMulti.setBounds(350,100, 100, 40);
		rbMulti.setVisible(false);
		
		bg.add(rbSingle);
		bg.add(rbMulti);
		
		String text = " = = = = = = = = RANKING = = = = = = = = \n\n" + "- Selecione um modo!";
		textArea = new JTextArea();
		textArea.setBounds(330,150, 290, 350);
		textArea.setVisible(true);
		barra = new JScrollPane(textArea);
		barra.setBounds(330,150,290,350);
		textArea.setFont(new Font("Heliabe", Font.BOLD, 15));
		textArea.setEditable(false);
		barra.setVisible(false);
		textArea.setText(text);
		
		btnResultados = new JButton(new ImageIcon(getClass().getClassLoader().getResource("img/RankingBtn.png")));
		btnResultados.setBounds(270, 60, 66, 30);
		
		btnControle = new JButton(new ImageIcon(getClass().getClassLoader().getResource("img/ControleBtn.png")));
		btnControle.setBounds(380, 60, 66, 30);
		
		btnSobre = new JButton(new ImageIcon(getClass().getClassLoader().getResource("img/SobreBtn.png")));
		btnSobre.setBounds(490, 60, 66, 30);
		
		btnCreditos = new JButton(new ImageIcon(getClass().getClassLoader().getResource("img/CreditosBtn.png")));
		btnCreditos.setBounds(600, 60, 66, 30);
		
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
		lbControle.setBounds(230,130, 568, 500);
		lbControle.setVisible(false);
		
		lbCredito = new JLabel(new ImageIcon("src/img/Creditos.png"));
		lbCredito.setBounds(235, 100, 500, 500);
		lbCredito.setVisible(false);
		
		add(btnControle);
		add(btnSobre);
		add(btnCreditos);
		add(btnVoltar);
		add(btnResultados);

		add(rbMulti);
		add(rbSingle);
		add(barra);
		add(lbCredito);
		add(lbSobre);
		add(lbControle);
		add(lbBg);
		
		
	}
	
	
	
	
	public JScrollPane getBarra() {
		return barra;
	}




	public JTextArea getTextArea() {
		return textArea;
	}

	public JButton getBtnResultados() {
		return btnResultados;
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

	public JRadioButton getRbSingle() {
		return rbSingle;
	}

	public JRadioButton getRbMulti() {
		return rbMulti;
	}
	
	

	
}
