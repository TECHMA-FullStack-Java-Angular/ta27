package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Pieza;

public interface IPiezaDao extends JpaRepository<Pieza, Integer>{

}
