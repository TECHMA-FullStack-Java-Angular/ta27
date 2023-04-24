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
@Table(name="cajeros")
public class Cajero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	@Column(name="nom_apels")
	private String nomApels;
	
	@OneToMany
	@JoinColumn(name="cajero")
	private List<Venta> venta ;

	//Construcotres
	public Cajero(int codigo, String nomApels, List<Venta> venta) {
		super();
		this.codigo = codigo;
		this.nomApels = nomApels;
		this.venta = venta;
	}

	public Cajero() {
		super();
	}

	//getters & setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cajero")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	//toString
	@Override
	public String toString() {
		return "Cajero [codigo=" + codigo + ", nomApels=" + nomApels + ", venta=" + venta + "]";
	}
	
	

}
