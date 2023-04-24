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

import com.example.demo.dto.Asignado;

import com.example.demo.service.AsignadoServiceImpl;

@RestController
@RequestMapping("/api")
public class AsignadoController {
	
	@Autowired
	AsignadoServiceImpl asignadoService;
	
	@GetMapping("/asignado")
	public List<Asignado> listarAsignado(){
		return asignadoService.listarAsignado();
	}
	
	
	@PostMapping("/asignado")
	public Asignado guardarAsignado(@RequestBody Asignado asignado) {
		
		return asignadoService.guardarAsignado(asignado);
	}
	
	
	@GetMapping("/asignado/{id}")
	public Asignado asignadoXID(@PathVariable(name="id") int id) {
		
		Asignado Asignado_xid= new Asignado();
		
		Asignado_xid=asignadoService.asignadoXID(id);
		
		
		return Asignado_xid;
	}
	
	@PutMapping("/asignado/{id}")
	public Asignado actualizarAsignado(@PathVariable(name="id")int id,@RequestBody Asignado asignado) {
		
		Asignado Asignado_seleccionado= new Asignado();
		Asignado Asignado_actualizado= new Asignado();
		
		Asignado_seleccionado= asignadoService.asignadoXID(id);
		
		Asignado_seleccionado.setPrecio(asignado.getPrecio());
		Asignado_seleccionado.setCientifico(asignado.getCientifico());
		Asignado_seleccionado.setProyecto(asignado.getProyecto());
		
		
		Asignado_actualizado =  asignadoService.actualizarAsignado(Asignado_seleccionado);
				
		
		
		return Asignado_actualizado;
	}
	
	@DeleteMapping("/asignado/{id}")
	public void eliminarAsignado(@PathVariable(name="id")int id) {
		asignadoService.eliminarAsignado(id);
	}



}
