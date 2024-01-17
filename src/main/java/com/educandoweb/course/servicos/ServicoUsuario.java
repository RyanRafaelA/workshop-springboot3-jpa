package com.educandoweb.course.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entidades.Usuario;
import com.educandoweb.course.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	public List<Usuario> encontrarTudo(){
		return repositorio.findAll();
	}
	
	public Usuario encontrarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Usuario insercao(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario obj) {
		Usuario entidade = repositorio.getReferenceById(id);
		atualizacaoDados(entidade, obj);
		return repositorio.save(entidade);
	}
	
	public void atualizacaoDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}
