package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.dto.Investigador;

public interface IInvestigadorDao extends JpaRepository<Investigador, String>{

}
