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
import br.com.tdp.model.Categoria;
import br.com.tdp.repository.CategoriaRepository;
import br.com.tdp.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	public final CategoriaService categoriaService;
	public final CategoriaRepository categoriaRepository;
	
	public CategoriaController(CategoriaService categoriaService, CategoriaRepository categoriaRepository) {
		this.categoriaService = categoriaService;
		this.categoriaRepository = categoriaRepository;
	}
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<?>> findAll() {
		LOGGER.info("findAll");
		return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> findOne(@PathVariable("id") String id) throws BusinessException {
		LOGGER.info("findOne");
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return new ResponseEntity<>(categoria, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/{id}/categoria", "/{id}/categoria/{id}" }, method = RequestMethod.POST)
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria)
			throws BusinessException {
		LOGGER.info("save");
		categoria = categoriaRepository.insert(categoria);
//		alert.info(SOLICITACAO_SAVE_SUCCESS);
		return new ResponseEntity<>(categoria, HttpStatus.CREATED);
	}

}
