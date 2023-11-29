package pdv.model.entidades;

public class Cliente extends Pessoa {
	
	
    public Cliente(int id, String nome, String endereco, String email, String cpf) {
        super(id, nome, endereco, email, cpf);
    }
    public Cliente(String nome, String endereco, String email, String cpf) {
        super(nome, endereco, email, cpf);
    }
    @Override
    public String toString() {
        return "Cliente " + super.toString();
    }
}
