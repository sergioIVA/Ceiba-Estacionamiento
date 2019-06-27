package co.com.ceiba.parqueadero.domain.model;



public class TablaPrecio {
	
	private static final float PRECIO_CARRO_HORA = 1000;
	private static final float PRECIO_CARRO_DIA = 8000;
	private static final float PRECIO_MOTO_HORA = 500;
	private static final float PRECIO_MOTO_DIA = 4000;
	private static final float PRECIO_MOTO_EXTRA_CILINDRAJE = 2000;
	private static final String MOTO="MOTO";
	private static final String CARRO="CARRO";
	

	public static float devolverValorDia(TipoVehiculo tipoVehiculo) {
	
		if (tipoVehiculo.getNombre().equalsIgnoreCase(CARRO)) {
			return PRECIO_CARRO_DIA;
		} else if (tipoVehiculo.getNombre().equalsIgnoreCase(MOTO)) {
			return PRECIO_MOTO_DIA;
		}
		return 0;
	}
	
	public static float devolverValorHora(TipoVehiculo tipoVehiculo) {
		
		if (tipoVehiculo.getNombre().equalsIgnoreCase(CARRO)) {
			return PRECIO_CARRO_HORA;
		} else if (tipoVehiculo.getNombre().equalsIgnoreCase(MOTO)) {
			return  PRECIO_MOTO_HORA ;
		}
		return 0;
	}

	public static float devolverValorAdiconal() {
		return PRECIO_MOTO_EXTRA_CILINDRAJE;
	
	}

}
