package pdv.model.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {
	private int id;
	private ArrayList<ProdutoVenda> itens;
	private LocalDate data;
	private Cliente cliente;
	private Funcionario funcionario;
	
	public Venda() {
		this.itens = new ArrayList<ProdutoVenda>();
		this.data = null;
		this.cliente = null;
	}
	
	public int getId() 								 { return id; }
	public void setId(int id) 						 { this.id = id; }
	public ArrayList<ProdutoVenda> getItens() 			 { return this.itens; }
	public void setItens(ArrayList<ProdutoVenda> itens) { this.itens = itens; }
	
	public LocalDate getData() 					{ return this.data; 		}
	public void setData(LocalDate localDate)	{ this.data = localDate;	}
	public Pessoa getCliente() 					{ return this.cliente; 		}
	public void setCliente(Cliente cliente) 	{ this.cliente = cliente; 	}
	public void adicionarItem(ProdutoVenda item){ this.itens.add(item); 	}
	public Funcionario getFuncionario() 		{ return this.funcionario;	}
	
	public Produto getUltimoProduto() 			{
	    if (!this.itens.isEmpty()) {
	        return this.itens.get(this.itens.size() - 1).getProduto();
	    } else {
	        return null;
	    }
	}
	public double getTotal() 				{
		double t = 0.0;
		for(ProdutoVenda i : this.itens){
			t += i.getTotal();
		}
		return t;
	 }
	
	@Override
	public String toString() {
		String i = "";
		for(ProdutoVenda item : this.itens){
			i += item + "\n";
		}
		return i.substring(0,i.length());
	}
	
	

}
