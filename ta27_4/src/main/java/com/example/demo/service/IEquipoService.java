package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Equipo;


public interface IEquipoService {
	
	//Metodos del CRUD
	public List<Equipo> listarEquipos(); //Listar All 
	
	public Equipo guardarEquipo(Equipo equipo);	// CREATE
	
	public Equipo equipoXID(String numSerie); // READ
	
	public Equipo actualizarEquipo(Equipo equipo); // UPDATE
	
	public void eliminarEquipo(String numSerie);//  DELETE

}
