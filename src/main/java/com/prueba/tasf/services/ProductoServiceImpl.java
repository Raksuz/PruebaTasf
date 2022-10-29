package com.prueba.tasf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.tasf.entidades.Producto;
import com.prueba.tasf.repositories.ProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private ProductoRepo productoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> listarP() {
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	@Transactional
	public void guardar(Producto p) {
		productoRepository.save(p);
	}

	@Override
	@Transactional
	public void eliminar(Producto p) {
		productoRepository.delete(p);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto buscarP(Producto p) {
		return productoRepository.findById(p.getId()).orElse(null);
	}
	
}
