package com.prueba.tasf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.tasf.entidades.Producto;

public interface ProductoRepo extends JpaRepository<Producto, Integer>{

}
