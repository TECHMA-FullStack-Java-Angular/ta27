package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinaRegistradoraDao;
import com.example.demo.dto.MaquinaRegistradora;

@Service
public class MaquinaRegistradoraServiceimpl implements IMaquinaRegistradoraService{
	
	@Autowired
	IMaquinaRegistradoraDao iMaquina;

	@Override
	public List<MaquinaRegistradora> listarMaquinaRegistradora() {
		
		return iMaquina.findAll();
	}

	@Override
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		
		return iMaquina.save(maquinaRegistradora);
	}

	@Override
	public MaquinaRegistradora maquinaRegistradoraXID(int codigo) {
		
		return iMaquina.findById(codigo).get();
	}

	@Override
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		
		return iMaquina.save(maquinaRegistradora);
	}

	@Override
	public void eliminarMaquinaRegistradora(int codigo) {
		iMaquina.deleteById(codigo);
		
	}

}
