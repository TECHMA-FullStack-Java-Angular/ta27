package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Asignado;


public interface IAsignadoService {
	
	//Metodos del CRUD
			public List<Asignado> listarAsignado(); //Listar All 
			
			public Asignado guardarAsignado(Asignado asignado);	//Guarda un asignado CREATE
			
			public Asignado asignadoXID(int id); //Leer datos de un asignado READ
			
			public Asignado actualizarAsignado(Asignado asignado); //Actualiza datos del asignado UPDATE
			
			public void eliminarAsignado(int id);// Elimina el asignado DELETE

}
