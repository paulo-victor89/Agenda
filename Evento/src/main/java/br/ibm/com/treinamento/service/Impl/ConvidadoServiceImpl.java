package br.ibm.com.treinamento.service.Impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ibm.com.treinamento.model.Convidado;
import br.ibm.com.treinamento.repository.ConvidadoRepository;
import br.ibm.com.treinamento.service.ConvidadoService;

@Service
public class ConvidadoServiceImpl implements ConvidadoService {
	@Autowired
	ConvidadoRepository cr;
	
	@Override
	public Convidado findByRg(String rg) {
		Optional<Convidado> c = cr.findById(rg);
		return c.get();
	}

	@Override
	public Convidado save(Convidado convidado) {
		return cr.save(convidado);
	}

	@Override
	public void delete(Convidado convidado) {
		cr.delete(convidado);
	}

	@Override
	public List<Convidado> findAll(Convidado convidado) {
		return cr.findAll();
	}
	

}
