package com.alissonrsousa.produtoservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.alissonrsousa.produtoservice.model.ProdutoFornecedor;
import com.alissonrsousa.produtoservice.repository.ProdutoFornecedorRepository;

@Service
public class ProdutoFornecedorService {

    @Autowired
    private ProdutoFornecedorRepository repository;

    public ProdutoFornecedor save(@Validated ProdutoFornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public Optional<ProdutoFornecedor> findById(Long id){
        return repository.findById(id);
    }

    public Iterable<ProdutoFornecedor> findAll(){
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

	public void save(List<ProdutoFornecedor> produtos) {
		for (ProdutoFornecedor produto: produtos) {
			ProdutoFornecedor produtoFornecedor = repository.findByFornecedorIdAndIdProdutoFornecedor(produto.getIdFornecedor(), produto.getIdProdutoFornecedor());
			produtoFornecedor.setEstoque(produto.getEstoque());
			produtoFornecedor.setPreco(produto.getPreco());
			produtoFornecedor.setValorFrete(produto.getValorFrete());
			produtoFornecedor.setPrazoEntrega(produto.getPrazoEntrega());
			produtoFornecedor.setDataAtualizacao(new Date());
			repository.save(produtoFornecedor);
		}
	}
}
