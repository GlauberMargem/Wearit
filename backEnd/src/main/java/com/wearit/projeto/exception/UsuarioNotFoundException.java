package com.wearit.projeto.exception;

public class UsuarioNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(String mensagem) {
        super(mensagem);
    }
}
