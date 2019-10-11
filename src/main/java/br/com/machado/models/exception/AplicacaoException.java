package br.com.machado.models.exception;

public class AplicacaoException extends RuntimeException {

	private static final long serialVersionUID = -4208575096105465333L;
	
	
	public AplicacaoException() {}
	
	public AplicacaoException(String msg) {
		super(msg);
	}
	
	public AplicacaoException(Throwable thr) {
		super(thr);
	}
	
	public AplicacaoException(String msg, Throwable thr) {
		super(msg, thr);
	}

}
