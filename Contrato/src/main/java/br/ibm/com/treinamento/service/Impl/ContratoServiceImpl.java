package br.ibm.com.treinamento.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.ibm.com.treinamento.exception.ObjetoInexistenteException;
import br.ibm.com.treinamento.model.Contrato;
import br.ibm.com.treinamento.repository.ContratoRepository;
import br.ibm.com.treinamento.service.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService {
	@Autowired
	private ContratoRepository contratoRepository;

	@Override
	public Contrato criaNovoContrato(Contrato novoContrato) {
		contratoRepository.save(novoContrato);
		return novoContrato;
	}

	@Override
	public Object pesquisaContratoCpf(String cpfCliente) {
		Optional<Contrato> contrato = contratoRepository.findByCpfCliente(cpfCliente);
		if (!contrato.isPresent())
			throw new ObjetoInexistenteException("Contrato vinculado ao " + cpfCliente + " não encontrado");
		return contrato.get();
	}

	@Override
	public Object pesquisaStatus(String cpfCliente, String status) {
		Optional<Contrato> contrato = contratoRepository.findByCpfClienteAndStatus(cpfCliente, status);
		if (!contrato.isPresent())
			throw new ObjetoInexistenteException("Contrato vinculado ao " + cpfCliente + " não encontrado");
		return contrato.get();
	}

	@Override
	public Object pesquisaCpfCliente(String cpfCliente) {
		Optional<Contrato> contrato = contratoRepository.findByCpfCliente(cpfCliente);
		if (!contrato.isPresent())
			throw new ObjetoInexistenteException("Contrato com o cpf " + cpfCliente + " não encontrado");
		return contrato.get();
	}

	@Override
	public Object pesquisaNumContrato(Integer numContrato) {
		Optional<Contrato> contrato = contratoRepository.findBynumContrato(numContrato);
		if (!contrato.isPresent())
			throw new ObjetoInexistenteException("Contrato de  " + numContrato + " não encontrado");
		return contrato.get();
	}

	@Override
	public Object atualizaStatus(Contrato atualizaStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object pesquisaCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

}
