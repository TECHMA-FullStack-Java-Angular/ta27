package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservaDao;
import com.example.demo.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{
	
	@Autowired
	IReservaDao reservaDao;

	@Override
	public List<Reserva> listarReservas() {
		
		return reservaDao.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		
		return reservaDao.save(reserva);
	}

	@Override
	public Reserva reservaXID(int id) {
		
		return reservaDao.findById(id).get();
	}

	@Override
	public Reserva actualizarFacultad(Reserva reserva) {
		
		return reservaDao.save(reserva);
	}

	@Override
	public void eliminarReserva(int id) {
		reservaDao.deleteById(id);
		
	}

}
