package com.example.demo.service;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IUsuarioDao;
import com.example.demo.dto.User;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	
	public UsuarioDetailsServiceImpl(IUsuarioDao iUsuarioDAO) {
		this.usuarioDao = iUsuarioDAO;
	}

	// Load user details by username
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User usuario = usuarioDao.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UsuarioDetailsServiceImpl.build(usuario);
	}
	
}
