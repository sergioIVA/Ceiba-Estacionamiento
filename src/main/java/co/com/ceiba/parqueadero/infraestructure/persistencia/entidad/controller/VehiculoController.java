package co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.parqueadero.aplication.service.VehiculoService;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;



@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {


	private VehiculoService vehiculoService;

	public VehiculoController(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}

	@GetMapping("/listado-vehiculos")
	public ResponseEntity<List<Vehiculo>> listarVehiculos() {
		return new ResponseEntity<>(vehiculoService.listarVehiculos(), HttpStatus.OK);
	}
	
	@GetMapping("/{placa}")
	public ResponseEntity<Vehiculo> consultarPorPlaca(@PathVariable("placaVehiculo") String placaVehiculo){
		return new ResponseEntity<>(vehiculoService.obtenerVehiculoPorPlaca(placaVehiculo),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Vehiculo> registrarVehiculo(@RequestBody Vehiculo vehiculo) {
		vehiculoService.registrarVehiculo(vehiculo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
}
