package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("unidadeList")
public class UnidadeList extends EntityQuery<Unidade> {

	private static final long serialVersionUID = 4376112239760925072L;

	private static final String EJBQL = "select unidade from Unidade unidade";

	private static final String[] RESTRICTIONS = {"lower(unidade.descricao) like lower(concat(#{unidadeList.unidade.descricao},'%'))",};

	private Unidade unidade = new Unidade();

	public UnidadeList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Unidade getUnidade() {
		return unidade;
	}
}
