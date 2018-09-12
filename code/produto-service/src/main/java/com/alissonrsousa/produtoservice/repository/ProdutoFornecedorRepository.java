package com.alissonrsousa.produtoservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.alissonrsousa.produtoservice.model.ProdutoFornecedor;

public interface ProdutoFornecedorRepository extends CrudRepository<ProdutoFornecedor, Long> {

	@Query(value="select p from ProdutoFornecedor p where p.fornecedor.id = :idFornecedor and p.idProdutoFornecedor = :idProdutoFornecedor")
	ProdutoFornecedor findByFornecedorIdAndIdProdutoFornecedor(@Param("idFornecedor") Integer idFornecedor, @Param("idProdutoFornecedor") Long idProdutoFornecedor);

}
