package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	
	Usuario findByUsername(String username);

}
