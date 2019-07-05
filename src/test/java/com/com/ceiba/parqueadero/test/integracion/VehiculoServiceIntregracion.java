package com.com.ceiba.parqueadero.test.integracion;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.com.ceiba.parqueadero.test.databuilder.VehiculoTestBuilder;
import co.com.ceiba.parqueadero.CeibaEstacionamientoApplication;
import co.com.ceiba.parqueadero.aplication.service.VehiculoService;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;
import co.com.ceiba.parqueadero.domain.repositorio.VehiculoRepositorio;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CeibaEstacionamientoApplication.class)
@AutoConfigureMockMvc
public class VehiculoServiceIntregracion {
	
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	
	@MockBean 
	VehiculoRepositorio vehiculoRepositorio;
	
    VehiculoService vehiculoService;
    
    private static final int SIZE=2;
    private static final String PLACA="RWW111";
    private static final long ID_VEHICULO = 3;
	private static final short CILINDRAJE = 110;

    
    
    @Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		this.vehiculoService=new VehiculoService(this.vehiculoRepositorio);
		
	}
    
    
    @Test
	public void listarVehiculosServicio() {
		
		
		VehiculoTestBuilder vehiculoTestBuilder=new VehiculoTestBuilder();
		 List<Vehiculo> vehiculos=vehiculoTestBuilder.listadoVehiculos();
		
		given(vehiculoRepositorio.listarVehiculos()).willReturn(vehiculos);
		
		
		assertEquals(SIZE,vehiculoService.listarVehiculos().size());
		
	}
    
    
    @Test
   	public void obtenerVehiculoPorPlaca() {
   		
   		
   		VehiculoTestBuilder vehiculoTestBuilder=new VehiculoTestBuilder();
   		 Vehiculo vehiculo=vehiculoTestBuilder.build();
   		
   		given(vehiculoRepositorio.obtenerVehiculoPorPlaca(PLACA)).willReturn(vehiculo);
   		
   		
   		assertEquals(PLACA,vehiculoService.obtenerVehiculoPorPlaca(PLACA).getPlaca());
   		
   	}
    
    

    @Test
   	public void registraVehiculo() {
   		
   		
   		VehiculoTestBuilder vehiculoTestBuilder=new VehiculoTestBuilder();
   		 Vehiculo vehiculo=vehiculoTestBuilder.build();
   		
   		given(vehiculoRepositorio.registrarVehiculo(vehiculo)).willReturn(vehiculo);
   		
   		assertEquals(ID_VEHICULO,vehiculoService.registrarVehiculo(vehiculo).getIdVehiculo());
   		assertEquals(PLACA,vehiculoService.registrarVehiculo(vehiculo).getPlaca());
   		assertEquals(CILINDRAJE,vehiculoService.registrarVehiculo(vehiculo).getCilindraje());
   		
   		
   	}
    
    
    
    
    
    
    
    
    

}
