package co.com.ceiba.parqueadero.infraestructure.persistencia.exception;

public class NotContentException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NotContentException(String msg) {
		super(msg);
	}

}
