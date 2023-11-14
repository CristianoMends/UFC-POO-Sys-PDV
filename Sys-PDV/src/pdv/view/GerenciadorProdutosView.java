package pdv.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class GerenciadorProdutosView extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton btnAtualizar;
	private JTextArea textEstoque;

	public GerenciadorProdutosView( ) {
		getContentPane().setLayout(null);
		setSize(800,600);
        setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(251, 251, 251));
		panel_1.setBounds(0, 45, 790, 286);
		getContentPane().add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoque.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEstoque.setForeground(new Color(0, 0, 0));
		lblEstoque.setBackground(new Color(255, 255, 255));
		lblEstoque.setBounds(310, 12, 117, 15);
		lblEstoque.setOpaque(true);
		panel_1.add(lblEstoque);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(77, 54, 608, 193);
		panel_1.add(scrollPane);
		
		this.textEstoque = new JTextArea();
		this.textEstoque.setOpaque(false);
		this.textEstoque.setFont(new Font("Dialog", Font.PLAIN, 14));
		scrollPane.setColumnHeaderView(textEstoque);
		
		JLabel lblCodNome = new JLabel("Cod |                  Nome                  |        Preço        |  QtdEstoque  | Categoria");
		lblCodNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCodNome.setForeground(new Color(255, 255, 255));
		lblCodNome.setBounds(77, 40, 608, 15);
		panel_1.add(lblCodNome);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 280, 800, 25);
		panel_1.add(separator);
		
		this.btnAtualizar = new JButton("Atualizar");
		this.btnAtualizar.setBounds(310, 249, 117, 25);
		panel_1.add(btnAtualizar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 790, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPainelDoAdministrador = new JLabel("Gerenciador de produtos");
		lblPainelDoAdministrador.setForeground(new Color(255, 255, 255));
		lblPainelDoAdministrador.setBounds(292, 12, 194, 15);
		panel.add(lblPainelDoAdministrador);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagemIcon = new ImageIcon(GerenciadorProdutosView.class.getResource("/pdv/view/imagens/background.jpg"));
		Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
		background.setIcon(imagemFundo);
		background.setBounds(0, 0, 790, 600);
		getContentPane().add(background);
	}
	 
	 public void showGerencioadorProdutos() {
		 setVisible(true);
	 }
	 public void hiddenGerenciadorProdutos() {
		 setVisible(false);
	 }

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public JTextArea getTextEstoque() {
		return textEstoque;
	}
	 
}
