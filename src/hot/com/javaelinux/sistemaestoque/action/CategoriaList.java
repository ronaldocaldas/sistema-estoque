package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("categoriaList")
public class CategoriaList extends EntityQuery<Categoria> {

	private static final long serialVersionUID = 9165991412332673221L;

	private static final String EJBQL = "select categoria from Categoria categoria";

	private static final String[] RESTRICTIONS = {"lower(categoria.nome) like lower(concat(#{categoriaList.categoria.nome},'%'))",};

	private Categoria categoria = new Categoria();

	public CategoriaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Categoria getCategoria() {
		return categoria;
	}
}
