package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDao;
import com.example.demo.dto.Proyecto;

@Service
public class ProyectoServiceImpl implements IProyectoService{
	
	@Autowired
	IProyectoDao iProyecto;

	@Override
	public List<Proyecto> listarProyecto() {
		
		return iProyecto.findAll();
	}

	@Override
	public Proyecto guardarProyecto(Proyecto proyecto) {
		
		return iProyecto.save(proyecto);
	}

	@Override
	public Proyecto proyectoXID(String id) {
		
		return iProyecto.findById(id).get();
	}

	@Override
	public Proyecto actualizarProyecto(Proyecto proyecto) {
		
		return iProyecto.save(proyecto);
	}

	@Override
	public void eliminarProyecto(String id) {
		iProyecto.deleteById(id);
		
	}

}
