package com.educandoweb.course.recursos.excecao;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.servicos.excecao.BancoDadosExcecao;
import com.educandoweb.course.servicos.excecao.RecursoNaoEncontradoExcecao;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RecursoIdentificadorExcecao {

	@ExceptionHandler(RecursoNaoEncontradoExcecao.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoExcecao e, HttpServletRequest solicitar){
		String erro = "Recurso não encontyrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), solicitar.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(BancoDadosExcecao.class)
	public ResponseEntity<ErroPadrao> bancoDados(BancoDadosExcecao e, HttpServletRequest solicitar){
		String erro = "Banco de Dados erro";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), solicitar.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
