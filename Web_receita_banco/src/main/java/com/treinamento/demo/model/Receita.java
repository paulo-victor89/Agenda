package com.treinamento.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_RECEITA")
public class Receita {

	@Id
	@JsonProperty("id_receita")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_receita")
	@SequenceGenerator(allocationSize = 1, name = "seq_receita", sequenceName = "seq_receita")
	private Long id;

	@NotNull
	private String descricao;

	@OneToOne(cascade = CascadeType.ALL)
	private Categoria categoria;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<Ingrediente> ingredientes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

}
