package br.ibm.com.treinamento.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ibm.com.treinamento.model.Convidado;
import br.ibm.com.treinamento.model.Evento;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, String> {

	Iterable<Convidado> findByEvento(Evento evento);
}
