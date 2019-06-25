package co.com.ceiba.parqueadero.infraestructure.persistencia.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.VehiculoEntity;

public interface VehiculoJPA extends JpaRepository<VehiculoEntity, Long> {

	Optional<VehiculoEntity> findByPlaca(String placaVehiculo);

	Optional<VehiculoEntity> findByIdVehiculo(long idVehiculo);

}
