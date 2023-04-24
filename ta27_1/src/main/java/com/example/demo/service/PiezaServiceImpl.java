package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezaDao;
import com.example.demo.dto.Pieza;

@Service
public class PiezaServiceImpl implements IPiezaService{
	
	@Autowired
	IPiezaDao iPieza;

	@Override
	public List<Pieza> listarPiezas() {
		
		return iPieza.findAll();
	}

	@Override
	public Pieza guardarPieza(Pieza pieza) {
		
		return iPieza.save(pieza);
	}

	@Override
	public Pieza piezaXID(int codigo) {
		
		return iPieza.findById(codigo).get();
	}

	@Override
	public Pieza actualizarPieza(Pieza pieza) {
		
		return iPieza.save(pieza);
	}

	@Override
	public void eliminarPieza(int codigo) {
		iPieza.deleteById(codigo);
		
	}

}
