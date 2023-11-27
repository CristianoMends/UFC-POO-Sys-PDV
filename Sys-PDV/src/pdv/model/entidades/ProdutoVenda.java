package pdv.model.entidades;

public class ProdutoVenda {
	private int id;
	private Produto produto;
	private int quantidade;
	private double total;
	
	public ProdutoVenda(int id, Produto produto, int quantidade, double total) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getTotal() {
		return this.quantidade * this.produto.getPreco();
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return String.format("%04d|%-35s|%05d|R$ %10.2f|R$ %10.2f",getId(), getProduto().getNome(), getQuantidade(), getProduto().getPreco(), getTotal());
	}

}
