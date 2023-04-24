package com.example.demo.service;

import static java.util.Collections.emptyList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsuarioDao;
import com.example.demo.dto.Usuario;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService{

	
	private IUsuarioDao usuarioDao;
	
	
	public UsuarioDetailsServiceImpl(IUsuarioDao iUsuarioDAO) {
		this.usuarioDao = iUsuarioDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
	}
	
}
