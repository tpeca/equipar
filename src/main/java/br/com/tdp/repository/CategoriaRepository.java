package br.com.tdp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.tdp.model.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {

	@Query("{'nome' : ?0}")
	Categoria buscarPorNome(final String nome);
	
	@Query("{'id' : ?0}")
	Categoria findOne(String idCategoria);
	
	
}
