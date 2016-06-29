package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("categoriaHome")
public class CategoriaHome extends EntityHome<Categoria> {

	private static final long serialVersionUID = -106455940822855516L;

	public void setCategoriaId(Integer id) {
		setId(id);
	}

	public Integer getCategoriaId() {
		return (Integer) getId();
	}

	@Override
	protected Categoria createInstance() {
		Categoria categoria = new Categoria();
		return categoria;
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

	public Categoria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Produto> getProdutos() {
		return getInstance() == null ? null : new ArrayList<Produto>(
				getInstance().getProdutos());
	}
	
}
