package com.treinamento.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.demo.exception.ObjetoInexistenteException;
import com.treinamento.demo.model.Ingrediente;
import com.treinamento.demo.model.Receita;
import com.treinamento.demo.repository.ReceitaRepository;
import com.treinamento.demo.service.ReceitaService;

@Service
public class ReceitaServiceImpl implements ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;

	@Override
	public Double calculaCalorias(Long idReceita) {

		Optional<Receita> receita = receitaRepository.findById(idReceita);
		if (!receita.isPresent())
			throw new ObjetoInexistenteException("Receita não encontrada");

		Double totalCalorias = 0.0;
		for (Ingrediente ingredientes : receita.get().getIngredientes()) {
			totalCalorias = +ingredientes.getCalorias();
			return totalCalorias;
		}

		return null;

	}

	@Override
	public Receita criaNovaReceita(Receita receita) {
		return receitaRepository.save(receita);
	}

	@Override
	public Receita pesquisaReceita(Long id) {
		Optional<Receita> receita = receitaRepository.findById(id);
		if(!receita.isPresent())
			throw new ObjetoInexistenteException("Receita com o ID " + id + " não encontrada");
			
		return receita.get();
	}

	@Override
	public List<Receita> pesquisaTodasReceita() {

		return receitaRepository.findAll();
	}

	@Override
	public Receita deletaReceita(Long id) {

		Optional<Receita> receita = receitaRepository.findById(id);
		if (!receita.isPresent())
			throw new ObjetoInexistenteException("Receita não encontrada");
		
		receitaRepository.deleteById(id);
		return receita.get();

	}

	@Override
	public List<Receita> pesquisaReceitaDescricao(String descricao) {
		
		List<Receita> receita = receitaRepository.findByDescricaoLike(descricao);
		return receita;
	}

}
