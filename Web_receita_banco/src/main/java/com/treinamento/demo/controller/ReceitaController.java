package com.treinamento.demo.controller;

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

import com.treinamento.demo.exception.InternalException;
import com.treinamento.demo.exception.ObjetoInexistenteException;
import com.treinamento.demo.exception.Resposta;
import com.treinamento.demo.model.Receita;
import com.treinamento.demo.service.ReceitaService;

@RestController
@RequestMapping("/")
public class ReceitaController {


	@Autowired
	private ReceitaService receitaService;

	@PostMapping("receita/novo")
	public ResponseEntity<Object> criaReceita(@RequestBody Receita novaReceita) {
		try {
			return ResponseEntity.ok(receitaService.criaNovaReceita(novaReceita));

		} catch (InternalException ie) {
			return ResponseEntity.badRequest().body(new Resposta(ie.getCode(), ie.getMessage(), null));
		}
	}

	@GetMapping("receita/lista")
	public List<Receita> listaReceitas() {
		return receitaService.pesquisaTodasReceita();
	}

	@GetMapping("receita/{id}")
	public ResponseEntity<Object> listaReceitas(@PathVariable(value = "id") Long id) {
		try {
			return ResponseEntity.ok(receitaService.pesquisaReceita(id));
		} catch (ObjetoInexistenteException e) {
			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
		}

	}

	@GetMapping("receita/filtro/{desc}")
	public List<Receita> pesquisaReceitaByDescricao(@PathVariable(value = "desc") String desc) {
		return receitaService.pesquisaReceitaDescricao(desc);
	}

	@DeleteMapping("/receita/{id}")
	public ResponseEntity<Object> DeletaReceita(@PathVariable(value = "id") Long id) {
		try {
			Receita receitaDeletada = receitaService.deletaReceita(id);
			return ResponseEntity.ok("Receita de ID " + receitaDeletada.getId() + " deletada com sucesso!!");
		} catch (ObjetoInexistenteException e) {
			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
		}

	}

	@GetMapping("receita/calorias/{id_receita}")
	public String calculaCaloria(@PathVariable(value = "id_receita") Long id_receita) {

		Double totalCalorias = receitaService.calculaCalorias(id_receita);
		String resposta = "Total de calorias da receita é " + totalCalorias.toString();
		return resposta;
	}

}
