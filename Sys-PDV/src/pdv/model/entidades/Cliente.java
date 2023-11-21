package pdv.model.entidades;

public class Cliente extends Pessoa {

    public Cliente() {
    }

    public Cliente(int id, String nome, String endereco, String email, int cpf) {
        super(id, nome, endereco, email, cpf);
    }

    @Override
    public String toString() {
        return "Cliente " + super.toString();
    }
}
