package co.com.ceiba.parqueadero.domain.exception;

public class TipoVehiculoIncompatibleException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TipoVehiculoIncompatibleException(String msg) {
		super(msg);
	}


}
