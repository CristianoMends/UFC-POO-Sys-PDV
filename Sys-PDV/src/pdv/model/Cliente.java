package pdv.model;

public class Cliente extends Pessoa{
	private int id;
	private static int nextId=0;
	
	public Cliente(String nome, String endereco,String email,String cpf) {
		super(nome,endereco,email,cpf);
		this.id = nextId++;
	}
	public int getId() {
		return this.id;
	}

}
