package com.elabbora.cursomc.services.exception;

//Classe criada para tratar exceções aproveitando a infraestrutura pronta
public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}

	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
