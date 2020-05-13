package br.ibm.com.treinamento.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ibm.com.treinamento.demo.model.ProdutoVenda;
import br.ibm.com.treinamento.demo.repository.ProdutoVendaRepository;
import br.ibm.com.treinamento.demo.service.ProdutoVendasService;
import br.ibm.com.treinamento.exception.ObjetoInexistenteException;


@Service
public class ProdutoVendaServiceImpl implements ProdutoVendasService{
	
	@Autowired
	private ProdutoVendaRepository pvr;

	@Override
	public ProdutoVenda criaPV(ProdutoVenda pv) {
		return pvr.save(pv);
	}

	@Override
	public ProdutoVenda consultaPVById(Long id) {
		Optional<ProdutoVenda> pv = pvr.findById(id);
		if (!pv.isPresent()) throw new ObjetoInexistenteException("ProdutoVenda com o ID"+id+" nao encontrada!");
		
		return pv.get();
		
	}

	@Override
	public java.util.List<ProdutoVenda> consultaPV() {
		return pvr.findAll();
	}

	@Override
	public ProdutoVenda removePVById(Long id) {
		Optional<ProdutoVenda> pv = pvr.findById(id);
		if (!pv.isPresent()) throw new ObjetoInexistenteException("ProdutoVenda com o ID"+id+" nao encontrada!");
		//pvr.deletaById(id);
		return pv.get();
		
	}

	
	
}
