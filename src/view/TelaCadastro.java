package view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.BancoExercicios;

public class TelaCadastro extends JFrame{
	private JLabel lbEnunciado, lbResposta, lbTag, lbIdentificador;
	private JTextField tfEnunciado, tfResposta, tfTag, tfIdentificador;
	private JButton btnCadastrar, btnRemover;
	private JTextArea textArea;
	private JScrollPane barra;
	private JPanel panelAdd, panelRemove, panelText, panelRadios;
	private ButtonGroup bg;
	private JRadioButton rbCadastrar, rbRemover;
	
	public TelaCadastro(){
		super("Cadastro");
		setSize(205,500);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		panelAdd = new JPanel();
		panelAdd.setLayout(new FlowLayout());
		panelAdd.setBounds(1,40, 195,200);
		
		panelRemove = new JPanel();
		panelRemove.setLayout(new FlowLayout());
		panelRemove.setBounds(1,100, 195,100);
		
		panelText = new JPanel();
		panelText.setLayout(new FlowLayout());
		panelText.setBounds(1,250, 195,185);
		
		panelRadios = new JPanel();
		panelRadios.setLayout(new FlowLayout());
		panelRadios.setBounds(1,10, 195,25);
		
		bg =new ButtonGroup();
		
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
		
		lbEnunciado = new JLabel("Enunciado: ");
		lbResposta = new JLabel("Resposta(True/False): ");
		lbTag = new JLabel("Tag: ");
		lbIdentificador = new JLabel("ID:");
		
		tfEnunciado = new JTextField(15);
		tfResposta = new JTextField(15);
		tfTag = new JTextField(15);
		tfIdentificador = new JTextField(15);
		
		rbCadastrar = new JRadioButton("Cadastrar");
		rbCadastrar.setSelected(true);
		rbRemover = new JRadioButton("Remover");
		bg.add(rbCadastrar);
		bg.add(rbRemover);
		
		btnCadastrar = new JButton("Cadastrar");
		btnRemover= new JButton("Remover");
		
		textArea = new JTextArea(10,15);
		
		barra = new JScrollPane(textArea);
		
		textArea.setFont(new Font("Heliabe", Font.PLAIN, 12));
		textArea.setEditable(false);
		
		textArea.setText(BancoExercicios.gerarTexto());
		
		panelAdd.add(lbEnunciado);
		panelAdd.add(tfEnunciado);
		panelAdd.add(lbResposta);
		panelAdd.add(tfResposta);
		panelAdd.add(lbTag);
		panelAdd.add(tfTag);
		panelAdd.add(btnCadastrar);
		
		panelRemove.add(lbIdentificador);
		panelRemove.add(tfIdentificador);
		panelRemove.add(btnRemover);
		panelRemove.setVisible(false);
		
		panelText.add(barra);
		
		
		
		panelRadios.add(rbCadastrar);
		panelRadios.add(rbRemover);
		
		add(panelRadios);
		add(panelAdd);
		add(panelRemove);
		add(panelText);
		
		
		setVisible(false);
	}
	

	
	public JTextField getTfEnunciado() {
		return tfEnunciado;
	}

	public JTextField getTfResposta() {
		return tfResposta;
	}

	public JTextField getTfTag() {
		return tfTag;
	}

	public JTextField getTfIdentificador() {
		return tfIdentificador;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnRemover() {
		return btnRemover;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JPanel getPanelAdd() {
		return panelAdd;
	}

	public JRadioButton getRbCadastrar() {
		return rbCadastrar;
	}

	public JRadioButton getRbRemover() {
		return rbRemover;
	}



	public JPanel getPanelRemove() {
		return panelRemove;
	}
	
	
	
}
