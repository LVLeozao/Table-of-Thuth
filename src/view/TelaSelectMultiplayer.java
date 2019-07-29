package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TelaSelectMultiplayer extends JFrame{
	
	private JLabel lbPlayer1,lbPlayer2;
	private JTextField tfPlayer1, tfPlayer2;
	private JButton btnComecar;
	
	public TelaSelectMultiplayer(){
		super("Select");
		setSize(190,168);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		
		lbPlayer1 = new JLabel("Jogador 1 Nome: ");
		lbPlayer2 = new JLabel("Jogador 2 Nome: ");
		
		tfPlayer1 = new JTextField(10);
		tfPlayer2 = new JTextField(10);
		
		btnComecar = new JButton("Começar");
		
		
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
		
		
		
		add(lbPlayer1);
		add(tfPlayer1);
		add(lbPlayer2);
		add(tfPlayer2);
		add(btnComecar);
		
		setVisible(false);
		
		
		
	}

	public JTextField getTfPlayer1() {
		return tfPlayer1;
	}

	public JTextField getTfPlayer2() {
		return tfPlayer2;
	}

	public JButton getBtnComecar() {
		return btnComecar;
	}
	
	

}
