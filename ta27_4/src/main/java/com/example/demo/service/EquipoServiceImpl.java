package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquipoDao;
import com.example.demo.dto.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService{
	
	@Autowired
	IEquipoDao equipoDao;

	@Override
	public List<Equipo> listarEquipos() {
		
		return equipoDao.findAll();
	}

	@Override
	public Equipo guardarEquipo(Equipo equipo) {
		
		return equipoDao.save(equipo);
	}

	@Override
	public Equipo equipoXID(String numSerie) {
		
		return equipoDao.findById(numSerie).get();
	}

	@Override
	public Equipo actualizarEquipo(Equipo equipo) {
		
		return equipoDao.save(equipo);
	}

	@Override
	public void eliminarEquipo(String numSerie) {
		equipoDao.deleteById(numSerie);
		
	}

}
