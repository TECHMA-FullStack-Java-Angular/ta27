package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="asignado_a")
public class Asignado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int precio;
	
	@ManyToOne
	@JoinColumn(name="cientifico")
	Cientifico cientifico;
	

	@ManyToOne
	@JoinColumn(name="proyecto")
	Proyecto proyecto;

	//constructores
	public Asignado(int id, int precio, Cientifico cientificoObject, Proyecto proyectoObject) {
		super();
		this.id = id;
		this.precio = precio;
		this.cientifico = cientificoObject;
		this.proyecto = proyectoObject;
	}


	public Asignado() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public Cientifico getCientifico() {
		return cientifico;
	}


	public void setCientifico(Cientifico cientifico) {
		this.cientifico = cientifico;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	@Override
	public String toString() {
		return "Asignado [id=" + id + ", precio=" + precio + ", cientifico=" + cientifico + ", proyecto=" + proyecto
				+ "]";
	}

	
	
}
