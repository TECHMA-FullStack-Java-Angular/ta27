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

import com.example.demo.dto.Facultad;
import com.example.demo.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {
	
	@Autowired
	FacultadServiceImpl facultadService;
	
	
	@GetMapping("/facultad")
	public List<Facultad> listarFacultad(){
		return facultadService.listarFacultad();
	}
	
	
	@PostMapping("/facultad")
	public Facultad guardarFacultad(@RequestBody Facultad facultad) {
		
		return facultadService.guardarFacultad(facultad);
	}
	
	
	@GetMapping("/facultad/{codigo}")
	public Facultad facultadXID(@PathVariable(name="codigo") int codigo) {
		
		Facultad facultad_xid= new Facultad();
		
		facultad_xid=facultadService.facultadXID(codigo);
		
		
		return facultad_xid;
	}
	
	@PutMapping("/facultad/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name="codigo")int codigo,@RequestBody Facultad facultad) {
		
		Facultad facultad_seleccionada= new Facultad();
		Facultad facultad_actualizada= new Facultad();
		
		facultad_seleccionada= facultadService.facultadXID(codigo);
		
		facultad_seleccionada.setEquipos(facultad.getEquipos());
		facultad_seleccionada.setInvestigadores(facultad.getInvestigadores());
		facultad_seleccionada.setNombre(facultad.getNombre());
	
		
		
		facultad_actualizada = facultadService.actualizarFacultad(facultad_seleccionada);
				
		
		
		return facultad_actualizada;
	}
	
	@DeleteMapping("/facultad/{codigo}")
	public void eliminarFacultad(@PathVariable(name="codigo")int codigo) {
		facultadService.eliminarFacultad(codigo);
	}

}
