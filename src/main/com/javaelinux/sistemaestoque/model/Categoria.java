package com.javaelinux.sistemaestoque.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Categoria
 */
@Entity
@Table(name = "categoria", catalog = "sistemaestoque")
public class Categoria implements java.io.Serializable {

	private static final long serialVersionUID = -4859869123587144401L;
	private Integer id;
	private String nome;
	private Set<Produto> produtos = new HashSet<Produto>(0);

	public Categoria() {
	}

	public Categoria(String nome) {
		this.nome = nome;
	}
	public Categoria(String nome, Set<Produto> produtos) {
		this.nome = nome;
		this.produtos = produtos;
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

	@Column(name = "nome", nullable = false, length = 100)
	@NotNull
	@Length(max = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

}
