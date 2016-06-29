package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("vendaHome")
public class VendaHome extends EntityHome<Venda> {

	private static final long serialVersionUID = -5131797529969432183L;
	@In(create = true)
	ClienteHome clienteHome;
	@In(create = true)
	VendedorHome vendedorHome;

	public void setVendaId(Integer id) {
		setId(id);
	}

	public Integer getVendaId() {
		return (Integer) getId();
	}

	@Override
	protected Venda createInstance() {
		Venda venda = new Venda();
		return venda;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Cliente cliente = clienteHome.getDefinedInstance();
		if (cliente != null) {
			getInstance().setCliente(cliente);
		}
		Vendedor vendedor = vendedorHome.getDefinedInstance();
		if (vendedor != null) {
			getInstance().setVendedor(vendedor);
		}
	}

	public boolean isWired() {
		if (getInstance().getCliente() == null)
			return false;
		if (getInstance().getVendedor() == null)
			return false;
		return true;
	}

	public Venda getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ItensVenda> getItensVendas() {
		return getInstance() == null ? null : new ArrayList<ItensVenda>(
				getInstance().getItensVendas());
	}

}
