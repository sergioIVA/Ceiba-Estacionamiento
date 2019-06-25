package co.com.ceiba.parqueadero.domain.exception;

public class AccesoDenegadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccesoDenegadoException(String msg) {
		super(msg);
	}
}
