package br.ibm.com.treinamento.contrato;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.ibm.com.treinamento.model.Contrato;
import br.ibm.com.treinamento.service.ContratoService;
import br.ibm.com.treinamento.service.Impl.ContratoServiceImpl;

public class ContratoTest {
	
	private static final String contratoRepository = null;
	
	String dateInicio = "1999-03-01";
	String datef = "1999-04-10";
	LocalDate localDateInicio = LocalDate.parse(dateInicio);
	LocalDate localDateFim = LocalDate.parse(datef);
	
	@Spy
	private ContratoService contratoService;
	@InjectMocks
	private ContratoServiceImpl contratoServiceImpl;
	@Mock
	private Contrato contrato;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test(expected = NullPointerException.class)
	public void cria_novo_contrato() throws NullPointerException{
		
		//Given
		
		
	    	    
	    Contrato novoContrato = new Contrato(1,"379.181.988-75",localDateInicio, localDateFim, "Ativo", 10 );
	   // when(contratoService.criaNovoContrato(novoContrato));
	    assertThat(novoContrato.getNumContrato(), is(1));
		assertThat(novoContrato.getCpfCliente(), is("379.181.988-75"),null);
		assertThat(novoContrato.getDatInicio(),is("1999-03-01"));
		assertThat(novoContrato.getDatFim(), is("1999-04-10"));
		assertThat(novoContrato.getStatus(),is("Ativo"));
		assertThat(novoContrato.getValor(),is("10"));

	}
	@Test
	public void pesquisa_contrato_por_cpf() {
		
		Contrato novoContrato = new Contrato();
		Mockito.when(contratoService.pesquisaContratoCpf(novoContrato.getCpfCliente())).thenReturn(novoContrato);
		assertThat(contratoService.pesquisaCpfCliente("379.181.988-75").equals(novoContrato));
	}
	@Test
	public void pesquisa_contrato_por_status() {
		String statusA = "Ativo";
		String statusI = "Inativo";
		String dateInicio = "1999-03-01";
		String datef = "1999-04-10";
		LocalDate localDateInicio = LocalDate.parse(dateInicio);
		LocalDate localDateFim = LocalDate.parse(datef);
		Contrato novoContrato = new Contrato();
		Mockito.when(contratoService.pesquisaContratoCpf(novoContrato.getCpfCliente())).thenReturn(novoContrato);
		Assertions.assertThat(novoContrato.getCpfCliente()).as("379.181.988-75","1999-03-01","1999-04-10","Ativo","10");
	}
	@Test
	public void pesquisa_contrato_por_cpf_status() {
		String statusA = "Ativo";
		String statusI = "Inativo";
		String cpf = "379.181.988-75";
		String dateInicio = "1999-03-01";
		String datef = "1999-04-10";
		LocalDate localDateInicio = LocalDate.parse(dateInicio);
		LocalDate localDateFim = LocalDate.parse(datef);
		Contrato novoContrato = new Contrato();
		Mockito.when(contratoService.pesquisaContratoCpf(novoContrato.getCpfCliente())).thenReturn(novoContrato);
		Assertions.assertThat(novoContrato.getCpfCliente()).as("379.181.988-75","1999-03-01","1999-04-10","Ativo","10");
	}
	

}
