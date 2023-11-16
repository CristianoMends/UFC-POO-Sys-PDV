package pdv.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

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

import pdv.controller.Pdv;
import pdv.model.Estoque;
import pdv.model.FormaPagamento;
import pdv.model.ItemVenda;
import pdv.model.MsgException;
import pdv.model.Produto;
import pdv.model.Venda;

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
	private JTextArea textListaVenda;
	private JButton btnAdd;
	private JPanel panel;
	private String urlDaImagem;
	private JLabel imagemProduto;
	private JButton btnFinalizarVenda;
	
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

		JLabel lblNewLabel_2 = new JLabel("Cod.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 10, 45, 13);
		panel.add(lblNewLabel_2);

		this.textQtd = new JTextField("1");
		this.textQtd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.textQtd.setEditable(false);
		this.textQtd.setBounds(167, 22, 53, 25);
		panel.add(textQtd);
		this.textQtd.setColumns(10);

		this.btnRem = new JButton("-");
		this.btnRem.setMnemonic('-');
		this.btnRem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnRem.setBounds(221, 22, 50, 25);
		panel.add(btnRem);

		this.btnAdd = new JButton("+");
		this.btnAdd.setMnemonic('+');
		this.btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnAdd.setBounds(275, 22, 50, 25);
		panel.add(btnAdd);

		JLabel lblNewLabel_3 = new JLabel("Qtd.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(167, 10, 45, 13);
		panel.add(lblNewLabel_3);
		
		this.imagemProduto = new JLabel(imagemFundo);
		this.imagemProduto.setBounds(506, 90, 258, 266);
		panel.add(imagemProduto);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imagemIcon = new ImageIcon(GerenciadorProdutosView.class.getResource("/pdv/view/imagens/background.jpg"));
		Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
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
	            for(ItemVenda item : venda.getItens()) {
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
	
	public void showJanelaFinalizacao(Venda venda) {
		if(this.venda == null) {
			JOptionPane.showMessageDialog(btnFinalizar, "Nenhum produto foi adicionado!");
			return;
		}
		Double vTotal = venda.getTotal();
		
		JFrame finalizacao = new JFrame();
		finalizacao.setTitle("Janela Dinheiro");       
		finalizacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 250, 200);
		        
        JTextField entregue = new JTextField(10);
        entregue.setBounds(127, 23, 114, 19);
        entregue.setText("0");
        panel_5.setLayout(null);
        JLabel lblPago = new JLabel("Pago: ");
        lblPago.setBounds(7, 25, 115, 15);
        panel_5.add(lblPago);
        panel_5.add(entregue);
        
        
        JLabel label_1 = new JLabel("Troco: ");
        label_1.setBounds(7, 44, 48, 15);
        panel_5.add(label_1);        
        
        JComboBox<FormaPagamento> comboBoxFormaPagamento = new JComboBox<>(FormaPagamento.values());
        comboBoxFormaPagamento.setBounds(47, 93, 154, 24);
        
        JLabel label_2 = new JLabel("Forma de Pagamento: ");
        label_2.setBounds(47, 71, 160, 15);
        panel_5.add(label_2);
        panel_5.add(comboBoxFormaPagamento);

        JButton btnFinalizarVenda = new JButton("Finalizar");
        btnFinalizarVenda.setBounds(70, 131, 124, 25);
        
        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(7, 7, 115, 15);
        panel_5.add(lblTotal);
        
        JTextField total = new JTextField(10);
        total.setText(String.format("R$ %.2f", vTotal));
        total.setEditable(false);
        total.setBounds(127, 5, 114, 19);
        panel_5.add(total);
        
        JTextField troco = new JTextField(10);
        troco.setEditable(false);
        troco.setText("0.00");
        troco.setBounds(127, 42, 114, 19);
        panel_5.add(troco);
                
        btnFinalizarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Double vEntregue = Double.parseDouble(entregue.getText());
            	if(vEntregue < vTotal) {
            		JOptionPane.showMessageDialog(troco, "O valor pago é menor que o total da compra");
            		return;
            		//throw new MsgException("O valor pago é menor que o total da compra");
            	}
            	JOptionPane.showMessageDialog(troco, "Venda finalizada!");
            	lancarVenda();            	
            	finalizacao.dispose();
            }
        });
        entregue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Double vEntregue = Double.parseDouble(entregue.getText());
            	if(vEntregue > vTotal) {
                    troco.setText(String.format("R$ %.2f", (vEntregue - vTotal)));
            	}
            }
        });        
        
        Pdv.filtrarNumeros(entregue);
        panel_5.add(btnFinalizarVenda);        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - 250) / 2);
        int centerY = (int) ((screenSize.getHeight() - 200) / 2);
        finalizacao.setBounds(centerX, centerY, 250,200);
        finalizacao.getContentPane().add(panel_5);
        finalizacao.setUndecorated(true);
        finalizacao.setVisible(true);
	}
	
	// metodos get
	public JTextField getTextValorTotal() {
		return textValorTotal;
	}
	public void lancarVenda() {
		venda = new Venda();
		ItemVenda.setNextId(1);
		this.textListaVenda.setText("");
		ImageIcon imagemIcon = new ImageIcon(VendasView.class.getResource("/pdv/view/imagens/listaVazia.png"));
		Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(258, 266, Image.SCALE_SMOOTH);
		ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
		this.imagemProduto.setIcon(imagemFundo);
		this.textValorTotal.setText("R$ 0.00");

	}
	public static boolean exibirTelaLogin() {		
        String username = JOptionPane.showInputDialog("Nome de Usuário:");
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Senha:", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String password = new String(passwordField.getPassword());

            if ("admin".equals(username) && "qwe123".equals(password)) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido. Bem-vindo, " + username + "!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login cancelado.");
            return false;
        }
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
}
