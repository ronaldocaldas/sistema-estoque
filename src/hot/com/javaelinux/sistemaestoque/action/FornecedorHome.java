package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("fornecedorHome")
public class FornecedorHome extends EntityHome<Fornecedor> {

	private static final long serialVersionUID = -2747341119036380120L;
	public void setFornecedorId(Integer id) {
		setId(id);
	}

	public Integer getFornecedorId() {
		return (Integer) getId();
	}

	@Override
	protected Fornecedor createInstance() {
		Fornecedor fornecedor = new Fornecedor();
		return fornecedor;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Fornecedor getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Produto> getProdutos() {
		return getInstance() == null ? null : new ArrayList<Produto>(
				getInstance().getProdutos());
	}
}
