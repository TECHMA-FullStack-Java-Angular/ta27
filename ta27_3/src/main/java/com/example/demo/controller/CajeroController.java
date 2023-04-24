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

import com.example.demo.dto.Cajero;
import com.example.demo.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {
	
	@Autowired
	CajeroServiceImpl cajeroService;
	
	@GetMapping("/cajero")
	public List<Cajero> listarCajeros(){
		return cajeroService.listarCajeros();
	}
	
	
	@PostMapping("/cajero")
	public Cajero guardarCajero(@RequestBody Cajero cajero) {
		
		return cajeroService.guardarCajero(cajero);
	}
	
	
	@GetMapping("/cajero/{id}")
	public Cajero cajeroXID(@PathVariable(name="id") int codigo) {
		
		Cajero Cajero_xid= new Cajero();
		
		Cajero_xid=cajeroService.cajeroXID(codigo);
		
		
		return Cajero_xid;
	}
	
	@PutMapping("/cajero/{id}")
	public Cajero actualizarCientifico(@PathVariable(name="id")int codigo,@RequestBody Cajero cajero) {
		
		Cajero Cajero_seleccionado= new Cajero();
		Cajero Cajero_actualizado= new Cajero();
		
		Cajero_seleccionado= cajeroService.cajeroXID(codigo);
		
		Cajero_seleccionado.setNomApels(cajero.getNomApels());
		Cajero_seleccionado.setVenta(cajero.getVenta());
		
		
		Cajero_actualizado =  cajeroService.actualizarCajero(Cajero_seleccionado);
				
		
		
		return Cajero_actualizado;
	}
	
	@DeleteMapping("/cajero/{id}")
	public void eliminarCajero(@PathVariable(name="id")int codigo) {
		cajeroService.eliminarCajero(codigo);
	}

}
