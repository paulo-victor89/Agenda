package com.treinamento.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.treinamento.demo.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	
	@Query("Select r from Receita r where r.descricao like %:desc%")
	List<Receita> findByDescricaoLike(@Param("desc") String descricao);
	
	Receita findByDescricao(String descricao);
	
}
