package pdv.controller;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import pdv.dao.EstoqueDao;
import pdv.dao.PessoaDao;
import pdv.dao.ProdutoDao;
import pdv.dao.VendaDao;
import pdv.model.entidades.Cliente;
import pdv.model.entidades.Estoque;
import pdv.model.entidades.Funcionario;
import pdv.model.entidades.Venda;
import pdv.view.AdminView;
import pdv.view.EstoqueView;
import pdv.view.FuncionariosView;
import pdv.view.LoadView;
import pdv.view.PrincipalView;
import pdv.view.VendasView;

public class Pdv {
	public static final String USUARIO = "admin";
	public static final String SENHA = "qwe123";

	private Estoque estoque;
	public static Venda venda;

	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Venda> vendas;
	private ArrayList<Cliente> clientes;
	
	private LoadView loadView;
	private VendasView vendasView;
	private AdminView adminView;
	private EstoqueView estoqueView;
	private PrincipalView principalView;
	private FuncionariosView funcionariosView;
	
	public static ProdutoDao produtoDao;
	public static EstoqueDao estoqueDao;
	public static PessoaDao pessoaDao;
	public static VendaDao vendaDao;
	
	

	public Pdv() {
		produtoDao = new ProdutoDao();
		estoqueDao = new EstoqueDao();
		pessoaDao = new PessoaDao();
		vendaDao = new VendaDao();
		venda = new Venda();
		
		this.loadView = new LoadView();
		this.principalView = new PrincipalView();
		this.vendasView = new VendasView();
		this.estoqueView = new EstoqueView();
		this.adminView = new AdminView();
		this.funcionariosView = new FuncionariosView();
		
		atualizarEstado();
		setAcoes();
	}

	public void setAcoes() {
		this.loadView.setAcoes(principalView);
		this.principalView.setAcoesBtns(vendasView, adminView);
		this.funcionariosView.setAcoesBtns();
		this.vendasView.setAcoesBtns(principalView,venda, estoque, funcionarios, clientes, adminView);
		this.adminView.setAcoesBtns(principalView, estoqueView, vendasView, funcionariosView);
		this.estoqueView.setAcoesBtns();
	}
	public void atualizarEstado() {
		this.estoque = this.estoqueDao.getEstoqueDB();
		this.funcionarios = this.pessoaDao.getFuncionarios();
		this.vendas = this.vendaDao.getVendas();
		this.clientes = this.pessoaDao.getClientes();
	}
	public static void at() {
	}

	public static void showMensagem(Component componet, String mensagem, String titulo, int tipoMensagem) {
		JOptionPane.showMessageDialog(componet, mensagem, titulo, tipoMensagem);
	}
	public static int showMessageOpcao(Component componente, String mensagem, String titulo, int tipoMensagem) {
		return JOptionPane.showConfirmDialog(componente, mensagem, titulo, tipoMensagem);
	}
	public static String showInput(Component componente, String mensagem, String titulo, int tipoMensagem) {
		return JOptionPane.showInputDialog(componente, mensagem, titulo, tipoMensagem);
	}

	public static void filtrarNumeros(JTextField text) {
		((AbstractDocument) text.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				String novoTexto = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

				if (isNumero(novoTexto)) {
					super.replace(fb, offset, length, text, attrs);
				}
			}
			private boolean isNumero(String text) {
				for (char c : text.toCharArray()) {
					if (!Character.isDigit(c) && c != '.') {
						return false;
					}
				}

				if (text.indexOf('.') != text.lastIndexOf('.')) {
					return false;
				}

				return true;
			}
		});
	}

}
