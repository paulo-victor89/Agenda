package br.ibm.com.treinamento.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.ibm.com.treinamento.agenda.model.Pessoa;
import br.ibm.com.treinamento.agenda.model.Telefone;
import br.ibm.com.treinamento.agenda.repository.AgendaRepository;


@RestController
@RequestMapping("/")
public class AgendaController {

	@Autowired
	AgendaRepository agendaRepository;

	@PostMapping("/telefone/novo") // cria telefone
	public Pessoa criaPessoa(@RequestBody Pessoa pes) {
		Pessoa pess = agendaRepository.save(pes);
		return pess;

		// return tel;
	}

	public AgendaRepository getAgendaRepository() {
		return agendaRepository;
	}

	public void setAgendaRepository(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}

	
	  @GetMapping("telefone/lista") // listar os contatos public static
	  List<Pessoa> listaTelefone() 
	  {
		  return agendaRepository.findAll(); 
		  }
	  
	 @GetMapping("/telefone/{id}") // listar os contatos public static
	  List<Pessoa> listaTelefoneId(@PathVariable(value = "id") Long id) {
	  List<Pessoa> list = (List<Pessoa>) agendaRepository.findById(id).get();
	  return list; }
	  
	  
	  @RequestMapping ("/telefone/{id}")
	  public String criaTelefone(@Valid @RequestBody Telefone telefone)
	  {
		  Telefone.add(telefone);
		  return "Telefone adicionado"; 
	  }
	  
	 
	  @DeleteMapping ("/telefone/{id}") 
	  public String deletaTelefone(@Valid @RequestBody Telefone telefone)
	  {
		  Telefone.clear();
		  return "Telefone Deletado"; 
	  }
	  @DeleteMapping("telefone/delete") // listar os contatos public static
	   List<Pessoa> deleteTelefone() 
	  {
		  return agendaRepository.findAll(); 
		  }
	
	/*
	 * @DeleteMapping("/telefone/{id}") // remove todos os contatos public String
	 * apagaLista(@Valid @RequestBody Telefone telefone) { Telefone.clear(); return
	 * "lista de contatos apagada com sucesso";
	 * 
	 * }
	 */
	 
	/*
	 * @DeleteMapping ("/telefone/{nome}")//Apaga apenas o contato escolhido public
	 * String deletaTelefoneId(@RequestParam(value = "nome", required = true)String
	 * nome) { Long id = null; for (Pessoa telefone : listaTelefoneId(id)) {
	 * if(telefone.getNome().equals(nome)) { Telefone.remove(telefone); return
	 * "Telefone "+ telefone.getNome()+ "Deletado com sucesso"; }
	 * 
	 * } return "Nome não encontrado"; }
	 * 
	 */
	 
}
