package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("fornecedorList")
public class FornecedorList extends EntityQuery<Fornecedor> {

	private static final long serialVersionUID = 6810421840714056779L;

	private static final String EJBQL = "select fornecedor from Fornecedor fornecedor";

	private static final String[] RESTRICTIONS = {
			"lower(fornecedor.cep) like lower(concat(#{fornecedorList.fornecedor.cep},'%'))",
			"lower(fornecedor.cnpj) like lower(concat(#{fornecedorList.fornecedor.cnpj},'%'))",
			"lower(fornecedor.email) like lower(concat(#{fornecedorList.fornecedor.email},'%'))",
			"lower(fornecedor.endereco) like lower(concat(#{fornecedorList.fornecedor.endereco},'%'))",
			"lower(fornecedor.fone) like lower(concat(#{fornecedorList.fornecedor.fone},'%'))",
			"lower(fornecedor.nome) like lower(concat(#{fornecedorList.fornecedor.nome},'%'))",
			"lower(fornecedor.razaoSocial) like lower(concat(#{fornecedorList.fornecedor.razaoSocial},'%'))",};

	private Fornecedor fornecedor = new Fornecedor();

	public FornecedorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
}
