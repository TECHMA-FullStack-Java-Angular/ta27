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

import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	
	@Autowired
	ProyectoServiceImpl proyectoService;
	
	@GetMapping("/proyecto")
	public List<Proyecto> listarProyecto(){
		return proyectoService.listarProyecto();
	}
	
	
	@PostMapping("/proyecto")
	public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
		
		return proyectoService.guardarProyecto(proyecto);
	}
	
	
	@GetMapping("/proyecto/{id}")
	public Proyecto proyectoXID(@PathVariable(name="id") String id) {
		
		Proyecto Proyecto_xid= new Proyecto();
		
		Proyecto_xid=proyectoService.proyectoXID(id);
		
		
		return Proyecto_xid;
	}
	
	@PutMapping("/proyecto/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")String id,@RequestBody Proyecto proyecto) {
		
		Proyecto Proyecto_seleccionado= new Proyecto();
		Proyecto Proyecto_actualizado= new Proyecto();
		
		Proyecto_seleccionado= proyectoService.proyectoXID(id);
		
		Proyecto_seleccionado.setId(proyecto.getId());
		Proyecto_seleccionado.setNombre(proyecto.getNombre());
		Proyecto_seleccionado.setHoras(proyecto.getHoras());
		Proyecto_seleccionado.setAsignado(proyecto.getAsignado());
		
		
		Proyecto_actualizado = proyectoService.actualizarProyecto(Proyecto_seleccionado);
				
		
		
		return Proyecto_actualizado;
	}
	
	@DeleteMapping("/proyecto/{id}")
	public void eleiminarCientifico(@PathVariable(name="id")String dni) {
		proyectoService.eliminarProyecto(dni);
	}


}
