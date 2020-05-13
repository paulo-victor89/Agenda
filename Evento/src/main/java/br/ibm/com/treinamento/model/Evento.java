package br.ibm.com.treinamento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@SuppressWarnings("deprecation")
@Entity
@Table(name = "evento")
public class Evento implements Serializable {
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_evento")
	@SequenceGenerator(allocationSize = 1, name="seq_evento", sequenceName="seq_evento")
	@Column(name="codigo")
	private long codigo;
	
	@NotBlank
	@Column(name="nome")
	private String nome;
	
	@NotBlank
	@Column(name="local")
	private String local;
	
	@NotBlank
	@Column(name="data")
	private String data;
	
	@NotBlank
	@Column(name="horario")
	private String horario;
	
	@OneToMany
	@JoinColumn(name = "idevento")
	private List<Convidado> convidado;
	
	public List<Convidado> getConvidado() {
		return convidado;
	}
	public void setConvidado(List<Convidado> convidado) {
		this.convidado = convidado;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public long getCodigo() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
