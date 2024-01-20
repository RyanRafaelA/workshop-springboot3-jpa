package com.educandoweb.course.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entidades.ItemPedido;
import com.educandoweb.course.entidades.pk.ItemPedidoPK;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido, ItemPedidoPK>{
	
}
