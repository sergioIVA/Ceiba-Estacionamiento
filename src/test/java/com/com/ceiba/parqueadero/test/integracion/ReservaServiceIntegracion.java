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

import com.com.ceiba.parqueadero.test.databuilder.PuestoTestBuilder;
import com.com.ceiba.parqueadero.test.databuilder.ReservaTestBuilder;

import co.com.ceiba.parqueadero.CeibaEstacionamientoApplication;
import co.com.ceiba.parqueadero.aplication.service.ParqueaderoService;
import co.com.ceiba.parqueadero.aplication.service.PuestoService;
import co.com.ceiba.parqueadero.aplication.service.ReservaServicio;
import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.domain.repositorio.PuestoRepositorio;
import co.com.ceiba.parqueadero.domain.repositorio.ReservaRepositorio;
import co.com.ceiba.parqueadero.domain.repositorio.VehiculoRepositorio;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CeibaEstacionamientoApplication.class)
@AutoConfigureMockMvc
public class ReservaServiceIntegracion {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	
	@MockBean 
	ReservaRepositorio reservaRepositorio;
	
	@MockBean 
	PuestoRepositorio puestoRepositorio;
	
	
	@MockBean 
	VehiculoRepositorio vehiculoRepositorio;
	
	
	@MockBean 
	ParqueaderoService parqueaderoRepositorio;
	
	private static final int SIZE=2;
	
	private static final int ID_PUESTO=11;
	
	private static final int ID_VEHICULO=1;
	
    ReservaServicio reservaService; 
    
    
    @Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		this.reservaService=new ReservaServicio(this.parqueaderoRepositorio,this.reservaRepositorio,
				                                this.puestoRepositorio,this.vehiculoRepositorio);
		
		
	}
    
    
    @Test
	public void listarReserva() {
		
		
		ReservaTestBuilder reservaTestBuilder=new ReservaTestBuilder();
		List<Reserva> reservas=reservaTestBuilder.listaReservas();
		
		given(reservaRepositorio.listarReserva()).willReturn(reservas);
		
		
		assertEquals(SIZE,reservaService.listarReservas().size());
		
	}
    
    @Test
	public void listarReservaPendientes() {
		
		
		ReservaTestBuilder reservaTestBuilder=new ReservaTestBuilder();
		List<Reserva> reservas=reservaTestBuilder.listaReservasPendientes();
		
		given(reservaRepositorio.listarReserva()).willReturn(reservas);
		
		
		assertEquals(null,reservaService.listarReservas().get(0).getFechaRetiro());
		assertEquals(null,reservaService.listarReservas().get(1).getFechaRetiro());
		
	}
    
    /**
    @Test
	public void registrarEntrada() {
		
		
		ReservaTestBuilder reservaTestBuilder=new ReservaTestBuilder();
		Reserva reserva=reservaTestBuilder.build();
		
		given(reservaRepositorio.registrarEntrada(reserva)).willReturn(reserva);
		
		
		assertEquals(null,reservaService.registrarEntrada(ID_PUESTO,ID_VEHICULO));
		
		
	}
    
    **/
	
	
    
    
    
    

}
