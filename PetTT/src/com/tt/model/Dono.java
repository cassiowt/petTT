package com.tt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DONOS")
@NamedQuery(name="queryDono", query="SELECT d FROM Dono d")
public class Dono implements Serializable {
	private static final long serialVersionUID = -3884254578509670471L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DONO_ID")
	private Long id;

	@Column(name = "NOME", length = 255, nullable = false)
	private String nome;

	@Column(name = "TELEFONE", length = 15, nullable = false)
	private String telefone;

	@Column(name = "ENDERECO", length = 255, nullable = false)
	private String endereco;
	
	@OneToMany
	@JoinColumn(name="DONO_ID",foreignKey=@ForeignKey(name="FK_ANIMAIS_DONO_ID"))
	private Collection<Animal> animais = new ArrayList<Animal>();

	public Dono() {

	}

	public Dono(String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
