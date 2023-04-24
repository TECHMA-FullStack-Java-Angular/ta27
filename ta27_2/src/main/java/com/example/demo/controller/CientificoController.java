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

import com.example.demo.dto.Cientifico;
import com.example.demo.service.CientificoServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificoController {
	
	@Autowired
	CientificoServiceImpl cientificoService;
	
	@GetMapping("/cientifico")
	public List<Cientifico> listarCientificos(){
		return cientificoService.listarCientificos();
	}
	
	
	@PostMapping("/cientifico")
	public Cientifico guardarCientifico(@RequestBody Cientifico cientifico) {
		
		return cientificoService.guardarCientifico(cientifico);
	}
	
	
	@GetMapping("/cientifico/{id}")
	public Cientifico cientificoXID(@PathVariable(name="id") String dni) {
		
		Cientifico Cientifico_xid= new Cientifico();
		
		Cientifico_xid=cientificoService.cientificoXID(dni);
		
		
		return Cientifico_xid;
	}
	
	@PutMapping("/cientifico/{id}")
	public Cientifico actualizarCientifico(@PathVariable(name="id")String dni,@RequestBody Cientifico cientifico) {
		
		Cientifico Cientifico_seleccionado= new Cientifico();
		Cientifico Cientifico_actualizado= new Cientifico();
		
		Cientifico_seleccionado= cientificoService.cientificoXID(dni);
		
		Cientifico_seleccionado.setDni(cientifico.getDni());
		Cientifico_seleccionado.setNomApels(cientifico.getNomApels());
		Cientifico_seleccionado.setAsignado(cientifico.getAsignado());
		
		
		Cientifico_actualizado = cientificoService.actualizarCientifico(Cientifico_seleccionado);
				
		
		
		return Cientifico_actualizado;
	}
	
	@DeleteMapping("/cientifico/{id}")
	public void eleiminarCientifico(@PathVariable(name="id")String dni) {
		cientificoService.eliminarCientifico(dni);
	}


}
