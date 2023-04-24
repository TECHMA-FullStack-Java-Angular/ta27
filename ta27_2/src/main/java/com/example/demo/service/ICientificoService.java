package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;



public interface ICientificoService {
	
	//Metodos del CRUD
	public List<Cientifico> listarCientificos(); //Listar All 
	
	public Cientifico guardarCientifico(Cientifico cientifico);	//Guarda un cientifico CREATE
	
	public Cientifico cientificoXID(String dni); //Leer datos de un cientifico READ
	
	public Cientifico actualizarCientifico(Cientifico cientifico); //Actualiza datos del cientifico UPDATE
	
	public void eliminarCientifico(String dni);// Elimina el cientifico DELETE

}
