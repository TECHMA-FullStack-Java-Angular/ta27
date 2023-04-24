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


import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {
	
	@Autowired
	SuministraServiceImpl suministraService;
	
	@GetMapping("/suministra")
	public List<Suministra> listarSuministras(){
		return suministraService.listarSuministras();
	}
	
	
	@PostMapping("/suministra")
	public Suministra guardarSuministra(@RequestBody Suministra suministra) {
		
		return suministraService.guardarSuministra(suministra);
	}
	
	
	@GetMapping("/suministra/{id}")
	public Suministra suministraXID(@PathVariable(name="id") int id) {
		
		Suministra Suministra_xid= new Suministra();
		
		Suministra_xid=suministraService.suministraXID(id);
		
		
		return Suministra_xid;
	}
	
	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name="id")int id,@RequestBody Suministra suministra) {
		
		Suministra Suministra_seleccionada= new Suministra();
		Suministra Suministra_actualizada= new Suministra();
		
		Suministra_seleccionada= suministraService.suministraXID(id);
		
		Suministra_seleccionada.setPieza(suministra.getPieza());
		Suministra_seleccionada.setPrecio(suministra.getPrecio());
		Suministra_seleccionada.setProveedor(suministra.getProveedor());
		
		
		Suministra_actualizada = suministraService.actualizarSuministra(Suministra_seleccionada);
				
		
		
		return Suministra_actualizada;
	}
	
	@DeleteMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable(name="id")int id) {
		suministraService.eliminarSuministra(id);
	}

}
