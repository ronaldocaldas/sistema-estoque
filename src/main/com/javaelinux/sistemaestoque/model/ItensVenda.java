package com.javaelinux.sistemaestoque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * ItensVenda 
 */
@Entity
@Table(name = "itens_venda", catalog = "sistemaestoque")
public class ItensVenda implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8855993516172873706L;
	private Integer id;
	private Venda venda;
	private Produto produto;
	private Integer quantidade;
	private Float valor;

	public ItensVenda() {
	}

	public ItensVenda(Venda venda, Produto produto) {
		this.venda = venda;
		this.produto = produto;
	}
	public ItensVenda(Venda venda, Produto produto, Integer quantidade,
			Float valor) {
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venda", nullable = false)
	@NotNull
	public Venda getVenda() {
		return this.venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", nullable = false)
	@NotNull
	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Column(name = "quantidade")
	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name = "valor", precision = 12, scale = 0)
	public Float getValor() {
		return this.valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}
