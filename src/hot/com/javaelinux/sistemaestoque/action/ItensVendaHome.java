package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("itensVendaHome")
public class ItensVendaHome extends EntityHome<ItensVenda> {

	private static final long serialVersionUID = 8964500474649132347L;
	@In(create = true)
	ProdutoHome produtoHome;
	@In(create = true)
	VendaHome vendaHome;

	public void setItensVendaId(Integer id) {
		setId(id);
	}

	public Integer getItensVendaId() {
		return (Integer) getId();
	}

	@Override
	protected ItensVenda createInstance() {
		ItensVenda itensVenda = new ItensVenda();
		return itensVenda;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Produto produto = produtoHome.getDefinedInstance();
		if (produto != null) {
			getInstance().setProduto(produto);
		}
		Venda venda = vendaHome.getDefinedInstance();
		if (venda != null) {
			getInstance().setVenda(venda);
		}
	}

	public boolean isWired() {
		if (getInstance().getProduto() == null)
			return false;
		if (getInstance().getVenda() == null)
			return false;
		return true;
	}

	public ItensVenda getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
