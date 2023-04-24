package com.example.demo.service;

import java.util.List;


import com.example.demo.dto.Venta;

public interface IVentaService {
	
	//Metodos del CRUD
	public List<Venta> listarVenta(); //Listar All 
	
	public Venta guardarVenta(Venta venta);	//Guarda venta CREATE
	
	public Venta ventaXID(int id); //Leer datos de venta READ
	
	public Venta actualizarVenta(Venta venta); //Actualiza datos de venta UPDATE
	
	public void eliminarVenta(int id);// Elimina venta DELETE

}
