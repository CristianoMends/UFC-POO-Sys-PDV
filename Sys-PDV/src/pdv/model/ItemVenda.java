package pdv.model;

public class ItemVenda {
	private int id;
	private static int nextId=1;
	private Produto produto;
	private int quantidade;
	private double total;
	
	public ItemVenda(Produto produto, int quantidade, double total) {
		this.id = nextId++;
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
		return this.quantidade * this.produto.getPreco();
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return String.format("%4d|%-25s    |%-4d|    R$ %.2f|    R$ %.2f",getId(), getProduto().getNome(), getQuantidade(), getProduto().getPreco(), getTotal());
	}

}
