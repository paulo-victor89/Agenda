package br.ibm.com.treinamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ibm.com.treinamento.model.Convidado;
import br.ibm.com.treinamento.model.Evento;
import br.ibm.com.treinamento.repository.ConvidadoRepository;
import br.ibm.com.treinamento.service.ConvidadoService;
import br.ibm.com.treinamento.service.EventoService;

@Controller
public class EventoController {
	@Autowired
	private EventoService es;
	@Autowired
	private ConvidadoService cs;
	@Autowired
	private ConvidadoRepository cr;
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String formCadastra() {
		return "evento/formEvento";
		
	}
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String formCadastra(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {

			attributes.addFlashAttribute("mensagem", "Verifique os campos do formulario");
			return "redirect:/cadastro";

		}

		es.save(evento);
		attributes.addFlashAttribute("mensagem", "Evento adicionado com sucesso!	");
		return "redirect:/cadastro";
	}
	@RequestMapping(value = "/alteracao/{codigo}", method =RequestMethod.POST)
	public String formAltera(@PathVariable("codigo")long codigo, @Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			  
			 attributes.addFlashAttribute("mensagem",
			 "Verifique os campos do formulario"); 
			 return "redirect:/alteracao/"+codigo;
			 
			 }
			 
			 es.alterar(evento, codigo); 
			 
			 attributes.addFlashAttribute("mensagem","Evento alterado com sucesso!	"); 
			
			 	return "redirect:/alteracao/"+codigo; 
			 }
	
	@RequestMapping(value = "/alteracao/{codigo}", method = RequestMethod.GET)
	 public ModelAndView alterarEvento(@PathVariable("codigo") long codigo) { 
		Evento evento = es.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/formEventoEdit");
		mv.addObject("evento", evento);

		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);

		return mv;
	}
	 
	@RequestMapping("/eventos")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> evs = es.findAll();
		mv.addObject("eventos", evs);
		return mv;
	}

	@RequestMapping("/deletarEvento")
	public String deletarEvento(long codigo) {
		Evento evento = es.findByCodigo(codigo);
		es.delete(evento);
		return "redirect:/eventos";
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
		Evento evento = es.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);

		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);

		return mv;
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("codigo") long codigo, @Valid Convidado convidado,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {

			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{codigo}";
		}
		Evento evento = es.findByCodigo(codigo);
		convidado.setEvento(evento);
		cr.save(convidado);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{codigo}";
	}

	@RequestMapping("/deletarConvidado")
	public String deletarConvidado(String rg) {
		Convidado convidado = cs.findByRg(rg);
		cs.delete(convidado);

		Evento evento = convidado.getEvento();
		long codigoLong = evento.getCodigo();
		String codigo = "" + codigoLong;

		return "redirect:/" + codigo;
	}
}