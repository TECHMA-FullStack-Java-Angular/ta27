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

import com.example.demo.dto.Venta;
import com.example.demo.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {
	
	@Autowired
	VentaServiceImpl ventaService;
	
	
	@GetMapping("/venta")
	public List<Venta> listarVenta(){
		return ventaService.listarVenta();
	}
	
	
	@PostMapping("/venta")
	public Venta guardarVenta(@RequestBody Venta venta ) {
		
		return ventaService.guardarVenta(venta);
	}
	
	
	@GetMapping("/venta/{id}")
	public Venta ventaXID(@PathVariable(name="id") int codigo) {
		
		Venta venta_xid= new Venta();
		
		venta_xid= ventaService.ventaXID(codigo);
		
		
		return venta_xid;
	}
	
	@PutMapping("/venta/{id}")
	public Venta actualizarVenta(@PathVariable(name="id")int codigo,@RequestBody Venta venta) {
		
		Venta venta_seleccionada= new Venta();
		Venta venta_actualizada= new Venta();
		
		venta_seleccionada = ventaService.ventaXID(codigo);
		
		venta_seleccionada.setCajero(venta.getCajero());
		venta_seleccionada.setMaquina(venta.getMaquina());
		venta_seleccionada.setProducto(venta.getProducto());

		
		venta_actualizada =  ventaService.actualizarVenta(venta_seleccionada);
				
		
		
		return venta_actualizada;
	}
	
	@DeleteMapping("/venta/{id}")
	public void eliminarVenta(@PathVariable(name="id")int codigo) {
		ventaService.eliminarVenta(codigo);
	}


}
