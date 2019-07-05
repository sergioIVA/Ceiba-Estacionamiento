package com.com.ceiba.parqueadero.test.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import co.com.ceiba.parqueadero.CeibaEstacionamientoApplication;
import co.com.ceiba.parqueadero.aplication.service.PuestoService;
import co.com.ceiba.parqueadero.domain.model.Puesto;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CeibaEstacionamientoApplication.class)
@AutoConfigureMockMvc
public class PuestoControllerIntegracion {
	
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	
	@MockBean 
	PuestoService puestoService; 
	
	

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}

	@Test
	public void listarPuestos() throws Exception {
		
		/**
		List<Puesto> puestos;
		puestos=new ArrayList(); 
		
		Puesto puesto1=new Puesto();
		puesto1.setIdPuesto(1L);
		puesto1.setEstado(true);
		puesto1.setTipoPuestoVehiculo("Carro");
		
		
		Puesto puesto2=new Puesto();
		puesto2.setIdPuesto(2L);
		puesto2.setEstado(false);
		puesto2.setTipoPuestoVehiculo("Moto");
		
		puestos.add(puesto1);
		puestos.add(puesto2);
		
		
		given(puestoService.listarPuestos()).willReturn(puestos);
		**/
		mvc.perform(get("/puesto/listar-puestos").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());

	}
	
	@Test
	public void listarPuestosLibres() throws Exception {
		/**
		List<Puesto> puestos;
		puestos=new ArrayList(); 
		
		Puesto puesto1=new Puesto();
		puesto1.setIdPuesto(1L);
		puesto1.setEstado(true);
		puesto1.setTipoPuestoVehiculo("Carro");
		
		
		Puesto puesto2=new Puesto();
		puesto2.setIdPuesto(2L);
		puesto2.setEstado(true);
		puesto2.setTipoPuestoVehiculo("Moto");
		
		puestos.add(puesto1);
		puestos.add(puesto2);
		
		given(puestoService.listarPuestos()).willReturn(puestos);
		**/
		
		mvc.perform(get("/puesto/listado-puestos-libres").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
	

}
