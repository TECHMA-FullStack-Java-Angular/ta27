package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductoDao;
import com.example.demo.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	IProductoDao iProducto;

	@Override
	public List<Producto> listarProductos() {
		
		return iProducto.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		
		return iProducto.save(producto);
	}

	@Override
	public Producto productoXID(int codigo) {
		
		return iProducto.findById(codigo).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		
		return iProducto.save(producto);
	}

	@Override
	public void eliminarProducto(int codigo) {
		iProducto.deleteById(codigo);
		
	}

}
