package br.ibm.com.treinamento.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ibm.com.treinamento.agenda.model.Pessoa;

@Repository
public interface AgendaRepository extends JpaRepository<Pessoa, Long> {
	

}
