package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="facultad")
public class Facultad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="facultad")
	private List<Investigador> investigadores;
	
	@OneToMany
	@JoinColumn(name="facultad")
	private List<Equipo> equipos;

	public Facultad(int codigo, String nombre, List<Investigador> investigadores, List<Equipo> equipos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.investigadores = investigadores;
		this.equipos = equipos;
	}

	public Facultad() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facultad")
	public List<Investigador> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(List<Investigador> investigadores) {
		this.investigadores = investigadores;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facultad")
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + ", investigadores=" + investigadores + ", equipos="
				+ equipos + "]";
	}
	
	
	

}
