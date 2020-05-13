package br.ibm.com.treinamento.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ibm.com.treinamento.model.Evento;
import br.ibm.com.treinamento.repository.EventoRepository;
import br.ibm.com.treinamento.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {
	@Autowired
	private EventoRepository er;

	@Override
	public Evento save(Evento evento) {
		return er.save(evento);
	}

	@Override
	public void delete(Evento evento) {
		er.delete(evento);		
	}

	@Override
	public List<Evento> findAll() {
		return er.findAll();
	}

	@Override
	public void alterar(Evento evento, long codigo) {		
		 er.alterarEvento(evento.getNome(), evento.getLocal(), evento.getData(), evento.getHorario(), codigo);
	}

	@Override
	public Evento findByCodigo(long codigo) {
		Optional<Evento> e = er.findById(codigo);
		return e.get();
	} 
	
	
	
	
	

}
