package pdv.model;

public abstract class Pessoa {
	private String nome;
	private String endereco;
	private String email;
	private String cpf;
	
	public Pessoa(String nome, String endereco, String email, String cpf) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.cpf = cpf;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", endereco=" + endereco + ", email=" + email + ", cpf=" + cpf + "]";
	}


}
