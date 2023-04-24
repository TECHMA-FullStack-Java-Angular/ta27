package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="cajero")
	Cajero cajero;
	@ManyToOne
	@JoinColumn(name="maquina")
	MaquinaRegistradora maquina;
	@ManyToOne
	@JoinColumn(name="producto")
	Producto producto;
	
	//Constructores
	public Venta(int id, Cajero cajero, MaquinaRegistradora maquina, Producto producto) {
		super();
		this.id = id;
		this.cajero = cajero;
		this.maquina = maquina;
		this.producto = producto;
	}

	public Venta() {
		super();
	}
	
	//getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public MaquinaRegistradora getMaquina() {
		return maquina;
	}

	public void setMaquina(MaquinaRegistradora maquina) {
		this.maquina = maquina;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", maquina=" + maquina + ", producto=" + producto + "]";
	}
	
	
	

}
