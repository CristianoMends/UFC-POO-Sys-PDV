package pdv.model;

public enum Cargo {	
	
	VENDEDOR("Vendedor"),
	ADMINISTRADOR("Administrador");
	
	private String descricao;
	
	Cargo(String desc){
		this.descricao = desc;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	
}
