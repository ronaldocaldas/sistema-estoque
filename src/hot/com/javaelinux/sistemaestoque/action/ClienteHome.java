package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.enums.Tipo;
import com.javaelinux.sistemaestoque.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("clienteHome")
public class ClienteHome extends EntityHome<Cliente> {

	private static final long serialVersionUID = 3589763443402548421L;

	public void setClienteId(Integer id) {
		setId(id);
	}

	public Integer getClienteId() {
		return (Integer) getId();
	}

	@Override
	protected Cliente createInstance() {
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new Date());
		return cliente;
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

	public Cliente getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Venda> getVendas() {
		return getInstance() == null ? null : new ArrayList<Venda>(
				getInstance().getVendas());
	}
	
	public Tipo[] getTipos(){
		return Tipo.values();
	}

}
