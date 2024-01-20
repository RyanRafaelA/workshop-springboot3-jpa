package com.educandoweb.course.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entidades.Pedido;
import com.educandoweb.course.servicos.ServicoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso {
	
	@Autowired
	private ServicoPedido servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> encontraTudo(){
		List<Pedido> lista = servico.encontrarTudo();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> encontrarPorId(@PathVariable Long id){
		Pedido obj = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}