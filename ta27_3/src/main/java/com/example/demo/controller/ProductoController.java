package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.Producto;
import com.example.demo.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductoServiceImpl productoService;
	
	@GetMapping("/produco")
	public List<Producto> listarProductos(){
		return productoService.listarProductos();
	}
	
	
	@PostMapping("/produco")
	public Producto guardarProducto(@RequestBody Producto producto ) {
		
		return productoService.guardarProducto(producto);
	}
	
	
	@GetMapping("/produco/{id}")
	public Producto productoXID(@PathVariable(name="id") int codigo) {
		
		Producto Producto_xid= new Producto();
		
		Producto_xid=productoService.productoXID(codigo);
		
		
		return Producto_xid;
	}
	
	@PutMapping("/produco/{id}")
	public Producto actualizarProducto(@PathVariable(name="id")int codigo,@RequestBody Producto producto) {
		
		Producto Producto_seleccionado= new Producto();
		Producto Producto_actualizado= new Producto();
		
		Producto_seleccionado= productoService.productoXID(codigo);
		
		Producto_seleccionado.setNombre(producto.getNombre());
		Producto_seleccionado.setPrecio(producto.getPrecio());
		Producto_seleccionado.setVenta(producto.getVenta());
		
		
		Producto_actualizado =  productoService.actualizarProducto(Producto_seleccionado);
				
		
		
		return Producto_actualizado;
	}
	
	@DeleteMapping("/produco/{id}")
	public void eliminarProducto(@PathVariable(name="id")int codigo) {
		productoService.eliminarProducto(codigo);
	}

}
