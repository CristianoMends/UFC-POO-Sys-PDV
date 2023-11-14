package pdv.model;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
	
	private Map<Integer, Produto> produtos;

	public Estoque(){
			this.produtos = new HashMap<Integer,Produto>();
	}
	public Produto getProduto(int cod){
		if(!this.produtos.containsKey(cod)){
			return null;
		}
		return this.produtos.get(cod);
	}
	public void addProduto(Produto produto){
		this.produtos.put(produto.getId(), produto);
	}
	public String getEstoqueTotal(){
		String pro = "";
		for(Produto produto : this.produtos.values()){
			pro += produto + "\n";
		}
		return pro.substring(0,pro.length());
	}
	@Override
	public String toString(){
		String pro = "";
		for(Produto produto : this.produtos.values()){
			pro += produto + "\n";
		}
		return pro.substring(0,pro.length());
	}

}
