package co.com.ceiba.parqueadero.domain.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.domain.model.Puesto;



public interface PuestoRepositorio {
	
   public List<Puesto>  listarPuesto();
	
	public List<Puesto> listarPuestoLibre();
	
	public Puesto obtenerPuestoPorId(long id);
	
	public void cambiarEstadoPuesto(long idBahia);


}
