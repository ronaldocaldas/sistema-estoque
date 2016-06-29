package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;

@Name("vendedorList")
public class VendedorList extends EntityQuery<Vendedor> {

	private static final long serialVersionUID = 5187493683400925054L;

	private static final String EJBQL = "select vendedor from Vendedor vendedor";
	
	private List<SelectItem> vendedorSelect;

	private static final String[] RESTRICTIONS = {
			"lower(vendedor.cpf) like lower(concat(#{vendedorList.vendedor.cpf},'%'))",
			"lower(vendedor.email) like lower(concat(#{vendedorList.vendedor.email},'%'))",
			"lower(vendedor.endereco) like lower(concat(#{vendedorList.vendedor.endereco},'%'))",
			"lower(vendedor.nome) like lower(concat(#{vendedorList.vendedor.nome},'%'))",};

	private Vendedor vendedor = new Vendedor();

	public VendedorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Vendedor getVendedor() {
		return vendedor;
	}
	
	
	public List<SelectItem> getVendedorSelect() {
		
		if (vendedorSelect == null) {

			vendedorSelect = new ArrayList<SelectItem>();
			List<Vendedor> listaVendedores = getResultList();

			if (listaVendedores != null && !listaVendedores.isEmpty()) {
				SelectItem item;
				for (Vendedor vendedorLista : listaVendedores) {
					item = new SelectItem(vendedorLista, vendedorLista.getNome());
					vendedorSelect.add(item);
				}
			}

		}

		return vendedorSelect;
	}

	public void setVendedorSelect(List<SelectItem> vendedorSelect) {
		this.vendedorSelect = vendedorSelect;
	}
}
