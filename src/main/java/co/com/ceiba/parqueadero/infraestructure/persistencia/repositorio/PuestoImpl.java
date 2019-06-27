package co.com.ceiba.parqueadero.infraestructure.persistencia.repositorio;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.repositorio.PuestoRepositorio;
import co.com.ceiba.parqueadero.infraestructure.persistencia.exception.NotContentException;
import co.com.ceiba.parqueadero.infraestructure.persistencia.mapeador.PuestoMapper;
import co.com.ceiba.parqueadero.infraestructure.persistencia.exception.NotFoundException;


@Repository
@Transactional
public class PuestoImpl implements PuestoRepositorio{

	private final PuestoJPA puestoJPA;
	

	public PuestoImpl(final PuestoJPA puestoJPA) {
		this.puestoJPA = puestoJPA;
	}

	@Override
	public List<Puesto> listarPuesto() {
		
		List<Puesto> puestos = this.puestoJPA.findAll().stream().map
				              (
				              PuestoMapper::toDomain
				              ).collect(Collectors.toList());
		
		if (!puestos.isEmpty()) {
			return puestos;
		}
		
		throw new NotContentException("No existen Puestos registrados actualmente");
	}

	@Override
	public List<Puesto> listarPuestoLibre() {
		
		List<Puesto> listPuestos = this.puestoJPA.findByEstado(true).stream().map
				                   (
									PuestoMapper::toDomain
								   ).collect(Collectors.toList());
		if (!listPuestos.isEmpty()) {
			return listPuestos;
		}
		throw new NotContentException("No hay puestos libres");

	}

	@Override
	public Puesto obtenerPuestoPorId(long id) {
		
		return PuestoMapper.toDomain(this.puestoJPA.findByIdPuesto(id)
				.orElseThrow(() -> new NotFoundException("El puesto con el id: " + id + ", no fue encontrado.")));
	}

	@Override
	public void cambiarEstadoPuesto(long idPuesto) {
		
		Puesto puesto = this.obtenerPuestoPorId(idPuesto);
		if (puesto == null) {
			throw new NotFoundException("El puesto con el id: " + idPuesto + ", no fue encontrado");
		}
		puesto.setEstado(!puesto.isEstado());
		puestoJPA.save(PuestoMapper.toEntity(puesto));
	}
	
	
	

}
