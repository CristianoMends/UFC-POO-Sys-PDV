package pdv.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import pdv.controller.Pdv;
import pdv.model.entidades.Estoque;
import pdv.model.entidades.Produto;
import pdv.model.enums.Cor;
import pdv.model.exceptions.MsgException;

public class EstoqueView extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnAtualizar;
	private JTextArea textEstoque;
	private JTextField textImagem;
	private JTextField textCategoria;
	private JTextField textQtdEstoque;
	private JTextField textPreco;
	private JTextField textNome;
	private JButton btnCadastrar;
	private JButton btnRemover;
	private JButton btnColar;
    private JTable table;


	public EstoqueView() {
		setLayout(null);
		setBackground(Cor.AzulDodger.getColor());

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 330, 790, 240);
		panel_2.setBackground(Cor.AzulDodger.getColor());
		panel_2.setOpaque(false);
		add(panel_2);
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
		lblNome.setForeground(Cor.BrancoPuro.getColor());
		lblNome.setBounds(29, 52, 70, 15);
		panel_2.add(lblNome);

		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setForeground(Cor.BrancoPuro.getColor());
		lblPreo.setBounds(29, 79, 70, 15);
		panel_2.add(lblPreo);

		JLabel lblQtdEstoque = new JLabel("Qtd. Estoque:");
		lblQtdEstoque.setForeground(Cor.BrancoPuro.getColor());
		lblQtdEstoque.setBounds(29, 106, 116, 15);
		panel_2.add(lblQtdEstoque);

		JLabel lblCategoria = new JLabel("Categoria: ");
		lblCategoria.setForeground(Cor.BrancoPuro.getColor());
		lblCategoria.setBounds(29, 136, 104, 15);
		panel_2.add(lblCategoria);

		JLabel lblLinkImagem = new JLabel("Link Imagem:");
		lblLinkImagem.setForeground(Cor.BrancoPuro.getColor());
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

		btnColar = new JButton("colar");
		btnColar.setBounds(268, 159, 70, 19);
		panel_2.add(btnColar);

		btnColar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textImagem.setText(getAreaTransferencia());
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Cor.CinzaMedio.getColor());
		panel_1.setBounds(0, 45, 790, 286);
		add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Cor.AzulDodger.getColor());
		panel3.setBounds(0, 45, 790, 240);
        add(panel3);
        panel3.setOpaque(false);
        panel3.setLayout(new BorderLayout());

        JLabel lblEstoque = new JLabel("Estoque");
        lblEstoque.setHorizontalAlignment(SwingConstants.CENTER);
        lblEstoque.setFont(new Font("Dialog", Font.BOLD, 15));
        lblEstoque.setForeground(Cor.CinzaMedio.getColor());
        lblEstoque.setBackground(Cor.BrancoPuro.getColor());
        lblEstoque.setBounds(310, 12, 117, 15);
        lblEstoque.setOpaque(true);
        panel3.add(lblEstoque, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel3.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setEnabled(false);
        table.setFont(new Font("Dialog", Font.PLAIN, 14));
        table.setForeground(Cor.BrancoPuro.getColor());
        table.setBackground(Cor.CinzaMedio.getColor());
        scrollPane.setViewportView(table);

        // Adiciona colunas à tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cod");
        model.addColumn("Nome");
        model.addColumn("Preço");
        model.addColumn("QtdEstoque");
        model.addColumn("Categoria");
        table.setModel(model);	

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
		panel.setBackground(Cor.CinzaMedio.getColor());
		panel.setBounds(0, 0, 790, 44);
		add(panel);
		panel.setLayout(null);

		JLabel lblPainelDoAdministrador = new JLabel("Gerenciador de produtos");
		lblPainelDoAdministrador.setForeground(Cor.BrancoPuro.getColor());
		lblPainelDoAdministrador.setBounds(292, 12, 194, 15);
		panel.add(lblPainelDoAdministrador);
		Pdv.filtrarNumeros(textPreco);
	}
	public Produto getProduto() {
		try {
		String nome = this.textNome.getText();		
		Double preco = Double.parseDouble(this.textPreco.getText());
		int qtdEstoque = Integer.parseInt(this.textQtdEstoque.getText());
		String categoria = this.textCategoria.getText();
		String imagem = this.textImagem.getText();
		
		if (nome.length() > 37) {
			nome = nome.substring(0, 37);
		}
		if (categoria.length() > 18) {
			categoria = categoria.substring(0, 18);
		}
		return new Produto(nome, preco, qtdEstoque, categoria, imagem);
		}catch(MsgException e) {
			Pdv.showMensagem(btnCadastrar, "Valor invalido", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}

	private static String getAreaTransferencia() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		try {
			String link = (String) clipboard.getData(DataFlavor.stringFlavor);
			try {
				URL url = new URL(link);
				return link;
			} catch (Exception e) {
				Pdv.showMensagem(null, "Link de imagem invalido!", "Erro!", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch (UnsupportedFlavorException | IOException e) {
			Pdv.showMensagem(null, "Link de imagem invalido!", "Erro!", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	 private void atualizarTabela() {
	        Estoque estoque = Pdv.estoqueDao.getEstoqueDB();
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);
	        for (Produto produto : estoque.getListProdutos()) {
	            Object[] rowData = {produto.getId(), produto.getNome(), produto.getPreco(), produto.getQtdEstoque(), produto.getCategoria()};
	            model.addRow(rowData);
	        }
	    }
	
	public void setAcoesBtns() {
		getBtnAtualizar().addActionListener(new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
	                atualizarTabela();
	            }
		});

		getBtnCadastrar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Pdv.produtoDao.inserirProdutoDB(getProduto())) {					
					Pdv.showMensagem(getBtnCadastrar(), "Produto cadastrado com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				Pdv.showMensagem(getBtnCadastrar(), "Erro ao cadastrar produto!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		});
		getBtnRemover().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cod = 0;
				while (true) {
					try {
						String input = JOptionPane.showInputDialog("Digite o codigo do produto:");
						cod = Integer.parseInt(input);
						Pdv.produtoDao.removerProdutoDB(cod);
						break;
					}catch(MsgException me) {
						Pdv.showMensagem(getBtnRemover(), "Codigo invalido", "Aviso!", JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
	}
	
	//metodos get
	public JButton		getBtnColar()		{ return btnColar;			}
	public JButton 		getBtnAtualizar() 	{ return btnAtualizar; 		}
	public JTextArea 	getTextEstoque() 	{ return textEstoque; 		}
	public JTextField 	getTextImagem() 	{ return textImagem; 		}
	public JTextField 	getTextCategoria() 	{ return textCategoria; 	}
	public JTextField 	getTextQtdEstoque() { return textQtdEstoque; 	}
	public JTextField 	getTextPreco() 		{ return textPreco; 		}
	public JTextField 	getTextNome() 		{ return textNome; 			}
	public JButton 		getBtnCadastrar() 	{ return btnCadastrar; 		}
	public JButton 		getBtnRemover() 	{ return this.btnRemover; 	}
}
