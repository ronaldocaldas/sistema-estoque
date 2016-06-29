package com.javaelinux.sistemaestoque.action;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;

import com.javaelinux.sistemaestoque.model.ItensVenda;
import com.javaelinux.sistemaestoque.model.Produto;
import com.javaelinux.sistemaestoque.model.Venda;

@Name("itensVendaHome")
public class ItensVendaHome extends EntityHome<ItensVenda> {

	private static final long serialVersionUID = 8964500474649132347L;
	@In(create = true)
	ProdutoHome produtoHome;
	@In(create = true)
	VendaHome vendaHome;
	@In
	private FacesMessages facesMessages;
	
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

	public void salvarItemVenda(){
		
		int quantidadeProdutoEstoque  = getInstance().getProduto().getQuantidade();
		float valorProduto =  getInstance().getProduto().getValorVenda();

		if(quantidadeProdutoEstoque> 0){
			if(getInstance().getQuantidade() <= quantidadeProdutoEstoque){
			getInstance().setValor(getInstance().getQuantidade()*valorProduto);
			getInstance().getProduto().setQuantidade(quantidadeProdutoEstoque-getInstance().getQuantidade());
			persist();
			}else{
				facesMessages.addToControl("vendaTable","Quantidade de produto acima do estoque!");
				FacesMessages.instance().add("Quantidade de produto acima do estoque!");
			}
		}else{
			facesMessages.addToControl("vendaTable", "Produto fora de estoque!");
		}
	}
	
	public void atualizarItemVenda(){
		int quantidadeProdutoEstoque  = getInstance().getProduto().getQuantidade();
		float valorProduto =  getInstance().getProduto().getValorVenda();
		
		if(quantidadeProdutoEstoque> 0){
			if(getInstance().getQuantidade() <= quantidadeProdutoEstoque){
			getInstance().setValor(getInstance().getQuantidade()*valorProduto);
			getInstance().getProduto().setQuantidade(quantidadeProdutoEstoque-getInstance().getQuantidade());
			update();
			}else{
				facesMessages.addToControl("vendaTable","Quantidade de produto acima do estoque!");
				FacesMessages.instance().add("Quantidade de produto acima do estoque!");
			}
		}else{
			facesMessages.addToControl("vendaTable", "Produto fora de estoque!");
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
