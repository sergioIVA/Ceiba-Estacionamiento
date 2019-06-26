package com.com.ceiba.parqueadero.test.databuilder;

import co.com.ceiba.parqueadero.domain.model.Puesto;

public class PuestoTestBuilder {
	
	private static final long ID_PUESTO = 11;
	private static final boolean ESTADO_PUESTO = true;
	private static final String TIPO_PUESTO = "CARRO";
	
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
	
	public Puesto build() {
		Puesto puesto = new Puesto();
		puesto.setIdPuesto(this.idPuesto);
		puesto.setEstado(this.estadoPuesto);
		puesto.setTipoPuestoVehiculo(this.tipoPuesto);
		return puesto;
	}
	

}
