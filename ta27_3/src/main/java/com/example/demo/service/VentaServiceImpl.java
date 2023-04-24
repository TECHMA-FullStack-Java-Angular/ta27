package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVentaDao;
import com.example.demo.dto.Venta;

@Service
public class VentaServiceImpl implements IVentaService{
	
	@Autowired
	IVentaDao iVenta;

	@Override
	public List<Venta> listarVenta() {
		
		return iVenta.findAll();
	}

	@Override
	public Venta guardarVenta(Venta venta) {
		
		return iVenta.save(venta);
	}

	@Override
	public Venta ventaXID(int id) {
		
		return iVenta.findById(id).get();
	}

	@Override
	public Venta actualizarVenta(Venta venta) {
		
		return iVenta.save(venta);
	}

	@Override
	public void eliminarVenta(int id) {
		iVenta.deleteById(id);
		
	}

}
