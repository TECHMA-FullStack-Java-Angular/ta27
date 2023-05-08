package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.Proveedor;
import com.example.demo.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	ProveedorServiceImpl proveedorService;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/proveedor")
	public List<Proveedor> listarProveedors(){
		return proveedorService.listarProveedors();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/proveedor")
	public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
		
		return proveedorService.guardarProveedor(proveedor);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/proveedor/{id}")
	public Proveedor proveedorXID(@PathVariable(name="id") String id) {
		
		Proveedor Proveedor_xid= new Proveedor();
		
		Proveedor_xid=proveedorService.proveedorXID(id);
		
		
		return Proveedor_xid;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/proveedor/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id")String id,@RequestBody Proveedor proveedor) {
		
		Proveedor Proveedor_seleccionado= new Proveedor();
		Proveedor Proveedor_actualizado= new Proveedor();
		
		Proveedor_seleccionado= proveedorService.proveedorXID(id);
		
		Proveedor_seleccionado.setNombreProveedor(proveedor.getNombreProveedor());
		Proveedor_seleccionado.setSuministra(proveedor.getSuministra());
		
		
		
		Proveedor_actualizado = proveedorService.actualizarProveedor(Proveedor_seleccionado);
				
		
		
		return Proveedor_actualizado;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/proveedor/{id}")
	public void eliminarProveedor(@PathVariable(name="id")String id) {
		proveedorService.eliminarProveedor(id);
	}

}
