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
import org.hibernate.validator.NotNull;

/**
 * Venda
 */
@Entity
@Table(name = "venda", catalog = "sistemaestoque")
public class Venda implements java.io.Serializable {

	private static final long serialVersionUID = 1537592981880595917L;
	private Integer id;
	private Cliente cliente;
	private Vendedor vendedor;
	private Date dataVenda;
	private Set<ItensVenda> itensVendas = new HashSet<ItensVenda>(0);

	public Venda() {
	}

	public Venda(Cliente cliente, Vendedor vendedor) {
		this.cliente = cliente;
		this.vendedor = vendedor;
	}
	public Venda(Cliente cliente, Vendedor vendedor, Date dataVenda,
			Set<ItensVenda> itensVendas) {
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.dataVenda = dataVenda;
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
	@JoinColumn(name = "id_cliente", nullable = false)
	@NotNull
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vendedor", nullable = false)
	@NotNull
	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_venda", length = 19)
	public Date getDataVenda() {
		return this.dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venda")
	public Set<ItensVenda> getItensVendas() {
		return this.itensVendas;
	}

	public void setItensVendas(Set<ItensVenda> itensVendas) {
		this.itensVendas = itensVendas;
	}

}
