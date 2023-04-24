package com.example.demo.dto;

import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="dni")
	private Investigador investigador;
	@ManyToOne
	@JoinColumn(name="num_serie")
	private Equipo equipo;
	private Date comienzo;
	private Date fin;
	
	
	public Reserva(int id, Investigador investigador, Equipo equipo, Date comienzo, Date fin) {
		super();
		this.id = id;
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}
	public Reserva() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Investigador getInvestigador() {
		return investigador;
	}
	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Date getComienzo() {
		return comienzo;
	}
	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", investigador=" + investigador + ", equipo=" + equipo + ", comienzo=" + comienzo
				+ ", fin=" + fin + "]";
	}
	
	
	
	

	
}
