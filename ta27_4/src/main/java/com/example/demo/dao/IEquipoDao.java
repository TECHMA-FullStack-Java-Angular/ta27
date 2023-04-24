package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Equipo;



public interface IEquipoDao extends JpaRepository<Equipo, String>{

}
