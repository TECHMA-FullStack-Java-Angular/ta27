package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="piezas")
public class Pieza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	@Column(name="nombre")
	private String nombrePieza;
	
	@OneToMany
	@JoinColumn(name="codigo_pieza")
	private List<Suministra> suministra;
	
	//Contructores

	public Pieza(int codigo, String nombrePieza, List<Suministra> suministra) {
		
		this.codigo = codigo;
		this.nombrePieza = nombrePieza;
		this.suministra = suministra;
	}

	public Pieza() {
		
	}
	
	//Getters & Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombrePieza() {
		return nombrePieza;
	}

	public void setNombrePieza(String nombrePieza) {
		this.nombrePieza = nombrePieza;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "codigo_pieza")
	public List<Suministra> getSuministra() {
		return suministra;
	}

	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	//toString
	@Override
	public String toString() {
		return "Pieza [codigo=" + codigo + ", nombrePieza=" + nombrePieza + ", suministra=" + suministra + "]";
	}
	
	
	
	 

}
