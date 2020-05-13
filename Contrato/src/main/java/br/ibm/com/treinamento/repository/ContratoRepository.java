package br.ibm.com.treinamento.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.ibm.com.treinamento.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	Optional<Contrato> findByCpfCliente(String cpfCliente);

	Optional<Contrato> findByCpfClienteAndStatus(String cpfCliente, String status);

	Optional<Contrato> findBynumContrato(String numContrato);

	Optional<Contrato> findBynumContrato(Integer numContrato);
	// Optional<Contrato> findByCpfAndStatus(String cpfCliente, String status);
}
