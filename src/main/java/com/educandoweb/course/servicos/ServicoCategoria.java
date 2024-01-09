package com.educandoweb.course.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entidades.Categoria;
import com.educandoweb.course.repositorios.RepositorioCategoria;

@Service
public class ServicoCategoria {
	
	@Autowired
	private RepositorioCategoria repositorio;
	
	public List<Categoria> encontrarTudo(){
		return repositorio.findAll();
	}
	
	public Categoria encontrarPorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
}
