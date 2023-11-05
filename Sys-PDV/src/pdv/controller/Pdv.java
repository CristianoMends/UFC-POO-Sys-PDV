package pdv.controller;
import pdv.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import javax.swing.JOptionPane;

import pdv.view.*;

public class Pdv {
	
	private Estoque estoque;
	private Map<Integer, Cliente> 	  clientes;
	private Map<Integer, Venda> 	  vendas;
	private Map<Integer, Caixa> 	  caixas;
	private Map<Integer, Funcionario> funcionarios;
	private Venda venda;
	private MainView mainView;
	
	public Pdv() {
		clientes 	 = new HashMap<Integer, Cliente>();
		vendas 	 	 = new HashMap<Integer, Venda>();
		caixas 	 	 = new HashMap<Integer, Caixa>();
		funcionarios = new HashMap<Integer, Funcionario>();
		estoque		 = this.getEstoqueByDB();
		venda		 = new Venda();
		mainView	 = new MainView();

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
	                    int 	id 		= resultSet		.getInt("id");
	                    String 	nome 	= resultSet	.getString("nome");
	                    double 	preco 	= resultSet.getDouble("preco");
	                    int qtdEstoque	= resultSet.getInt("qtdEstoque");
	                    
	                    Produto produto = new Produto(id, nome, preco, qtdEstoque);

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
		this.mainView.getTextCod().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              Produto produto = mainView.getProduto(Integer.parseInt(mainView.getTextCod().getText()), estoque);
               if(produto == null){
            	   //throw new MsgException("Produto não encontrado!");
            	   JOptionPane.showMessageDialog(mainView, "Produto não encontrado!");
            	   return;
               }

               int      quantidade  = Integer.parseInt(mainView.getTextQtd().getText());
               double   total       = (double) (produto.getPreco() * quantidade); 
                
                ItemVenda itemVenda = new ItemVenda(produto, quantidade, total);

                if(venda == null){ venda = new Venda(); }

                venda.adicionarItem(itemVenda);
                venda.setData(LocalDate.now());
              
                mainView.atualizarVenda(venda);
            }
        });

        mainView.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.add();     
            }
        });
        mainView.getBtnRem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rem();     
            }
        });
	}
    public void iniciarVenda(){
        venda = null;
    }

	public void showMainView() {
		this.mainView.showMainView();
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
