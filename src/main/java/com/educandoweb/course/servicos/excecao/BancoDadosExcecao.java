package com.educandoweb.course.servicos.excecao;

public class BancoDadosExcecao extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BancoDadosExcecao(String msg) {
		super(msg);
	}
}
