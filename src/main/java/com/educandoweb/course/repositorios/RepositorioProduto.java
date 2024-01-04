package com.educandoweb.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entidades.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long>{
	
}
