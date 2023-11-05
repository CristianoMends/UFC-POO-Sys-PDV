package pdv.controller;
import pdv.model.*;
import java.util.*;
import pdv.view.*;

public class Pdv {
	
	private Map<Integer,Produto> 	  produtos;
	private Map<Integer, Cliente> 	  clientes;
	private Map<Integer, Venda> 	  vendas;
	private Map<Integer, Caixa> 	  caixas;
	private Map<Integer, Funcionario> funcionarios;
	
	private Estoque estoque;
	private MainViewController mvc;
	
	public Pdv() {
		produtos 	 = new HashMap<Integer,Produto>();
		clientes 	 = new HashMap<Integer, Cliente>();
		vendas 	 	 = new HashMap<Integer, Venda>();
		caixas 	 	 = new HashMap<Integer, Caixa>();
		funcionarios = new HashMap<Integer, Funcionario>();
		estoque 	 = new Estoque();
		mvc 	 = new MainViewController(this.estoque);
		
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
	public void showMainView() {
		this.mvc.show();
	}
	public void iniciarVenda(){
		
	}

	public Map<Integer, Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Map<Integer, Produto> produtos) {
		this.produtos = produtos;
	}

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
