package pdv.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import pdv.model.Caixa;
import pdv.model.Cliente;
import pdv.model.Estoque;
import pdv.model.Funcionario;
import pdv.model.ItemVenda;
import pdv.model.PostgreSQLJDBC;
import pdv.model.Produto;
import pdv.model.Venda;
import pdv.view.AdminView;
import pdv.view.ProductRegistrationView;
import pdv.view.VendasView;

public class Pdv {
	
	private Estoque estoque;
	private Map<Integer, Cliente> 	  clientes;
	private Map<Integer, Venda> 	  vendas;
	private Map<Integer, Caixa> 	  caixas;
	private Map<Integer, Funcionario> funcionarios;
	private Venda venda;
	private VendasView vendasView;
	private AdminView adminView;
	private ProductRegistrationView registrationView;
	
	public Pdv() {
		clientes 	 = new HashMap<Integer, Cliente>();
		vendas 	 	 = new HashMap<Integer, Venda>();
		caixas 	 	 = new HashMap<Integer, Caixa>();
		funcionarios = new HashMap<Integer, Funcionario>();
		estoque		 = this.getEstoqueByDB();
		venda		 = new Venda();
		vendasView	 = new VendasView();
		registrationView = new ProductRegistrationView(this.estoque);
		adminView = new AdminView(estoque);

		this.setAcoesBtns();
	}
	
	//adiciona produto ao estoque
	public void adiocionarProduto(Produto produto) {
		
	}
	//lista todos os produtos do estoque na tela
	public void mostrarEstoque() {

	}
	//remove produto do estoque
	public void removerProduto(int id) {
		
	}
	//inicia caixa com saldo indicado
	public void abrirCaixa(double saldoInicial) {
		
	}
	public void fecharCaixa() {
		
	}
	public void realizarVenda() {
		
	}
	public void adicionarFuncionario() {
		
	}
	public void removerFuncionario() {
		
	}
	
	//busca todos os produtos do bd e adiciona a estoque
	private Estoque getEstoqueByDB() {
		 Connection connection = PostgreSQLJDBC.getConnection();
		 Estoque estoque = new Estoque();
	        if (connection != null) {
	            try {
	                String query = "SELECT * FROM produto";
	                PreparedStatement preparedStatement = connection.prepareStatement(query);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                	                
	                while (resultSet.next()) {
	                    int 	id 			= resultSet		.getInt("id");
	                    String 	nome 		= resultSet	.getString("nome");
	                    double 	preco 		= resultSet.getDouble("preco");
	                    int qtdEstoque		= resultSet.getInt("qtdEstoque");
	                    String categoria 	= resultSet.getString("categoria");
	                    String imagem 		= resultSet.getString("imagem");
	                    
	                    Produto produto = new Produto(id, nome, preco, qtdEstoque, categoria, imagem);

	                    estoque.addProduto(produto);
	                }

	                resultSet.close();
	                preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } finally {
	                PostgreSQLJDBC.closeConnection(connection);
	            }
	        }
	        return estoque;
	}
	//metodos da mainView-------------------------------------------------------------------------------------------
	public void setAcoesBtns() {
		this.vendasView.getTextCod().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              Produto produto = vendasView.getProduto(Integer.parseInt(vendasView.getTextCod().getText()), estoque);
               if(produto == null){
            	   //throw new MsgException("Produto não encontrado!");
            	   JOptionPane.showMessageDialog(vendasView, "Produto não encontrado!");
            	   return;
               }

               int      quantidade  = Integer.parseInt(vendasView.getTextQtd().getText());
               double   total       = (double) (produto.getPreco() * quantidade); 
                
                ItemVenda itemVenda = new ItemVenda(produto, quantidade, total);

                if(venda == null){ venda = new Venda(); }

                venda.adicionarItem(itemVenda);
                venda.setData(LocalDate.now());
              
                vendasView.atualizarVenda(venda);
            }
        });
        vendasView.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendasView.add();     
            }
        });
        vendasView.getBtnRem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendasView.rem();     
            }
        });
        
        vendasView.getBtnCancelar().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		vendasView.cancelar(venda);
        	}
        });

        vendasView.getBtnPainelAdm().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if(vendasView.exibirTelaLogin()) {
            		vendasView.hideMainView();
        			adminView.showPainelAdm();
        		}
        	}
        });
        
        vendasView.getBtnFinalizar().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {        		
        		vendasView.showJanelaFinalizacao(venda);
        		venda = new Venda();
        	}
        });
		
        filtrarNumeros(vendasView.getTextCod());
	}
	public static void filtrarNumeros(JTextField text) {
        ((AbstractDocument) text.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
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
    public void iniciarVenda(){
        venda = null;
    }

	public void showMainView() {
		this.vendasView.showMainView();
	}
	
	//----------------------------------------------------------------------------
	public Map<Integer, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Map<Integer, Cliente> clientes) {
		this.clientes = clientes;
	}

	public Map<Integer, Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Map<Integer, Venda> vendas) {
		this.vendas = vendas;
	}

	public Map<Integer, Caixa> getCaixas() {
		return caixas;
	}

	public void setCaixas(Map<Integer, Caixa> caixas) {
		this.caixas = caixas;
	}

	public Map<Integer, Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Map<Integer, Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	
}
