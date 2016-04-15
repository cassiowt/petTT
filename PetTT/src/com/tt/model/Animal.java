package com.tt.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMAIS")
@NamedQuery(name="queryAnimais", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 8323525015276295004L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ANIMAL_ID")
	private Long id;

	@Column(name = "APELIDO", length = 60, nullable = false)
	private String apelido;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_ANIMAL", nullable = false)
	private TipoAnimal tipoAnimal;

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "RACA_ID", foreignKey = @ForeignKey(name = "FK_ANIMAIS_RACA_ID") )
	private Raca raca;

	@Column(name = "CARACTERISTICAS", length = 255, nullable = false)
	private String caracteristicas;

	public Animal() {
	}

	public Animal(String apelido, TipoAnimal tipoAnimal, Raca raca, String caracteristicas) {
		this.apelido = apelido;
		this.tipoAnimal = tipoAnimal;
		this.raca = raca;
		this.caracteristicas = caracteristicas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
