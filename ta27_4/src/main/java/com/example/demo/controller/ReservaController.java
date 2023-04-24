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

import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	ReservaServiceImpl reservaService;
	
	@GetMapping("/reserva")
	public List<Reserva> listarReservas(){
		return reservaService.listarReservas();
	}
	
	
	@PostMapping("/reserva")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		
		return reservaService.guardarReserva(reserva);
	}
	
	
	@GetMapping("/reserva/{id}")
	public Reserva reservaXID(@PathVariable(name="id") int id) {
		
		Reserva reserva_xid= new Reserva();
		
		reserva_xid=reservaService.reservaXID(id);
		
		
		return reserva_xid;
	}
	
	@PutMapping("/reserva/{id}")
	public Reserva actualizarFacultad(@PathVariable(name="id")int id,@RequestBody Reserva reserva) {
		
		Reserva reserva_seleccionada= new Reserva();
		Reserva reserva_actualizada= new Reserva();
		
		reserva_seleccionada= reservaService.reservaXID(id);
		
		reserva_seleccionada.setEquipo(reserva.getEquipo());
		reserva_seleccionada.setInvestigador(reserva.getInvestigador());
		reserva_seleccionada.setComienzo(reserva.getComienzo());
		reserva_seleccionada.setFin(reserva.getFin());
	
		
		
		reserva_actualizada = reservaService.actualizarFacultad(reserva_seleccionada);
				
		
		
		return reserva_actualizada;
	}
	
	@DeleteMapping("/reserva/{id}")
	public void eliminarReserva(@PathVariable(name="id")int id) {
		reservaService.eliminarReserva(id);
	}

}
