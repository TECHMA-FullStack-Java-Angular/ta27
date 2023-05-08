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

import com.example.demo.dto.Pieza;
import com.example.demo.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {
	
	@Autowired
	PiezaServiceImpl piezaService;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/pieza")
	public List<Pieza> listarPieza(){
		return piezaService.listarPiezas();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/pieza")
	public Pieza guardarPieza(@RequestBody Pieza pieza) {
		
		return piezaService.guardarPieza(pieza);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/pieza/{id}")
	public Pieza piezaXID(@PathVariable(name="id") int codigo) {
		
		Pieza Pieza_xid= new Pieza();
		
		Pieza_xid=piezaService.piezaXID(codigo);
		
		
		return Pieza_xid;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/pieza/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")int codigo,@RequestBody Pieza pieza) {
		
		Pieza Pieza_seleccionada= new Pieza();
		Pieza Pieza_actualizada= new Pieza();
		
		Pieza_seleccionada= piezaService.piezaXID(codigo);
		
		Pieza_seleccionada.setCodigo(pieza.getCodigo());
		Pieza_seleccionada.setNombrePieza(pieza.getNombrePieza());
		Pieza_seleccionada.setSuministra(pieza.getSuministra());
		
		
		Pieza_actualizada = piezaService.actualizarPieza(Pieza_seleccionada);
				
		
		
		return Pieza_actualizada;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/pieza/{id}")
	public void eliminarPieza(@PathVariable(name="id")int codigo) {
		piezaService.eliminarPieza(codigo);
	}

}
