package br.ibm.com.treinamento.service;

import br.ibm.com.treinamento.model.Contrato;

public interface ContratoService {

	Contrato criaNovoContrato(Contrato novoContrato);

	Object pesquisaStatus(String cpfCliente, String status);

	Object atualizaStatus(Contrato atualizaStatus);

	Object pesquisaContratoCpf(String cpfCliente);

	Object pesquisaCpf(String cpfCliente);

	Object pesquisaNumContrato(Integer numContrato);

	Object pesquisaCpfCliente(String cpfCliente);

}
