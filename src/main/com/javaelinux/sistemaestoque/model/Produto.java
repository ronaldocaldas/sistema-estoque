package com.javaelinux.sistemaestoque.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Produto
 */
@Entity
@Table(name = "produto", catalog = "sistemaestoque")
public class Produto implements java.io.Serializable {

	private static final long serialVersionUID = 6448804814721917682L;
	private Integer id;
	private Fornecedor fornecedor;
	private Categoria categoria;
	private Unidade unidade;
	private String nome;
	private String descricao;
	private Date dataCadastro;
	private Integer quantidade;
	private float valorPago;
	private float valorVenda;
	private Set<ItensVenda> itensVendas = new HashSet<ItensVenda>(0);

	public Produto() {
	}

	public Produto(Unidade unidade, float valorPago, float valorVenda) {
		this.unidade = unidade;
		this.valorPago = valorPago;
		this.valorVenda = valorVenda;
	}
	public Produto(Fornecedor fornecedor, Categoria categoria, Unidade unidade,
			String nome, String descricao, Date dataCadastro,
			Integer quantidade, float valorPago, float valorVenda,
			Set<ItensVenda> itensVendas) {
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		this.unidade = unidade;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.quantidade = quantidade;
		this.valorPago = valorPago;
		this.valorVenda = valorVenda;
		this.itensVendas = itensVendas;
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
	@JoinColumn(name = "id_fornecedor")
	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unidade", nullable = false)
	@NotNull
	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	@Column(name = "nome", length = 45)
	@Length(max = 45)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", length = 19)
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name = "quantidade")
	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name = "valor_pago", nullable = false, precision = 12, scale = 0)
	public float getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

	@Column(name = "valor_venda", nullable = false, precision = 12, scale = 0)
	public float getValorVenda() {
		return this.valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<ItensVenda> getItensVendas() {
		return this.itensVendas;
	}

	public void setItensVendas(Set<ItensVenda> itensVendas) {
		this.itensVendas = itensVendas;
	}

}
