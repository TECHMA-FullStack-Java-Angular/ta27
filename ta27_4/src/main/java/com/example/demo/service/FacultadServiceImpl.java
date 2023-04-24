package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFacultadDao;
import com.example.demo.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService{
	
	@Autowired
	IFacultadDao facultadDao;

	@Override
	public List<Facultad> listarFacultad() {
		
		return facultadDao.findAll();
	}

	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		
		return facultadDao.save(facultad);
	}

	@Override
	public Facultad facultadXID(int codigo) {
		
		return facultadDao.findById(codigo).get();
	}

	@Override
	public Facultad actualizarFacultad(Facultad facultad) {
		
		return facultadDao.save(facultad);
	}

	@Override
	public void eliminarFacultad(int codigo) {
		facultadDao.deleteById(codigo);
		
	}

}
