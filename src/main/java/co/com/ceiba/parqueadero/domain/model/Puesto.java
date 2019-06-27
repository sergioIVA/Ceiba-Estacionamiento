package co.com.ceiba.parqueadero.domain.model;

public class Puesto {
	
	private Long idPuesto;
	private boolean estado;
	private String tipoPuestoVehiculo;
	

	public Long getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(Long idPuesto) {
		this.idPuesto = idPuesto;
	}
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getTipoPuestoVehiculo() {
		return tipoPuestoVehiculo;
	}
	public void setTipoPuestoVehiculo(String tipoPuestoVehiculo) {
		this.tipoPuestoVehiculo = tipoPuestoVehiculo;
	}
	
	
	
	

}
