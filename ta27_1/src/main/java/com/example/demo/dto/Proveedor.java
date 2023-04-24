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
@Table(name="proveedores")
public class Proveedor {
	
	@Id
	private String id;
	@Column(name="nombre")
	private String nombreProveedor;
	
	@OneToMany
	@JoinColumn(name="id_proveedor")
	private List<Suministra> suministra;
	
	//Constructores

	public Proveedor(String id, String nombreProveedor, List<Suministra> suministra) {
		
		this.id = id;
		this.nombreProveedor = nombreProveedor;
		this.suministra = suministra;
	}

	public Proveedor() {
		
	}
	
	//Getters & Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_proveedor")
	public List<Suministra> getSuministra() {
		return suministra;
	}

	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}
	
	
	

}
