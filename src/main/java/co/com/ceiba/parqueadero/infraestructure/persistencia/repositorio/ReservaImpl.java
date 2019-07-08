package co.com.ceiba.parqueadero.infraestructure.persistencia.repositorio;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.domain.repositorio.ReservaRepositorio;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.VehiculoEntity;
import co.com.ceiba.parqueadero.infraestructure.persistencia.exception.NotContentException;
import co.com.ceiba.parqueadero.infraestructure.persistencia.exception.NotFoundException;
import co.com.ceiba.parqueadero.infraestructure.persistencia.mapeador.ReservaMapper;

@Repository
@Transactional
public class ReservaImpl implements ReservaRepositorio {

	private final ReservaJPA reservaJPA;

	public ReservaImpl(ReservaJPA reservaJPA) {
		this.reservaJPA = reservaJPA;
	}

	@Override
	public List<Reserva> listarReserva() {
		List<Reserva> listReservas = this.reservaJPA.findAll().stream().map(ReservaMapper::toDomain)
				.collect(Collectors.toList());
		if (!listReservas.isEmpty()) {
			return listReservas;
		}
		throw new NotContentException("No exiten Reservas registradas");

	}

	@Override
	public Reserva registrarEntrada(Reserva reserva) {
		return ReservaMapper.toDomain(this.reservaJPA.save(ReservaMapper.toEntity(reserva)));
	}

	@Override
	public Reserva obtenerReservaPorId(long idReserva) {

		return ReservaMapper.toDomain(this.reservaJPA.findByIdReserva(idReserva)
				.orElseThrow(() -> new NotFoundException("La Reserva: " + idReserva + " no fue encontrada")));

	}

	@Override
	public List<Reserva> listarReservaPendiente() {

		List<Reserva> listReservas = this.reservaJPA.findByFechaRetiro(null).stream().map(ReservaMapper::toDomain)
				.collect(Collectors.toList());
		if (!listReservas.isEmpty()) {
			return listReservas;
		}
		throw new NotFoundException("No existen Reservas pendientes");

	}

	@Override
	public Reserva registrarSalida(Reserva reserva) {
		return ReservaMapper.toDomain(reservaJPA.save(ReservaMapper.toEntity(reserva)));
	}

	// metodo creado
	@Override
	public List<Reserva> reservasVehiculo(VehiculoEntity v) {

		return this.reservaJPA.findByVehiculo(v).stream().map(ReservaMapper::toDomain)
				.collect(Collectors.toList());

		
	}

}
