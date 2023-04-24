package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.dto.Reserva;

public interface IReservaDao extends JpaRepository<Reserva, Integer>{

}
