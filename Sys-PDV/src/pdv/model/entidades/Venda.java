package pdv.model.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {
	private int 					id;
	private ArrayList<ProdutoVenda> itens;
	private LocalDate 				data;
	private Cliente 				cliente;
	private String 					metodo;
	private Funcionario 			funcionario;
	
	public Venda() {
		this.itens = new ArrayList<ProdutoVenda>();
		this.data = null;
		this.cliente = null;
		this.metodo = null;
		this.funcionario = null;
	}
	
	public void sortIdProdutos() {
	    int n = itens.size();	    
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            if (itens.get(j).getId() > itens.get(j + 1).getId()) {
	            	
	                int tempId = itens.get(j).getId();
	                itens.get(j).setId(itens.get(j + 1).getId());
	                itens.get(j + 1).setId(tempId);
	            }
	        }
	    }	    
	    for (int i = 0; i < n; i++) {
	        itens.get(i).setId(i + 1);
	    }
	}
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
	public int 						getId()									{ return id; 				}
	public ArrayList<ProdutoVenda> 	getItens() 								{ return this.itens; 		}
	public void 				   	setItens(ArrayList<ProdutoVenda> itens) { this.itens = itens; 		}
	public void 				   	setId(int id) 							{ this.id = id; 			}
	public LocalDate 				getData() 								{ return this.data; 		}
	public void 					setData(LocalDate localDate)			{ this.data = localDate;	}
	public Pessoa 					getCliente() 							{ return this.cliente; 		}
	public void 					setCliente(Cliente cliente) 			{ this.cliente = cliente; 	}
	public void 					adicionarItem(ProdutoVenda item)		{ this.itens.add(item); 	}
	public void						setFuncionario(Funcionario f)			{ this.funcionario = f;		}
	public Funcionario 				getFuncionario() 						{ return this.funcionario;	}
	public String					getMetodo()								{ return this.metodo;		}
	public void						setMetodo(String m)						{ this.metodo = m;			} 
	
	@Override
	public String toString() {
		return "";
	}
	
	

}
