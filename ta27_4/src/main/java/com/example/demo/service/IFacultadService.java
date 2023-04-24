package com.example.demo.service;

import java.util.List;


import com.example.demo.dto.Facultad;

public interface IFacultadService {
	
	//Metodos del CRUD
	public List<Facultad> listarFacultad(); //Listar All 
	
	public Facultad guardarFacultad(Facultad facultad);	// CREATE
	
	public Facultad facultadXID(int codigo); // READ
	
	public Facultad actualizarFacultad(Facultad facultad); // UPDATE
	
	public void eliminarFacultad(int codigo);//  DELETE

}
