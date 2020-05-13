package br.ibm.com.treinamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ibm.com.treinamento.exception.InternalException;
import br.ibm.com.treinamento.exception.ObjetoInexistenteException;
import br.ibm.com.treinamento.exception.Resposta;
import br.ibm.com.treinamento.model.Contrato;
import br.ibm.com.treinamento.service.ContratoService;

@RestController
@RequestMapping("/")
public class ContratoController {

	@Autowired
	private ContratoService contratoService;

	@PostMapping("contrato/novo")
	public ResponseEntity<Object> criaContrato(@RequestBody Contrato novoContrato) {
		try {
			return ResponseEntity.ok(contratoService.criaNovoContrato(novoContrato));

		} catch (InternalException ie) {
			return ResponseEntity.badRequest().body(new Resposta(ie.getCode(), ie.getMessage(), null));
		}
	}

	@GetMapping("contrato/encontrar/{cpfCliente}/{status}")
	public ResponseEntity<?> buscaStatus(@PathVariable(value = "cpfCliente") String cpfCliente,
			@PathVariable(value = "status") String status) {
		try {
			return ResponseEntity.ok(contratoService.pesquisaStatus(cpfCliente, status));
		} catch (ObjetoInexistenteException e) {
			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
		}
	}

	@GetMapping("contrato/buscacpf/{cpfCliente}")
	public ResponseEntity<?> buscaCpfCliente(@PathVariable(value = "cpfCliente") String cpfCliente) {
		try {
			return ResponseEntity.ok(contratoService.pesquisaCpfCliente(cpfCliente));
		} catch (ObjetoInexistenteException e) {
			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
		}
	}

	@GetMapping("contrato/buscacontrato/{numContrato}")
	public ResponseEntity<?> buscaNumeroContrato(@PathVariable(value = "numContrato") Integer numContrato) {
		try {
			return ResponseEntity.ok(contratoService.pesquisaNumContrato(numContrato));
		} catch (ObjetoInexistenteException e) {
			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
		}
	}


}
