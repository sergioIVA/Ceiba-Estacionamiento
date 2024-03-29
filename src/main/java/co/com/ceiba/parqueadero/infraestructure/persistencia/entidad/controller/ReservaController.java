package co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.parqueadero.aplication.service.ReservaServicio;
import co.com.ceiba.parqueadero.domain.model.Reserva;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
	
	
	private final ReservaServicio reservaServicio;
	
	public ReservaController(ReservaServicio reservaServicio) {
		this.reservaServicio = reservaServicio;
	}

	@GetMapping("/listar-reservas")
	public ResponseEntity<List<Reserva>> listarReservas() {
		return new ResponseEntity<>(reservaServicio.listarReservas(), HttpStatus.OK); //ok
	}

	
	@GetMapping("/listar-reservas-pendientes")
	public ResponseEntity<List<Reserva>> listraReservaPendientes() {
		return new ResponseEntity<>(reservaServicio.listarReservasPendientes(), HttpStatus.OK); //ok
	}
	
	@PostMapping
	public ResponseEntity<Reserva> registrarEntrada(@RequestBody Reserva reserva) {
		
		Reserva reservaDe=reservaServicio.registrarEntrada(reserva.getPuesto().getIdPuesto(), reserva.getVehiculo().getIdVehiculo());
		return new ResponseEntity<>(reservaDe,HttpStatus.CREATED);
	}
	
	
	@PatchMapping("/{idReserva}")
	public ResponseEntity<Reserva> registrarSalida(@PathVariable("idReserva") long idReserva) {  //ok
		
		Reserva reservaMod=reservaServicio.registrarSalida(idReserva);
		return new ResponseEntity<>(reservaMod,HttpStatus.OK);
	}
	

}
