package co.com.ceiba.parqueadero.domain.repositorio;
import java.util.List;

import co.com.ceiba.parqueadero.domain.model.Reserva;


public interface ReservaRepositorio {

	
    public List<Reserva> listarReserva();
	
	public Reserva registrarEntrada(Reserva reserva);
	
	public Reserva obtenerReservaPorId(long idReserva);	
	
	public List<Reserva> listarReservaPendiente();
	
	public Reserva registrarSalida(Reserva reserva);
}
