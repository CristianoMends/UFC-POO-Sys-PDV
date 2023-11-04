package pdv.model;

import java.util.Date;
import java.util.Map;

public class Venda {
	private int id;
	private static int nextId=0;
	private Map<Integer,ItemVenda> itens;
	private double total;
	private Date data;
	private Cliente cliente;
	
	public Venda(int id, Map<Integer, ItemVenda> itens, double total, Date data, Cliente cliente) {
		this.id = nextId++;
		this.itens = itens;
		this.total = total;
		this.data = data;
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "Venda [id=" + id + ", itens=" + itens + ", total=" + total + ", data=" + data + ", cliente=" + cliente
				+ "]";
	}
	
	public int getId() 						{ return id; }
	public void setId(int id) 				{ this.id = id; }
	public Map<Integer, ItemVenda> getItens() { return this.itens; }
	public void setItens(Map<Integer, ItemVenda> itens) { this.itens = itens; }
	public double getTotal() 				{ return this.total; 		 }
	public void setTotal(double total) 		{ this.total = total; 	  }
	public Date getData() 					{ return this.data; 			  }
	public void setData(Date data) 			{ this.data = data;		  }
	public Cliente getCliente() 			{ return this.cliente; 		  }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
	
	public void adicionarItem(ItemVenda item) {
		this.itens.put(item.getId(),item);
	}
	

}
