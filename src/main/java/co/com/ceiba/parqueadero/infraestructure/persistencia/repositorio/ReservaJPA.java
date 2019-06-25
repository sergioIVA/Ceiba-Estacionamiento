package co.com.ceiba.parqueadero.infraestructure.persistencia.repositorio;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.ReservaEntity;

public interface ReservaJPA extends JpaRepository<ReservaEntity,Long>{

    Optional <ReservaEntity> findByIdReserva(long idReserva);
	
	List<ReservaEntity> findByFechaRetiro(Calendar fechaRetiro);

}
