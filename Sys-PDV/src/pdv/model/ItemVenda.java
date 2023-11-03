package pdv.model;

public class ItemVenda {
	private int id;
	private Produto produto;
	private int quantidade;
	private double total;
	
	public ItemVenda(int id, Produto produto, int quantidade, double total) {
		this.id = 1;
		this.produto = produto;
		this.quantidade = quantidade;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setNextId(int id) {
		this.id++;
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
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return String.format("%s|Cafe tres coracoes 500g    |0002|    R$10.00|    R$20.00",getId(), getProduto().getNome(), getQuantidade(), getProduto().getPreco(), getTotal());
	}

}
