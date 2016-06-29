package com.javaelinux.sistemaestoque.action;

import java.util.Date;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.javaelinux.sistemaestoque.model.Cliente;
import com.javaelinux.sistemaestoque.model.Venda;
import com.javaelinux.sistemaestoque.model.Vendedor;

@Name("registroVendaHome")
public class RegistroVendaHome extends EntityHome<Venda> {

	private static final long serialVersionUID = -5349750588307774945L;
	
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
		venda.setDataVenda(new Date());
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
	
	public void salvarVenda(){
		if(getInstance().getCliente() != null && getInstance().getVendedor() != null){
			persist();
		}
	}

}
