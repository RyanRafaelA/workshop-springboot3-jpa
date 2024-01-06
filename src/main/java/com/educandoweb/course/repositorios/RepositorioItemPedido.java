package com.educandoweb.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entidades.ItemPedido;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido, Long>{
	
}
