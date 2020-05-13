package br.ibm.com.treinamento.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "PRODUTOVENDA")
public class ProdutoVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_prov" )
	@Column(name ="id_produtovenda")
	private Long id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Vendas vendas;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Produtos produtos;
	
	@Column(name = "quantidade_produtovenda", nullable = false)
	private Integer quantidade;
	
	@Column(name = "valor_produtovenda", nullable = true)
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vendas getVendas() {
		return vendas;
	}

	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	


}
