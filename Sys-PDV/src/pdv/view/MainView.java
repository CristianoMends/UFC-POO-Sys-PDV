package pdv.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import pdv.model.Estoque;
import pdv.model.MsgException;
import pdv.model.Produto;
import pdv.model.Venda;

public class MainView extends JFrame {
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

	public MainView() {

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(280, 71, 506, 582);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 84, 486, 300);
		panel.add(panel_3);
		panel_3.setLayout(null);

		this.textListaVenda = new JTextArea();
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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 786, 71);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnPainelAdm = new JButton("Painel Adm");
		btnPainelAdm.setBounds(654, 22, 122, 21);
		panel_1.add(btnPainelAdm);

		JLabel lblNewLabel_4 = new JLabel("SysPDV");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(12, 12, 114, 37);
		panel_1.add(lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(0, 71, 282, 582);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		ImageIcon imagemIcon = new ImageIcon(MainView.class.getResource("/pdv/view/imagens/listaVazia.png"));
		Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(258, 266, Image.SCALE_SMOOTH);
		ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
		imagemProduto = new JLabel(imagemFundo);
		imagemProduto.setBounds(12, 25, 258, 266);
		panel_2.add(imagemProduto);

		JLabel label1 = new JLabel("Sys-PDV");
		this.rootPane.add(label1);

		getContentPane().setBackground(new Color(0, 0, 0));
		setBounds(250, 250, 800, 600);
		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);

	}

	public void hideMainView() {
		setVisible(false);
	}

	public void showMainView() {
		setVisible(true);
	}

	public void atualizarVenda(Venda venda) {
		textCod.setText("");
		textQtd.setText("1");
		textListaVenda.setText(venda.toString());
		textValorTotal.setText(String.format("R$ %.2f", venda.getTotal()));

		setUrlDaImagem(venda.getUltimoProduto().getImagem());
		try {
			ImageIcon imagemIcon = new ImageIcon(new URL(urlDaImagem));
			Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(258, 266, Image.SCALE_SMOOTH);
			ImageIcon imagemFundo = new ImageIcon(imagemRedimensionada);
			imagemProduto.setIcon(imagemFundo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MsgException("Erro ao carregar imagem do produto!");
		}
	}

	public Produto getProduto(Integer cod, Estoque estoque) {
		return estoque.getProduto(cod);
	}

	public void add() {
		int qtd = Integer.parseInt(textQtd.getText());
		textQtd.setText(String.format("%d", qtd + 1));
	}

	public void rem() {
		int qtd = Integer.parseInt(textQtd.getText());

		if (qtd <= 1) {
			textQtd.setText(String.format("%d", 1));
			return;
		}
		textQtd.setText(String.format("%d", qtd - 1));
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

	public void setUrlDaImagem(String urlDaImagem) {
		this.urlDaImagem = urlDaImagem;
	}
}
