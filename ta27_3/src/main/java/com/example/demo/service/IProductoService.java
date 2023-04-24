package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Producto;

public interface IProductoService {
	
	//Metodos del CRUD
			public List<Producto> listarProductos(); //Listar All 
			
			public Producto guardarProducto(Producto producto);	//Guarda un producto CREATE
			
			public Producto productoXID(int codigo); //Leer datos de un producto READ
			
			public Producto actualizarProducto(Producto producto); //Actualiza datos del producto UPDATE
			
			public void eliminarProducto(int codigo);// Elimina el producto DELETE

}
