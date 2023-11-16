package pdv.model;

public class Funcionario extends Pessoa{
	
	private int id;
	private Cargo cargo;
	
	public Funcionario(int id, String nome, String endereco, String email, String cpf,String cargo) {
		super(nome, endereco, email, cpf);
		if(cargo.equalsIgnoreCase("vendedor")) {
			this.cargo = Cargo.VENDEDOR;
		}
		else if(cargo.equalsIgnoreCase("administrador")) {
			this.cargo = Cargo.ADMINISTRADOR;
		}
	}
	
	public String getCargo() {
		return cargo.getDescricao();
	}
	@Override
	public String toString() {
		return super.getNome();
	}

}
