package com.educandoweb.course.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entidades.Categoria;
import com.educandoweb.course.servicos.ServicoCategoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {
	
	@Autowired
	private ServicoCategoria servico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> encontraTudo(){
		List<Categoria> lista = servico.encontrarTudo();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> encontrarPorId(@PathVariable Long id){
		Categoria obj = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}