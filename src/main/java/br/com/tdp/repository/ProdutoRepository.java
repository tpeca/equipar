package br.com.tdp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.tdp.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

	@Query("{'nome' : ?0}")
	Produto buscarPorNome(final String nome);

	@Query("{'id' : ?0}")
	Produto findOne(String idProduto);
	
	
}
