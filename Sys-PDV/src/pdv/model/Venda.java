package pdv.model;

import java.util.Date;
import java.util.Map;

public class Venda {
	private int id;
	private Map<Integer,ItemVenda> itens;
	private double total;
	private Date data;
	private Cliente cliente;
	
	public Venda(int id, Map<Integer, ItemVenda> itens, double total, Date data, Cliente cliente) {
		this.id = id;
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
	public Map<Integer, ItemVenda> getItens() { return itens; }
	public void setItens(Map<Integer, ItemVenda> itens) { this.itens = itens; }
	public double getTotal() 				{ return total; 		 }
	public void setTotal(double total) 		{ this.total = total; 	  }
	public Date getData() 					{ return data; 			  }
	public void setData(Date data) 			{ this.data = data;		  }
	public Cliente getCliente() 			{ return cliente; 		  }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
	
	public void adicionarItem(ItemVenda item) {
		
	}
	

}
