package pdv.model;

import javax.swing.ImageIcon;

public class Produto {
	private int id;
	private String nome;
	private double preco;
	private int quantidadeEstoque;
	private ImageIcon image;
	
	public Produto(int id,String nome, double preco, int quantidadeEstoque, ImageIcon image) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidadeEstoque=" + quantidadeEstoque
				+ "]";
	}
}
