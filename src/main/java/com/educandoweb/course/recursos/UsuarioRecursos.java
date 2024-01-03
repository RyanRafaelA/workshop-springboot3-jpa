package com.educandoweb.course.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {
	
	@GetMapping
	public ResponseEntity<Usuario> encontraTudo(){
		Usuario u = new Usuario(1L, "Maira", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
	}

}