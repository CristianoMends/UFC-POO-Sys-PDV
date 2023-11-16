package pdv.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import pdv.model.Produto;

public class GerenciadorProdutosView extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton btnAtualizar;
	private JTextArea textEstoque;
	private JTextField textImagem;
	private JTextField textCategoria;
	private JTextField textQtdEstoque;
	private JTextField textPreco;
	private JTextField textNome;
	private JButton btnCadastrar;
	private JButton btnPainelAdm;
	private JButton btnRemover;

	public GerenciadorProdutosView( ) {
		getContentPane().setLayout(null);
		setSize(800,600);
        setLocationRelativeTo(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 330, 790, 240);
		panel_2.setOpaque(false);		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setBounds(313, 12, 116, 15);
		lblCadastro.setOpaque(true);
		panel_2.add(lblCadastro);
		
		textImagem = new JTextField();
		textImagem.setEditable(false);
		textImagem.setBounds(151, 159, 116, 19);
		panel_2.add(textImagem);
		textImagem.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(29, 52, 70, 15);
		panel_2.add(lblNome);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setForeground(new Color(255, 255, 255));
		lblPreo.setBounds(29, 79, 70, 15);
		panel_2.add(lblPreo);
		
		JLabel lblQtdEstoque = new JLabel("Qtd. Estoque:");
		lblQtdEstoque.setForeground(Color.WHITE);
		lblQtdEstoque.setBounds(29, 106, 116, 15);
		panel_2.add(lblQtdEstoque);
		
		JLabel lblCategoria = new JLabel("Categoria: ");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setBounds(29, 136, 104, 15);
		panel_2.add(lblCategoria);
		
		JLabel lblLinkImagem = new JLabel("Link Imagem:");
		lblLinkImagem.setForeground(Color.WHITE);
		lblLinkImagem.setBounds(29, 163, 104, 15);
		panel_2.add(lblLinkImagem);
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		textCategoria.setBounds(151, 134, 114, 19);
		panel_2.add(textCategoria);
		
		textQtdEstoque = new JTextField();
		textQtdEstoque.setColumns(10);
		textQtdEstoque.setBounds(151, 104, 114, 19);
		panel_2.add(textQtdEstoque);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(151, 77, 114, 19);
		panel_2.add(textPreco);
		
		this.textNome = new JTextField();
		this.textNome.setColumns(30);
		this.textNome.setBounds(151, 50, 165, 19);
		panel_2.add(textNome);
		
		this.btnCadastrar = new JButton("Cadastrar");
		this.btnCadastrar.setBounds(313, 203, 117, 25);
		panel_2.add(btnCadastrar);
		
		JButton btnColar = new JButton("colar");
		btnColar.setBounds(268, 159, 70, 19);
		panel_2.add(btnColar);
		
		btnColar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				    textImagem.setText(getAreaTransferencia());			
			}
		});
		
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
		this.textEstoque.setEditable(false);
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
		this.btnAtualizar.setBounds(390, 249, 117, 25);
		panel_1.add(btnAtualizar);
		
		this.btnRemover = new JButton("remover");
		this.btnRemover.setBounds(230, 249, 117, 25);
		panel_1.add(this.btnRemover);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 790, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPainelDoAdministrador = new JLabel("Gerenciador de produtos");
		lblPainelDoAdministrador.setForeground(new Color(255, 255, 255));
		lblPainelDoAdministrador.setBounds(292, 12, 194, 15);
		panel.add(lblPainelDoAdministrador);
		
		this.btnPainelAdm = new JButton("Painel Adm");
		this.btnPainelAdm.setBounds(661, 7, 117, 25);
		panel.add(btnPainelAdm);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagemIcon = new ImageIcon(getClass().getResource("/pdv/view/imagens/background.jpg"));
		Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
		background.setIcon(imagemFundo);
		background.setBounds(0, 0, 800, 600);
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

	public JTextField getTextImagem() {
		return textImagem;
	}

	public JTextField getTextCategoria() {
		return textCategoria;
	}

	public JTextField getTextQtdEstoque() {
		return textQtdEstoque;
	}

	public JTextField getTextPreco() {
		return textPreco;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}
	public JButton getbtnPainelAdmin() {
		return this.btnPainelAdm;
	}
	public JButton getBtnRemover() {
		return this.btnRemover;
	}
	
	public Produto getProduto() {
		String nome = this.textNome.getText();
		Double preco = Double.parseDouble(this.textPreco.getText());
		int qtdEstoque = Integer.parseInt(this.textQtdEstoque.getText());
		String categoria = this.textCategoria.getText();
		String imagem = this.textImagem.getText();
		
		if(nome.length() > 37) {nome = nome.substring(0,37);}
		if(categoria.length() > 18) {categoria = categoria.substring(0,18);}
		return new Produto(nome, preco, qtdEstoque, categoria, imagem);
	}
	 
	 private static String getAreaTransferencia() {
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        try {
	            String link = (String) clipboard.getData(DataFlavor.stringFlavor);
	            try {
	            	URL url = new URL(link);
	            	return link;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Link errado");
					return null;
				}
	        } catch (UnsupportedFlavorException | IOException e) {
				JOptionPane.showMessageDialog(null, "Area de transferencia invalida");
	            return null;
	        }
    }
}
