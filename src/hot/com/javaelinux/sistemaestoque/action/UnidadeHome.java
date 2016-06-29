package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("unidadeHome")
public class UnidadeHome extends EntityHome<Unidade> {

	private static final long serialVersionUID = -481350337130456812L;
	public void setUnidadeId(Integer id) {
		setId(id);
	}

	public Integer getUnidadeId() {
		return (Integer) getId();
	}

	@Override
	protected Unidade createInstance() {
		Unidade unidade = new Unidade();
		return unidade;
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

	public Unidade getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Produto> getProdutos() {
		return getInstance() == null ? null : new ArrayList<Produto>(
				getInstance().getProdutos());
	}

}
