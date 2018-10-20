package br.com.trusthub.domain.enums;

public enum Risco {
	
	A(0), B(10), C(20);
	
	private Integer taxa;
	
	private Risco(Integer taxa) {
		this.taxa = taxa;
	}

	public Integer getTaxa() {
		return taxa;
	}

	public void setTaxa(Integer taxa) {
		this.taxa = taxa;
	}
	
}
