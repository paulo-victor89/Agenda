package br.ibm.com.treinamento.agenda.model;

import javax.validation.Valid;

public class Telefone{
	
	public String ddd;
	public String telefone;
	
	public Telefone() {
		super();
	}
	public Telefone(String ddd, String telefone) {
		super();
		this.ddd = ddd;
		this.telefone = telefone;
	}
	
	
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public static void add(@Valid Telefone telefone2) {
		// TODO Auto-generated method stub
		
	}
	public static void clear() {
		// TODO Auto-generated method stub
		
	}
}