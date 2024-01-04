package com.educandoweb.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entidades.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long>{
	
}
