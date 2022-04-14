package com.exemple.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movimentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cartao;
	private int valor;
	private LocalDate data;
	public Movimentacao() {
		super();
	}
	
	
	public Movimentacao(String cartao, int valor, LocalDate data) {
		super();
		this.cartao = cartao;
		this.valor = valor;
		this.data = data;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cartao, data, id, valor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(cartao, other.cartao) && Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& valor == other.valor;
	}
	
	
	
	
}
