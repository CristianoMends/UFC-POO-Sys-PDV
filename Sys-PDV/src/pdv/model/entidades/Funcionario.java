package pdv.model.entidades;

import pdv.model.enums.Cargo;

public class Funcionario extends Pessoa{	
	private int id;
	private Cargo cargo;
	private String usuario;
	private String senha;
	
	public Funcionario(int id, String nome, String endereco, String email, int cpf,String cargo, String usuario, String senha) {
		super(id,nome, endereco, email, cpf);
		this.setId(id);
		this.setUsuario(usuario);
		this.setSenha(senha);
		
			 if(cargo.equalsIgnoreCase("vendedor")) 	 { this.cargo = Cargo.VENDEDOR; 	 }
		else if(cargo.equalsIgnoreCase("administrador")) { this.cargo = Cargo.ADMINISTRADOR; }
	}
	
	public String getCargo() {
		return cargo.getDescricao();
	}
	@Override
	public String toString() {
		return super.getNome();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
