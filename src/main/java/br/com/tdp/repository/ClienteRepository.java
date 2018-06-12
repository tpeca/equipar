package br.com.tdp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.tdp.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

	@Query("{'nome' : ?0}")
	Cliente buscarPorNome(final String nome);
	
	@Query("{'cpf' : ?0}")
	Cliente buscarPorCpf(final String cpf);
	
	@Query("{'veiculo.marca' : ?0,'veiculo.modelo' : ?1}")
	List<Cliente> buscarClientesPorVeiculo(final String marca, final String modelo);
	
	
}
