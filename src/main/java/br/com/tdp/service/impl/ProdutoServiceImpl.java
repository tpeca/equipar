package br.com.tdp.service.impl;

import org.springframework.stereotype.Service;

import br.com.tdp.repository.ProdutoRepository;
import br.com.tdp.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	
	public final ProdutoRepository produtoRepository;
	
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	
}
