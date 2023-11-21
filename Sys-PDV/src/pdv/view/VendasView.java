package pdv.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import pdv.controller.Pdv;
import pdv.model.entidades.Cliente;
import pdv.model.entidades.Estoque;
import pdv.model.entidades.Funcionario;
import pdv.model.entidades.Produto;
import pdv.model.entidades.ProdutoVenda;
import pdv.model.entidades.Venda;
import pdv.model.enums.Cargo;
import pdv.model.enums.FormaPagamento;
import pdv.model.exceptions.MsgException;

public class VendasView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textValorTotal;
	private JTextField textCod;
	private JTextField textQtd;
	private JButton btnPainelAdm;
	private JButton btnFinalizar;
	private JButton btnRem;
	private JButton btnCancelar;
	protected JTextArea textListaVenda;
	private JButton btnAdd;
	private JPanel panel;
	private String urlDaImagem;
	private JLabel imagemProduto;
	private JButton btnFinalizarVenda;
	private JComboBox<String> selectVendedor;
	private JComboBox<String> selectCliente;
	
	private DefaultComboBoxModel<String> modelClientes = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<String> modelVendedores = new DefaultComboBoxModel<>();
	
	private Venda venda;
	ImageIcon imagemIcon = new ImageIcon(VendasView.class.getResource("/pdv/view/imagens/listaVazia.png"));
	Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(258, 266, Image.SCALE_SMOOTH);
	ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
	private JLabel label;
	
	public VendasView() {

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 59, 800, 511);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 84, 486, 300);
		panel.add(panel_3);
		panel_3.setLayout(null);

		this.textListaVenda = new JTextArea();
		textListaVenda.setForeground(new Color(255, 255, 255));
		textListaVenda.setBackground(new Color(0, 0, 0));
		this.textListaVenda.setEditable(false);
		this.textListaVenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(textListaVenda); // Adiciona o JTextArea a um JScrollPane
		scrollPane.setBounds(0, 0, 486, 350); // Define o tamanho do JScrollPane
		panel_3.add(scrollPane);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 255));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 57, 486, 28);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel = new JLabel("Produto                               Qtd         P.Unitario      P.Total");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 10, 458, 15);
		panel_4.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Valor Total");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
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

		this.textCod = new JTextField();
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
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(178, 10, 103, 13);
		panel.add(lblNewLabel_3);
		
		this.imagemProduto = new JLabel(imagemFundo);
		this.imagemProduto.setBounds(506, 90, 258, 266);
		panel.add(imagemProduto);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagemIcon = new ImageIcon(GerenciadorProdutosView.class.getResource("/pdv/view/imagens/background.jpg"));
		Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
		
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
		try {
            MaskFormatter maskFormatter = new MaskFormatter("###########");

		} catch (ParseException e) {
            e.printStackTrace(); // Lide com a exceção adequadamente
        }		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBounds(0, 0, 788, 58);
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
		background.setIcon(imagemFundo);
		background.setBounds(0, 0, 790, 600);
		panel.add(background);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 800, 59);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		this.btnPainelAdm = new JButton("Painel Adm");
		this.btnPainelAdm.setBounds(654, 22, 122, 21);
		panel_1.add(btnPainelAdm);

		JLabel lblNewLabel_4 = new JLabel("SysPDV");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(12, 12, 114, 37);
		panel_1.add(lblNewLabel_4);

		JLabel label1 = new JLabel("Sys-PDV");
		this.rootPane.add(label1);
		
		setSize(800,600);
        setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void hideMainView() {
		setVisible(false);
	}

	public void showVendasView() {
		setVisible(true);
	}
	
	public void addVendedores(ArrayList<Funcionario> funcionarios) {
		this.getModelVendedores().addElement("Nenhum");
		for(Funcionario f : funcionarios) {
			if(f.getCargo().equals(Cargo.VENDEDOR.getDescricao())) {
				this.getModelVendedores().addElement(f.getNome());
			}
		}

	}
	
	public void addClientes(ArrayList<Cliente> clientes) {
		this.getModelClientes().addElement("Nenhum");
		for(Cliente c : clientes) {
			this.getModelClientes().addElement(c.getNome());
		}

	}
	
	public void showJanelaFinalizacao(Venda venda) {
		if(this.venda == null) {
			JOptionPane.showMessageDialog(btnFinalizar, "Nenhum produto foi adicionado!");
			return;
		}
		new FinalizacaoVenda(this.venda, this);
	}

	public void atualizarVenda(Venda venda) {
		this.venda = venda;
		this.textCod.setText("");
		this.textQtd.setText("1");
		this.textListaVenda.setText(venda.toString());
		this.textValorTotal.setText(String.format("R$ %.2f", venda.getTotal()));
		if(venda.getItens().size() < 1) {
			this.imagemProduto.setIcon(this.imagemFundo);
			return;
		}
		try {
			this.setUrlDaImagem(venda.getUltimoProduto().getImagem());
			ImageIcon imagemIcon = new ImageIcon(new URL(this.getUrlDaImagem()));
			Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(258, 266, Image.SCALE_SMOOTH);
			ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
			this.imagemProduto.setIcon(imagemFundo);
		} catch (Exception e) {
			e.printStackTrace();			
			throw new MsgException("Erro ao carregar imagem do produto!");
		}
	}
	public void cancelar(Venda venda) {
		if(venda.getItens().size() < 1) {
			JOptionPane.showMessageDialog(btnCancelar, "Não possui produtos para cancelar!");
			return;
		}
		   String input = Pdv.showInput(btnCancelar, "Digite o codigo do produto", "", JOptionPane.QUESTION_MESSAGE);
	        try {
	            int cod = Integer.parseInt(input);
	            boolean encontrado = false;
	            for(ProdutoVenda item : venda.getItens()) {
	            	if(item.getId() == cod) {
	            		venda.getItens().remove(item);
	            		JOptionPane.showMessageDialog(null, "Produto cancelado");
	            		atualizarVenda(venda);
	            		encontrado = true;
	            		break;
	            	}
	            }
	            
	            if(!encontrado) {
	            	Pdv.showMensagem(btnCancelar, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (NumberFormatException e) {
	        	Pdv.showMensagem(btnCancelar, "Valor invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
	        	//throw new MsgException("Valor invalido!");
	        }
	}

	public Produto getProduto(Integer cod, Estoque estoque) {
		return estoque.getProduto(cod);
	}

	public void add() {
		if(this.textCod.getText().equals("")) {
			JOptionPane.showMessageDialog(this.btnAdd, "Selecione o codigo do produto!");
			return;
		}
		int qtd = Integer.parseInt(this.textQtd.getText());
		textQtd.setText(String.format("%d", qtd + 1));
	}

	public void rem() {
		if(this.textCod.getText().equals("")) {
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
	
	
	// metodos get
	public JTextField getTextValorTotal() {
		return textValorTotal;
	}

	public JTextField getTextCod() {
		return this.textCod;
	}

	public JTextField getTextQtd() {
		return textQtd;
	}

	public JButton getBtnPainelAdm() {
		return btnPainelAdm;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public JButton getBtnRem() {
		return btnRem;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JTextArea getTextListaVenda() {
		return textListaVenda;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public String getUrlDaImagem() {
		return urlDaImagem;
	}
	public JButton getBtnFinalizarVenda() {
		return this.btnFinalizarVenda;
	}

	public void setUrlDaImagem(String urlDaImagem) {
		this.urlDaImagem = urlDaImagem;
	}
	public JComboBox getSelectVendedor() {
		return this.selectVendedor;
	}
	public JComboBox getSelectCliente() {
		return this.selectCliente;
	}
	
	public JLabel getImagemProduto() {
		return this.imagemProduto;
	}

	public DefaultComboBoxModel<String> getModelClientes() {
		return modelClientes;
	}

	public DefaultComboBoxModel<String> getModelVendedores() {
		return modelVendedores;
	}
	
}
