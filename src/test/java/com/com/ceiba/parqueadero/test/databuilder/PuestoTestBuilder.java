package com.com.ceiba.parqueadero.test.databuilder;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.domain.model.Puesto;

public class PuestoTestBuilder {
	
	private static final long ID_PUESTO = 11;
	private static final boolean ESTADO_PUESTO = true;
	private static final String TIPO_PUESTO = "CARRO";
	
	
	private static final long ID_PUESTO2 = 12;
	private static final boolean ESTADO_PUESTO2 = true;
	private static final String TIPO_PUESTO2 = "CARRO";
	
	private long idPuesto;
	private boolean estadoPuesto;
	private String tipoPuesto;
	
	public PuestoTestBuilder() {
		this.idPuesto = ID_PUESTO;
		this.estadoPuesto = ESTADO_PUESTO;
		this.tipoPuesto = TIPO_PUESTO;
	}
	
	public PuestoTestBuilder puestoPorId(long idPuesto) {
		this.idPuesto = idPuesto;
		return this;
	}
	
	public PuestoTestBuilder puestoPorEstado(boolean estadoPuesto) {
		this.estadoPuesto = estadoPuesto;
		return this;
	}
	
	public PuestoTestBuilder puestoPorTipo(String tipoPuesto) {
		this.tipoPuesto = tipoPuesto;
		return this;
	}
	
	
	public List<Puesto> listaPuestos(){
		
		List<Puesto> puestos;
		puestos=new ArrayList(); 
		
		Puesto puesto1=new Puesto();
		puesto1.setIdPuesto(ID_PUESTO);
		puesto1.setEstado(ESTADO_PUESTO);
		puesto1.setTipoPuestoVehiculo(TIPO_PUESTO);
		
		
		Puesto puesto2=new Puesto();
		puesto2.setIdPuesto(ID_PUESTO2);
		puesto2.setEstado(ESTADO_PUESTO2);
		puesto2.setTipoPuestoVehiculo(TIPO_PUESTO2);
		
		puestos.add(puesto1);
		puestos.add(puesto2);
		
		return puestos;
		
	}
	
	
public List<Puesto> listaPuestosLibres(){
		
		List<Puesto> puestos;
		puestos=new ArrayList(); 
		
		Puesto puesto1=new Puesto();
		puesto1.setIdPuesto(ID_PUESTO);
		puesto1.setEstado(!ESTADO_PUESTO);
		puesto1.setTipoPuestoVehiculo(TIPO_PUESTO);
		
		
		Puesto puesto2=new Puesto();
		puesto2.setIdPuesto(ID_PUESTO2);
		puesto2.setEstado(!ESTADO_PUESTO2);
		puesto2.setTipoPuestoVehiculo(TIPO_PUESTO2);
		
		puestos.add(puesto1);
		puestos.add(puesto2);
		
		return puestos;
		
	}
	
	
	
	public Puesto build() {
		Puesto puesto = new Puesto();
		puesto.setIdPuesto(this.idPuesto);
		puesto.setEstado(this.estadoPuesto);
		puesto.setTipoPuestoVehiculo(this.tipoPuesto);
		return puesto;
	}
	

}
