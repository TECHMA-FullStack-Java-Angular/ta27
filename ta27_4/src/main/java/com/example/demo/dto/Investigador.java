package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="investigadores")
public class Investigador {
	
	@Id
	private String dni;
	@Column(name="nom_apels")
	private String nomApels;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultad facultad;
	
	@OneToMany
	@JoinColumn(name="dni")
	private List<Reserva> reservas;

	public Investigador(String dni, String nomApels, Facultad facultad, List<Reserva> reservas) {
		super();
		this.dni = dni;
		this.nomApels = nomApels;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	public Investigador() {
		super();
	}

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

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dni")
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Investigador [dni=" + dni + ", nomApels=" + nomApels + ", facultad=" + facultad + ", reservas="
				+ reservas + "]";
	}
	
	

}
