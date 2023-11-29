package pdv.model.enums;

public enum FormaPg {
	        DINHEIRO("Dinheiro"),
	        CARTAO_CREDITO("Crédito"),
	        CARTAO_DEBITO("Débito");

	        private final String descricao;

	        FormaPg(String descricao) {
	            this.descricao = descricao;
	        }

	        public String getDescricao() {
	            return descricao;
	        }

}
