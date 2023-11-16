package pdv.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pdv.model.Estoque;
import java.awt.Color;

public class AdminView extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton btnGerenciarCaixas;
	private JButton btnVender;
	private JButton btnGerenciarProdutos;

	public AdminView() {
		super("");
		getContentPane().setLayout(null);
		setSize(800,600);
        setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 800, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPainelDoAdministrador = new JLabel("Painel do Administrador");
		lblPainelDoAdministrador.setForeground(new Color(255, 255, 255));
		lblPainelDoAdministrador.setBounds(292, 12, 194, 15);
		panel.add(lblPainelDoAdministrador);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 800, 600);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		this.btnGerenciarProdutos = new JButton("Gerenciar produtos");
		this.btnGerenciarProdutos.setBounds(276, 90, 200, 25);
		panel_1.add(btnGerenciarProdutos);
		
		this.btnVender = new JButton("Vender");
		this.btnVender.setBounds(276, 201, 200, 25);
		panel_1.add(btnVender);
		
		this.btnGerenciarCaixas = new JButton("Gerenciar caixas");
		this.btnGerenciarCaixas.setBounds(276, 127, 200, 25);
		panel_1.add(btnGerenciarCaixas);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagemIcon = new ImageIcon(GerenciadorProdutosView.class.getResource("/pdv/view/imagens/background.jpg"));
		Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
		
		JButton btnGerenciarFuncionarios = new JButton("Gerenciar funcionarios");
		btnGerenciarFuncionarios.setBounds(276, 164, 200, 25);
		panel_1.add(btnGerenciarFuncionarios);
		background.setIcon(imagemFundo);
		background.setBounds(0, 0, 800, 600);
		panel_1.add(background);
	}
	
	 public void showAdminView() {
		 setVisible(true);
	 }
	 public void hiddenAdminView() {
		 setVisible(false);
	 }
	public JButton getBtnGerenciarCaixas() {
		return btnGerenciarCaixas;
	}
	public JButton getBtnVender() {
		return btnVender;
	}
	public JButton getBtnGerenciarProdutos() {
		return btnGerenciarProdutos;
	}
}
