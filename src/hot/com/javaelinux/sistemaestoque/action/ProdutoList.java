package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("produtoList")
public class ProdutoList extends EntityQuery<Produto> {

	private static final long serialVersionUID = 6983475348493609868L;

	private static final String EJBQL = "select produto from Produto produto";

	private static final String[] RESTRICTIONS = {
			"lower(produto.descricao) like lower(concat(#{produtoList.produto.descricao},'%'))",
			"lower(produto.nome) like lower(concat(#{produtoList.produto.nome},'%'))",};

	private Produto produto = new Produto();

	public ProdutoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Produto getProduto() {
		return produto;
	}
}
