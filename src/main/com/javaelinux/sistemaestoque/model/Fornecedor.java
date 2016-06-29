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
 * Fornecedor
 */
@Entity
@Table(name = "fornecedor", catalog = "sistemaestoque")
public class Fornecedor implements java.io.Serializable {

	private static final long serialVersionUID = -1255461769998402047L;
	private Integer id;
	private String nome;
	private String razaoSocial;
	private String cnpj;
	private String cep;
	private String email;
	private String fone;
	private String endereco;
	private Set<Produto> produtos = new HashSet<Produto>(0);

	public Fornecedor() {
	}

	public Fornecedor(String nome) {
		this.nome = nome;
	}
	public Fornecedor(String nome, String razaoSocial, String cnpj, String cep,
			String email, String fone, String endereco, Set<Produto> produtos) {
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cep = cep;
		this.email = email;
		this.fone = fone;
		this.endereco = endereco;
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

	@Column(name = "nome", nullable = false, length = 45)
	@NotNull
	@Length(max = 45)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "razao_social", length = 45)
	@Length(max = 45)
	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(name = "cnpj", length = 15)
	@Length(max = 15)
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "cep", length = 15)
	@Length(max = 15)
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "email", length = 45)
	@Length(max = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "fone", length = 45)
	@Length(max = 45)
	public String getFone() {
		return this.fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@Column(name = "endereco", length = 100)
	@Length(max = 100)
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

}
