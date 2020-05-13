package br.ibm.com.teste.unitarios;

public class Conta1Test {
	
	public void testaContaComSaldo() {
		Conta c = new Conta (10.0);
		if(c.temSaldo())
			System.out.println("Ok");
		else
			System.out.println("Erro");
	}
	public void testaContaSemSaldo() {
		Conta c = new Conta (0.0);
		if(c.temSaldo())
			System.out.println("Erro");
		else
			System.out.println("OK");
	}
	public void testaContaComSaldoNulo() {
		Conta c = new Conta (null);
		if(c.temSaldo())
			System.out.println("Erro");
		else
			System.out.println("OK");
	}
	public static void main(String[] args) {
		new Conta1Test().testaContaComSaldo();
		new Conta1Test().testaContaSemSaldo();
		new Conta1Test().testaContaComSaldoNulo();
	}
}