package pdv.model.entidades;

import java.util.ArrayList;

public class Estoque {
	
	private ArrayList<Produto> produtos;

	public Estoque(){
			this.produtos = new ArrayList<Produto>();
	}
	public ArrayList<Produto> getListProdutos() {
		return this.produtos;
	}
	public Produto getProduto(int cod){
		for(Produto p : produtos) {
			if(p.getId() == cod) {
				return p;
			}
		}
		return null;
	}
	public void addProduto(Produto produto){
		this.produtos.add(produto);
	}
	
	@Override
	public String toString(){
		String pro = "";
		for(Produto produto : this.produtos){
			pro += produto + "\n";
		}
		return pro.substring(0,pro.length());
	}

}
