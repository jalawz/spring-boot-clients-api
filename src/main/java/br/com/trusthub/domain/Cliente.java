package br.com.trusthub.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.trusthub.domain.enums.Risco;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private Double limiteCredito;

	@Enumerated(EnumType.STRING)
	private Risco risco;
	private Integer taxa;

	public Cliente() {
	}

	public Cliente(String nome, Double limiteCredito, Risco risco) {
		super();
		this.nome = nome;
		this.limiteCredito = limiteCredito;
		this.risco = risco;
		this.taxa = risco.getTaxa();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Risco getRisco() {
		return risco;
	}

	public void setRisco(Risco risco) {
		this.risco = risco;
	}

	public Integer getTaxa() {
		return taxa;
	}

}
