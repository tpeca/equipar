package br.com.tdp.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {

	@Id
	private int id;
	private BigDecimal valorFinal;
	private BigDecimal valorItem;
	private BigDecimal desconto;
	private Produto produto;
	private String nome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
	public BigDecimal getValorItem() {
		return valorItem;
	}
	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
