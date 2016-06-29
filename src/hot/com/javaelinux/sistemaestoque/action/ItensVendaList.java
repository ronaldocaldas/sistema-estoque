package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("itensVendaList")
public class ItensVendaList extends EntityQuery<ItensVenda> {

	private static final long serialVersionUID = 5820572935596626138L;

	private static final String EJBQL = "select itensVenda from ItensVenda itensVenda";

	private static final String[] RESTRICTIONS = {};

	private ItensVenda itensVenda = new ItensVenda();

	public ItensVendaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ItensVenda getItensVenda() {
		return itensVenda;
	}
}
