package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISuministraDao;
import com.example.demo.dto.Suministra;

@Service
public class SuministraServiceImpl implements ISuministraService{
	
	@Autowired
	ISuministraDao iSuministra;

	@Override
	public List<Suministra> listarSuministras() {
		
		return iSuministra.findAll();
	}

	@Override
	public Suministra guardarSuministra(Suministra suministra) {
		
		return iSuministra.save(suministra);
	}

	@Override
	public Suministra suministraXID(int id) {
		
		return iSuministra.findById(id).get();
	}

	@Override
	public Suministra actualizarSuministra(Suministra suministra) {
		
		return iSuministra.save(suministra);
	}

	@Override
	public void eliminarSuministra(int id) {
		iSuministra.deleteById(id);
		
	}

}
