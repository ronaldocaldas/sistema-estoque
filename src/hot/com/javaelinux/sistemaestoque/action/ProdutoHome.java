package com.javaelinux.sistemaestoque.action;

import com.javaelinux.sistemaestoque.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("produtoHome")
public class ProdutoHome extends EntityHome<Produto> {

	private static final long serialVersionUID = 8584579746321263019L;
	@In(create = true)
	CategoriaHome categoriaHome;
	@In(create = true)
	FornecedorHome fornecedorHome;
	@In(create = true)
	UnidadeHome unidadeHome;

	public void setProdutoId(Integer id) {
		setId(id);
	}

	public Integer getProdutoId() {
		return (Integer) getId();
	}

	@Override
	protected Produto createInstance() {
		Produto produto = new Produto();
		produto.setDataCadastro(new Date());
		return produto;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Categoria categoria = categoriaHome.getDefinedInstance();
		if (categoria != null) {
			getInstance().setCategoria(categoria);
		}
		Fornecedor fornecedor = fornecedorHome.getDefinedInstance();
		if (fornecedor != null) {
			getInstance().setFornecedor(fornecedor);
		}
		Unidade unidade = unidadeHome.getDefinedInstance();
		if (unidade != null) {
			getInstance().setUnidade(unidade);
		}
	}

	public boolean isWired() {
		if (getInstance().getUnidade() == null)
			return false;
		return true;
	}

	public Produto getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ItensVenda> getItensVendas() {
		return getInstance() == null ? null : new ArrayList<ItensVenda>(
				getInstance().getItensVendas());
	}

}
