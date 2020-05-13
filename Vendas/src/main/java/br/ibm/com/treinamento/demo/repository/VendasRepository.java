package br.ibm.com.treinamento.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ibm.com.treinamento.demo.model.Vendas;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long> {
	
}
