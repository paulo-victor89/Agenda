package br.ibm.com.treinamento.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator= "seq_pro")
	@Column(name = "id_produto")
	private Long id;
	
	@Column(name= "nome_produto", length = 45, nullable = true)// verificar o pq dessas informacoes 
	private String nome;
	
	@Column(name= "preco_produto", length = 45, nullable = true)
	private String preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	

	
	

}
