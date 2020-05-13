package br.ibm.com.treinamento.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ibm.com.treinamento.demo.model.Vendas;
import br.ibm.com.treinamento.demo.repository.VendasRepository;
import br.ibm.com.treinamento.demo.service.ProdutoVendasService;
import br.ibm.com.treinamento.exception.InternalException;
import br.ibm.com.treinamento.exception.ObjetoInexistenteException;
import br.ibm.com.treinamento.exception.Resposta;

@RestController
@RequestMapping("/")

public class VendasController {
	
	@Autowired
	private VendasRepository vr;
	
	@PostMapping("vendas/novo")
	public Vendas criaVenda(@RequestBody Vendas novaVenda){
		return vr.save(novaVenda);
	
	}
	@GetMapping("vendas/consulta")
	public List<Vendas> consultaVendas(){
		return vr.findAll();
	}
	
	@GetMapping("vendas/consulta/{id}")
	public Vendas constultaVendasById(@PathVariable(value = "id")Long id){
		return vr.findById(id).get();
	}
	
	@DeleteMapping("vendas/deleta")
	public void deletaVendasById(@RequestBody Vendas deletaVenda) {
		vr.delete(deletaVenda);
	}

	
	
	
	
	
	
	
	
	

}
