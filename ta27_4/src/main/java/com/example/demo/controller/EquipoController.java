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

import com.example.demo.dto.Equipo;
import com.example.demo.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {
	
	@Autowired
	EquipoServiceImpl equipoService;
	
	
	@GetMapping("/equipo")
	public List<Equipo> listarEquipos(){
		return equipoService.listarEquipos();
	}
	
	
	@PostMapping("/equipo")
	public Equipo guardarEquipo(@RequestBody Equipo equipo) {
		
		return equipoService.guardarEquipo(equipo);
	}
	
	
	@GetMapping("/equipo/{numSerie}")
	public Equipo equipoXID(@PathVariable(name="numSerie") String numSerie) {
		
		Equipo equipo_xid= new Equipo();
		
		equipo_xid=equipoService.equipoXID(numSerie);
		
		
		return equipo_xid;
	}
	
	@PutMapping("/equipo/{numSerie}")
	public Equipo actualizarEquipo(@PathVariable(name="numSerie")String numSerie,@RequestBody Equipo equipo) {
		
		Equipo equipo_seleccionado= new Equipo();
		Equipo equipo_actualizado= new Equipo();
		
		equipo_seleccionado= equipoService.equipoXID(numSerie);
		
		equipo_seleccionado.setReservas(equipo.getReservas());
		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setFacultad(equipo.getFacultad());
	
		
		
		equipo_actualizado = equipoService.actualizarEquipo(equipo_seleccionado);
				
		
		
		return equipo_actualizado;
	}
	
	@DeleteMapping("/equipo/{numSerie}")
	public void eliminarEquipo(@PathVariable(name="numSerie")String numSerie) {
		equipoService.eliminarEquipo(numSerie);
	}

}
