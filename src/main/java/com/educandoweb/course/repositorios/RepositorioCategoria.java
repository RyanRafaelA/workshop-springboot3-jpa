package com.educandoweb.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entidades.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long>{
	
}
