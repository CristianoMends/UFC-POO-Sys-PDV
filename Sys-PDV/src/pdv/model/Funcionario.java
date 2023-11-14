package pdv.model;

public class Funcionario extends Pessoa{
	
	private int id;
	private static int nextId=0;
	private Cargo cargo;
	
	public Funcionario(String nome, String endereco, String email, String cpf,Cargo cargo) {
		super(nome, endereco, email, cpf);
		this.id = nextId++;
		this.cargo = cargo;
	}

}
