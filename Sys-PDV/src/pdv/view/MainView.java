package pdv.view;
import java.util.Scanner;

import pdv.model.*;

/*
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;*/

public class MainView /*extends JFrame*/{
	private static Scanner sc = new Scanner(System.in);
	private static void println(Object o){
		System.out.println(o);
	}
	private static String input(){
		return sc.nextLine();
	}
	
	
	public MainView() {
		/*getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		
		JLabel label1 = new JLabel("Sys-PDV");
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(label1);*/
	}
	public void listarEstoque(Estoque estoque){
		println(estoque);
	}
}
