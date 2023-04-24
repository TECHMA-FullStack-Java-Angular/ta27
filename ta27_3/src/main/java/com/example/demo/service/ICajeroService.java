package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajero;


public interface ICajeroService {
	
	//Metodos del CRUD
		public List<Cajero> listarCajeros(); //Listar All 
		
		public Cajero guardarCajero(Cajero cajero);	//Guarda un cajero CREATE
		
		public Cajero cajeroXID(int codigo); //Leer datos de un cajero READ
		
		public Cajero actualizarCajero(Cajero cajero); //Actualiza datos del cajero UPDATE
		
		public void eliminarCajero(int codigo);// Elimina el cajero DELETE

}
