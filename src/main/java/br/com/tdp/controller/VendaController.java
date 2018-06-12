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
import br.com.tdp.model.Venda;
import br.com.tdp.repository.VendaRepository;
import br.com.tdp.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {

	public final VendaService vendaService;
	public final VendaRepository vendaRepository;
	
	public VendaController(VendaService vendaService, VendaRepository vendaRepository) {
		this.vendaService = vendaService;
		this.vendaRepository = vendaRepository;
	}
	private static final Logger LOGGER = LoggerFactory.getLogger(VendaController.class);

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<?>> findAll() {
		LOGGER.info("findAll");
		return new ResponseEntity<>(vendaRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Venda>> findById(@PathVariable("id") String id) throws BusinessException {
		LOGGER.info("findOne");
		Optional<Venda> venda = vendaRepository.findById(id);
		return new ResponseEntity<>(venda, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/{id}/venda", "/{id}/venda/{id}" }, method = RequestMethod.POST)
	public ResponseEntity<Venda> save(@RequestBody Venda venda)
			throws BusinessException {
		LOGGER.info("save");
		venda = vendaRepository.save(venda);
//		alert.info(SOLICITACAO_SAVE_SUCCESS);
		return new ResponseEntity<>(venda, HttpStatus.CREATED);
	}

}
