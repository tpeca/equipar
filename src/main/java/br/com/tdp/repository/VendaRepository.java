package br.com.tdp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.tdp.model.Venda;

public interface VendaRepository extends MongoRepository<Venda, String> {

	@Query("{'versionId' : ?0, 'portabilityInfo.spidOwner' : ?1}")
	Venda findByVersionIdAndSpidOwner(final Long versionId, final String spidOwner);

	
}
