package pdv.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {
	private int id;
	private static int nextId=1;
	private ArrayList<ItemVenda> itens;
	private double total;
	private LocalDate data;
	private Cliente cliente;
	
	public Venda() {
		this.id = nextId++;
		this.itens = new ArrayList<ItemVenda>();
		this.total = 0.0;
		this.data = null;
		this.cliente = null;
	}
	
	@Override
	public String toString() {
		String i = "";
		for(ItemVenda item : this.itens){
			i += item + "\n";
		}
		return i.substring(0,i.length());
	}
	
	public int getId() 						{ return id; }
	public void setId(int id) 				{ this.id = id; }
	public ArrayList<ItemVenda> getItens() { return this.itens; }
	public void setItens(ArrayList<ItemVenda> itens) { this.itens = itens; }
	public double getTotal() 				{
		double t = 0.0;
		for(ItemVenda i : this.itens){
			t += i.getTotal();
		}
		return t;
	 }
	public void setTotal(double total) 		{ this.total = total; 	  }
	public LocalDate getData() 					{ return this.data; 			  }
	public void setData(LocalDate localDate) 			{ this.data = localDate;		  }
	public Cliente getCliente() 			{ return this.cliente; 		  }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
	public Produto getUltimoProduto() {
	    if (!this.itens.isEmpty()) {
	        return this.itens.get(this.itens.size() - 1).getProduto();
	    } else {
	        return null;
	    }
	}

	
	public void adicionarItem(ItemVenda item) {
		this.itens.add(item);
	}
	

}
