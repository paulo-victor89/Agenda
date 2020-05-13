package com.treinamento.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_INGREDIENTE")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="seq_ing")
	@SequenceGenerator(allocationSize = 1, name="seq_ing", sequenceName = "seq_ing")
	@Column(name = "ingrediente_id")
	private Long id;

	private String descricao;
	
	private Double calorias;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Receita receita;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCalorias() {
		return calorias;
	}

	public void setCalorias(Double calorias) {
		this.calorias = calorias;
	}

	
	

}
