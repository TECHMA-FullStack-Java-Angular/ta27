package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Venta;

public interface IVentaDao extends JpaRepository<Venta, Integer>{

}
