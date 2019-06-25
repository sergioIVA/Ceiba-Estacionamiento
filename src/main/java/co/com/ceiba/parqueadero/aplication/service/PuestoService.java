package co.com.ceiba.parqueadero.aplication.service;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.repositorio.PuestoRepositorio;

@Service
public class PuestoService {
	
	private PuestoRepositorio puestoRepositorio;

	public PuestoService(PuestoRepositorio puestoRepositorio) {
		this.puestoRepositorio = puestoRepositorio;
	}
	
	public List<Puesto> listarPuestos(){
		return puestoRepositorio.listarPuesto();
	}
	
	public List<Puesto> listarPuestosLibres(){
		return puestoRepositorio.listarPuestoLibre();
	}
	
	
	
	

}
