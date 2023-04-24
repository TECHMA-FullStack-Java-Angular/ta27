package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDao;
import com.example.demo.dto.Cientifico;

@Service
public class CientificoServiceImpl implements ICientificoService{
	
	@Autowired
	ICientificoDao iCientifico;

	@Override
	public List<Cientifico> listarCientificos() {
		
		return iCientifico.findAll();
	}

	@Override
	public Cientifico guardarCientifico(Cientifico cientifico) {
		
		return iCientifico.save(cientifico);
	}

	@Override
	public Cientifico cientificoXID(String dni) {
		
		return iCientifico.findById(dni).get();
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico cientifico) {
		
		return iCientifico.save(cientifico);
	}

	@Override
	public void eliminarCientifico(String dni) {
		iCientifico.deleteById(dni);
		
	}

}
