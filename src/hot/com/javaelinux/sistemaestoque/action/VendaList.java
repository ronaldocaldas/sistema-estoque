package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("vendaList")
public class VendaList extends EntityQuery<Venda> {

	private static final long serialVersionUID = -6470026134444426477L;

	private static final String EJBQL = "select venda from Venda venda";

	private static final String[] RESTRICTIONS = {};

	private Venda venda = new Venda();

	public VendaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Venda getVenda() {
		return venda;
	}
}
