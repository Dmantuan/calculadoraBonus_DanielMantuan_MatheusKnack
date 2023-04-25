package model;

import java.time.LocalDateTime;

public class Resultado {

	private final String nome;
	private final Double valor;
	private final LocalDateTime data;

	public Resultado( String nome, Double valor ) {
		this.nome = nome;
		this.valor = valor;
		this.data = LocalDateTime.now();
	}

	public String getNome() {
		return this.nome;
	}

	public Double getValor() {
		return this.valor;
	}

	public LocalDateTime getData() {
		return this.data;
	}
}
