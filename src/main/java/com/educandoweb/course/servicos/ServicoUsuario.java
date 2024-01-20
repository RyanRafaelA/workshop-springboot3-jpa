package com.educandoweb.course.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entidades.Usuario;
import com.educandoweb.course.repositorios.RepositorioUsuario;
import com.educandoweb.course.servicos.excecao.BancoDadosExcecao;
import com.educandoweb.course.servicos.excecao.RecursoNaoEncontradoExcecao;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> encontrarTudo() {
		return repositorio.findAll();
	}

	public Usuario encontrarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));
	}

	public Usuario insercao(Usuario obj) {
		return repositorio.save(obj);
	}

	public void deletar(Long id) {
		try {
			repositorio.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		} catch(DataIntegrityViolationException e) {
			throw new BancoDadosExcecao(e.getMessage());
		}
	}

	public Usuario atualizar(Long id, Usuario obj) {
		try {
			Usuario entidade = repositorio.getReferenceById(id);
			atualizacaoDados(entidade, obj);
			return repositorio.save(entidade);
		}catch(EntityNotFoundException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
	}

	public void atualizacaoDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}
