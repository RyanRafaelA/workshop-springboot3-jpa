package com.educandoweb.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
	
}
