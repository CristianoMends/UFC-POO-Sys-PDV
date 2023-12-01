package pdv.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import pdv.controller.Pdv;
import pdv.model.entidades.Cliente;
import pdv.model.entidades.Estoque;
import pdv.model.entidades.Funcionario;
import pdv.model.entidades.Produto;
import pdv.model.entidades.ProdutoVenda;
import pdv.model.entidades.Venda;
import pdv.model.enums.Cargo;
import pdv.model.enums.Cor;

public class TelaVendas extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textValorTotal;
	private JTextField textCod;
	private JTextField textQtd;
	private JButton btnFinalizar;
	private JButton btnRem;
	private JButton btnCancelar;
	private JButton btnAdd;
	private JPanel panel;
	private String urlDaImagem;
	private JLabel imagemProduto;
	private JButton btnFinalizarVenda;
	private JComboBox<String> selectVendedor;
	private JComboBox<String> selectCliente;
	private DefaultTableModel tableModel;
    private JTable table;
	private DefaultComboBoxModel<String> modelClientes = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<String> modelVendedores = new DefaultComboBoxModel<>();
	
	MaskFormatter maskFormatter;
	ImageIcon imagemIcon = new ImageIcon(TelaVendas.class.getResource("/pdv/view/imagens/listaVazia.png"));
	Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(258, 266, Image.SCALE_SMOOTH);
	ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);

	public TelaVendas() {
		JPanel panel = new JPanel();
		panel.setBackground(Cor.AzulDodger.getColor());
		panel.setBounds(0, 59, 800, 550);
		add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 84, 487, 300);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Cod");
        tableModel.addColumn("Produto");
        tableModel.addColumn("Qtd");
        tableModel.addColumn("P.Unitario");
        tableModel.addColumn("P.Total");
        table = new JTable(tableModel);
        table.setEnabled(false);

		
		JScrollPane scrollPane = new JScrollPane(table); // Adiciona o JTextArea a um JScrollPane
		scrollPane.setBounds(0, 0, 486, 300); // Define o tamanho do JScrollPane
		panel_3.add(scrollPane);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Cor.AzulDodger.getColor());
		panel_4.setBounds(10, 57, 486, 28);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Valor Total");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setForeground(Cor.BrancoPuro.getColor());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(12, 418, 200, 25);
		panel.add(lblNewLabel_1);

		this.textValorTotal = new JTextField("R$ 0,00");
		this.textValorTotal.setToolTipText("valor total");
		this.textValorTotal.setEditable(false);
		this.textValorTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		this.textValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.textValorTotal.setColumns(10);
		this.textValorTotal.setBounds(155, 403, 200, 50);
		panel.add(textValorTotal);

		this.textCod = new JFormattedTextField(maskFormatter);
		this.textCod.setToolTipText("Codigo do produto");
		this.textCod.setBounds(10, 22, 150, 25);
		panel.add(textCod);
		this.textCod.setColumns(10);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(71, 465, 150, 25);
		panel.add(btnCancelar);

		this.btnFinalizar = new JButton("Receber e Finalizar");
		this.btnFinalizar.setBounds(253, 465, 187, 25);
		panel.add(btnFinalizar);

		JLabel lblNewLabel_2 = new JLabel("Codigo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 10, 75, 13);
		panel.add(lblNewLabel_2);

		this.textQtd = new JTextField("1");
		this.textQtd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.textQtd.setEditable(false);
		this.textQtd.setBounds(177, 22, 53, 25);
		Pdv.filtrarNumeros(textCod);
		panel.add(textQtd);
		this.textQtd.setColumns(10);

		this.btnRem = new JButton("-");
		this.btnRem.setMnemonic('-');
		this.btnRem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnRem.setBounds(231, 22, 50, 25);
		panel.add(btnRem);

		this.btnAdd = new JButton("+");
		this.btnAdd.setMnemonic('+');
		this.btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnAdd.setBounds(281, 22, 50, 25);
		panel.add(btnAdd);

		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Cor.BrancoPuro.getColor());
		lblNewLabel_3.setBounds(178, 10, 103, 13);
		panel.add(lblNewLabel_3);

		this.imagemProduto = new JLabel(imagemFundo);
		this.imagemProduto.setBounds(506, 90, 258, 266);
		panel.add(imagemProduto);

		this.selectVendedor = new JComboBox<String>();
		this.selectVendedor.setModel(this.modelVendedores);
		this.selectVendedor.setToolTipText("Selecione o Vendedor aqui");
		this.selectVendedor.setBounds(343, 22, 150, 25);
		panel.add(this.selectVendedor);

		JLabel lblNewLabel_3_1 = new JLabel("Vendedor");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(344, 9, 96, 13);
		panel.add(lblNewLabel_3_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Cor.CinzaMedio.getColor());
		panel_2.setForeground(Cor.CinzaMedio.getColor());
		panel_2.setBounds(0, 0, 800, 58);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3_1_1 = new JLabel("Cliente");
		lblNewLabel_3_1_1.setBounds(504, 9, 96, 13);
		panel_2.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));

		this.selectCliente = new JComboBox<String>();
		this.selectCliente.setModel(this.modelClientes);
		this.selectCliente.setToolTipText("Selecione o Cliente aqui");
		this.selectCliente.setBounds(504, 22, 150, 25);
		panel_2.add(selectCliente);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Cor.CinzaMedio.getColor());
		panel_1.setBounds(0, 0, 800, 59);
		add(panel_1);
		panel_1.setLayout(null);

		setLayout(null);
		}

	public void addVendedores(ArrayList<Funcionario> funcionarios) {
		if(getModelVendedores().getSize() == funcionarios.size()) {
			return;
		}
		this.getModelVendedores().removeAllElements();
		this.getModelVendedores().addElement("Nenhum");
		for (Funcionario f : funcionarios) {
			if (f.getCargo().equals(Cargo.VENDEDOR.getDescricao())) {
				this.getModelVendedores().addElement(f.getNome());
			}
		}

	}

	public void addClientes(ArrayList<Cliente> clientes) {
		if(getModelClientes().getSize() == clientes.size() + 1) {
			return;
		}
		this.getModelClientes().removeAllElements();
		this.getModelClientes().addElement("Nenhum");
		for (Cliente c : clientes) {
			this.getModelClientes().addElement(c.getNome());
		}

	}

	public void showJanelaFinalizacao(Venda venda) {
		if (Pdv.venda == null) {
			JOptionPane.showMessageDialog(btnFinalizar, "Nenhum produto foi adicionado!");
			return;
		}
		new TelaFinalizacao(Pdv.venda, this);
	}

	public void atualizarVenda(Venda venda) {
		 Pdv.venda = venda;
	        tableModel.setRowCount(0);

	        for (ProdutoVenda item : venda.getItens()) {
	            Object[] rowData = {
	            		item.getId(),
	                    item.getProduto().getNome(),
	                    item.getQuantidade(),
	                    String.format("R$ %.2f", item.getProduto().getPreco()),
	                    String.format("R$ %.2f", item.getTotal())
	            };
	            tableModel.addRow(rowData);
	        }
		Pdv.venda = venda;
		this.textCod.setText("");
		this.textQtd.setText("1");
		this.textValorTotal.setText(String.format("R$ %.2f", venda.getTotal()));		
		if (venda.getItens().size() < 1) {
			this.imagemProduto.setIcon(this.imagemFundo);
			getSelectCliente().setSelectedIndex(0);
			getSelectVendedor().setSelectedIndex(0);
			return;
		}
		try {
			this.setUrlDaImagem(Pdv.venda.getUltimoProduto().getImagem());
			ImageIcon imagemIcon = new ImageIcon(new URL(this.getUrlDaImagem()));
			Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(258, 266, Image.SCALE_SMOOTH);
			ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
			this.imagemProduto.setIcon(imagemFundo);
		} catch (Exception e) {
			Pdv.showMensagem(null, "Erro ao carregar imagem do produto!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	public void cancelar() {
		if(!Pdv.chequeLogin(btnCancelar)) {
    		return;
    	}
		if (Pdv.venda.getItens().size() < 1) {
			JOptionPane.showMessageDialog(btnCancelar, "Não possui produtos para cancelar!");
			return;
		}
		String input = Pdv.showInput(btnCancelar, "Digite o codigo do produto", "", JOptionPane.QUESTION_MESSAGE);
		try {
			int cod = Integer.parseInt(input);

			boolean encontrado = false;
			for (ProdutoVenda item : Pdv.venda.getItens()) {
				if (item.getId() == cod) {
					Pdv.venda.getItens().remove(item);
					Pdv.showMensagem(btnCancelar, "Produto cancelado com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
					Pdv.venda.sortIdProdutos();
					atualizarVenda(Pdv.venda);
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				Pdv.showMensagem(btnCancelar, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			Pdv.showMensagem(btnCancelar, "Valor invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	public Produto getProduto(Integer cod, Estoque estoque) {
		return estoque.getProduto(cod);
	}

	public boolean estaVendendo() {
		if (Pdv.venda == null) {			
			return false;
		}else {
			if(Pdv.venda.getItens().size() < 1) {
				return false;
			}else {
				return true;
			}
			
		}
	}

	public void add() {
		if (this.textCod.getText().equals("")) {
			JOptionPane.showMessageDialog(this.btnAdd, "Selecione o codigo do produto!");
			return;
		}
		int qtd = Integer.parseInt(this.textQtd.getText());
		textQtd.setText(String.format("%d", qtd + 1));
	}

	public void rem() {
		if (this.textCod.getText().equals("")) {
			JOptionPane.showMessageDialog(this.btnRem, "Selecione o codigo do produto!");
			return;
		}
		int qtd = Integer.parseInt(this.textQtd.getText());

		if (qtd <= 1) {
			this.textQtd.setText(String.format("%d", 1));
			return;
		}
		this.textQtd.setText(String.format("%d", qtd - 1));
	}

	
	public void adicionarProduto(Estoque estoque) {
		int cod;
		try {
			cod = Integer.parseInt(getTextCod().getText());
		}catch(Exception e) {
			Pdv.showMensagem(getTextCod(), "Codigo inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		Produto produto = getProduto(cod, estoque);
		if (produto == null) {
			Pdv.showMensagem(getTextCod(), "Produto não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}

		int quantidade = Integer.parseInt(getTextQtd().getText());
		int qtdAdicionada = 0;
		for(ProdutoVenda item : Pdv.venda.getItens()) {
			if(item.getProduto().getId() == produto.getId()) {
				qtdAdicionada += item.getQuantidade();
			}
		}
		if(quantidade + qtdAdicionada > estoque.getProduto(cod).getQtdEstoque()) {			
			Pdv.showMensagem(getTextCod(), "A quantidade selecionada não está disponível no estoque!", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		double total = (double) (produto.getPreco() * quantidade);				
		
		if(Pdv.venda == null) {Pdv.venda = new Venda();}
		ProdutoVenda itemVenda = new ProdutoVenda(Pdv.venda.getItens().size() + 1, produto, quantidade, total);

		Pdv.venda.adicionarItem(itemVenda);
		
		Object[] rowData = {
                produto.getNome(),
                quantidade,
                String.format("R$ %.2f", produto.getPreco()),
                String.format("R$ %.2f", total)
        };
        tableModel.addRow(rowData);
		atualizarVenda(Pdv.venda);
	}

	public void setEvents(PrincipalView parent, Venda venda, Estoque estoque, ArrayList<Funcionario> funcionarios,
			ArrayList<Cliente> clientes, AdmView admView) {
		this.getTextCod().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				adicionarProduto(estoque);
			}
		});
		this.getBtnAdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		this.getBtnRem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rem();
			}
		});

		this.getBtnCancelar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});

		this.getBtnFinalizar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showJanelaFinalizacao(venda);
			}
		});
		getBtnAdd().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    getTextCod().requestFocusInWindow();  // Certifica-se de que o campo de texto tem o foco
                    adicionarProduto(estoque);
                }
            }
        });
		getBtnRem().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    getTextCod().requestFocusInWindow();  // Certifica-se de que o campo de texto tem o foco
                    adicionarProduto(estoque);
                }
            }
        });
		getSelectCliente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String nomeCli = (String) getSelectCliente().getSelectedItem();
            	
            	for (Cliente c : clientes) {
        				if(c.getNome().equals(nomeCli)) {
        		               Pdv.venda.setCliente(c);
        				}        			
        		}
            }
        });
		getSelectVendedor().addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {            	
            	String nomeFun = (String) getSelectVendedor().getSelectedItem();
            	
            	for (Funcionario f : funcionarios) {
        			if (f.getCargo().equals(Cargo.VENDEDOR.getDescricao())) {
        				if(f.getNome().equals(nomeFun)) {
        		               Pdv.venda.setFuncionario(f);
        				}
        			}
        		}
            }
        });
		getSelectVendedor().addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	        		addVendedores(funcionarios);
	            }
	        });
		addClientes(clientes);
		setFocusable(true); 
	}
	
	// metodos get
	public JTextField 					getTextValorTotal() 				{ return textValorTotal;			}
	public JTextField 					getTextCod() 						{ return this.textCod; 				}
	public JTextField 					getTextQtd() 						{ return textQtd; 					}
	public JButton 						getBtnFinalizar() 					{ return btnFinalizar; 				}
	public JButton 						getBtnRem() 						{ return btnRem; 					}
	public JButton 						getBtnCancelar() 					{ return btnCancelar; 				}
	public JButton 						getBtnAdd() 						{ return btnAdd; 					}
	public JPanel 						getPanel() 							{ return this.panel; 				}
	public String 						getUrlDaImagem() 					{ return urlDaImagem;				}
	public JButton 						getBtnFinalizarVenda() 				{ return this.btnFinalizarVenda;	}
	public void 						setUrlDaImagem(String urlDaImagem) 	{ this.urlDaImagem = urlDaImagem; 	}
	public JComboBox<String> 			getSelectVendedor() 				{ return this.selectVendedor; 		}
	public JComboBox<String> 			getSelectCliente() 					{ return this.selectCliente; 		}
	public JLabel 						getImagemProduto() 					{ return this.imagemProduto; 		}
	public DefaultComboBoxModel<String> getModelClientes() 					{ return modelClientes; 			}
	public DefaultComboBoxModel<String> getModelVendedores() 				{ return modelVendedores; 			}
}
