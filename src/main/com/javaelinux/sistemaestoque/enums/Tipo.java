package com.javaelinux.sistemaestoque.enums;

public enum Tipo {
	FISICO("Fisíco"), JUDIRICO("Juridico");

	private String label;

	Tipo(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}