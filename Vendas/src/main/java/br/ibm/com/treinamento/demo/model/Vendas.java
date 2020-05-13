package br.ibm.com.treinamento.demo.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vendas")
public class Vendas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_vendas")
	private Long id;
	
	@OneToOne(cascade  = CascadeType.ALL)
	private Clientes clientes;
	
	@Column(name = "data_venda", length = 45, nullable = true)
	private String data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
}

	

	
	