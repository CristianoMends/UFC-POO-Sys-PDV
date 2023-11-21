package pdv.model.entidades;

public abstract class Pessoa {
	private int id;
	private String nome;
	private String endereco;
	private String email;
	private int cpf;
	
	public Pessoa() {
		
	}
	
	public Pessoa(int id,String nome, String endereco, String email, int cpf) {
		setId(id);
		setNome(nome);
		setEndereco(endereco);
		setEmail(email);
		setCpf(cpf);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", endereco=" + endereco + ", email=" + email + ", cpf=" + cpf + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
