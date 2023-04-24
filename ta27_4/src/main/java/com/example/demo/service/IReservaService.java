package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Reserva;



public interface IReservaService {
	
	//Metodos del CRUD
		public List<Reserva> listarReservas(); //Listar All 
		
		public Reserva guardarReserva(Reserva reserva);	// CREATE
		
		public Reserva reservaXID(int id); // READ
		
		public Reserva actualizarFacultad(Reserva reserva); // UPDATE
		
		public void eliminarReserva(int id);//  DELETE

}
