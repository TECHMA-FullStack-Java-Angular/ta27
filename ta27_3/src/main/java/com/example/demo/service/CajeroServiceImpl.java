package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajeroDao;
import com.example.demo.dto.Cajero;

@Service
public class CajeroServiceImpl implements ICajeroService{
	
	@Autowired
	ICajeroDao iCajero;

	@Override
	public List<Cajero> listarCajeros() {
		
		return iCajero.findAll();
	}

	@Override
	public Cajero guardarCajero(Cajero cajero) {
		
		return iCajero.save(cajero);
	}

	@Override
	public Cajero cajeroXID(int codigo) {
		
		return iCajero.findById(codigo).get();
	}

	@Override
	public Cajero actualizarCajero(Cajero cajero) {
		
		return iCajero.save(cajero);
	}

	@Override
	public void eliminarCajero(int codigo) {
		iCajero.deleteById(codigo);
		
	}

}
