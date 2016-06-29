package com.javaelinux.sistemaestoque.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.Length;

/**
 * Cliente 
 */
@Entity
@Table(name = "cliente", catalog = "sistemaestoque")
public class Cliente implements java.io.Serializable {

	private static final long serialVersionUID = -4006777761225467007L;
	private Integer id;
	private String cpf;
	private Date dataCadastro;
	private String email;
	private String endereco;
	private String nome;
	private float renda;
	private String tipo;
	private Set<Venda> vendas = new HashSet<Venda>(0);

	public Cliente() {
	}

	public Cliente(float renda) {
		this.renda = renda;
	}
	public Cliente(String cpf, Date dataCadastro, String email,
			String endereco, String nome, float renda, String tipo,
			Set<Venda> vendas) {
		this.cpf = cpf;
		this.dataCadastro = dataCadastro;
		this.email = email;
		this.endereco = endereco;
		this.nome = nome;
		this.renda = renda;
		this.tipo = tipo;
		this.vendas = vendas;
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

	@Column(name = "cpf")
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", length = 19)
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "endereco")
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "renda", nullable = false, precision = 12, scale = 0)
	public float getRenda() {
		return this.renda;
	}

	public void setRenda(float renda) {
		this.renda = renda;
	}

	@Column(name = "tipo", length = 8)
	@Length(max = 8)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}
	
}
