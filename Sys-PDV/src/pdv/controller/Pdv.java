package pdv.controller;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import pdv.dao.EstatisticasDao;
import pdv.dao.EstoqueDao;
import pdv.dao.PessoaDao;
import pdv.dao.ProdutoDao;
import pdv.dao.VendaDao;
import pdv.model.entidades.Cliente;
import pdv.model.entidades.Estoque;
import pdv.model.entidades.Funcionario;
import pdv.model.entidades.Venda;
import pdv.view.AdmCliente;
import pdv.view.AdmEstatisticas;
import pdv.view.AdmEstoque;
import pdv.view.AdmFuncionario;
import pdv.view.AdmView;
import pdv.view.PrincipalView;
import pdv.view.TelaLoad;
import pdv.view.TelaVendas;

public class Pdv {
	//entidade estoque
	private Estoque estoque;
	
	//listas
	private ArrayList<Funcionario> 	funcionarios;
	private ArrayList<Cliente> 		clientes;
	
	//telas
	private TelaLoad 			telaLoad;
	private TelaVendas 			telaVendas;
	private AdmView 			admView;
	private AdmEstoque 			admEstoque;
	private PrincipalView 		principalView;
	private AdmFuncionario 		AdmFuncionario;
	private AdmEstatisticas 	admEstatisticas;
	private AdmCliente 			admCliente;
	
	//objetos de acesso ao banco de dados
	public static Venda venda;
	public static ProdutoDao produtoDao;
	public static EstoqueDao estoqueDao;
	public static PessoaDao pessoaDao;
	public static VendaDao vendaDao;
	public static EstatisticasDao estDao;	
	
	private static Funcionario admAtual = null;
	
	public Pdv() {
			produtoDao 	= new ProdutoDao();
			estoqueDao 	= new EstoqueDao();
			pessoaDao 	= new PessoaDao();
			vendaDao 	= new VendaDao();
			venda 		= new Venda();
			estDao 		= new EstatisticasDao();
			
			this.telaLoad 			= new TelaLoad();
			this.principalView 		= new PrincipalView();
			this.telaVendas 		= new TelaVendas();
			this.admEstoque 		= new AdmEstoque();
			this.admView 			= new AdmView();
			this.AdmFuncionario 	= new AdmFuncionario();
			this.admEstatisticas 	= new AdmEstatisticas();
			this.admCliente 		= new AdmCliente();
			
			this.estoque 		= estoqueDao.getEstoqueDB();
			this.funcionarios 	= pessoaDao.getFuncionarios();
			this.clientes 		= pessoaDao.getClientes();
			
			this.telaLoad		.setEvents(principalView);
			this.principalView	.setEvents(telaVendas, admView);
			this.telaVendas		.setEvents(principalView, venda, estoque, funcionarios, clientes, admView);
			this.admView		.setEvents(principalView, admEstoque, telaVendas, AdmFuncionario, admEstatisticas, admCliente);
			this.AdmFuncionario	.setEvents();
			this.admEstoque		.setEvents();
			this.admCliente		.setEvents();
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
        AbstractDocument document = (AbstractDocument) text.getDocument();
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                String novoTexto = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (isNumero(novoTexto)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            private boolean isNumero(String text) {
                return text.matches("\\d*\\.?\\d*");
            }
        });
    }
	 public static boolean verificarLogin(Component parent) {
	        JPanel panel = new JPanel();
	        JPasswordField passwordField = new JPasswordField(20);
	        panel.add(new JLabel("Senha:"));
	        panel.add(passwordField);

	        int result = JOptionPane.showConfirmDialog(
	                parent,
	                panel,
	                "Digite sua senha:",
	                JOptionPane.OK_CANCEL_OPTION,
	                JOptionPane.PLAIN_MESSAGE
	        );

	        if (result == JOptionPane.OK_OPTION) {
	            String senhaDigitada = new String(passwordField.getPassword());
	            return senhaDigitada.equals(Pdv.getAdmAtual().getSenha());
	        } else {
	            return false;
	        }
	    }
	 
	public static Funcionario 		getAdmAtual() 						{ return admAtual; 			}
	public static void 				setAdmAtual(Funcionario admAtual) 	{ Pdv.admAtual = admAtual; 	}

   public static void main(String[] arg) { new Pdv(); }

}
