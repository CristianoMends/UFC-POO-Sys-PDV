package pdv.model.entidades;

public class Produto {
	private int id;
	private String nome;
	private double preco;
	private int qtdEstoque;
	private String categoria;
	private String imagem;
	
	public Produto(int id,String nome, double preco, int qtdEstoque, String categoria, String imagem) {
		this.setId(id);
		this.setNome(nome);
		this.setPreco(preco);
		this.setQtdEstoque(qtdEstoque);
		this.setCategoria(categoria);
		this.setImagem(imagem);
	}
	//construtor sem id para inserir ao banco
	public Produto(String nome, double preco, int qtdEstoque, String categoria, String imagem) {
		this.setNome(nome);
		this.setPreco(preco);
		this.setQtdEstoque(qtdEstoque);
		this.setCategoria(categoria);
		this.setImagem(imagem);
	}
	public int 		getId() 						{ return id; 					}
	public void 	setId(int id) 					{ this.id = id; 				}
	public String 	getNome() 						{ return nome;					}
	public void 	setNome(String nome) 			{ this.nome = nome; 			}
	public double 	getPreco() 						{ return preco;					}
	public void 	setPreco(double preco) 			{ this.preco = preco;			}
	public int 		getQtdEstoque() 				{ return qtdEstoque;			}
	public void 	setQtdEstoque(int qtdEstoque) 	{ this.qtdEstoque = qtdEstoque; }
	public String 	getCategoria() 					{ return categoria; 			}
	public void 	setCategoria(String categoria) 	{ this.categoria = categoria;	}
	public String 	getImagem() 					{ return imagem;				}
	public void 	setImagem(String imagem) 		{ this.imagem = imagem;			}
	
	@Override
	public String toString() {						     
	    return String.format("%04d | %22s | %18.2f | %05d | %-10s", getId(), getNome(), getPreco(), getQtdEstoque(), getCategoria());
	}

	
}