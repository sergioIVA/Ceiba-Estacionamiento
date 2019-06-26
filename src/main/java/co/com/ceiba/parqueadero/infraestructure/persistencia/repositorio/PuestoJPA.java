package co.com.ceiba.parqueadero.infraestructure.persistencia.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.PuestoEntity;


public interface PuestoJPA extends JpaRepository<PuestoEntity, Long>{

	List<PuestoEntity> findByEstado(boolean estado);

	Optional<PuestoEntity> findByIdPuesto(long idPuesto);
	
}
