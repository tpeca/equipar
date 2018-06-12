package br.com.tdp.service.impl;

import org.springframework.stereotype.Service;

import br.com.tdp.repository.CategoriaRepository;
import br.com.tdp.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	
	public final CategoriaRepository categoriaRepository;

	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}


}
