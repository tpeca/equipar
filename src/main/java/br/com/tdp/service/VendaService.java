package br.com.tdp.service;

import java.util.List;

import br.com.tdp.model.Item;

public interface VendaService {

	void calcularDesconto(List<Item> itens); 
}
