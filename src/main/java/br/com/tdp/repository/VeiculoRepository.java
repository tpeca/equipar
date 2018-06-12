package br.com.tdp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.tdp.model.Veiculo;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

	@Query("{'modelo' : ?0}")
	Veiculo buscarPorModelo(final String modelo);
	
	
}
