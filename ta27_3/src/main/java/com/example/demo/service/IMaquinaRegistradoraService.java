package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MaquinaRegistradora;


public interface IMaquinaRegistradoraService {
	
	//Metodos del CRUD
	public List<MaquinaRegistradora> listarMaquinaRegistradora(); //Listar All 
	
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora);	//Guarda maquinaRegistradora CREATE
	
	public MaquinaRegistradora maquinaRegistradoraXID(int codigo); //Leer datos de maquinaRegistradora READ
	
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora); //Actualiza datos de maquinaRegistradora UPDATE
	
	public void eliminarMaquinaRegistradora(int codigo);// Elimina maquinaRegistradora DELETE

}
