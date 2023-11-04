package pdv.view;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;
import pdv.model.*;

public class MainView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textValorTotal;
	private JTextField textCod;
	private JTextField textQtd;
	private JButton btnPainelAdm;
	private JPanel ImagemProduto;
	private JButton btnFinalizar;
	private JButton btnRem;
	private JButton btnCancelar;
	private JTextArea textListaVenda;
	private JButton btnAdd;
	private JButton btnVerTodosProdutos;
		
	public MainView() {
		getContentPane().setBackground(new Color(0, 0, 0));
		setSize(800, 700);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(280, 71, 506, 582);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 84, 486, 300);
		panel.add(panel_3);
		panel_3.setLayout(null);
				
		textListaVenda = new JTextArea();
		textListaVenda.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textListaVenda); // Adiciona o JTextArea a um JScrollPane
		scrollPane.setBounds(0, 0, 486, 350); // Define o tamanho do JScrollPane
		panel_3.add(scrollPane);
				
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 255));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 57, 486, 28);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produto                                            Qtd         P.Unitario      P.Total");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 10, 448, 15);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Total");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 393, 120, 25);
		panel.add(lblNewLabel_1);
		
		this.textValorTotal = new JTextField();
		this.textValorTotal.setToolTipText("valor total");
		this.textValorTotal.setEditable(false);
		this.textValorTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		this.textValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.textValorTotal.setColumns(10);
		this.textValorTotal.setBounds(10, 415, 200, 50);
		panel.add(textValorTotal);
		
		this.textCod = new JTextField();
		this.textCod.setToolTipText("Codigo do produto");
		this.textCod.setBounds(10, 22, 150, 25);
		panel.add(textCod);
		this.textCod.setColumns(10);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(89, 489, 150, 25);
		panel.add(btnCancelar);
		
		this.btnFinalizar = new JButton("Receber e Finalizar");
		this.btnFinalizar.setBounds(275, 489, 150, 25);
		panel.add(btnFinalizar);
		
		JLabel lblNewLabel_2 = new JLabel("Cod.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 10, 45, 13);
		panel.add(lblNewLabel_2);
		
		this.textQtd = new JTextField();
		this.textQtd.setEditable(false);
		this.textQtd.setBounds(325, 22, 81, 25);
		panel.add(textQtd);
		this.textQtd.setColumns(10);
		
		this.btnRem = new JButton("-");
		this.btnRem.setMnemonic('-');
		this.btnRem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.btnRem.setBounds(406, 22, 45, 25);
		panel.add(btnRem);
		
		this.btnAdd = new JButton("+");
		this.btnAdd.setMnemonic('-');
		this.btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.btnAdd.setBounds(451, 22, 45, 25);
		panel.add(btnAdd);
		
		JLabel lblNewLabel_3 = new JLabel("Qtd.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(325, 10, 45, 13);
		panel.add(lblNewLabel_3);
		
		this.btnVerTodosProdutos = new JButton("...");
		this.btnVerTodosProdutos.setToolTipText("listar todos os produtos");
		this.btnVerTodosProdutos.setBounds(162, 22, 25, 25);
		panel.add(btnVerTodosProdutos);
		
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
		lblNewLabel_4.setBounds(10, 10, 73, 37);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(0, 71, 282, 582);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		this.ImagemProduto = new JPanel();
		this.ImagemProduto.setBounds(10, 57, 262, 194);
		panel_2.add(ImagemProduto);	

		JLabel label1 = new JLabel("Sys-PDV");
		this.rootPane.add(label1);
		setVisible(true);
	}
	public void hideMainView(){
		setVisible(false);
	}
	public void showMainView() {
		setVisible(true);
	}
	public void addProdutoLista(Produto produto) {
		textListaVenda.setText(produto.toString());
	}
	public void setValorTotal(Venda venda) {
		textValorTotal.setText(String.format("R$ %.2f", venda.getTotal()));
	}
	public Produto getProduto(Integer cod, Estoque estoque){
		return estoque.getProduto(cod);
	}
	//metodos get
	public JTextField getTextValorTotal() {
		return textValorTotal;
	}
	public Integer getTextCod() {
		return textCod;
	}
	public JTextField getTextQtd() {
		return textQtd;
	}
	public JButton getBtnPainelAdm() {
		return btnPainelAdm;
	}
	public JPanel getImagemProduto() {
		return ImagemProduto;
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
	public JButton getBtnVerTodosProdutos() {
		return btnVerTodosProdutos;
	}

	
}
