package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAsignadoDao;
import com.example.demo.dto.Asignado;

@Service
public class AsignadoServiceImpl implements IAsignadoService{
	
	@Autowired
	IAsignadoDao iAsignado;

	@Override
	public List<Asignado> listarAsignado() {
		
		return iAsignado.findAll();
	}

	@Override
	public Asignado guardarAsignado(Asignado asignado) {
		
		return iAsignado.save(asignado);
	}

	@Override
	public Asignado asignadoXID(int id) {
		
		return iAsignado.findById(id).get();
	}

	@Override
	public Asignado actualizarAsignado(Asignado asignado) {
		
		return iAsignado.save(asignado);
	}

	@Override
	public void eliminarAsignado(int id) {
		iAsignado.deleteById(id);
		
	}

}
