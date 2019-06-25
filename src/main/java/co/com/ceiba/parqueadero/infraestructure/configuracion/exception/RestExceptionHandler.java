package co.com.ceiba.parqueadero.infraestructure.configuracion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import co.com.ceiba.parqueadero.domain.exception.AccesoDenegadoException;
import co.com.ceiba.parqueadero.domain.exception.TipoVehiculoIncompatibleException;
import co.com.ceiba.parqueadero.infraestructure.persistencia.exception.NotContentException;
import co.com.ceiba.parqueadero.infraestructure.persistencia.exception.NotFoundException;



@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFound(NotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), "");
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ExceptionHandler(NotContentException.class)
	public ResponseEntity<Object> handleNotContent(NotContentException ex) {
		ApiError apiError = new ApiError(HttpStatus.NO_CONTENT, ex.getMessage(), "");
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ExceptionHandler(AccesoDenegadoException.class)
	public ResponseEntity<Object> handleDanyAccess(AccesoDenegadoException ex) {
		ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, ex.getMessage(), "");
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ExceptionHandler(TipoVehiculoIncompatibleException.class)
	public ResponseEntity<Object> handleIncompatibleVehicle(TipoVehiculoIncompatibleException ex) {
		ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, ex.getMessage(), "");
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}


}
