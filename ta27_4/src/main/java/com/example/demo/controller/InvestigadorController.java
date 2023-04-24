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


import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {
	
	@Autowired
	InvestigadorServiceImpl investigadorService;
	
	@GetMapping("/investigador")
	public List<Investigador> listarInvestigadores(){
		return investigadorService.listarInvestigadores();
	}
	
	
	@PostMapping("/investigador")
	public Investigador guardarInvestigador(@RequestBody Investigador investigador) {
		
		return investigadorService.guardarInvestigador(investigador);
	}
	
	
	@GetMapping("/investigador/{nomApels}")
	public Investigador investigadorXID(@PathVariable(name="nomApels") String nomApels) {
		
		Investigador investigador_xid= new Investigador();
		
		investigador_xid=investigadorService.investigadorXID(nomApels);
		
		
		return investigador_xid;
	}
	
	@PutMapping("/investigador/{nomApels}")
	public Investigador actualizarInvestigador(@PathVariable(name="nomApels")String nomApels,@RequestBody Investigador investigador) {
		
		Investigador investigador_seleccionado= new Investigador();
		Investigador investigador_actualizado= new Investigador();
		
		investigador_seleccionado= investigadorService.investigadorXID(nomApels);
		
		investigador_seleccionado.setFacultad(investigador.getFacultad());
		investigador_seleccionado.setNomApels(investigador.getNomApels());
		investigador_seleccionado.setReservas(investigador.getReservas());
	
		
		
		investigador_seleccionado = investigadorService.actualizarInvestigador(investigador_seleccionado);
				
				
		
		
		return investigador_actualizado;
	}
	
	@DeleteMapping("/investigador/{nomApels}")
	public void eliminarInvestigador(@PathVariable(name="nomApels")String nomApels) {
		investigadorService.eliminarInvestigador(nomApels);
	}

}
