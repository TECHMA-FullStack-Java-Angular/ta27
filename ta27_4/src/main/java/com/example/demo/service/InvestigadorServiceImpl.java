package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IInvestigadorDao;
import com.example.demo.dto.Investigador;

@Service
public class InvestigadorServiceImpl implements IInvestigadorService{
	
	@Autowired
	IInvestigadorDao investigadorDao;

	@Override
	public List<Investigador> listarInvestigadores() {
		
		return investigadorDao.findAll();
	}

	@Override
	public Investigador guardarInvestigador(Investigador investigador) {
		
		return investigadorDao.save(investigador);
	}

	@Override
	public Investigador investigadorXID(String nomApels) {
		
		return investigadorDao.findById(nomApels).get();
	}

	@Override
	public Investigador actualizarInvestigador(Investigador investigador) {
		
		return investigadorDao.save(investigador);
	}

	@Override
	public void eliminarInvestigador(String nomApels) {
		investigadorDao.deleteById(nomApels);
		
	}

}
