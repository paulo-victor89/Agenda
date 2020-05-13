package br.ibm.com.treinamento.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ibm.com.treinamento.demo.model.ProdutoVenda;

@Service
public interface ProdutoVendasService {
	
		//PV = ProdutoVenda
	
		//Insere no H2 via JSON
		ProdutoVenda criaPV(ProdutoVenda pv);
		
		//Consulta no H2 por Id via JSON
		ProdutoVenda consultaPVById(Long id);
		
		//Consulta no H2 todos PVs
		List<ProdutoVenda> consultaPV();
		
		//Deleta do H2 todos dados por Id do PV via JSON
	ProdutoVenda removePVById(Long id);

}
