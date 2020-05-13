package br.ibm.com.treinamento.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

//import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * @Getter
 * 
 * @Setter
 */
@Entity
public class Contrato {

	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer numContrato;
	
	@JsonProperty("cpf")
	private String cpfCliente;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate datInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate datFim;
	private String status;
	
	@JsonProperty("valor_contrato")
	private Integer valor;
	
	public Contrato() {
		super();
	}
	
	public Contrato(Integer numContrato, String cpfCliente, LocalDate datInicio, LocalDate datFim, String status,
			Integer valor) {
		super();
		this.numContrato = numContrato;
	
		this.cpfCliente = cpfCliente;
		this.datInicio = datInicio;
		this.datFim = datFim;
		this.status = status;
		this.valor = valor;
	}

	public Integer getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(Integer numContrato) {
		this.numContrato = numContrato;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public LocalDate getDatInicio() {
		return datInicio;
	}

	public void setDatInicio(LocalDate datInicio) {
		this.datInicio = datInicio;
	}

	public LocalDate getDatFim() {
		return datFim;
	}

	public void setDatFim(LocalDate datFim) {
		this.datFim = datFim;
	}

}
