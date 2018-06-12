package br.com.tdp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tdp.exception.BusinessException;
import br.com.tdp.model.Produto;
import br.com.tdp.repository.ProdutoRepository;
import br.com.tdp.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	public final ProdutoService produtoService;
	public final ProdutoRepository produtoRepository;
	
	public ProdutoController(ProdutoService produtoService, ProdutoRepository produtoRepository) {
		this.produtoService = produtoService;
		this.produtoRepository = produtoRepository;
	}
	private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoController.class);

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<?>> findAll() {
		LOGGER.info("findAll");
		return new ResponseEntity<>(produtoRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Produto>> findById(@PathVariable("id") String id) throws BusinessException {
		LOGGER.info("findById");
		Optional<Produto> produto = produtoRepository.findById(id);
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/{id}/produto", "/{id}/produto/{id}" }, method = RequestMethod.POST)
	public ResponseEntity<Produto> save(@RequestBody Produto produto)
			throws BusinessException {
		LOGGER.info("save");
		produto = produtoRepository.save(produto);
//		alert.info(SOLICITACAO_SAVE_SUCCESS);
		return new ResponseEntity<>(produto, HttpStatus.CREATED);
	}

}
