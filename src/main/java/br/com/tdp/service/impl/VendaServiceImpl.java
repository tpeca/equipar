package br.com.tdp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tdp.model.Item;
import br.com.tdp.repository.VendaRepository;
import br.com.tdp.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {
	
	
	public final VendaRepository vendaRepository;
	
	public VendaServiceImpl(VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}

	@Override
	public void calcularDesconto(List<Item> itens) {
		// TODO Auto-generated method stub
		
	}

	
}
