package com.example.demo.service;

import java.util.List;


import com.example.demo.dto.Investigador;

public interface IInvestigadorService {
	
	//Metodos del CRUD
		public List<Investigador> listarInvestigadores(); //Listar All 
		
		public Investigador guardarInvestigador(Investigador investigador);	// CREATE
		
		public Investigador investigadorXID(String nomApels); // READ
		
		public Investigador actualizarInvestigador(Investigador investigador); // UPDATE
		
		public void eliminarInvestigador(String nomApels);//  DELETE

}
