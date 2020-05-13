package br.ibm.com.teste.unitarios;

public class Conta {
	
	private Double saldo = 0.0d;
	
	public Conta(Double saldo) {
		this.saldo = saldo;
	}
	public boolean temSaldo() {
		return saldo != null && saldo >0;
	}
}