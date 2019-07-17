package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShowMessage {
	
	public static void showText(String text){
		JOptionPane.showMessageDialog(null, text);
	}
	
	public static int activeInputDialog(String text){
		Object[] options = {"Verdadeiro.", "Falso"};
		
		int n = JOptionPane.showOptionDialog(new JFrame(), text, "Questionario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		
		
		return n;
	}
	
	public static void main(String[] args) {
		System.out.println(ShowMessage.activeInputDialog("TESTE"));
	}

}
