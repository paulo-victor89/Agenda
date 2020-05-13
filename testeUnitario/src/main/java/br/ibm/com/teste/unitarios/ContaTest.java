package br.ibm.com.teste.unitarios;

public class ContaTest {
	
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
			System.out.println("Ok");
		else
			System.out.println("Erro");
	}
	
	public static void main(String[] args) {
		new ContaTest().testaContaComSaldo();
		new ContaTest().testaContaSemSaldo();
	}

}
