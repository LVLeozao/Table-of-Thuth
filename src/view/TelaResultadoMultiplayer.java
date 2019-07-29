package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TelaResultadoMultiplayer extends JFrame{
	
	private JLabel lbGanhador, lbPontucao;
	private JButton btnSair;
	
	public TelaResultadoMultiplayer(){
		super("Resultado");
		setSize(130,110);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lbGanhador = new JLabel("Ganhador:");
		
		lbPontucao = new JLabel("Pontuação: 0000");
		btnSair = new JButton("Sair");
		
		add(lbGanhador);
		add(lbPontucao);
		add(btnSair);
		
		
		setVisible(false);
	}

	public JLabel getLbGanhador() {
		return lbGanhador;
	}

	public JLabel getLbPontucao() {
		return lbPontucao;
	}

	public JButton getBtnSair() {
		return btnSair;
	}
	
	
}
