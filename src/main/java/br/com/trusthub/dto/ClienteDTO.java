package br.com.trusthub.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Campo nome não está presente")
	@NotBlank(message="Campo nome deve ser preechido")
	private String nome;
	
	@NotNull(message="Campo limiteCredito não está presente")
	private Double limiteCredito;
	
	@NotNull(message="Campo risco não está presente")
	@NotBlank(message="Campo risco deve ser preechido")
	private String risco;

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

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

}
