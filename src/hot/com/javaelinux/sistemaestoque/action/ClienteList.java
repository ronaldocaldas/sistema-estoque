package com.javaelinux.sistemaestoque.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.javaelinux.sistemaestoque.model.Cliente;

@Name("clienteList")
public class ClienteList extends EntityQuery<Cliente> {

	private static final long serialVersionUID = -4385035342625010947L;

	private static final String EJBQL = "select cliente from Cliente cliente";
	
	private List<SelectItem> clienteSelect;


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
	
	public List<SelectItem> getClienteSelect() {
		
		if (clienteSelect == null) {

			clienteSelect = new ArrayList<SelectItem>();
			List<Cliente> listaClientes = getResultList();

			if (listaClientes != null && !listaClientes.isEmpty()) {
				SelectItem item;
				for (Cliente clienteLista : listaClientes) {
					item = new SelectItem(clienteLista, clienteLista.getNome());
					clienteSelect.add(item);
				}
			}

		}

		return clienteSelect;
	}

	public void setClienteSelect(List<SelectItem> clienteSelect) {
		this.clienteSelect = clienteSelect;
	}
}
