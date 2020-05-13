package br.ibm.com.treinamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ibm.com.treinamento.model.Convidado;

@Service
public interface ConvidadoService {

	 Convidado findByRg(String rg);
	 
	 Convidado save(Convidado convidado);

	 void delete(Convidado convidado);
	 
	 List<Convidado> findAll(Convidado convidado);
	

}
