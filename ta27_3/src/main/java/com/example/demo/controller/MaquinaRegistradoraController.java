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

import com.example.demo.dto.MaquinaRegistradora;

import com.example.demo.service.MaquinaRegistradoraServiceimpl;

@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {
	
	@Autowired
	MaquinaRegistradoraServiceimpl maquinaService;
	
	@GetMapping("/maquina")
	public List<MaquinaRegistradora> listarMaquinaRegistradora(){
		return maquinaService.listarMaquinaRegistradora();
	}
	
	
	@PostMapping("/maquina")
	public MaquinaRegistradora guardarMaquinaRegistradora(@RequestBody MaquinaRegistradora maquina ) {
		
		return maquinaService.guardarMaquinaRegistradora(maquina);
	}
	
	
	@GetMapping("/maquina/{id}")
	public MaquinaRegistradora maquinaRegistradoraXID(@PathVariable(name="id") int codigo) {
		
		MaquinaRegistradora maquina_xid= new MaquinaRegistradora();
		
		maquina_xid=maquinaService.maquinaRegistradoraXID(codigo);
		
		
		return maquina_xid;
	}
	
	@PutMapping("/maquina/{id}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name="id")int codigo,@RequestBody MaquinaRegistradora maquina) {
		
		MaquinaRegistradora maquina_seleccionada= new MaquinaRegistradora();
		MaquinaRegistradora maquina_actualizada= new MaquinaRegistradora();
		
		maquina_seleccionada= maquinaService.maquinaRegistradoraXID(codigo);
		
		maquina_seleccionada.setPiso(maquina.getPiso());
		maquina_seleccionada.setVenta(maquina.getVenta());
		
		
		maquina_actualizada =  maquinaService.actualizarMaquinaRegistradora(maquina_seleccionada);
				
		
		
		return maquina_actualizada;
	}
	
	@DeleteMapping("/maquina/{id}")
	public void eliminarMaquinaRegistradora(@PathVariable(name="id")int codigo) {
		maquinaService.eliminarMaquinaRegistradora(codigo);
	}



}
