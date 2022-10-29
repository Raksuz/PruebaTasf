package com.prueba.tasf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.tasf.entidades.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
}
