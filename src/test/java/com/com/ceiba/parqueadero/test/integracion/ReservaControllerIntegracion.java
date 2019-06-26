package com.com.ceiba.parqueadero.test.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.com.ceiba.parqueadero.test.databuilder.ReservaTestBuilder;

import co.com.ceiba.parqueadero.CeibaEstacionamientoApplication;
import co.com.ceiba.parqueadero.domain.model.Reserva;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = CeibaEstacionamientoApplication.class)
@AutoConfigureMockMvc
public class ReservaControllerIntegracion {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	private Reserva reserva;
	

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		ReservaTestBuilder reservaTestBuilder=new ReservaTestBuilder();
		reserva=reservaTestBuilder.build();
		
	}

	@Test
	public void listarReservas() throws Exception {
		mvc.perform(
				get("/reserva/listar-reservas").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void listarReservasPendientes() throws Exception {
		mvc.perform(get("/reserva/listar-reservas-pendientes").contentType(MediaType.APPLICATION_JSON))
		                                                      .andExpect(status().isOk());
	}
	
	/**
	@Test
	public void registrarEntrada() throws Exception {
		mvc.perform(post("/reserva").content(AbstractRestControllerTest.asJsonString(reserva))
				                     .contentType(MediaType.APPLICATION_JSON))
		                             .andExpect(status().isCreated());
	}
    **/ 
	
	


}
