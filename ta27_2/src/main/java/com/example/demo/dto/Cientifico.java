package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cientificos")
public class Cientifico {

	@Id
	private String dni;
	@Column(name="nom_apels")
	private String nomApels;
	
	@OneToMany
	@JoinColumn(name="cientifico")
	private List<Asignado> asignado;

	//constructores
	public Cientifico(String dni, String nomApels, List<Asignado> asignado) {
		super();
		this.dni = dni;
		this.nomApels = nomApels;
		this.asignado = asignado;
	}

	public Cientifico() {
		super();
	}

	
	//getters & setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cientifico")
	public List<Asignado> getAsignado() {
		return asignado;
	}

	public void setAsignado(List<Asignado> asignado) {
		this.asignado = asignado;
	}

	@Override
	public String toString() {
		return "Cientifico [dni=" + dni + ", nomApels=" + nomApels + ", asignado=" + asignado + "]";
	}
	
	
	
}
