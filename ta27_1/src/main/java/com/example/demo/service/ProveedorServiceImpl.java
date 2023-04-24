package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedorDao;
import com.example.demo.dto.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService{
	
	@Autowired
	IProveedorDao iProveedor;

	@Override
	public List<Proveedor> listarProveedors() {
		
		return iProveedor.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		
		return iProveedor.save(proveedor);
	}

	@Override
	public Proveedor proveedorXID(String id) {
		
		return iProveedor.findById(id).get();
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		
		return iProveedor.save(proveedor);
	}

	@Override
	public void eliminarProveedor(String id) {
		iProveedor.deleteById(id);
		
	}

}
