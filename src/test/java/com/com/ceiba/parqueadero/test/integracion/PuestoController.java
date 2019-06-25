package com.com.ceiba.parqueadero.test.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import co.com.ceiba.parqueadero.CeibaEstacionamientoApplication;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = CeibaEstacionamientoApplication.class)
@AutoConfigureMockMvc
public class PuestoController {
	
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void listarPuestos() throws Exception {
		mvc.perform(get("/puesto/listar-puestos").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());

	}
	
	@Test
	public void listarPuestosLibres() throws Exception {
		mvc.perform(get("/puesto/listado-puestos-libres").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());

	}
	

}
