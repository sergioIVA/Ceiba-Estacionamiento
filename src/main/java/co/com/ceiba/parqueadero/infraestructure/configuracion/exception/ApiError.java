package co.com.ceiba.parqueadero.infraestructure.configuracion.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError {

	@JsonProperty("status")
    private HttpStatus status;
    @JsonProperty("message")
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(error);
    }
    public List<String> getErrors(){
    	return new ArrayList<>(errors);
    }

	public HttpStatus getStatus() {
		return status;
	}
	public String getMessage() {
		return this.message;
	}
	
}
