package co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.parqueadero.aplication.service.PuestoService;
import co.com.ceiba.parqueadero.domain.model.Puesto;



@RestController
@RequestMapping("/puesto")
public class PuestoController {
	
	private PuestoService puestoService;
	
	public PuestoController(PuestoService puestoService) {
		this.puestoService = puestoService;
	}

	@GetMapping("/listar-puestos")
	public ResponseEntity<List<Puesto>> listarPuestos() {
		return new ResponseEntity<>(puestoService.listarPuestos(), HttpStatus.OK);  //ok
	}
	
	@GetMapping("/listado-puestos-libres")
	public ResponseEntity<List<Puesto>> listarPuestosLibres() {
		return new ResponseEntity<>(puestoService.listarPuestosLibres(), HttpStatus.OK); //ok
	}
	
	
	
	

}
