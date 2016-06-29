package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("vendedorHome")
public class VendedorHome extends EntityHome<Vendedor> {

	private static final long serialVersionUID = 7584354523412122107L;
	public void setVendedorId(Integer id) {
		setId(id);
	}

	public Integer getVendedorId() {
		return (Integer) getId();
	}

	@Override
	protected Vendedor createInstance() {
		Vendedor vendedor = new Vendedor();
		return vendedor;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Vendedor getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Venda> getVendas() {
		return getInstance() == null ? null : new ArrayList<Venda>(
				getInstance().getVendas());
	}

}
