package br.ibm.com.teste.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;


public class ContaTest2 {
	@Test
	public void testTemSaldo() {
		Conta c = new Conta(10.0);
		assertTrue(c.temSaldo());
	}
	
	@Test
	public void testaContaSemSaldo() {
		Conta c = new Conta(0.0);
		assertFalse(c.temSaldo());
	}
	
	@Test
	public void testaContaComSaldoNulo() {
		Conta c = new Conta(null);
		assertFalse(c.temSaldo());
	}

}
