package co.com.ceiba.parqueadero.domain.model;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;
import co.com.ceiba.parqueadero.domain.exception.AccesoDenegadoException;
import co.com.ceiba.parqueadero.domain.exception.TipoVehiculoIncompatibleException;

@Component
public class Parqueadero {

	private static final String PUESTO_OCUPADO = "El puesto se encuentra ocupado";

	private static final String VEHICULO_NO_PERMITIDO = "Tipo de vehiculo no permitido en el parqueadero";

	private static final String VEHICULO_INCOMPATIBLE_CON_PUESTO = "El vehiculo no puede parquear en este tipo de puesto";

	private static final String ACCESO_DENEGADO_SEGUN_DIA = "No puede parquear su vehiculo en este dia";
	
	private static final String CARRO="CARRO";
	
	private static final String MOTO="MOTO";

	public Reserva registrarEntrada(Puesto puesto, Vehiculo vehiculo) {

		if (!estaLibre(puesto)) {
			throw new AccesoDenegadoException(PUESTO_OCUPADO);
		}
	
		if (!estaPermitido(vehiculo)) {
			throw new TipoVehiculoIncompatibleException(VEHICULO_NO_PERMITIDO);
		}
		if (!esCompatible(vehiculo, puesto)) {
			throw new TipoVehiculoIncompatibleException(VEHICULO_INCOMPATIBLE_CON_PUESTO);
		}

		Calendar fechaIngreso = Calendar.getInstance();
		
		if (this.permitirEntrada(vehiculo.getPlaca(), fechaIngreso)) {
			Reserva reserva = new Reserva();
			reserva .setPuesto(puesto);
			reserva .setVehiculo(vehiculo);
			reserva .setFechaIngreso(fechaIngreso.getTime());
			return reserva ;
		}

		throw new AccesoDenegadoException(ACCESO_DENEGADO_SEGUN_DIA);
	}

	public boolean estaPermitido(Vehiculo vehiculo) {
		
	   return vehiculo.getTipoVehiculo().getNombre().equalsIgnoreCase(CARRO) || 
		       vehiculo.getTipoVehiculo().getNombre().equalsIgnoreCase(MOTO);
		
	}

	public boolean estaLibre(Puesto puesto) {
		
		         if(puesto.isEstado()) {
		           return true;	 
		         }
		         
		         return false;
		              
	}

	public boolean esCompatible(Vehiculo vehiculo, Puesto puesto) {
		
		if(vehiculo.getTipoVehiculo().getNombre().equalsIgnoreCase(puesto.getTipoPuestoVehiculo())) {
			return true;
		} 
		
		    return false;
	}
	
	public boolean permitirEntrada(String placa, Calendar fechaIngreso) {
		
	
		char letra = placa.charAt(0);
		boolean letraBool = (letra == Character.toUpperCase('A'));
		
		           if(letraBool) {
		        	   
	     int dia = fechaIngreso.get(Calendar.DAY_OF_WEEK);
	     
		return (dia == Calendar.SUNDAY)  ||  (dia == Calendar.MONDAY);
	     
		           }
		
		  return true;

	}
	
	public Reserva registrarSalida(Reserva reserva, Vehiculo vehiculo) {
		
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.setTime(reserva.getFechaIngreso());
		Calendar fechaRetiro = Calendar.getInstance();
		reserva.setFechaRetiro(fechaRetiro.getTime());
		reserva.setValorTotal(this.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				fechaIngreso, fechaRetiro));
		return reserva;
	}
	
	public float calcularValor(TipoVehiculo tipoVehiculo, short cilindraje, Calendar fechaIngreso,
			Calendar fechaRetiro) {
		
		float valor = 0;

		long tiempoParqueo = fechaRetiro.getTimeInMillis() - fechaIngreso.getTimeInMillis();
		
		tiempoParqueo = TimeUnit.MILLISECONDS.toHours(tiempoParqueo);

		//mayor a un dia
		while (tiempoParqueo > 24) {
			valor += TablaPrecio.devolverValorDia(tipoVehiculo);
			tiempoParqueo -= 24;
		}

		// menor a las 9 horas
		if (tiempoParqueo < 9) {
				valor += TablaPrecio.devolverValorHora(tipoVehiculo) * tiempoParqueo;
				
		} else if (tiempoParqueo <= 24) {
			valor += TablaPrecio.devolverValorDia(tipoVehiculo);
		}

		if (tipoVehiculo.getNombre().equalsIgnoreCase(MOTO) && cilindraje > 500) {
			valor += TablaPrecio.devolverValorAdiconal();
		}

		return valor;

	}
	

}
