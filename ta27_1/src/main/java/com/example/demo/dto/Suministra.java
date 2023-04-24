package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="suministra")
public class Suministra {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int precio;
	
	@ManyToOne
	@JoinColumn(name="codigo_pieza")
	Pieza pieza;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	Proveedor proveedor;

	//constructores
	public Suministra(int id, int precio, Pieza pieza, Proveedor proveedor) {
		super();
		this.id = id;
		this.precio = precio;
		this.pieza = pieza;
		this.proveedor = proveedor;
	}

	public Suministra() {
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

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Suministra [id=" + id + ", precio=" + precio + ", pieza=" + pieza + ", proveedor=" + proveedor + "]";
	}

	
	
	
	 

}
