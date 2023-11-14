package pdv.model;

public class Caixa {
	private int caixaId;
	private static int nextCaixaId = 1;
	double saldoInicial;
	double saldoAtual;
	
	public Caixa(int caixaId ,double saldoInicial) {
		this.setCaixaId();
		this.saldoInicial = saldoInicial;
	}
	
	public int getCaixaId() {
		return this.caixaId;
	}
	public void setCaixaId() {
		this.caixaId = Caixa.nextCaixaId++;
	}
	public void inserirValor(double valor) {
		if(valor < 1) {
			throw new MsgException("erro: precisa inserir valor maior que 0");
		}
		this.setSaldoAtual(getSaldoAtual() + valor);
	}
	public double retirarValor(double valor) {
		if(valor < 1) {
			throw new MsgException("erro: precisa ser acima de 0");
		}
		if(valor > this.getSaldoAtual()) {
			throw new MsgException("erro: o caixa nao tem o saldo desejado");
		}
		
		return valor;
	}
	public double getTroco(double valorEntregue, double valorPagamento) {
		if(valorEntregue < valorPagamento) {
			throw new MsgException("erro: o saldo é menor que o pagamento");
		}
		return valorEntregue - valorPagamento;
	}
	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	public double getSaldoAtual() {
		return this.saldoAtual;
	}

}
