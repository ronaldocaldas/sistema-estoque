package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("clienteList")
public class ClienteList extends EntityQuery<Cliente> {

	private static final long serialVersionUID = -4385035342625010947L;

	private static final String EJBQL = "select cliente from Cliente cliente";

	private static final String[] RESTRICTIONS = {
			"lower(cliente.cpf) like lower(concat(#{clienteList.cliente.cpf},'%'))",
			"lower(cliente.email) like lower(concat(#{clienteList.cliente.email},'%'))",
			"lower(cliente.endereco) like lower(concat(#{clienteList.cliente.endereco},'%'))",
			"lower(cliente.nome) like lower(concat(#{clienteList.cliente.nome},'%'))",
			"lower(cliente.tipo) like lower(concat(#{clienteList.cliente.tipo},'%'))",};

	private Cliente cliente = new Cliente();

	public ClienteList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Cliente getCliente() {
		return cliente;
	}
}
