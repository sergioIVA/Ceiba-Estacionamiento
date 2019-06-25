package co.com.ceiba.parqueadero.infraestructure.persistencia.repositorio;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.domain.model.Vehiculo;
import co.com.ceiba.parqueadero.domain.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.infraestructure.persistencia.exception.NotContentException;
import co.com.ceiba.parqueadero.infraestructure.persistencia.exception.NotFoundException;
import co.com.ceiba.parqueadero.infraestructure.persistencia.mapeador.VehiculoMapper;

@Repository
@Transactional
public class VehiculoImpl implements VehiculoRepositorio{


	private final VehiculoJPA vehiculoJPA;

	public VehiculoImpl(final VehiculoJPA vehiculoJPA) {
		this.vehiculoJPA = vehiculoJPA;
	}

	
	@Override
	public List<Vehiculo> listarVehiculos() {
		
		List<Vehiculo> listVehiculos = this.vehiculoJPA.findAll().stream().map
				                       (
				                       VehiculoMapper::toDomain
				                       ).collect(Collectors.toList());
		if (listVehiculos.isEmpty()) {
			throw new NotContentException("Lista de vehiculos vacia");
		} else {
			return listVehiculos;
		}
		
	}

	@Override
	public Vehiculo obtenerVehiculoPorPlaca(String placaVehiculo) {
		
		return VehiculoMapper.toDomain(this.vehiculoJPA.findByPlaca(placaVehiculo)
				.orElseThrow(() -> new NotFoundException("No existen vehiculos registrados")));
	}

	@Override
	public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
		return VehiculoMapper.toDomain(vehiculoJPA.save(VehiculoMapper.toEntity(vehiculo)));
	}

	@Override
	public Vehiculo obtenerVehiculoPorId(long idVehiculo) {
		
		return VehiculoMapper.toDomain(this.vehiculoJPA.findByIdVehiculo(idVehiculo)
				.orElseThrow(() -> new NotFoundException(
				"El vehiculo con Id: " + idVehiculo + ", no fue hallado")));		
	}

	
	

}
