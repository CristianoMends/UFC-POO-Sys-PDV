package pdv.model.entidades;

public class ProdutoVenda {
	private int id;
	private Produto produto;
	private int quantidade;
	
	public ProdutoVenda(int id, Produto produto, int quantidade, double total) {
		setId(id);
		setProduto(produto);
		setQuantidade(quantidade);
	}
	public int 		getId() 						{ return id; 										}
	public void 	setId(int id) 					{ this.id = id; 									}
	public Produto 	getProduto() 					{ return produto; 									}
	public void 	setProduto(Produto produto) 	{ this.produto = produto; 							}
	public int 		getQuantidade() 				{ return quantidade; 								}
	public void 	setQuantidade(int quantidade) 	{ this.quantidade = quantidade; 					}
	public double 	getTotal() 						{ return this.quantidade * this.produto.getPreco(); }

	@Override
	public String toString() {
		return "";
	}

}
