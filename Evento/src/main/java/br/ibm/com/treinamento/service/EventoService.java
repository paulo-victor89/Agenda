package br.ibm.com.treinamento.service;

import java.util.List;

import javax.validation.Valid;

import br.ibm.com.treinamento.model.Evento;

public interface EventoService {
	
	public Evento save(Evento evento);
	
	public void delete(Evento evento);
	
	public List<Evento> findAll();
	
	public Evento findByCodigo(long codigo);
	
	public void alterar(Evento evento, long codigo);
	

}
