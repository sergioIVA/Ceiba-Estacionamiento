package co.com.ceiba.parqueadero.domain.model;



public class Vehiculo {
	
	private long idVehiculo;
	private String placa;
	private short cilindraje;
	private TipoVehiculo tipoVehiculo;
	
	
	
	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", placa=" + placa + ", cilindraje=" + cilindraje
				+ ", tipoVehiculo= nombre: " + tipoVehiculo.getNombre() + "idTipo: "+tipoVehiculo.getIdTipoVehiculo()+"]";
	}
	public long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public short getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(short cilindraje) {
		this.cilindraje = cilindraje;
	}
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
	
	

}
