package com.prueba.tasf.services;

import java.util.List;

import com.prueba.tasf.entidades.Producto;

public interface IProductoService {
	
	public List<Producto> listarP();
	
	public void guardar(Producto p);
	
	public void eliminar(Producto p);
	
	public Producto buscarP(Producto p);
}
