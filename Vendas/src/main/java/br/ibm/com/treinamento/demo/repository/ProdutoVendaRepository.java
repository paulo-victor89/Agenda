package br.ibm.com.treinamento.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ibm.com.treinamento.demo.model.ProdutoVenda;

@Repository
public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long> {
	
	  public default ProdutoVenda save(ProdutoVenda pv) { 
		  return null; 
	 }
	 
	 public default java.util.Optional<ProdutoVenda> findById(Long id) { 
		 return null; }
	  
	  public default List<ProdutoVenda> findAll() { 
		  return null;
	  }
	 
	 public default void deletaById(Long id) { 
	  
	  }
	 

}
